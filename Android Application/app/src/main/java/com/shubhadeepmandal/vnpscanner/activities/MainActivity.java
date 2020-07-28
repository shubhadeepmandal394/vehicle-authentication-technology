package com.shubhadeepmandal.vnpscanner.activities;

/**
 * Developed by Shubhadeep Mandal on 27/07/2020
 */

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.shubhadeepmandal.vnpscanner.R;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private CompoundButton useFlash;
    private TextView statusMessage;
    private TextView textValue;
    String code = null;

    private static final int RC_OCR_CAPTURE = 9003;
    private static final String TAG = "MainActivity";

    TextView resultTextView;
    int flag;

    public void authenticatePlateNumber(View view){
        try {
            getJSON("http://192.168.31.222/getdata.php");
            resultTextView= (TextView) findViewById(R.id.resultTextView);
        }catch(Exception e){
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        statusMessage = (TextView)findViewById(R.id.status_message);
        textValue = (TextView)findViewById(R.id.text_value);
        useFlash = (CompoundButton) findViewById(R.id.use_flash);

        Button detectButton = (Button) findViewById(R.id.detectButton);
        detectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CaptureActivity.class);
                intent.putExtra(CaptureActivity.AutoFocus, true);
                intent.putExtra(CaptureActivity.UseFlash, useFlash.isChecked());
                startActivityForResult(intent, RC_OCR_CAPTURE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == RC_OCR_CAPTURE) {
            if (resultCode == CommonStatusCodes.SUCCESS) {
                if (data != null) {
                    String text = data.getStringExtra(CaptureActivity.TextBlockObject);
                    code = text;
                    statusMessage.setText(R.string.ocr_success);
                    textValue.setText(text);
                    Log.d(TAG, "Text read: " + text);
                } else {
                    statusMessage.setText(R.string.ocr_failure);
                    Log.d(TAG, "No Text captured, intent data is null");
                }
            } else {
                statusMessage.setText(String.format(getString(R.string.ocr_error),
                        CommonStatusCodes.getStatusCodeString(resultCode)));
            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void getJSON(final String urlWebService) {
        class GetJSON extends AsyncTask<Void, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String json) {
                super.onPostExecute(json);
                try{
                    JSONArray jsonArray = new JSONArray(json);
                    String[] users = new String[jsonArray.length()];
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject obj = jsonArray.getJSONObject(i);
                        users[i] = obj.getString("code");
                        if(users[i].equalsIgnoreCase(code)){
                            flag ++;
                        }
                    }
                    if(flag > 0){
                        resultTextView.setText("VEHICLE REGISTERED");
                        resultTextView.setBackgroundColor(Color.GREEN);
                        Log.d(TAG, "Vehicle with Plate Number " + code + " is REGISTERED ");
                        //Toast.makeText(getApplicationContext(), "VEHICLE REGISTERED", Toast.LENGTH_LONG).show();
                        flag=0;
                    }else {
                        resultTextView.setText("VEHICLE NOT REGISTERED");
                        resultTextView.setBackgroundColor(Color.RED);
                        Log.d(TAG, "Vehicle with Plate Number " + code + " is NOT REGISTERED ");
                        //Toast.makeText(getApplicationContext(), "VEHICLE NOT REGISTERED", Toast.LENGTH_LONG).show();
                        flag=0;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            protected String doInBackground(Void... voids) {
                try {
                    URL url = new URL(urlWebService);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String json;
                    while ((json = bufferedReader.readLine()) != null) {
                        sb.append(json + "\n");
                    }
                    return sb.toString().trim();
                } catch (Exception e) {
                    return null;
                }
            }
        }
        GetJSON getJSON = new GetJSON();
        getJSON.execute();
    }
}
<?php

$a=$_POST['first_name'];
$b=$_POST['last_name'];
$c=$_POST['email'];
$d=$_POST['vech_name'];
$e=$_POST['vech_num'];

$servername = "localhost";
$username = "root";
$password = "";
$dbname = "tamarillo_technologies";

//Creating Connection
$con = new mysqli($servername,$username,$password,$dbname);

//Checking Connection
if($con->connect_error)
{
    die("Connection Failed !!" . $con->connect_error);
}
echo "Connected Successfully !!";
$sql = "INSERT INTO users (fname,lname,mail,vech1,vech2) VALUES ('$a','$b','$c','$d','$e')";

if($con->query($sql) === TRUE)
{
    echo "New Record Created Successfully !!";
}
else
{
    echo "Error: " . $sql . "<br>" . $con->error;
}

$con->close();

?>
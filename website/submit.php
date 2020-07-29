<?php

$a=$_POST['firstname'];
$b=$_POST['lastname'];
$c=$_POST['mailaddress'];
$d=$_POST['secretcode'];

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
$sql = "INSERT INTO users (fname,lname,mail,code) VALUES ('$a','$b','$c','$d')";

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
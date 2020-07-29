<?php

$servername = "localhost";
$username = "root";
$password = "";
$database = "vehicle_authentication";
 
$conn = new mysqli($servername, $username, $password, $database);

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 

$platenumbers = array(); 
$sql = "SELECT code FROM users;";
$stmt = $conn->prepare($sql);
$stmt->execute(); 
$stmt->bind_result($code);
 
while($stmt->fetch()){
	$temp = [
		'code'=>$code
	];
	array_push($platenumbers, $temp);
}

echo json_encode($platenumbers);

?>
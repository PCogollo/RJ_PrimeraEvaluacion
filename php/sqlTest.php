<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "myBase";

$ID = $_POST["id"];
$LastName = $_POST["lastName"];
$FirstName = $_POST["firstName"];
$Age = $_POST["age"];
$Nationality = $_POST["nationality"];

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}

$sql = "INSERT INTO Persons (ID, LastName, FirstName, Age, Nationality)
VALUES (". $ID .", '". $LastName ."', '". $FirstName ."',  ". $Age . ", '". $Nationality ."')";



if ($conn->query($sql) === TRUE) {
  echo "New record created successfully " . $sql;
} else {
  echo "Error: " . $sql . "<br>" . $conn->error;
}

$conn->close();
?>
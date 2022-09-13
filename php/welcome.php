<?php
$name = $_POST["name"];
$mail = $_POST["email"];
$password = $_POST["password"];

	//echo "Welcome " . $name . "<br> Your email address is: " . $mail;
	checkPasswordWithUsername($name, $password);
	echo "<br>"
	echo addNumbers(2, 4);

	function checkPasswordWithUsername($username, $userPassword)
	{
			if($username == "VIVAESPAÑA" && $userPassword == "SPANISH INQUISITION")
				echo "Welcome " . $username;

			else
				echo "Wrong password for " . $username;
	}		

	function addNumbers($input1, $input2)
	{
		return $input1 + $input2;
	}



?>



<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="css/style.css">
	<script src=js/codigo.js></script>

</head>


<body>

	<?php
	echo "My first PHP script!";
	?>

	<?php
		$t = date("H");

		if($t < "12"){
			echo "Have a good day!";
		}
		else {
			echo "Have a good afternoon!";
		}
	?>

	<form>
		
	</form>

	<h1> This is a header </h1>
	<p> This is a paragraph </p>

</body>
</html>
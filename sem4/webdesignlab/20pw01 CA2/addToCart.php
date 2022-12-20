<?php
session_start();
$item = array($_POST['name'], $_POST['price'], $_POST['qty']);
array_push($_SESSION['cart'], $item);
header("Location: test.php");
?>
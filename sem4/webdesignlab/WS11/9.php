<?php
    session_start();
    if(!isset($_SESSION['bg'])){
        $_SESSION['bg'] = 'black';
    }
    if(isset($_POST['submit'])){
        $_SESSION['bg'] = $_POST['bg'];
    }
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body bgcolor="<?=$_SESSION['bg'] ?>">
    <form action="9.php" method="POST">
        <input type="text" name="bg">
        <input type="submit" name="submit">
    </form>
</body>
</html>

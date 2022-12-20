<?php
    // echo $_POST['name'];
    setcookie('user',$_POST['name'],time()+3600,'/');
    echo $_COOKIE['user'];
    header('Location: 11.php');
?>

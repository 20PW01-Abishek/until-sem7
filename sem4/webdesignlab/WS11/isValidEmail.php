<!DOCTYPE html>
<html lang="en">
<head>
    <title>isValidEmail</title>
</head>
<body>
    <?php
        function isValidEmail($email) {
            if (filter_var($email, FILTER_VALIDATE_EMAIL))
                echo $email . ' = Valid<br>';
            else
                echo $email . ' = Invalid<br>';
        }
        $email1= "psg4tech@gmail.com";
        $email2 = "24gmail.com";

        isValidEmail($email1);
        isValidEmail($email2);
    ?>
</body>
</html>
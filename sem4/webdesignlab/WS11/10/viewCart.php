<?php
session_start();
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<style>
    tr {
        text-align: center;
        width: 150px;
    }
    th {
        text-align: center;
        width: 150px;
    }
    table {
        border: solid black 1px;
    }
</style>
<body>
    <table>
        <tr>
            <th>Fruit</th>
            <th>Cost</th>
            <th>Qty</th>
        </tr>
        <?php
        foreach($_SESSION['cart'] as $item){
            echo '<tr>';
            echo '<td>'.$item[0].'</td>';
            echo '<td>'.$item[1].'</td>';
            echo '<td>'.$item[2].'</td>';
            echo '</tr>';
        }
        ?>
    </table>
</body>
</html>
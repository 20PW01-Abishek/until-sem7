<?php
session_start();
if(!isset($_SESSION['cart'])){
    $_SESSION['cart'] = array();
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fruit shop</title>
    <style>
        body{
            margin: 10px;
        }
        .header {
            margin: 10px;
        }
        .cBtns {
            margin: 10px;
            display: flex;
        }
        .parent {
            display: flex;
        }
        .container {
            margin: 10px;
        }
        .pic{
            height: 200px;
            width: 200px;
        }
        .cart {
            height: 30px;
            width: 30px;
        }
        .btn {
            font-size: 1.15rem;
            font-weight: bold;
            background-color: lightblue;
            color: white;
            height: 50px;
            width: 150px;
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="header">
        <h1>Fruit order form</h1>
        <p>Welcome to our online shop! We work directly with the local farms to bring you fresh fruits<br>that are pesticides free. Order your fruits today and get it delivered to your door. </p>
    </div>
    <div class="cBtns">
        <form style="margin-right: 340px;" action="viewCart.php">
            <input class="btn" type="submit" value="View Cart">
        </form>
        <br>
        <form action="deleteCart.php" method="post">
            <input class="btn" type="submit" value='Delete Cart'>
        </form>
    </div>

    <div class="parent">
        <div class="container">
            <div>
                <img class="pic" src = "images/Green Apples.png">
                <p>Green Apples</p>
                <b>$1.20</b>
            </div>
            <form action="addToCart.php" method="POST">
                <input type="hidden" name="name" value="Green Apples">
                <input type="hidden" name="price" value="7"><br>
                <input type="number" name="qty"><br><br>
                <input type="submit" value="Add to Cart">
            </form>
        </div>

        <div class="container">
            <div>
                <img class="pic" src = "images/Red Apples.png">
                <p>Red Apples</p>
                <b>$0.90</b>
            </div>
            <form action="addToCart.php" method="POST">
                <input type="hidden" name="name" value="Red Apples">
                <input type="hidden" name="price" value="5"><br>
                <input type="number" name="qty"><br><br>
                <input type="submit" value="Add to Cart">
            </form>
        </div>

        <div class="container">
            <div>
                <img class="pic" src = "images/Pears.png">
                <p>Pears</p>
                <b>$1.10</b>
            </div>
            <form action="addToCart.php" method="POST">
                <input type="hidden" name="name" value="Pears">
                <input type="hidden" name="price" value="5"><br>
                <input type="number" name="qty"><br><br>
                <input type="submit" value="Add to Cart">
            </form>
        </div>
    </div>
    <div class="parent">
        <div class="container">
            <div>
                <img class="pic" src = "images/Red Grapes.png">
                <p>Red Grapes</p>
                <b>$4.50 per kg</b>
            </div>
            <form action="addToCart.php" method="POST">
                <input type="hidden" name="name" value="Green Red Grapes">
                <input type="hidden" name="price" value="6"><br>
                <input type="number" name="qty"><br><br>
                <input type="submit" value="Add to Cart">
            </form>
        </div>

        <div class="container">
            <div>
                <img class="pic" src = "images/Green Grapes.png">
                <p>Green Grapes</p>
                <b>$4.00 per kg</b>
            </div>
            <form action="addToCart.php" method="POST">
                <input type="hidden" name="name" value="Green Grapes">
                <input type="hidden" name="price" value="4"><br>
                <input type="number" name="qty"><br><br>
                <input type="submit" value="Add to Cart">
            </form>
        </div>

        <div class="container">
            <div>
                <img class="pic" src = "images/Grapes.png">
                <p>Grapes</p>
                <b>$4.25 per kg</b>
            </div>
            <form action="addToCart.php" method="POST">
                <input type="hidden" name="name" value="Grapes">
                <input type="hidden" name="price" value="4"><br>
                <input type="number" name="qty"><br><br>
                <input type="submit" value="Add to Cart">
            </form>
        </div>
    </div>
</body>
</html>
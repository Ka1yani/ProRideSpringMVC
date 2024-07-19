<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ProRide - Home</title>
    <link rel="stylesheet" type="text/css" href="/WEB-INF/views/css/home.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
    <style>
        /* Reset some default styles */
        body, h1, h2, h3, h4, h5, h6, p, ul, li, a, header, footer {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Roboto', sans-serif;
        }

        body {
            color: #0c0c0c;
            background-color: #ffffff;
        }

        /* Header styles */
        header {
            background-color: #000000;
            padding: 1rem 0;
        }

        header .container {
            display: flex;
            justify-content: space-between;
            align-items: center;
            max-width: 1200px;
            margin: 0 auto;
            padding: 0 1rem;
        }

        header .logo {
            color: #fefdfc;
            font-size: 1.5rem;
            font-weight: 700;
        }

        header nav ul {
            list-style: none;
            display: flex;
            gap: 1rem;
        }

        header nav ul li a {
            color: #fefdfc;
            text-decoration: none;
            font-weight: 500;
        }

        header nav ul li a.signup-btn {
            background-color: #a7c464;
            padding: 0.5rem 1rem;
            border-radius: 5px;
            color: #fefdfc;
            cursor: pointer;
        }

        /* Hero section styles */
        .hero {
            background-image: url('https://source.unsplash.com/1600x900/?city,car');
            background-size: cover;
            background-position: center;
            color: #020202;
            text-align: center;
            padding: 6rem 0;
        }

        .hero .container {
            max-width: 800px;
            margin: 0 auto;
            padding: 0 1rem;
        }

        .hero h1 {
            font-size: 3rem;
            font-weight: 700;
            margin-bottom: 1rem;
        }

        .hero p {
            font-size: 1.2rem;
            margin-bottom: 2rem;
        }

        .hero .cta-buttons a {
            text-decoration: none;
            padding: 1rem 2rem;
            border-radius: 5px;
            font-weight: 500;
            margin: 0.5rem;
        }

        .hero .cta-buttons .btn-primary {
            background-color: #a7c464;
            color: #fefdfc;
        }

        .hero .cta-buttons .btn-secondary {
            background-color: rgba(255, 255, 255, 0.7);
            color: #000000;
        }

        /* Footer styles */
        footer {
            background-color: #000000;
            color: #fefdfc;
            padding: 2rem 0;
        }

        footer .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 0 1rem;
        }

        footer .footer-columns {
            display: flex;
            justify-content: space-between;
            margin-bottom: 2rem;
        }

        footer .column {
            flex: 1;
            margin: 0 1rem;
        }

        footer .column h4 {
            font-size: 1.2rem;
            margin-bottom: 1rem;
        }

        footer .column ul {
            list-style: none;
        }

        footer .column ul li {
            margin-bottom: 0.5rem;
        }

        footer .column ul li a {
            color: #fefdfc;
            text-decoration: none;
        }

        footer .footer-bottom {
            text-align: center;
        }

        .footer-bottom p {
            font-size: 0.8rem;
        }

        /* Modal styles */
        .modal {
            display: none;
            position: fixed;
            z-index: 1000;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.5);
        }

        .modal-content {
            background-color: #fefefe;
            margin: 15% auto;
            padding: 20px;
            border: 1px solid #888;
            width: 80%;
            max-width: 400px;
            border-radius: 5px;
            text-align: center;
        }

        .modal-content h2 {
            margin-bottom: 1rem;
        }

        .modal-content .btn {
            display: inline-block;
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            border-radius: 5px;
            text-decoration: none;
            margin: 10px;
        }

        .modal-content .btn:hover {
            background-color: #0056b3;
        }

        .sgnup-btn {
            background-color: #a7c464;
            padding: 0.5rem 1rem;
            border-radius: 5px;
            color: #fefdfc;
            cursor: pointer;
        }

        #msg{
            margin: 0 auto;
            padding: 20px;
            position: relative; /* Added */
            min-height: calc(100vh - 300px); /* Added */ /* Adjust the height as needed */
        }


    </style>
</head>
<body>
<header>
    <div class="container">
        <div class="logo">ProRide</div>
        <nav>
            <ul>
                <li><a href="#">Home</a></li>
                <li><a href="#">Ride</a></li>
                <li><a href="#">Drive</a></li>
                <li><a href="#">Help</a></li>
                <li><a href="#">Login</a></li>
                <li><a id="signupBtn" class="signup-btn">Sign Up</a></li>
            </ul>
        </nav>
    </div>
</header>
<section id="msg" class="hero">
    <div class="container">
        <h1>Get there. Your day belongs to you.</h1>
        <p>Book a ride now or schedule one for later.</p>
        <div class="cta-buttons">
            <a href="#" class="btn-primary">Book a Ride</a>
            <a href="#" class="btn-secondary">Learn More</a>
        </div>
    </div>
</section>
<footer>
    <div class="container">
        <div class="footer-columns">
            <div class="column">
                <h4>Company</h4>
                <ul>
                    <li><a href="#">About</a></li>
                    <li><a href="#">Careers</a></li>
                    <li><a href="#">Blog</a></li>
                    <li><a href="#">Press</a></li>
                </ul>
            </div>
            <div class="column">
                <h4>Services</h4>
                <ul>
                    <li><a href="#">Ride</a></li>
                    <li><a href="#">Drive</a></li>
                    <li><a href="#">Business</a></li>
                    <li><a href="#">Freight</a></li>
                </ul>
            </div>
            <div class="column">
                <h4>Support</h4>
                <ul>
                    <li><a href="#">Help Center</a></li>
                    <li><a href="#">Safety</a></li>
                    <li><a href="#">Accessibility</a></li>
                    <li><a href="#">Community Guidelines</a></li>
                </ul>
            </div>
        </div>
        <div class="footer-bottom">
            <p>&copy; 2024 ProRide. All rights reserved.</p>
        </div>
    </div>
</footer>

<!-- Modal HTML -->
<div id="myModal" class="modal">
    <div class="modal-content">
        <h2>Select Registration Type</h2>
        <button id="userBtn" class="sgnup-btn">Register as User</button>
        <button id="driverBtn" class="sgnup-btn">Register as Driver</button>
    </div>
</div>

<script>
    document.getElementById('signupBtn').addEventListener('click', function() {
        document.getElementById('myModal').style.display = 'block';
    });

    document.getElementById('userBtn').addEventListener('click', function() {
        window.location.href = '/ProRideSpringMVC_war/user/register';
    });

    document.getElementById('driverBtn').addEventListener('click', function() {
        window.location.href = '/ProRideSpringMVC_war/driver/register';
    });

    // Close the modal if the user clicks outside of it
    window.onclick = function(event) {
        if (event.target == document.getElementById('myModal')) {
            document.getElementById('myModal').style.display = "none";
        }
    }
</script>

</body>
</html>

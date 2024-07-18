<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Registration - ProRide</title>
    <link rel="stylesheet" type="text/css" href="/views/styles.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
    <style>
        /* Add additional styles here if needed */
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
                <li><span id="signupBtn" class="signup-btn">Sign Up</span></li>
            </ul>
        </nav>
    </div>
</header>
<section>
    <div class="container">
        <h2>User Registration</h2>
        <form action="registerUser" method="post">
            <label for="firstName">First Name:</label><br>
            <input type="text" id="firstName" name="firstName" required><br><br>

            <label for="lastName">Last Name:</label><br>
            <input type="text" id="lastName" name="lastName" required><br><br>

            <label for="email">Email:</label><br>
            <input type="email" id="email" name="email" required><br><br>

            <label for="password">Password:</label><br>
            <input type="password" id="password" name="password" required><br><br>

            <label for="phone">Phone Number:</label><br>
            <input type="text" id="phone" name="phone" required><br><br>

            <label for="dob">Date of Birth:</label><br>
            <input type="date" id="dob" name="dob" required><br><br>

            <label for="address">Address:</label><br>
            <textarea id="address" name="address" rows="4" required></textarea><br><br>

            <label for="licenseNumber">Driver's License Number:</label><br>
            <input type="text" id="licenseNumber" name="licenseNumber"><br><br>

            <label for="carModel">Car Model:</label><br>
            <input type="text" id="carModel" name="carModel"><br><br>

            <input type="submit" value="Register">
        </form>
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
</body>
</html>

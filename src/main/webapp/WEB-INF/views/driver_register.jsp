<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Driver Registration</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/driver_register.css'/>">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function () {
            // Form validation logic
            $("#registrationForm").submit(function (event) {
                event.preventDefault();

                var mobileNumber = $("#mobileNumber").val();
                var password = $("#password").val();
                var licenseNumber = $("#licenseNumber").val();

                if (mobileNumber === "" || password === "" || licenseNumber === "") {
                    alert("All fields are mandatory.");
                    return false;
                }

                // Additional validation logic for mobile number, password, and license number

                // Submit the form to the server-side code
                $.ajax({
                    url: "<c:url value='/driver/register'/>",
                    type: "POST",
                    data: {
                        phoneNumber: mobileNumber,
                        password: password,
                        licenseNumber: licenseNumber
                    },
                    success: function (response) {
                        alert("Driver registered successfully.");
                        // Redirect to a success page or perform any other necessary actions
                        window.location.href = "<c:url value='/home'/>";
                    },
                    error: function (xhr, status, error) {
                        alert("Error registering driver: " + error);
                    }
                });
            });
        });
    </script>
</head>
<body>
    <header>
        <div class="container">
            <div class="logo">ProRide</div>
            <nav>
                <ul>
                    <li><a href="<c:url value='/'/>">Home</a></li>
                    <li><a href="<c:url value='/driver/register'/>" class="signup-btn">Driver Sign Up</a></li>
                </ul>
            </nav>
        </div>
    </header>

    <div class="hero">
        <div class="container">
            <h1>Driver Registration</h1>
            <p>Fill out the form below to register as a driver on ProRide.</p>
            <div id="reg">
                <form id="registrationForm">
                    <div class="form-group">
                        <label for="mobileNumber">Mobile Number</label>
                        <input type="text" id="mobileNumber" name="mobileNumber" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" id="password" name="password" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label for="licenseNumber">License Number</label>
                        <input type="text" id="licenseNumber" name="licenseNumber" class="form-control" required>
                    </div>
                    <button type="submit" class="btn-primary">Register</button>
                </form>
            </div>
        </div>
    </div>

    <footer>
        <div class="container">
            <div class="footer-columns">
                <div class="column">
                    <h4>Company</h4>
                    <ul>
                        <li><a href="#">About Us</a></li>
                        <li><a href="#">Careers</a></li>
                        <li><a href="#">Press</a></li>
                    </ul>
                </div>
                <div class="column">
                    <h4>Help</h4>
                    <ul>
                        <li><a href="#">FAQ</a></li>
                        <li><a href="#">Contact Us</a></li>
                        <li><a href="#">Terms & Conditions</a></li>
                    </ul>
                </div>
                <div class="column">
                    <h4>Social Media</h4>
                    <ul>
                        <li><a href="#">Facebook</a></li>
                        <li><a href="#">Twitter</a></li>
                        <li><a href="#">Instagram</a></li>
                    </ul>
                </div>
            </div>
            <div class="footer-bottom">
                &copy; 2022 ProRide. All rights reserved.
            </div>
        </div>
    </footer>
</body>
</html>
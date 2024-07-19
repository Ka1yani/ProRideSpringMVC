<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Registration - ProRide</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/user_register.css'/>">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
</head>
<body>
<header>
    <div class="container">
        <div class="logo">ProRide</div>
        <nav>
            <ul>
                <li><a href="<c:url value='/'/>">Home</a></li>
                <li><a href="<c:url value='/login'/>">Login</a></li>
                <li><a href="<c:url value='/register'/>" class="signup-btn">Sign Up</a></li>
            </ul>
        </nav>
    </div>
</header>

<div id="reg">
    <h1>User Registration</h1>
    <c:url var="post_url" value="/user/register"/>
    <form:form method="post"
               action="${post_url}"
               modelAttribute="user">
        <div class="form-group">
            <label for="phoneNumber">Mobile Number:</label>
            <form:input path="phoneNumber" id="phoneNumber" class="form-control" required="true" pattern=".{10}"
                        title="Mobile Number must be 10 characters long"/>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <form:password path="password" id="password" class="form-control" required="true"
                           pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$"
                           title="Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one digit, and one special character"/>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary">SignUp</button>
        </div>
    </form:form>
</div>

<footer>
    <div class="container">
        <div class="footer-columns">
            <div class="column">
                <h4>About ProRide</h4>
                <ul>
                    <li><a href="<c:url value='/about'/>">About Us</a></li>
                    <li><a href="<c:url value='/contact'/>">Contact Us</a></li>
                </ul>
            </div>
            <div class="column">
                <h4>Support</h4>
                <ul>
                    <li><a href="<c:url value='/faq'/>">FAQ</a></li>
                    <li><a href="<c:url value='/support'/>">Support</a></li>
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
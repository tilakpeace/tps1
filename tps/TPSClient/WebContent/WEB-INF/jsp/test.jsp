<!DOCTYPE html>
<html>
<head>
    <meta charset="US-ASCII">
    <title>Login Page</title>
    <script src='https://www.google.com/recaptcha/api.js'></script>
</head>
<body>

<form action="LoginServlet" method="post">

    Username: <input type="text" name="user"> <br> Password:
    <input type="password" name="pwd"> <br>
    <div class="g-recaptcha" data-sitekey="6LfDkygTAAAAACCCaeSTsWUa5PmViMO_yflTFeTI"></div>
    <br> <input type="submit" value="Login">
</form>
</body>
</html>
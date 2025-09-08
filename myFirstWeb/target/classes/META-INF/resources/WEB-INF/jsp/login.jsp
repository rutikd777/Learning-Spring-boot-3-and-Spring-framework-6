<html>
    <head>
        <title>Login page</title>
    </head>
    <body>


        <div class="container">
            <h1>Welcome to the login page</h1>
            <pre>${errorMsg}</pre>
            <form method="post" action="welcome">
                Name: <input type="text" name="name" required><br><br>
                Password: <input type="password" name="password" required><br><br>
                <input type="submit" value="Login">
            </form>
        </div>
    </body>
</html>

<html>

    <head>
             <title>
                    Welcome page
             </title>
    </head>

    <body>

        <%@ include file="common/navigation.jspf" %>

        <div class="container">
                <h1> Welcome</h1>

                 <div>Name: ${name}
                 </div>
                    <br>
                 <div>
                        <a href="list-todos">todoList</a>
                 </div>
        </div>
    </body>

</html>
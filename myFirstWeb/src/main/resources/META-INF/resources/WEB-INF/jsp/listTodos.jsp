<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <link href="webjars/bootstrap/5.3.7/css/bootstrap.min.css" rel="stylesheet">
        <title>Todo List</title>
    </head>
    <body>

         <%@ include file="common/navigation.jspf" %>

        <div class="container">
            <h1>Welcome to the todo page</h1>

            <table class="table">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Description</th>
                        <th>Target Date</th>
                        <th>Is Done?</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${todos}" var="todo">
                        <tr>
                            <td>${todo.id}</td>
                            <td>${todo.desc}</td>
                            <td>${todo.targetDate}</td>
                            <td>${todo.done}</td>
                            <td>
                                <a href="update?id=${todo.id}" class="btn btn-success btn-sm">Update</a>
                                <a href="delete?id=${todo.id}" class="btn btn-warning btn-sm ms-1"
                                   onclick="return confirm('Are you sure you want to delete this todo?')">
                                   Delete
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <a href="add-todo" class="btn btn-success">Add Todo</a>
        </div>
        <script src="webjars/bootstrap/5.3.7/js/bootstrap.min.js"></script>
        <script src="webjars/jquery/3.7.1/jquery.min.js"></script>
    </body>
</html>
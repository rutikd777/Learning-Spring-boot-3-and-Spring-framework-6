<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <link href="webjars/bootstrap/5.3.7/css/bootstrap.min.css" rel="stylesheet">
        <title>${todo.id == 0 ? 'Add' : 'Update'} Todo</title>
    </head>
    <body>

        <%@ include file="common/navigation.jspf" %>

        <div class="container">
            <h1>${todo.id == 0 ? 'Add' : 'Update'} Todo</h1>

            <c:choose>
                <c:when test="${todo.id == 0}">
                    <form:form method="post" modelAttribute="todo" action="add-todo">
                        <div class="mb-3">
                            <label for="desc" class="form-label">Description:</label>
                            <form:input type="text" path="desc" class="form-control" id="desc"
                                       placeholder="Enter todo description (min 10 characters)" />
                            <form:errors path="desc" cssClass="text-danger" />
                        </div>

                        <div class="mb-3">
                            <label for="targetDate" class="form-label">Target Date:</label>
                            <form:input type="date" path="targetDate" class="form-control" id="targetDate" />
                            <form:errors path="targetDate" cssClass="text-danger" />
                        </div>

                        <form:input type="hidden" path="id" />
                        <form:input type="hidden" path="done" />

                        <input type="submit" class="btn btn-success" value="Add Todo" />
                        <a href="list-todos" class="btn btn-secondary ms-2">Cancel</a>
                    </form:form>
                </c:when>
                <c:otherwise>
                    <form:form method="post" modelAttribute="todo" action="update">
                        <div class="mb-3">
                            <label for="desc" class="form-label">Description:</label>
                            <form:input type="text" path="desc" class="form-control" id="desc"
                                       placeholder="Enter todo description (min 10 characters)" />
                            <form:errors path="desc" cssClass="text-danger" />
                        </div>

                        <div class="mb-3">
                            <label for="targetDate" class="form-label">Target Date:</label>
                            <form:input type="date" path="targetDate" class="form-control" id="targetDate" />
                            <form:errors path="targetDate" cssClass="text-danger" />
                        </div>

                        <div class="mb-3 form-check">
                            <form:checkbox path="done" class="form-check-input" id="done" />
                            <label class="form-check-label" for="done">Completed</label>
                        </div>

                        <form:input type="hidden" path="id" />

                        <input type="submit" class="btn btn-primary" value="Update Todo" />
                        <a href="list-todos" class="btn btn-secondary ms-2">Cancel</a>
                    </form:form>
                </c:otherwise>
            </c:choose>
        </div>
        <script src="webjars/bootstrap/5.3.7/js/bootstrap.min.js"></script>
        <script src="webjars/jquery/3.7.1/jquery.min.js"></script>
    </body>
</html>
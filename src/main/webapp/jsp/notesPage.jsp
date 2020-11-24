<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <style>
        .note-form {
            width: 80%;
            margin: auto;
        }
    </style>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<div class="note-form">
    <form action="/notes/add-note" method="post">
        <div class="form-group">
            <label for="note-theme">Title</label>
            <input type="text" class="form-control" id="note-theme" name="title">
        </div>
        <div class="form-group">
            <label for="note">Note</label>
            <textarea class="form-control" id="note" rows="3" name="note"></textarea>
        </div>
        <input type="hidden" name="userId" value="${userId}">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-primary">Add</button>
    </form>
</div>

<table class="table table-dark">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Title</th>
        <th scope="col">Note</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>

        <c:forEach items="${notes}" var="note">
            <tr>
                <td>${note.id}</td>
                <td>${note.title}</td>
                <td>${note.note}</td>
                <td>
<%--                    Delete form and make delete mapping--%>
                    <div class="d-flex flex-row">
                        <a href="/notes/edit/${note.id}" class="btn btn-outline-warning" style="height: 38px">Edit</a>
                        <form action="/notes/delete/${note.id}" method="post">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            <button type="submit" class="btn btn-danger">Delete</button>
                        </form>
                    </div>
                </td>
            </tr>
        </c:forEach>

    </tbody>
</table>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

</body>
</html>

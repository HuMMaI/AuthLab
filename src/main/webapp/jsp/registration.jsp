<%--
  Created by IntelliJ IDEA.
  User: Dmytr
  Date: 10/19/2020
  Time: 12:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <style>
        .login-form {
            width: 40%;
            margin: auto;
        }
    </style>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<div class="login-form">
    <form action="/registration" method="post">
        <div class="form-group">
            <label for="email-lbl">Email:</label>
            <input type="text" class="form-control" id="email-lbl" name="email">
        </div>
        <div class="form-group">
            <label for="password-lbl">Password:</label>
            <input type="password" class="form-control" id="password-lbl" name="password">
        </div>
        <div class="form-group">
            <label for="first-name-lbl">First name:</label>
            <input type="text" class="form-control" id="first-name-lbl" name="firstName">
        </div>
        <div class="form-group">
            <label for="last-name-lbl">Last name:</label>
            <input type="text" class="form-control" id="last-name-lbl" name="lastName">
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-primary">Sign up</button>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

</body>
</html>

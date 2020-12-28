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
    <form action="/spring_security_check" method="post">
        <div class="form-group">
            <label for="email-lbl">Email:</label>
            <input type="text" class="form-control" id="email-lbl" name="email">
        </div>
        <div class="form-group">
            <label for="password-lbl">Password:</label>
            <input type="password" class="form-control" id="password-lbl" name="password">
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <div class="d-flex justify-content-between">
            <button type="submit" class="btn btn-primary" id="sign-in-btn">Sign in</button>
        </div>
    </form>
</div>

<%--<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>--%>
<%--<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>--%>
<%--<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>--%>
<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>--%>

<%--<script src="${pageContext.request.contextPath}/js/authFailure.js"></script>--%>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.2/rollups/aes.js"></script>
<script src="${pageContext.request.contextPath}/js/diffieHellman.js"></script>

</body>
</html>

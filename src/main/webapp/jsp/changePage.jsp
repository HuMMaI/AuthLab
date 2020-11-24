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
    <form action="/pw/change" method="post">
        <div class="form-group">
            <label for="email-lbl">Email:</label>
            <input type="text" class="form-control" id="email-lbl" name="email">
        </div>
        <div class="form-group">
            <label for="old-password-lbl">Old password:</label>
            <input type="password" class="form-control" id="old-password-lbl" name="oldPassword">
        </div>
        <div class="form-group">
            <label for="password-lbl">New password:</label>
            <input type="password" class="form-control" id="password-lbl" name="newPassword">
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-primary">Change</button>
    </form>
</div>

</body>
</html>

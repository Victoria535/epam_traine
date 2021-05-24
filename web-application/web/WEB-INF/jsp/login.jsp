<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <%--    <link href="../login.css" rel="stylesheet" type="text/css">--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/all.js"></script>
    <meta charset="UTF-8">
    <title>Авторизация</title>

    <style>
        body {
            background: grey
        }

        .container {
            margin: auto;
            width: 500px;
            height: 500px;
        }

        .form-horizontal {
            background: #fff;
            padding-bottom: 40px;
            border-radius: 15px;
            text-align: center;
        }

        .form-horizontal .heading {
            display: block;
            font-size: 35px;
            font-weight: 700;
            padding: 35px 0;
            border-bottom: 1px solid #f0f0f0;
            margin-bottom: 30px;
        }

        .form-horizontal .form-group {
            padding: 0 40px;
            margin: 0 0 25px 0;
            position: relative;
        }

        .form-horizontal .form-control {
            background: #f0f0f0;
            border: none;
            border-radius: 20px;
            box-shadow: none;
            padding: 0 20px 0 45px;
            height: 40px;
            transition: all 0.3s ease 0s;
        }

        .form-horizontal .form-control:focus {
            background: #e0e0e0;
            box-shadow: none;
            outline: 0 none;
        }

        .form-horizontal .btn {
            float: right;
            font-size: 14px;
            color: #fff;
            background: #00b4ef;
            border-radius: 30px;
            padding: 10px 25px;
            border: none;
            text-transform: capitalize;
            transition: all 0.5s ease 0s;
        }

        .error {
            color: red;
        }

    </style>
</head>
<body>

<div class="container">
    <c:url var="loginUrl" value="/login"/>
    <form class="form-horizontal" action="${loginUrl}" method="post">
        <span class="heading">АВТОРИЗАЦИЯ</span>
        <c:if test="${not empty param.message}">
            <div class="error">${param.message}</div>
        </c:if>
        <div class="form-group">
            <input name="login" class="form-control" placeholder="Login">
        </div>
        <div class="form-group help">
            <input type="password" name="password" class="form-control" placeholder="Password">
            <br/>
            <button class="btn btn-default">Войти</button>
        </div>
    </form>
</div><!-- /.container -->
</body>

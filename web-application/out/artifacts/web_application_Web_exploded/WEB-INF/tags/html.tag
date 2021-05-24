<%@tag language="java" pageEncoding="UTF-8" %>
<%@attribute name="title" required="true" rtexprvalue="true" type="java.lang.String" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
    <meta charset="UTF-8">
    <title>${title}</title>
</head>
<body>
<c:url var="listCourse" value="/listCourse"/>
<c:url var="listMark" value="/listMark"/>

<nav class="navbar sticky-top navbar-light bg-light">
    <div class="container-fluid">

        <c:choose>
            <c:when test="${currentUser.role == 'ADMIN'}">
                <c:url var="listUser" value="/listUser"/>
                <a class="navbar-brand" href="${listUser}"> Users </a>
            </c:when>
        </c:choose>

        <a class="navbar-brand" href="${listCourse}"> Courses </a>

        <c:choose>
            <c:when test="${currentUser.role == 'ADMIN'}">
                <c:url var="listCoursesStudents" value="/listCoursesStudents"/>
                <a class="navbar-brand" href="${listCoursesStudents}"> Courses-Students </a>
            </c:when>
        </c:choose>

        <c:if test="${currentUser.role == 'TEACHER'}">
            <c:url var="listMyCourses" value="/listMyCourses"/>
            <a class="navbar-brand" href="${listMyCourses}"> My courses </a>
        </c:if>

        <a class="navbar-brand" href="${listMark}"> Marks </a>

        <c:if test="${currentUser.role == 'STUDENT'}">
            <c:url var="listMyMarks" value="/listMyMarks"/>
            <a class="navbar-brand" href="${listMyMarks}"> My marks </a>
        </c:if>

        <c:choose>
            <c:when test="${not empty currentUser}">
                <c:url var="logOut" value="/logout"/>
                <a class="navbar-brand" href="${logOut}">Log out</a>
            </c:when>
            <c:otherwise>
                <c:url var="logIn" value="/login"/>
                <a class="navbar-brand" href="${logIn}">Log in</a>
            </c:otherwise>
        </c:choose>

    </div>
</nav>

<jsp:doBody/>

<footer class="text-center text-lg-start bg-light text-muted">
    <div class="text-center p-4" style="background-color: rgba(0, 0, 0, 0.05);">
        Create by Viktoryia Symaniuk
    </div>
</footer>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="u" %>

<u:html title="List of course">
    <table class="table table-striped">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Title</th>
            <th scope="col">Description</th>
            <th scope="col"></th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="course" items="${courses}">
            <c:url var="editCourse" value="/editCourse">
                <c:param name="id" value="${course.id}"/>
            </c:url>
            <c:url var="deleteCourse" value="/deleteCourse">
                <c:param name="id" value="${course.id}"/>
            </c:url>
            <tr>
                <td>${course.title}</td>
                <td>${course.description}</td>
                <td><a href="${editCourse}">&#9998;</a></td>
                <td><a href="${deleteCourse}">&#10006;</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a href="<c:url value="/editCourse"/>"> Add </a>
</u:html>

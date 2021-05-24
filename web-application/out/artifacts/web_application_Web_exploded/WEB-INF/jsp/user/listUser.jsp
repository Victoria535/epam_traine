<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="u" %>

<u:html title="List of users">
    <table class="table table-striped">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Login</th>
            <th scope="col">Role</th>
            <th scope="col"></th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <c:url var="editUser" value="/editUser">
                <c:param name="id" value="${user.id}"/>
            </c:url>
            <c:url var="deleteUser" value="/deleteUser">
                <c:param name="id" value="${user.id}"/>
            </c:url>
            <tr>
                <td>${user.name}</td>
                <td>${user.login}</td>
                <td>${user.role}</td>

                <td><a href="${editUser}">&#9998;</a></td>
                <td><a href="${deleteUser}">&#10006;</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a href="<c:url value="/editUser"/>"> Add </a>

</u:html>

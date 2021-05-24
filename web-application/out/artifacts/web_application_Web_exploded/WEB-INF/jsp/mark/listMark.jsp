<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="u" %>

<u:html title="List of marks">
    <%--    <jsp:useBean id="currentUser" class="com.application.entity.User"/>--%>
    <table class="table table-striped">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Student</th>
            <th scope="col">Course</th>
            <th scope="col">Mark</th>


            <c:if test="${currentUser.role == 'ADMIN'}">
                <th scope="col"></th>
                <th scope="col"></th>
            </c:if>

            <c:if test="${currentUser.role == 'TEACHER'}">
                <th scope="col"></th>
                <th scope="col"></th>
            </c:if>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="mark" items="${marks}">

            <tr>
                <td>${mark.student.name}</td>
                <td>${mark.course.title}</td>
                <c:choose>
                    <c:when test="${mark.mark == 0}">
                        <td>wait</td>
                    </c:when>
                    <c:otherwise>
                        <td>${mark.mark}</td>
                    </c:otherwise>
                </c:choose>

                <c:if test="${currentUser.role == 'ADMIN'}">
                    <c:url var="editMark" value="/editMark">
                        <c:param name="id" value="${mark.id}"/>
                    </c:url>
                    <td><a href="${editMark}">&#9998;</a></td>
                    <c:url var="deleteMark" value="/deleteMark">
                        <c:param name="id" value="${mark.id}"/>
                    </c:url>
                    <td><a href="${deleteMark}">&#10006;</a></td>
                </c:if>

                <c:if test="${currentUser.role == 'TEACHER'}">
                    <c:url var="editMark" value="/editMark">
                        <c:param name="id" value="${mark.id}"/>
                    </c:url>
                    <td><a href="${editMark}">&#9998;</a></td>
                    <c:url var="deleteMark" value="/deleteMark">
                        <c:param name="id" value="${mark.id}"/>
                    </c:url>
                    <td><a href="${deleteMark}">&#10006;</a></td>
                </c:if>

            </tr>
        </c:forEach>
        </tbody>
    </table>

    <c:if test="${currentUser.role == 'ADMIN'}">
        <a href="<c:url value="/editMark"/>"> Add </a>
    </c:if>
    <c:if test="${currentUser.role == 'TEACHER'}">
        <a href="<c:url value="/editMark"/>"> Add </a>
    </c:if>
</u:html>

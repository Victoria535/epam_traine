<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="u" %>

<u:html title="List of marks">
    <table class="table table-striped">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Course</th>
            <th scope="col">Mark</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="mark" items="${marks}">
            <tr>
                <td>${mark.course.title}</td>
                <c:choose>
                    <c:when test="${mark.mark == 0}">
                        <td>wait</td>
                    </c:when>
                    <c:otherwise>
                        <td>${mark.mark}</td>
                    </c:otherwise>
                </c:choose>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</u:html>

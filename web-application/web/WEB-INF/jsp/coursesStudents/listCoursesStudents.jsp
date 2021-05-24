<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="u" %>

<u:html title="List of users">
    <table class="table table-striped">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Course</th>
            <th scope="col">Student</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="courses" items="${courses}">
            <c:url var="deleteCoursesStudents" value="/deleteCoursesStudents">
                <c:param name="courseId" value="${courses.course.id}"/>
                <c:param name="studentId" value="${courses.student.id}"/>
            </c:url>
            <tr>
                <td>${courses.course.title}</td>
                <td>${courses.student.name}</td>

                <td><a href="${deleteCoursesStudents}">&#10006;</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</u:html>

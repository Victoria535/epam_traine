<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="u" %>

<u:html title="List of course">
    <table class="table table-striped">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Title</th>
            <th scope="col">Teacher</th>
            <th scope="col">Description</th>

            <c:choose>
                <c:when test="${currentUser.role == 'ADMIN'}">
                    <th scope="col"></th>
                    <th scope="col"></th>
                </c:when>
            </c:choose>
            <c:choose>
                <c:when test="${currentUser.role == 'STUDENT'}">
                    <th scope="col"></th>
                </c:when>
            </c:choose>

        </tr>
        </thead>
        <tbody>
        <c:forEach var="course" items="${courses}">
            <tr>
                <td>${course.key.title}</td>
                <td>${course.key.teacher.name}</td>
                <td>${course.key.description}</td>

                <c:choose>
                    <c:when test="${currentUser.role == 'ADMIN'}">
                        <c:url var="editCourse" value="/editCourse">
                            <c:param name="id" value="${course.key.id}"/>
                        </c:url>
                        <td><a style="text-decoration: none" href="${editCourse}">&#9998;</a></td>

                        <c:url var="deleteCourse" value="/deleteCourse">
                            <c:param name="id" value="${course.key.id}"/>
                        </c:url>
                        <td><a style="text-decoration: none" href="${deleteCourse}">&#10006;</a></td>
                    </c:when>
                </c:choose>

                <c:choose>
                    <c:when test="${currentUser.role == 'STUDENT'}">
                        <c:url var="saveCoursesStudents" value="/saveCoursesStudents">
                            <c:param name="courseId" value="${course.key.id}"/>
                            <c:param name="studentId" value="${currentUser.id}"/>
                            <c:param name="courseTitle" value="${course.key.title}"/>
                            <c:param name="studentName" value="${currentUser.name}"/>
                        </c:url>
                        <c:url var="deleteCoursesStudents" value="/deleteCoursesStudents">--%>
                            <c:param name="courseId" value="${course.key.id}"/>
                            <c:param name="studentId" value="${currentUser.id}"/>
                        </c:url>

                        <c:choose>
                            <c:when test="${course.value == 'SUBSCRIBABLE'}">
                                <td><a style="text-decoration: none" href="${deleteCoursesStudents}"> unsubscribe </a></td>
                            </c:when>
                            <c:otherwise>
                                <td><a style="text-decoration: none" href="${saveCoursesStudents}"> subscribe </a></td>
                            </c:otherwise>
                        </c:choose>

                    </c:when>
                </c:choose>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <c:if test="${currentUser.role == 'ADMIN'}">
        <a href="<c:url value="/editCourse"/>"> Add </a>
    </c:if>

</u:html>

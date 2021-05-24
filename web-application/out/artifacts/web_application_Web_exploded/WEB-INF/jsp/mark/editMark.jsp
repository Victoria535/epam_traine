<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="u" %>

<c:choose>
    <c:when test="${empty mark}">
        <jsp:useBean id="mark" class="com.application.entity.Mark"/>
        <c:set var="title" value="Add mark"/>
    </c:when>
    <c:otherwise>
        <c:set var="title" value="Edit mark for student ${mark.student.name}"/>
    </c:otherwise>
</c:choose>

<u:html title="${title}">
    <c:url var="saveMark" value="/saveMark"/>
    ${title}
    <form method="post">
        <c:if test="${not empty mark.id}">
            <label class="form-label" hidden> Id:
                <input type="text" name="id" value="${mark.id}"> <br/>
            </label>
        </c:if>
        <label class="form-label"> Student:
            <select name="student">
                <c:forEach var="user" items="${students}">
                    <jsp:useBean id="user" class="com.application.entity.User"/>
                    <c:choose>
                        <c:when test="${mark.student.id == user.id}">
                            <option selected>${user.name}</option>
                        </c:when>
                        <c:otherwise>
                            <option>${user.name}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
            <br/>
        </label>
        <br/>
        <label class="form-label"> Course:
            <select name="course">
                <jsp:useBean id="course" class="com.application.entity.Course"/>
                <c:choose>
                    <c:when test="${currentUser.role == 'ADMIN'}">
                        <c:forEach var="course" items="${courses}">
                            <c:choose>
                                <c:when test="${mark.course.id == course.id}">
                                    <option selected>${course.title}</option>
                                </c:when>
                                <c:otherwise>
                                    <option>${course.title}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <c:forEach var="course" items="${myCourses}">
                            <c:choose>
                                <c:when test="${mark.course.id == course.id}">
                                    <option selected>${course.title}</option>
                                </c:when>
                                <c:otherwise>
                                    <option>${course.title}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </select>
        </label>
        <br/>
        <label class="form-label"> Mark:
            <input type="number" min="0" name="mark" value="${mark.mark}"> <br/>
        </label>
        <br/>

        <button formaction="${saveMark}" class="btn btn-primary">Save</button>
    </form>

</u:html>



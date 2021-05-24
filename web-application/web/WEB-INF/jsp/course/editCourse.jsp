<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="u" %>

<c:choose>
    <c:when test="${empty course}">
        <jsp:useBean id="course" class="com.application.entity.Course"/>
        <c:set var="title" value="Add course"/>
    </c:when>
    <c:otherwise>
        <c:set var="title" value="Edit course ${course.title}"/>
    </c:otherwise>
</c:choose>

<u:html title="${title}">
    ${title}
    <c:if test="${not empty param.message}">
        <div class="message error">${param.message}</div>
    </c:if>
    <form method="post">
        <c:if test="${not empty course.id}">
            <label class="form-label" hidden> Id:
                <input type="text" name="id" value="${course.id}"> <br/>
            </label>
        </c:if>
        <label class="form-label"> Title:
            <input type="text" name="title" value="${course.title}"> <br/>
        </label>
        <c:choose>
            <c:when test="${currentUser.role == 'ADMIN'}">
                <br/>
                <label class="form-label"> Teacher:
                    <select name="teacher">
                        <c:forEach var="user" items="${teachers}">
                            <jsp:useBean id="user" class="com.application.entity.User"/>
                            <c:choose>
                                <c:when test="${course.teacher.id == user.id}">
                                    <option selected>${user.name}</option>
                                </c:when>
                                <c:otherwise>
                                    <option>${user.name}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </label>
                <br/>
            </c:when>
            <c:otherwise>
                <input type="text" name="teacher" value="${currentUser.name}" hidden> <br/>
            </c:otherwise>
        </c:choose>


        <label class="form-label"> Description:
            <input type="text" name="description" value="${course.description}"> <br/>
        </label>
        <br/>
        <c:url var="saveCourse" value="/saveCourse"/>
        <button formaction="${saveCourse}" class="btn btn-primary">Save</button>
    </form>

</u:html>



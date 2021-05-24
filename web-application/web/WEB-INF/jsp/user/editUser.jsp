<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="u" %>

<c:choose>
    <c:when test="${empty user}">
        <jsp:useBean id="user" class="com.application.entity.User"/>
        <c:set var="title" value="Add user"/>
    </c:when>
    <c:otherwise>
        <c:set var="title" value="Edit user ${user.name}"/>
    </c:otherwise>
</c:choose>

<u:html title="${title}">
    <c:url var="saveUser" value="/saveUser"/>
    ${title}
    <c:if test="${not empty param.message}">
        <div class="message error">${param.message}</div>
    </c:if>
    <form method="post">
        <c:if test="${not empty user.id}">
        <label class="form-label" hidden> Id:
            <input type="text" name="id" value="${user.id}"> <br/>
        </label>
        </c:if>
        <label class="form-label"> Name:
            <input type="text" name="name" value="${user.name}"> <br/>
        </label>
        <br/>
        <label class="form-label"> Login:
            <input type="text" name="login" value="${user.login}"> <br/>
        </label>
        <br/>
        <label class="form-label"> Password:
            <input type="text" name="password" value="${user.password}"> <br/>
        </label>
        <br/>
        <label class="form-label"> Role:
            <select name="role">
                <c:forEach var="role" items="${roles}">
                    <c:choose>
                        <c:when test="${user.role == role}">
                            <option selected>${role}</option>
                        </c:when>
                        <c:otherwise>
                            <option>${role}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select> <br/>
        </label>
        <br/>

        <button formaction="${saveUser}" class="btn btn-primary">Save</button>
    </form>
</u:html>



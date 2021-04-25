<%--
  Created by IntelliJ IDEA.
  User: Slegonca
  Date: 24.04.2021
  Time: 8:26
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="ru">
<body>
<div>

    <form:form method="POST" modelAttribute="userForm">

        <h2>Create your account</h2>
        <spring:bind path="username">
            <div ${status.error ? 'has-error' : ''}>
                <form:input type="text" path="username" class="form-control" placeholder="Username"
                            autofocus="true"/>

                <div> <form:errors path="username"/> <div/>

            </div>
        </spring:bind>

        <spring:bind path="password">
            <div ${status.error ? 'has-error' : ''}>
                <form:input type="password" path="password" class="form-control" placeholder="Password"/>
                <div> <form:errors path="password"/> <div/>
            </div>
        </spring:bind>

        <spring:bind path="confirmPassword">
            <div ${status.error ? 'has-error' : ''}>
                <form:input type="password" path="confirmPassword" class="form-control"
                            placeholder="Confirm your password"/>
                <div> <form:errors path="confirmPassword"/> <div/>
            </div>
        </spring:bind>

        <button type="submit">Submit</button>

    </form:form>

</div
</body>
</html>


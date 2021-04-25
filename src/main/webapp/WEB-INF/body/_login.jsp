<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Slegonca
  Date: 24.04.2021
  Time: 9:15
  To change this template use File | Settings | File Templates.
--%>
<html lang="en">
<body>
<div>

    <form method="POST" action="${contextPath}/login">
        <h2>Log in</h2>

        <div ${error != null ? 'has-error' : ''}>
            <input name="username" type="text" placeholder="Username"
                   autofocus="true"/>
            <input name="password" type="password" placeholder="Password"/>
            <button type="submit">Log In</button>

            <div>${error}</div>

            <h4><a href="${contextPath}/registration">Create an account</a></h4>
        </div>

    </form>

    <form action="/logout/">
        <button type="submit">Log out</button>
    </form>

</div>
</body>
</html>

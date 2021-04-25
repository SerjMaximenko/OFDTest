<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Slegonca
  Date: 23.04.2021
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<br>
Username: ${username}


<head>
<style>
    table.center {
        border-collapse: collapse;
        width: 300px;
    }
</style>
</head>

<table class="center" align="center">



    <caption><h2>Balances</h2></caption>
    <tr>
        <th>Balance</th>
        <th>Balance Type</th>
        <th>Added</th>
    </tr>
    <c:forEach var="o" items="${objects}">
        <tr>
            <td>${o.getBalance()}</td>
            <td>${o.getBalanceType()}</td>
            <td>
            <fmt:parseDate value="${o.getChanged()}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
            <fmt:formatDate pattern="dd.MM.yyyy HH:mm" value="${ parsedDateTime }" /></td>
        </tr>
    </c:forEach>
</table>

</head>

<div class="container">

    <form:form method="POST" modelAttribute="balanceAdd">

        <h3>Add balance to this user</h3>

        <spring:bind path="balance">
             ${status.error ? 'has-error' : ''}
                <form:input type="text" path="balance" placeholder="Balance"
                            autofocus="true"/>
        </spring:bind>

        <spring:bind path="balanceType">
             ${status.error ? 'has-error' : ''}
                <form:select size="1" path="balanceType">
                    <option value="Free">Free</option>
                    <option selected value="Fixed">Fixed</option>
                </form:select>

        </spring:bind>

        <button type="submit">Add</button>

        <div>
            <form:errors path="balance"/>
        </div>
        <div>
            <form:errors path="balanceType"/>
        </div>




    </form:form>

</div
</body>




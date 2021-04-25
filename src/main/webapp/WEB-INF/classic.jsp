<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: Slegonca
  Date: 23.04.2021
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title><tiles:getAsString name="title" /></title>
    <style>
        table.main {
            border-collapse: collapse;
            width: 100%;
        }
        TH, TD {
            border: 1px solid black;
            text-align: center;
            padding: 4px;
        }
        TH {
            background: #fc0;
            height: 40px;
            vertical-align: bottom;
            padding: 0;
        }
    </style>
</head>

<body>
<table class="main">
    <tr>
        <td colspan="2">
            <tiles:insertAttribute name="header" />
        </td>
    </tr>
    <tr>
        <td width="20%" nowrap="nowrap">
            <tiles:insertAttribute name="menu" />
        </td>
        <td width="80%" height="500px">
            <tiles:insertAttribute name="body" />
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <tiles:insertAttribute name="footer" />
        </td>
    </tr>
</table>
</body>
</html>




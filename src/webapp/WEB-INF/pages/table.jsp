
<%--
  Created by IntelliJ IDEA.
  User: andrei
  Date: 21.02.2020
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>PreProjectSpring3</title>

    <link href="<c:url value="/css/table.css" />" rel="stylesheet">
</head>
<body>

<div align="center"><h2>Список Пользователей</h2></div>
<form>
<table>
    <thead>
    <tr>
        <th>Имя</th>
        <th>Пароль</th>
        <th>Номер Пользователя</th>
        <th>Удалить</th>
        <th>Изменить</th>
    </tr>
    </thead>
    <tbody>


    <c:forEach var="user" items="${requestScope.users}">
        <tr>
            <td><strong> <c:out value="${user.name}"/></strong></td>

            <td><c:out value="${user.password}"/></td>
            <td><c:out value="${user.id}"/></td>

            <td>
                <button formaction="/remove" formmethod="post" type="submit" name="id" value="${user.id}">Удалить</button>
            </td>
            <td>
                <button formaction="/update" formmethod="get" type="submit" name="id" value="${user.id}">Изменить

                </button>
            </td>

        </tr>
    </c:forEach>
    </tbody>
    <thead>
    <tr>
        <th><label><input type="text" name="name"/></label> </th>
        <th><label> <input type="text" name="password"/></label></th>
        <th><input formaction="/table" formmethod="post" type="submit" value="Добавить пользователя"></th>

    </tr>
    </thead>


</table>
</form>

</body>
</html>

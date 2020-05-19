<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/15
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>学生信息</h2>
    <form:form modelAttribute="student">
        学生ID：<form:input path="id"/><br/>
        学生姓名：<form:input path="name"/><br/>
        学生年龄：<form:input path="age"/><br/>
        学生爱好：<form:checkboxes items="${student.hobby}" path="selectHobby"/><br/>
        <input type="submit" value="提交">
    </form:form>
</body>
</html>

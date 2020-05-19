<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/file/uploads" method="post" enctype="multipart/form-data">
        img1:<input type="file" name="imgs"/><br/>
        img2:<input type="file" name="imgs"/><br/>
        <input type="submit" value="上传">
    </form>
    <c:forEach items="${files}" var="file">
        <img src="${file}" width="300px">
    </c:forEach>
</body>
</html>

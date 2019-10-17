<%@ page contentType="text/html;charset=utf-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
<head>
    <%--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>
    <meta charset="utf-8">
    <title>我是一个粉刷匠</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/upload/test" method="post" enctype="multipart/form-data">
    <input type="file" name="fileTest"/>
    <input type="submit" value="上传"/>
</form>

<a href="${pageContext.request.contextPath}/download/test?fileName=idea快捷键.txt">点我下载</a>
</body>
</html>
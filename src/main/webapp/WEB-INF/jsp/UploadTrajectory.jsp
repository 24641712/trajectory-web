<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>上传数据</title>

</head>
<body>

<form action="/batchInsert" enctype="multipart/form-data" method="post">
    <input type="file" name="file"><br><br>
    <input type="text" name="number"><br><br>
    <input type="submit" value="上传">
</form>

</body>



</html>
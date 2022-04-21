<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>글 작성-MVC 게시판 프로젝트</title>
</head>
<body>
<h2>글 작성</h2>
<form action="insert" method="post" enctype="multipart/form-data">
    작성자 : <input type="text" name="writer"><br>
    제목 : <input type="text" name="title"><br>
    파일 : <input type="file" name="f_name"><hr>
    내용 <br>
    <textarea cols="60" rows="10" name="contents"></textarea><br>
    <input type="submit" value="작성하기">
</form>
</body>
</html>

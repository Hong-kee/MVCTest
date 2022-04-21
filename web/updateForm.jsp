<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>글 수정폼-MVC 게시판 프로젝트</title>
</head>
<body>
<h3>글 수정폼</h3>
<form action="update" method="post">
    <input type="hidden" name="seq" value="${myBoard.seq}"/>
    작성자 : ${myBoard.writer}<br>
    제목 : <input type="text" name="title" value="${myBoard.title}"><br>
    내용 : <br>
    <textarea rows="6" cols="70" name="contents">${myBoard.contents}</textarea>
    <input type="submit" value="수정 하기">
</form>
</body>
</html>

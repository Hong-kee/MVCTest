<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <td>글 번호</td>
        <td>제목</td>
        <td>작성자</td>
        <td>작성 일자</td>
        <td>조회수</td>
        <td>글 내용</td>
        <td>파일 이름</td>
    </tr>
    <tr>
        <td>${myBoard.seq}</td>
        <td>${myBoard.title}</td>
        <td>${bomyBoardard.writer}</td>
        <td>${myBoard.regDate}</td>
        <td>${myBoard.hitCount}</td>
        <td>${myBoard.contents}</td>
        <td><a href="/download.jsp?filename=${myBoard.f_name}">${myBoard.f_name}</a></td>
    </tr>
</table>

<h4>댓글 목록</h4>
<table border="1">
    <tr>
        <td>댓글 번호</td>
        <td>댓글 제목</td>
        <td>댓글 작성자</td>
        <td>댓글 내용</td>
        <td>댓글 일자</td>
    </tr>
    <c:forEach var="myReply" items="${listReply}">
        <tr>
            <td>${myReply.mr_no}</td>
            <td>${myReply.mr_title}</td>
            <td>${myReply.mr_writer}</td>
            <td>${myReply.mr_contents}</td>
            <td>${myReply.mr_regDate}</td>
        </tr>
    </c:forEach>
</table>

<form action="insertReply" method="post">
    <input type="hidden" name="seq" value="${myBoard.seq}">
    댓글 제목 : <input type="text" name="mr_title"><br>
    댓글 작성자 : <input type="text" name="mr_writer"><br>
    댓글 내용 : <input type="text" name="mr_contents"><br>
    <input type="submit" value="댓글 쓰기"/>
</form>

<a href="update?seq=${myBoard.seq}">글 수정하기</a>
<a href="delete?seq=${myBoard.seq}">글 삭제하기</a>

</body>
</html>

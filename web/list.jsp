<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>게시글 목록-MVC 게시판 프로젝트</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
<body>
<h1>게시글 목록</h1>


<a href="insert-form">
    <button type="button" class="btn btn-outline-primary">글 작성</button>
</a>

<table class="table table-hover">
    <thead>
    <tr>
        <td>번호</td>
        <td>사진</td>
        <td>제목</td>
        <td>작성자</td>
        <td>날짜</td>
        <td>조회수</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="myBoard" items="${listModel.list}">
        <tr>
            <td>${myBoard.seq}</td>
            <td>
                <c:if test="${myBoard.f_name != null }">
                    <c:set var="head" value="${fn:substring(myBoard.f_name, 0, fn:length(myBoard.f_name)-4) }"/>
                    <c:set var="pattern" value="${fn:substring(myBoard.f_name, fn:length(head) +1, fn:length(myBoard.f_name)) }"/>

                    <c:choose>
                        <c:when test="${pattern == 'jpg' || pattern == 'gif' || pattern == 'png' ||
                        pattern == 'JPG' || pattern == 'GIF' || pattern == 'PNG' || pattern == 'jpeg' || pattern == 'JPEG'}">
                            <img src="/upload/${head }_small.${pattern}">
                        </c:when>
                        <c:otherwise>
                            <c:out value="NO IMAGE"></c:out>
                        </c:otherwise>
                    </c:choose>
                </c:if>
            </td>
            <td><a href="detail?seq=${myBoard.seq}">${myBoard.title}</a></td>
            <td>${myBoard.writer}</td>
            <td>${myBoard.regDate}</td>
            <td>${myBoard.hitCount}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<hr>


<div>
    <form action="list" method="get">
        <input type="checkbox" name="area" value="title">제목
        <input type="checkbox" name="area" value="writer">작성자
        <input type="text" name="searchKey">
        <input type="submit" value="검색하기">
    </form>
</div>
<hr>


<div class="text-center">
    <ul class="pagination">
        <%--        이전--%>
        <c:if test="${listModel.startPage > 5}">
            <li><a href="list?pageNum=${listModel.startPage - 1}">이전</a></li>
        </c:if>

        <%--        페이지번호--%>
        <c:forEach var="pageNum" begin="${listModel.startPage}" end="${listModel.endPage}">
            <c:if test="${listModel.curPage == pageNum}"><b></c:if>
            <li><a href="list?pageNum=${pageNum}">${pageNum}</a></li>
            <c:if test="${listModel.curPage == pageNum}"></b></c:if>
        </c:forEach>

        <%--        이후--%>
        <c:if test="${listModel.endPage < listModel.totalPage}">
            <li><a href="list?pageNum=${listModel.endPage + 1}">이후</a></li>
        </c:if>
    </ul>
</div>
</body>
</html>

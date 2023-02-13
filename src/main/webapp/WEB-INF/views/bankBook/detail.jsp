<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>   detail page</h1>
    <c:if test="${not empty dto }"></c:if>
     <h3>Num : ${deo.bookNum}</h3>
     <h3>Title : ${deo.bookName}</h3>
     <h3>Delete : ${deo.bookDetail}</h3>
     <h3>Rate : ${deo.bookRate}</h3>
     <h3>Sale : ${deo.bookSale}</h3>
     
     
<a href="./delete?bookNum">상품삭제</a>
<c:if test=" ${empty dto }">
<h3> 존재하지 않는 상품입니다</h3>
</c:if>
<a href="./update?bookNum">상품수정</a>
<a href ="./list"> 목록으로</a>

</body>
</html>
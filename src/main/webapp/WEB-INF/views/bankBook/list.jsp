<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/table.css">
</head>
<body>

<h1 class="title"> bank Book page</h1>
<table>

<thead class="tbl2" >
<tr>
<th>상품명</th>
<th>이자율</th>
<th>판매여부</th>

</tr>


</thead>

<tbody>
<c:forEach items="${list}" var ="dto">
<tr>
<td> <a href ="./detail?bookNum=$[dto.bookNum}">${pageScope.dto. bookName} </td>
<td class="tbl_td">  ${dto.bookRate }  </td>
<td class="tbl_td"> 
 <%-- c:if test ="${dto,bookSale  }" 판매중></c:if>
 ${dto.bookSale } --%>
<c:choose>
  <c:when test=" ${dto.booksale eq 1 }"> 판매중</c:when>
 <c:otherwise> 판매중단</c:otherwise>
</c:choose>


</td> 
</tr>
</c:forEach>
</tbody>


</table>
 <a href = "./add">상품등록</a>

 <form action=""></form>





</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/reste.css">
<link rel="stylesheet" href="/resources/css/main.css">
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
<div>

<c:forEach begin = "1" end = "${pager.totalcount div 10 }" step ="1" var ="i">

<a href ="./list?page="> ${i}</a>
</c:forEach>
</div>

<nav aria-label="Page navigation example">
  <ul class="pagination">
    <li class="page-item">
      <a class="page-link" href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">2</a></li>
    <li class="page-item"><a class="page-link" href="#">3</a></li>
    <li class="page-item">
      
      <a class="page-link" href="./list?page=${pager,lastNum+1}" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>
<!--  검색창 -->
<div class ="row">
<form class="row g-3">
  <div class="col-auto">
   <label for="staticEmail2" class="visually-hidden">Email</label>
  <select class="form-select" aria-label="Default select example">
  <option value="title">상품명</option>
  <option value="contents">상품내용</option>
  
</select>
  <div class="col-auto">
    <label for="search" class="visually-hidden">Search</label>
    <input type="text" class="form-control" id="search" placeholder="검색어">
  </div>
  <div class="col-auto">
    <button type="submit" class="btn btn-primary mb-3">검색</button>
  </div>
</form>

</div>


<div class = "row col - md-7 mx-auto">
 <a href = "./add" class= "btn btn-primay col-2">상품등록</a>
</div>
 <form action=""></form>





</body>
</html>
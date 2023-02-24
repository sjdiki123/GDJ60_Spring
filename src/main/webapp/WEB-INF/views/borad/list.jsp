<%@page import="com.iu.s1.board.BbsDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common_css.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<div class="row my -5">
<h1> ${boradName }</h1>

</div>




<div class="container-fluid">
 <div class="row">
 <table class="table table-hover">
 
 <thead>
 <tr>
 <th>NUM</th><th>TITLE</th><th>WRITER</th><th>DATE</th><th>HIT</th>
 
 </tr>
 
 </thead>
 
 <tbody>
 <c:forEach items="${list}" var="dto" >
 
 <tr>
 <tb>${dto.num}</tb>
 	<td>
 	<c:catch>
 	<!--  notice에는 depth가 없어서 exception아 발생 -->
    <c:forEach begin="1" end="${dto.depth}">--</c:forEach>
    </c:catch>
 	<a href="./detail">${dto.title}</a></td> 
  <tb>${dto.title}</tb>
  <tb>${dto.writer}</tb>
  <tb>${dto.regDate}</tb>
  <tb>${dto.hit}</tb>

 </tr>
 </c:forEach>
 
 </tbody>
 
 </table>
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
 
 
 
<div class ="row">
<form class="row g-3">
  <div class="col-auto">
   <label for="staticEmail2" class="visually-hidden">Email</label>
  <select class="form-select" aria-label="Default select example">
  <option value="title">title</option>
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

 
 </div>
</div>


<c:import url="../temlate/common_css.jsp"></c:import>
<script src="../resources/memberjs/pageing.js"></script>
</body>
</html>
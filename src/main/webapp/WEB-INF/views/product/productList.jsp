<%@page import="com.iu.s1.product.ProductDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c"uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/table.css">
</head>
<body>

 <h1 class="title"> proudetLIst</h1>
 <%List<ProductDTO> ar = (List<ProductDTO>)request.getAttribute("list");
 for (ProductDTO productDTO:ar){
	 
 
 %>
 
<h3>  <%= productDTO.getProductname() %></h3>
<h3> <%= productDTO.getProductdetail() %></h3> 
 <%} %>
 
 <hr>

 <table class="tbl">
 <thead>
      <tr>
         <th> 상품명</th> <th>평점</th>
      </tr>
 
 </thead>
 <tbody>
 
 <c:forEach items="${list}" var="dto">  <!-- dto는 page영역에 담김  -->
 <tr>
 <td><a href = "./detail?productnum=${dto.proudctnum}">${pageScope.dto.productname}</a></td> 
 <td>${dto.productjumsu}</td>
     </c:forEach>
 </tr>
 </tbody>
 </table>
 <a class = "btn btn-danger" herf= "./proudctAdd">상품등록</a>
 </div>
 
 <h3>${list}</h3>
 
</body>
</html>
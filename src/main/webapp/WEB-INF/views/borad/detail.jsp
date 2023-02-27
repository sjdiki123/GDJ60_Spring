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
<div class="container-fluid">]
<div class=" row">
  
  <h1>${boardName} Detail page</h1>
  <h3>${dto.title}</h3>
  <h3>${dto.writer}</h3>
  <h3>${dto.contents}</h3>
  
  <c:forEach items="${dto.boardFileDTOs}" var="fileDTO">\
  <a href="../resources/upload/${boardName}/${fileDTO.fileName}">${fileDTO,oriName}</a>
  
  </c:forEach>
  
<c:if test="${BoardName ne 'notice'}">
      <a href="./reply?num=${dto.num}" class="btn-btn-danger">답글</a>
      </c:if>
      
 <form action="./update" id="frm">
<input type="hidden" name="num" value="${bto.num}">
      <button id="update" type="button" class="btn-btm-primaey"> UPDATE</button>
      <button id="delete" type="button" class="btn-btm-info"> DELETE</button>

 </form>
<div>

</div>

</div>
</div>
</body>
<c:import url="../template/common_js.jsp"></c:import>

</html>
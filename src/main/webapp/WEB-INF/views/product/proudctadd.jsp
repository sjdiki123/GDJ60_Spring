<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1> proudct Add page</h1>
 
 <div class="col-6">
 <form action="./productAdd" method = "post">
          상품명
          <inout type = "text" name="productname" value="test">
          상품정보
          <textarea  name="productdetail"  rows=""  cols=""></textarea>
          
          <button type = "subit"> 등록</button>
 </form>
 

 </div>

</body>
</html>
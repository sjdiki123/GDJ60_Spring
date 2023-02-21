<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/../template/heder.css.jsp"></c:import>
<
<div class=" ">
  <input class="form-check-input a" type="checkbox" value="" id="checkAll">
  <label class="form-check-label" for="checkAll">
전체동의
  </label>
</div>
<div class="form-check">
  <input class="form-check-input a" type="checkbox" value="" id="check1" >
  <label class="form-check-label" for="check1">
  동의1
    </label>
</div>
<div class="form-check">
  <input class="form-check-input a" type="checkbox" value="" id="check2" >
  <label class="form-check-label" for="check2 ">
  동의2
  </label>
</div>
<div class="form-check">
  <input class="form-check-input a" type="checkbox" value="" id="check3" >
  <label class="form-check-label" for="check3">
동의3
  </label>
</div>
</head>
<body>
<script type="text/javascript" src="../member/memberjs/member.js"></script>
<c:import url="/../template/common-js.jsp"></c:import>

<div>

<button class="">회원가입</button>

</div>

</body>
</html>
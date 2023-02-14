<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<c:import url="/template/header.jsp"></c:import>
</head>
<body>
<header >
	<c:import url="/template/header.jsp"></c:import>
	
	<section class = "container border border-danger">
	<article class = "row">
	<div class = "col border border-danger">1</div>
	<div class = " col border border-primary">2</div>
	<div class = "col border bodrder-danger ">3</div>
	
	
	</article>
	</section>
	<section class = "col border border-primary">
	<article class = "row">
	<div class = "col-2 border border-danger">1</div>
	<div class = " col-7 border border-primary">2</div>
	<div class = "col-3 border bodrder-danger ">3</div>
	</article>
	</section>
	
	
	<section class = "container border border-danger">
	<article class = "row">
	<div class = "col-2 border border-danger">1</div>
	<div class = " col-7 border border-primary">2</div>
	<div class = "col-3 border bodrder-danger ">3</div>
	</article>
	</section>
	
</header>
</body>
</html>

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

<div class="container-fluid">

	
<div class="row justify-content-center">
		<form class="col-md-7" action="./add" method="post" enctype="multipart/form-data">
			<div class="mb-3">
			  <label for="writer" class="form-label">작성자</label>
			  <input type="text" name="writer" class="form-control" id="writer" >
			</div>
			
			<div class="mb-3">
			  <label for="title" class="form-label">제목</label>
			  <input type="text" name="title" class="form-control" id="title" placeholder="제목입력">
			</div>
	
			<div class="mb-3">
			  <label for="contents" class="form-label">내용</label>
			  <textarea name="contents" class="form-control" id="contents" placeholder="내용입력" rows="7"></textarea>
			</div>	


	<div id="fileList">
			<!-- 	<div class="mb-3">
				<label for="files" class="form-label">Image</label>
				<input type="file" class="form-control" id="files" name="files">
				</div> -->
				<button  type="button" id="fileAdd">ADD</button>
			
			
				
			</div>
                      
			
			<div class="mb-3">
				<button class="my btn btn-danger" type="submit">등록</button>
			</div> 
		
		</form>
	</div>
</div>	
<script src="../resources/js/fileManger.js"></script>
<script>
	setMax(3);
	// setParam('f');
</script>

<c:import url="../template/common_js.jsp"></c:import>
</body>
</html>
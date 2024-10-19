<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>getStudentList</title>
	
	<!-- BootStrap CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<!-- BootStrap JS -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    
	<style>
		.my-container {
			max-width : 1000px;
			margin-top : 20px;
			padding : 35px;
			background-color : #fff;
			border-radius : 10px;
			box-shadow : 0 8px 20px 0 rgba(0,0,255,0.5);
		}
	</style>
</head>
<body>
	<div class="container my-container">
		
		<p class="fs-2 text-center">전체 학생 리스트</p>
		
		<table class="table table-hover">
		  <thead>
		    <tr>
		      <th scope="col">#</th>
		      <th scope="col">Name</th>
		      <th scope="col">Age</th>
		      <th scope="col">Dept</th>
			  <th scope="col">Modify/Delete</th>
		    </tr>
		  </thead>
		  <tbody>
			<c:forEach var="student" items="${sList}">
				<tr>
			      <th scope="row">${student.sid}</th>
			      <td>${student.sname}</td>
			      <td>${student.sage}</td>
			      <td>${student.sdept}</td>
				  <td>
					<button class="btn btn-primary"
					onclick="location.href='modifyStudent.do?sid=${student.sid}'">
					Modify</button>

					<button class="btn btn-danger"
					onclick="location.href='deleteStudent.do?sid=${student.sid}'">
					Delete</button>
				  </td>
			    </tr>
			</c:forEach>
		  </tbody>
		</table>
	</div>
</body>
</html>
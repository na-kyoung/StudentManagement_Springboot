<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>insertStudent</title>
	
	<!-- BootStrap CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<!-- BootStrap JS -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    
	<style>
		.my-container {
			max-width : 600px;
			margin-top : 40px;
			padding : 32px;
			background-color : #fff;
			border-radius : 10px;
			box-shadow : 0 8px 20px 0 rgba(0,0,255,0.5);
		}
	</style>
</head>
<body>
	<div class="container my-container">

		<p class="fs-2 text-center">학생 등록</p>

		<form action="insertStudentProc.do" method="get">
		  <div class="mb-3">
		    <label for="exampleInputEmail1" class="form-label">이름(Name)</label>
		    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="sname">
		  </div>
		  <div class="mb-3">
		    <label for="exampleInputPassword1" class="form-label">나이(Age)</label>
		    <input type="text" class="form-control" id="exampleInputPassword1" name="sage">
		  </div>
		  <div class="mb-3">
		    <label for="exampleCheck1" class="form-label">학과(Dept)</label>
			<input type="text" class="form-control" id="exampleCheck1" name="sdept">
		  </div>
		  
		  <div class="d-grid gap-2 d-md-flex justify-content-md-end">
			  <button type="submit" class="btn btn-primary">Submit</button>
			  <button type="reset" class="btn btn-danger">Reset</button>
		  </div>
		</form>
		
	</div>
</body>
</html>
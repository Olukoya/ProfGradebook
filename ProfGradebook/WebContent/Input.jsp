<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">


<head>
  <title>Input</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
<a class="navbar-brand" href="#">Professor Strongheim's Gradebook</a>
</nav>

  <div class="container">
  <h1>Welcome to Professor Strongheim's Gradebook</h1>
  <p> Please enter your student's details</p>
   <form action="ToDatabase" method="POST">
    <div class="form-group">
      <label for="sid">Student ID:</label>
      <input type="text" class="form-control" name="sid">
    </div>
    
    <div class="form-group">
      <label for="an">Assignment Name:</label>
      <input type="text" class="form-control" name="an">
    </div>
    
    <div class="form-group">
    <label for="type">Type:</label>
      <input type="text" class="form-control" name="type">
	</div>
	
   <div class = "form-group">
   <label for = "dt">Date:</label>
  <input type="date" name="dt">
  </div>
  
    <div class="form-group">
      <label for="grd">Grade:</label>
      <input type="number" class="form-control" name="grd">
    </div>
    
    <div class="form-group">
 	<input type="submit" value="Submit" />
	</div>
  </form>
  <form action= "FromDatabase" method="POST">
  <div class="form-group">
 	<input type="submit" value="View Records" />
	</div>
  </form>
  <form action= "TypeStudent" method="GET">
  <div class="form-group">
 	<input type="submit" value="Type&Student" />
	</div>
  </form>
</div>
  
</body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">


<head>
  <title>Student</title>
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
   <form action="TypeStudent" method="POST">
    <div class="form-group">
      <label for="sid">Student ID:</label>
      <input type="text" class="form-control" name="sid">
    </div>

    <div class="form-group">
    <label for="type">Type:</label>
      <input type="text" class="form-control" name="type">
	</div>

    <div class="form-group">
 	<input type="submit" value="Submit" />
	</div>
  </form>
</div>
</body>
</html>

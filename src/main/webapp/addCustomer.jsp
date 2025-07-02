<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Employ</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1>Add New Employ</h1>
        <form action="customer" method="post">
        <div class="form-group">
                <label for="firstname ">FirstnName</label>
                <input type="text" class="form-control" name="firstname" id="firstname" required>
            </div>
            <div class="form-group">
                <label for="lastname ">LastName</label>
                <input type="text" class="form-control" name="lastname" id="lastname" required>
            </div>
            <div class="form-group">
                <label for="phon">Mobile.no</label>
                <input type="tel" class="form-control" name="phon" id="phon" required>
            </div>
            <div class="form-group">
                <label for="name">UserName</label>
                <input type="text" class="form-control" name="name" id="name" required>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" class="form-control" name="email" id="email" required>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" class="form-control" name="password" id="password" required>
            </div>
            
            <div class="form-group">
            <p><h4>select your gender</h4></p>
            <select class ="form-control" name="Gender" id="gender" required  >
            <option>Gender</option>
            <option>male</option>
            <option>female</option>
            <option>other</option></select>
            
            </div>
            <button type="submit" class="btn btn-primary">Add Employ</button>
        </form>
    </div>
</body>
</html>
>
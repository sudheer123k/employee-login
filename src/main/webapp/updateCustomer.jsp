<%@ page import="com.sg.model.Customer" %>

<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Customer Details</title>
    <!-- Bootstrap CSS -->
    <link
        href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
        rel="stylesheet">
    <style>
        .form-container {
            max-width: 500px;
            margin: 50px auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 8px;
            background: #f9f9f9;
        }
        .btn-custom {
            background-color: #007bff;
            color: white;
        }
        .btn-custom:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<%
    Customer customer = (Customer) request.getAttribute("customer");
%>
    <div class="container">
        <h2 class="text-center mt-4">Edit Employ Details</h2>
        <div class="form-container">
            <form action="updateCustomer" method="post">
                <!-- Hidden ID field -->
                <input type="hidden" name="id" value="<%= customer.getId() %>">

                <!-- Name -->
                <div class="form-group">
                    <label for="name">Name</label>
                    <input type="text" 
                           id="name" 
                           name="name" 
                           class="form-control" 
                           value="<%= customer.getName() %>" 
                           required>
                </div>

                <!-- Email -->
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" 
                           id="email" 
                           name="email" 
                           class="form-control" 
                           value="<%= customer.getEmail() %>" 
                           required>
                </div>

                <!-- Password -->
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" 
                           id="password" 
                           name="password" 
                           class="form-control" 
                           value="<%= customer.getPassword() %>" 
                           required>
                </div>

                <!-- Submit Button -->
                <button type="submit" class="btn btn-custom btn-block">Update Customer</button>
                
                <!-- Cancel Button -->
                <a href="index.jsp" class="btn btn-secondary btn-block">Cancel</a>
            </form>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

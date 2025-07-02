<%@ page import="com.sg.model.Customer" %>
<%@ page import="com.sg.dao.CustomerDao" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
        }
        .header, .footer {
            background-color: orange;
            color: white;
            padding: 15px 0;
        }
        .header h1, .footer p {
            margin: 0;
            text-align: center;
        }
        .table {
            background-color: white;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .container {
            margin-top: 30px;
            margin-bottom: 30px;
        }
        .btn {
            margin-right: 5px;
        }
    </style>
</head>
<body>
    <!-- Header -->
    <div class="header">
        <h1>Customer Management System</h1>
    </div>

    <!-- Main Content -->
    <div class="container">
        <div class="d-flex justify-content-between align-items-center">
            <h2 class="mb-3">Customer List</h2>
            <a href="addCustomer.jsp" class="btn btn-success">Add Customer</a>
        </div>
        <table class="table table-striped table-bordered mt-3">
            <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>phone.No</th>
                    <th>Gender</th>
                    
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    CustomerDao customerDao = new CustomerDao();
                    List<Customer> customers = customerDao.getAllCustomers();
                    for (Customer customer : customers) { 
                %>
                    <tr>
                        <td><%= customer.getId() %></td>
                        <td><%= customer.getName() %></td>
                        <td><%= customer.getEmail() %></td>
                        <td><%= customer.getPhon() %></td>
                        <td><%= customer.getGender() %></td>
                        <td>
                            <a href="updateCustomer?id=<%= customer.getId() %>" class="btn btn-warning btn-sm">Update</a>
                            <a href="delete?id=<%= customer.getId() %>" 
                               class="btn btn-danger btn-sm" 
                               onclick="return confirm('Are you sure you want to delete this customer?');">
                               Delete
                            </a>
                        </td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    </div>

    <!-- Footer -->
    <div class="footer">
        <p>&copy; 2025 Employ Management System. All Rights Reserved.</p>
    </div>

    <!-- Bootstrap JS and Dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.4.4/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.min.js"></script>
</body>
</html>

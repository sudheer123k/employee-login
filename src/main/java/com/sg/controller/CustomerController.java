package com.sg.controller;

import java.io.IOException;

import com.sg.dao.CustomerDao;
import com.sg.model.Customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/customer")

public class CustomerController extends HttpServlet {

    private CustomerDao customerDao;

    @Override
    public void init() {
        customerDao = new CustomerDao();
    }

    // Handle Add Customer
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phon = request.getParameter("phon");
        String gender = request.getParameter("Gender");
       
        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setPassword(password);
        customer.setGender(gender);
        customer.setPhon(phon);
        
        if (customerDao.addCustomer(customer)) {
            response.sendRedirect("index.jsp");
        } else {
            response.getWriter().write("Error adding customer.");
        }
    }

    // Handle Update Customer
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phon =request.getParameter("phon");
        String gender = request.getParameter("gender");
       

        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        customer.setEmail(email);
        customer.setPassword(password);
        customer.setPhon(phon);
        customer.setGender(gender);

        if (customerDao.updateCustomer(customer)) {
            response.sendRedirect("index.jsp");
        } else {
            response.getWriter().write("Error updating customer.");
        }
    }

    // Handle Delete Customer
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        if (customerDao.deleteCustomer(id)) {
            response.sendRedirect("index.jsp");
        } else {
            response.getWriter().write("Error deleting customer.");
        }
    }
}
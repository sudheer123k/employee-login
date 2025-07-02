package com.sg.controller;

import java.io.IOException;

import com.sg.dao.CustomerDao;
import com.sg.model.Customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateCustomer")
public class UpdateCustomerServlet extends HttpServlet {

    private CustomerDao customerDao;

    @Override
    public void init() {
        customerDao = new CustomerDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("--------------------------------------");
    	int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerDao.getCustomerById(id);

        if (customer != null) {
            request.setAttribute("customer", customer);
            request.getRequestDispatcher("updateCustomer.jsp").forward(request, response);
        } else {
            response.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phon=request.getParameter("phon");
        String Gender=request.getParameter("gender");
        

        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        customer.setEmail(email);
        customer.setPassword(password);
        customer.setPhon(phon);
        customer.setGender(Gender);
        

        if (customerDao.updateCustomer(customer)) {
            response.sendRedirect("Login.html");
        } else {
            response.getWriter().write("Error updating customer.");
        }
    }
}

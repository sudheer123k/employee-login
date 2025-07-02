package com.sg.controller;

import java.io.IOException;

import com.sg.dao.CustomerDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteCustomer extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("--------------------------------------");
    	int id = Integer.parseInt(req.getParameter("id"));
    	CustomerDao cd=new CustomerDao();
    	cd.deleteCustomer(id);
    	RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
    	rd.forward(req, resp);
	}
}

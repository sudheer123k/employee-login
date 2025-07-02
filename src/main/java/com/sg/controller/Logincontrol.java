package com.sg.controller;

import java.io.IOException;

import com.sg.dao.CustomerDao;
import com.sg.model.Logmod;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/Logincontrol")
public class Logincontrol extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String pass= request.getParameter("password1");
		Logmod lm = new Logmod();
		lm.setPassword1(pass);
		lm.setUname(uname);
		System.out.println(lm);
		CustomerDao cd = new CustomerDao();
		boolean res = cd.findEmploybyemailandpass(lm);
		if(res) {
			RequestDispatcher v = request.getRequestDispatcher("index.jsp");

			v.forward(request, response);
			
			
		}else {
			RequestDispatcher v = request.getRequestDispatcher("Login.html");

			v.forward(request, response);
			
		}
		
	
		
	}

}

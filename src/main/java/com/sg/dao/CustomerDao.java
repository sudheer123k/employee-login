package com.sg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sg.model.Customer;
import com.sg.model.Logmod;
import com.sg.utility.DBConnection;

import jakarta.servlet.RequestDispatcher;


public class CustomerDao {
	static int n ;
	public static String s="suc";

    private Connection conn;

    public CustomerDao() {
    	 conn = DBConnection.getConnection();
    }

    // Add a new employ
    public boolean addCustomer(Customer customer) {
        try {
            String query = "INSERT INTO customer_db (name, email, password,phon,gender) VALUES (?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getEmail());
            stmt.setString(3, customer.getPassword());
            stmt.setString(4, customer.getPhon());
            stmt.setString(5, customer.getGender());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Get all customers
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        try {
            String query = "SELECT * FROM customer_db";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setEmail(rs.getString("email"));
                customer.setPassword(rs.getString("password"));
                customer.setPhon(rs.getString("phon"));
                customer.setGender(rs.getString("gender"));
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    // Get customer by ID
    public Customer getCustomerById(int id) {
        Customer customer = null;
        try {
            String query = "SELECT * FROM customer_db WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
            	
                customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setEmail(rs.getString("email"));
                customer.setPassword(rs.getString("password"));
                customer.setPhon("phon");
                customer.setGender("gender");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    // Update customer
    public boolean updateCustomer(Customer customer) {
        try {
            String query = "UPDATE customer_db SET name = ?, email = ?, password = ? phon=? gender=? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getEmail());
            stmt.setString(3, customer.getPassword());
           
            stmt.setString(5, customer.getPhon());
            stmt.setString(6, customer.getGender());
            stmt.setInt(4, customer.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Delete customer
    public boolean deleteCustomer(int id) {
        try {
            String query = "DELETE FROM customer_db WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean findEmploybyemailandpass(Logmod lm ) {
    	
    	try {
    		//String q1 = "select count(*) from customer_db where name =?and password = ?";
			PreparedStatement stmt = conn.prepareStatement( "select * from customer_db where name =?and password = ?");
			stmt.setString(1,lm.getUname());
			stmt.setString(2, lm.getPassword1());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
			
				 
				 return true;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false ;
        
    	
    	
    }
   
}
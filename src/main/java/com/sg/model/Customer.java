package com.sg.model;
public class Customer {
    private int id;
    private String name;
    private String email;
    private String password;
    private String phon ;
    private String gender;
    
    
	
	public String getPhon() {
		return phon;
	}
	public void setPhon(String  phon) {
		this.phon = phon;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	// Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
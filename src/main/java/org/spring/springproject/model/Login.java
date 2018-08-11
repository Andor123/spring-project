package org.spring.springproject.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Login {
	
	@NotBlank
	@Size(min = 3, max = 30)
	private String name;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	@Size(min = 8, max = 20)
	private String password;
	
	public Login() {
		
	}
	
	public Login(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Login [name=" + name + ", email=" + email + ", password=" + password + "]";
	}
	
}

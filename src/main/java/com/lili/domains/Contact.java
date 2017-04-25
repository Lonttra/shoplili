package com.lili.domains;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class Contact {
	
	@NotEmpty (message="please inform subject")
	private String subject;
	
	@NotEmpty (message="please inform your name")
	private String name;
	

	@NotEmpty (message="please inform your email")
	@Email (message="your email is not correct")
	private String email;
	
	@Size(max = 500)
	@NotEmpty (message="please inform your message")
	private String message;
	

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

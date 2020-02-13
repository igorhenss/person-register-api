package com.igorhenss.personregisterapi.domain.person.embedded;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Email {
	
	@Column(name = "email", length = 160, nullable = false, unique = true)
	private final String email;
	
	public Email(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
}

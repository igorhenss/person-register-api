package com.igorhenss.personregisterapi.domain.person.embedded;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	@Column(name = "address", length = 256, nullable = false)
	private String address;
	
	protected Address() {}
	
	public Address(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return address;
	}
	
}

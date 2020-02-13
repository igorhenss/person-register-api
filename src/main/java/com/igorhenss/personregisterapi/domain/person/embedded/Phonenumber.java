package com.igorhenss.personregisterapi.domain.person.embedded;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Phonenumber {

	@Column(name = "phonenumber", length = 40, nullable = false)
	private final String phonenumber;
	
	public Phonenumber(String phonenumber) {
		var digitsRegex = "[0-9]";
		this.phonenumber = phonenumber.replaceAll(digitsRegex,"");
	}
	
	public String getPhonenumber() {
		return phonenumber;
	}
	
}

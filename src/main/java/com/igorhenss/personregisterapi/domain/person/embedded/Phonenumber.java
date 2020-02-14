package com.igorhenss.personregisterapi.domain.person.embedded;

import com.igorhenss.personregisterapi.infrastructure.i18n.messages.Dictionary;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Phonenumber {

	@Column(name = "phonenumber", length = 40, nullable = false)
	private String phonenumber;
	
	protected Phonenumber() {}
	
	public Phonenumber(String phonenumber) {
		this.phonenumber = phonenumber.replaceAll(Dictionary.LETTERS_REGEX,"");
	}
	
	public String getPhonenumber() {
		return phonenumber;
	}
	
}

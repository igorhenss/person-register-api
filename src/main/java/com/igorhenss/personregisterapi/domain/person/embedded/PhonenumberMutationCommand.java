package com.igorhenss.personregisterapi.domain.person.embedded;

import com.igorhenss.personregisterapi.infrastructure.i18n.messages.Dictionary;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class PhonenumberMutationCommand implements Serializable {
	
	private static final long serialVersionUID = -5186077563255870664L;
	
	@NotNull(message = Dictionary.PHONENUMBER_MUST_BE_NOT_NULL)
	@NotBlank(message = Dictionary.PHONENUMBER_MUST_BE_NOT_BLANK)
	@Size(max = 40, message = Dictionary.PHONENUMBER_MAX_SIZE_IS_40)
	@Size(min = 5, message = Dictionary.PHONENUMBER_MIN_SIZE_IS_5)
	private String phonenumber;
	
	public PhonenumberMutationCommand() {}
	
	public String getPhonenumberWithoutSpecialCharacters() {
		var phonenumberWithoutSpecialChars = phonenumber.replaceAll(Dictionary.SPECIAL_CHARS_REGEX, "");
		return phonenumberWithoutSpecialChars.replaceAll(Dictionary.LETTERS_REGEX, "");
	}
	
	public String getPhonenumber() {
		return phonenumber;
	}
	
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
}

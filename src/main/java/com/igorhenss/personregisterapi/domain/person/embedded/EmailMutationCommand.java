package com.igorhenss.personregisterapi.domain.person.embedded;

import com.igorhenss.personregisterapi.infrastructure.i18n.messages.Dictionary;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class EmailMutationCommand implements Serializable {
	
	private static final long serialVersionUID = -7469955290782766160L;
	
	@NotNull(message = Dictionary.EMAIL_MUST_BE_NOT_NULL)
	@NotBlank(message = Dictionary.EMAIL_MUST_BE_NOT_BLANK)
	@Email(message = Dictionary.EMAIL_MUST_BE_VALID)
	@Size(max = 160, message = Dictionary.EMAIL_MAX_SIZE_IS_160)
	@Size(min = 10, message = Dictionary.EMAIL_MIN_SIZE_IS_10)
	private String email;
	
	public EmailMutationCommand() {}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
}

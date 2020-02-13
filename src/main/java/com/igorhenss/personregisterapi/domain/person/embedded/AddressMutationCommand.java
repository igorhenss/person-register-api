package com.igorhenss.personregisterapi.domain.person.embedded;

import com.igorhenss.personregisterapi.infrastructure.i18n.messages.Dictionary;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class AddressMutationCommand implements Serializable {
	
	private static final long serialVersionUID = 1775406806230355313L;
	
	@NotNull(message = Dictionary.ADDRESS_MUST_BE_NOT_NULL)
	@NotBlank(message = Dictionary.ADDRESS_MUST_BE_NOT_BLANK)
	@Size(max = 160, message = Dictionary.ADDRESS_MAX_SIZE_IS_160)
	@Size(min = 10, message = Dictionary.ADDRESS_MIN_SIZE_IS_10)
	private String address;
	
	public AddressMutationCommand() {}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
}

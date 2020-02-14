package com.igorhenss.personregisterapi.domain.person;

import com.igorhenss.personregisterapi.domain.person.embedded.AddressMutationCommand;
import com.igorhenss.personregisterapi.domain.person.embedded.EmailMutationCommand;
import com.igorhenss.personregisterapi.domain.person.embedded.PhonenumberMutationCommand;
import com.igorhenss.personregisterapi.infrastructure.i18n.messages.Dictionary;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PersonCreateCommand implements Serializable {
	
	private static final long serialVersionUID = 7881649587888614593L;
	
	@NotNull(message = Dictionary.BIRTHDATE_MUST_BE_NOT_NULL)
	@PastOrPresent(message = Dictionary.BIRTHDATE_MUST_BE_PAST_OR_PRESENT)
	private LocalDate birthdate;
	
	@NotNull(message = Dictionary.NAME_MUST_BE_NOT_NULL)
	@NotBlank(message = Dictionary.NAME_MUST_BE_NOT_BLANK)
	@Size(max = 40, message = Dictionary.NAME_MAX_SIZE_IS_40)
	@Size(min = 4, message = Dictionary.NAME_MIN_SIZE_IS_3)
	private String name;
	
	@NotNull(message = Dictionary.CPF_MUST_BE_NOT_NULL)
	@NotBlank(message = Dictionary.CPF_MUST_BE_NOT_BLANK)
	@CPF(message = Dictionary.CPF_MUST_BE_VALID)
	private String cpf;
	
	private List<@Valid EmailMutationCommand> emails = new ArrayList<>();
	
	private List<@Valid PhonenumberMutationCommand> phonenumbers = new ArrayList<>();
	
	private List<@Valid AddressMutationCommand> addresses = new ArrayList<>();
	
	public PersonCreateCommand() {}
	
	public String getCpfWithoutSpecialCharacters() {
		return cpf.replaceAll(Dictionary.SPECIAL_CHARS_REGEX, "");
	}
	
	public LocalDate getBirthdate() {
		return birthdate;
	}
	
	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public List<EmailMutationCommand> getEmails() {
		return emails;
	}
	
	public void setEmails(List<EmailMutationCommand> emails) {
		this.emails = emails;
	}
	
	public List<PhonenumberMutationCommand> getPhonenumbers() {
		return phonenumbers;
	}
	
	public void setPhonenumbers(List<PhonenumberMutationCommand> phonenumbers) {
		this.phonenumbers = phonenumbers;
	}
	
	public List<AddressMutationCommand> getAddresses() {
		return addresses;
	}
	
	public void setAddresses(List<AddressMutationCommand> addresses) {
		this.addresses = addresses;
	}
	
}

package com.igorhenss.personregisterapi.domain.person;

import com.igorhenss.personregisterapi.domain.person.embedded.Address;
import com.igorhenss.personregisterapi.domain.person.embedded.Email;
import com.igorhenss.personregisterapi.domain.person.embedded.Phonenumber;
import com.igorhenss.personregisterapi.resource.PersonResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonAdapter {
	
	public List<PersonResponseDTO> apply(List<Person> persons) {
		return persons.stream().map(this::apply).collect(Collectors.toList());
	}
	
	public PersonResponseDTO apply(Person person) {
		PersonResponseDTO dto = new PersonResponseDTO();
		
		dto.setCreatedTimestamp(person.getCreatedTimestamp());
		dto.setUpdatedTimestamp(person.getUpdatedTimestamp());
		dto.setBirthdate(person.getBirthdate());
		dto.setName(person.getName());
		dto.setCpf(person.getCpf());
		dto.setStatus(person.getStatus());
		dto.setEmails(applyToEmails(person.getEmails()));
		dto.setPhonenumbers(applyToPhonenumbers(person.getPhonenumbers()));
		dto.setAddresses(applyToAddresses(person.getAddresses()));
		
		return dto;
	}
	
	private List<String> applyToEmails(List<Email> emails) {
		return emails.stream().map(Email::getEmail).collect(Collectors.toList());
	}
	
	private List<String> applyToPhonenumbers(List<Phonenumber> phonenumbers) {
		return phonenumbers.stream().map(Phonenumber::getPhonenumber).collect(Collectors.toList());
	}
	
	private List<String> applyToAddresses(List<Address> addresses) {
		return addresses.stream().map(Address::getAddress).collect(Collectors.toList());
	}
	
}

package com.igorhenss.personregisterapi.domain.person;

import com.igorhenss.personregisterapi.domain.AbstractEntity;
import com.igorhenss.personregisterapi.domain.person.embedded.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "person")
public class Person extends AbstractEntity {
	
	@Column(name = "birthdate", nullable = false)
	private LocalDate birthdate;
	
	@Column(name = "name", length = 40, nullable = false)
	private String name;
	
	@Column(name = "cpf", length = 11, nullable = false, unique = true)
	private String cpf;
	
	@ElementCollection
	@CollectionTable(name = "email", joinColumns = @JoinColumn(name = "id_person"), foreignKey = @ForeignKey(name = "person_email_fk"))
	private List<Email> emails = new ArrayList<>();
	
	@ElementCollection
	@CollectionTable(name = "phonenumber", joinColumns = @JoinColumn(name = "id_person"), foreignKey = @ForeignKey(name = "person_phonenumber_fk"))
	private List<Phonenumber> phonenumbers = new ArrayList<>();
	
	@ElementCollection
	@CollectionTable(name = "address", joinColumns = @JoinColumn(name = "id_person"), foreignKey = @ForeignKey(name = "person_address_fk"))
	private List<Address> addresses = new ArrayList<>();
	
	public Person(PersonMutationCommand personMutationCommand) {
		this.birthdate = personMutationCommand.getBirthdate();
		this.name = personMutationCommand.getName();
		this.cpf = personMutationCommand.getCpfWithoutSpecialCharacters();
		this.emails = buildEmails(personMutationCommand.getEmails());
		this.phonenumbers = buildPhonenumbers(personMutationCommand.getPhonenumbers());
		this.addresses = buildAddresses(personMutationCommand.getAddresses());
	}
	
	private List<Email> buildEmails(List<EmailMutationCommand> emails) {
		return emails.stream()
				.map(emc -> new Email(emc.getEmail()))
				.collect(Collectors.toList());
	}
	
	private List<Phonenumber> buildPhonenumbers(List<PhonenumberMutationCommand> phonenumbers) {
		return phonenumbers.stream()
				.map(pmc -> new Phonenumber(pmc.getPhonenumberWithoutSpecialCharacters()))
				.collect(Collectors.toList());
	}
	
	private List<Address> buildAddresses(List<AddressMutationCommand> addresses) {
		return addresses.stream()
				.map(amc -> new Address(amc.getAddress()))
				.collect(Collectors.toList());
	}
	
}

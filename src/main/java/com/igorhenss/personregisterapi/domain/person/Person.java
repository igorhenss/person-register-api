package com.igorhenss.personregisterapi.domain.person;

import com.igorhenss.personregisterapi.domain.AbstractEntity;
import com.igorhenss.personregisterapi.domain.Status;
import com.igorhenss.personregisterapi.domain.person.embedded.*;
import com.igorhenss.personregisterapi.infrastructure.i18n.messages.Dictionary;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.igorhenss.personregisterapi.domain.Status.ACTIVE;
import static com.igorhenss.personregisterapi.domain.Status.INACTIVE;
import static com.igorhenss.personregisterapi.infrastructure.tester.Tester.*;

@Entity
@Table(name = "person")
public class Person extends AbstractEntity {
	
	@Column(name = "birthdate", nullable = false)
	private LocalDate birthdate;
	
	@Column(name = "name", length = 40, nullable = false)
	private String name;
	
	@Column(name = "cpf", length = 11, nullable = false, unique = true)
	private String cpf;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status", length = 20, nullable = false)
	private Status status;
	
	@ElementCollection
	@CollectionTable(name = "email", joinColumns = @JoinColumn(name = "id_person"), foreignKey = @ForeignKey(name = "person_email_fk"))
	private List<Email> emails = new ArrayList<>();
	
	@ElementCollection
	@CollectionTable(name = "phonenumber", joinColumns = @JoinColumn(name = "id_person"), foreignKey = @ForeignKey(name = "person_phonenumber_fk"))
	private List<Phonenumber> phonenumbers = new ArrayList<>();
	
	@ElementCollection
	@CollectionTable(name = "address", joinColumns = @JoinColumn(name = "id_person"), foreignKey = @ForeignKey(name = "person_address_fk"))
	private List<Address> addresses = new ArrayList<>();
	
	protected Person() {}
	
	public static Person of(PersonCreateCommand cmd) {
		Person person = new Person();
		
		person.birthdate = cmd.getBirthdate();
		person.name = cmd.getName();
		person.cpf = cmd.getCpfWithoutSpecialCharacters();
		person.status = ACTIVE;
		person.emails = buildEmails(cmd.getEmails());
		person.phonenumbers = buildPhonenumbers(cmd.getPhonenumbers());
		person.addresses = buildAddresses(cmd.getAddresses());
		
		return person;
	}
	
	public void update(PersonUpdateCommand cmd) {
		test(isActive(), Dictionary.PERSON_MUST_BE_ACTIVE_TO_UPDATE, name);
		
		birthdate = nonNull(cmd.getBirthdate()) ? cmd.getBirthdate() : birthdate;
		name = nonBlank(cmd.getName()) ? cmd.getName() : name;
		cpf = nonBlank(cmd.getCpf()) ? cmd.getCpfWithoutSpecialCharacters() : cpf;
		emails = nonEmpty(cmd.getEmails()) ? buildEmails(cmd.getEmails()) : emails;
		phonenumbers = nonEmpty(cmd.getPhonenumbers()) ? buildPhonenumbers(cmd.getPhonenumbers()) : phonenumbers;
		addresses = nonEmpty(cmd.getAddresses()) ? buildAddresses(cmd.getAddresses()) : addresses;
		
		super.update();
	}
	
	private static List<Email> buildEmails(List<EmailMutationCommand> emails) {
		return emails.stream()
				.map(emc -> new Email(emc.getEmail()))
				.collect(Collectors.toList());
	}
	
	private static List<Phonenumber> buildPhonenumbers(List<PhonenumberMutationCommand> phonenumbers) {
		return phonenumbers.stream()
				.map(pmc -> new Phonenumber(pmc.getPhonenumberWithoutSpecialCharacters()))
				.collect(Collectors.toList());
	}
	
	private static List<Address> buildAddresses(List<AddressMutationCommand> addresses) {
		return addresses.stream()
				.map(amc -> new Address(amc.getAddress()))
				.collect(Collectors.toList());
	}
	
	public void reactivate() {
		test(!isActive(), Dictionary.PERSON_ALREADY_ACTIVE, name);
		status = ACTIVE;
		
		super.update();
	}
	
	public void deactivate() {
		test(!isInactive(), Dictionary.PERSON_ALREADY_INACTIVE, name);
		status = INACTIVE;
		
		super.update();
	}
	
	public boolean isActive() {
		return status.equals(ACTIVE);
	}
	
	public boolean isInactive() {
		return status.equals(INACTIVE);
	}
	
	public LocalDate getBirthdate() {
		return birthdate;
	}
	
	public String getName() {
		return name;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public List<Email> getEmails() {
		return emails;
	}
	
	public List<Phonenumber> getPhonenumbers() {
		return phonenumbers;
	}
	
	public List<Address> getAddresses() {
		return addresses;
	}
	
}

package com.igorhenss.personregisterapi.resource;

import com.igorhenss.personregisterapi.domain.Status;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PersonResponseDTO extends AbstractResponseDTO implements Serializable {
	
	private static final long serialVersionUID = 943274597386453532L;
	
	private LocalDate birthdate;
	
	private String name;
	
	private String cpf;
	
	private Status status;
	
	private List<String> emails = new ArrayList<>();
	
	private List<String> phonenumbers = new ArrayList<>();
	
	private List<String> addresses = new ArrayList<>();
	
	public PersonResponseDTO() {}
	
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
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public List<String> getEmails() {
		return emails;
	}
	
	public void setEmails(List<String> emails) {
		this.emails = emails;
	}
	
	public List<String> getPhonenumbers() {
		return phonenumbers;
	}
	
	public void setPhonenumbers(List<String> phonenumbers) {
		this.phonenumbers = phonenumbers;
	}
	
	public List<String> getAddresses() {
		return addresses;
	}
	
	public void setAddresses(List<String> addresses) {
		this.addresses = addresses;
	}
	
}

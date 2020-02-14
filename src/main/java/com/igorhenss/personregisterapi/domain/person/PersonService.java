package com.igorhenss.personregisterapi.domain.person;

import com.igorhenss.personregisterapi.infrastructure.i18n.messages.Dictionary;
import com.igorhenss.personregisterapi.resource.PersonResponseDTO;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository repository;
	
	@Autowired
	private PersonAdapter adapter;
	
	public PersonResponseDTO create(PersonCreateCommand cmd) {
		Person person = Person.of(cmd);
		persist(person);
		return toResponse(person);
	}
	
	public PersonResponseDTO reactivate(UUID id) {
		Person person = findById(id);
		person.reactivate();
		persist(person);
		return toResponse(person);
	}
	
	public PersonResponseDTO read(UUID id) {
		Person person = findById(id);
		return toResponse(person);
	}
	
	public PersonResponseDTO update(UUID id, PersonUpdateCommand cmd) {
		Person person = findById(id);
		person.update(cmd);
		persist(person);
		return toResponse(person);
	}
	
	public PersonResponseDTO delete(UUID id) {
		Person person = findById(id);
		person.deactivate();
		persist(person);
		return toResponse(person);
	}
	
	@Transactional
	private Person findById(UUID id)  {
		return repository.findById(id).orElseThrow(() -> new ExpressionException(Dictionary.PERSON_NOT_FOUND, id.toString()));
	}
	
	@Transactional
	private void persist(Person person) {
		repository.saveAndFlush(person);
	}
	
	private PersonResponseDTO toResponse(Person person) {
		return adapter.apply(person);
	}

}

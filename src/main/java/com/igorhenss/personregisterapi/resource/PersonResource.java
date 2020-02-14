package com.igorhenss.personregisterapi.resource;

import com.igorhenss.personregisterapi.domain.person.PersonCreateCommand;
import com.igorhenss.personregisterapi.domain.person.PersonService;
import com.igorhenss.personregisterapi.domain.person.PersonUpdateCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
public class PersonResource {
	
	@Autowired
	private PersonService service;
	
	@PostMapping(value = "/person/post")
	@ResponseStatus(HttpStatus.CREATED)
	public PersonResponseDTO post(@Valid @RequestBody PersonCreateCommand cmd) {
		return service.create(cmd);
	}
	
	@GetMapping(value = "/person/get/{id}")
	@ResponseStatus(HttpStatus.FOUND)
	public PersonResponseDTO get(@PathVariable UUID id) {
		return service.read(id);
	}
	
	@PutMapping(value = "/person/put/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public PersonResponseDTO put(@PathVariable UUID id, @Valid @RequestBody PersonUpdateCommand cmd) {
		return service.update(id, cmd);
	}
	
	@PostMapping(value = "/person/reactivate/{id}")
	@ResponseStatus(HttpStatus.OK)
	public PersonResponseDTO reactivate(@PathVariable UUID id) {
		return service.reactivate(id);
	}
	
	@DeleteMapping(value = "/person/delete/{id}")
	@ResponseStatus(HttpStatus.OK)
	public PersonResponseDTO delete(@PathVariable UUID id) {
		return service.delete(id);
	}
	
}

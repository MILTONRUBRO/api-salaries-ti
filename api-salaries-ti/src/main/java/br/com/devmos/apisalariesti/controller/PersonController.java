package br.com.devmos.apisalariesti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.devmos.apisalariesti.model.PersonDTO;
import br.com.devmos.apisalariesti.service.PersonService;

@RestController
@RequestMapping("/persons")
public class PersonController {
	
	@Autowired
	public PersonService personService;

	@GetMapping()
	public ResponseEntity<List<PersonDTO>> getPersons() {
		List<PersonDTO> persons = personService.getAll();
		return ResponseEntity.ok(persons);
	}
	
	@GetMapping("/{personId}")
	public void getPerson(@PathVariable("personId") Long personId) {
		
	}
}

package br.com.devmos.apisalariesti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.devmos.apisalariesti.model.PersonDTO;
import br.com.devmos.apisalariesti.model.request.PersonRequestDTO;
import br.com.devmos.apisalariesti.model.response.PersonSavedResponseDTO;
import br.com.devmos.apisalariesti.service.PersonService;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/persons")
@Log4j2
public class PersonController {
	
	@Autowired
	public PersonService personService;

	@GetMapping()
	public ResponseEntity<List<PersonDTO>> getPersons() {
		List<PersonDTO> persons = personService.getAll();
		log.info("Get All Persons");
		log.info("Response {}", persons);
		return ResponseEntity.ok(persons);
	}
	
	@GetMapping("/{personId}")
	public ResponseEntity<PersonDTO> getPerson(@PathVariable("personId") Long personId) {
		log.info("Request Person ID: {}", personId);

		PersonDTO person = personService.getPerson(personId);
		
		log.info("Response Person {}", person);
		return ResponseEntity.ok(person);
	}
	
	@PostMapping()
	public ResponseEntity<PersonSavedResponseDTO> savePerson(@RequestBody PersonRequestDTO request) {
		log.info("Request Save Person: {}", request);
		PersonSavedResponseDTO response = personService.savePerson(request);
		log.info("Successfully saved person {}", response);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/genders/{gender}")
	public ResponseEntity<List<PersonDTO>> getPersonsByGender(@PathVariable("gender") String gender) {
		List<PersonDTO> persons = personService.getByGender(gender);
		log.info("Get All Persons by Gender");
		log.info("Response {}", persons);
		return ResponseEntity.ok(persons);
	}
	
}

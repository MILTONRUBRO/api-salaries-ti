package br.com.devmos.apisalariesti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devmos.apisalariesti.model.Person;
import br.com.devmos.apisalariesti.model.PersonDTO;
import br.com.devmos.apisalariesti.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	public List<PersonDTO> getAll() {
		List<Person> persons = personRepository.findAll();
		return  PersonDTO.toDtos(persons);
	}

}

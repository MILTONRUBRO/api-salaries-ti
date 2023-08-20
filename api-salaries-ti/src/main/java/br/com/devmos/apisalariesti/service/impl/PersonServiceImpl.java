package br.com.devmos.apisalariesti.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devmos.apisalariesti.model.Person;
import br.com.devmos.apisalariesti.model.PersonDTO;
import br.com.devmos.apisalariesti.model.request.PersonRequestDTO;
import br.com.devmos.apisalariesti.model.response.PersonSavedResponseDTO;
import br.com.devmos.apisalariesti.repository.PersonRepository;
import br.com.devmos.apisalariesti.service.PersonService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	public List<PersonDTO> getAll() {
		List<Person> persons = personRepository.findAll();
		return  PersonDTO.toDtos(persons);
	}

	@Override
	public PersonDTO getPerson(Long id) {
		Optional<Person> optionalPerson = personRepository.findById(id);
		
		if(optionalPerson.isEmpty()) {
			throw new EntityNotFoundException("Pessoa não encontrada");
		}
		
		return PersonDTO.builder().age(optionalPerson.get().getAge())
								.educationLevel(optionalPerson.get().getEducationLevel())
								.gender(optionalPerson.get().getGender())
								.jobTitle(optionalPerson.get().getJobTitle())
								.salary(optionalPerson.get().getSalary())
								.yearsOfExperience(optionalPerson.get().getYearsOfExperience())
								.build();
		

	}

	@Override
	@Transactional
	public PersonSavedResponseDTO savePerson(PersonRequestDTO request) {
		Person person = Person.builder().age(request.getAge())
										.educationLevel(request.getEducationLevel())
										.gender(request.getGender())
										.jobTitle(request.getJobTitle())
										.salary(request.getSalary())
										.yearsOfExperience(request.getYearsOfExperience())
										.build();
		
		Person personSaved = personRepository.save(person);
		
		return PersonSavedResponseDTO.builder()
				.id(personSaved.getId())
				.build();
	}

	@Override
	public List<PersonDTO> getByGender(String gender) {
		List<Person> persons = personRepository.findByGenderIgnoreCase(gender);
		return  PersonDTO.toDtos(persons);
	}

	@Override
	@Transactional
	public void deletPerson(Long id) {
		Optional<Person> optionalPerson = personRepository.findById(id);
		
		if(optionalPerson.isEmpty()) {
			throw new EntityNotFoundException("Pessoa não encontrada");
		}
		
		personRepository.delete(optionalPerson.get());
		
	}

}

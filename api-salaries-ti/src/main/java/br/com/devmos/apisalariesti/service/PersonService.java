package br.com.devmos.apisalariesti.service;

import java.util.List;

import br.com.devmos.apisalariesti.model.PersonDTO;
import br.com.devmos.apisalariesti.model.request.PersonRequestDTO;

public interface PersonService {
	
	List<PersonDTO> getAll();
	PersonDTO getPerson(Long id);
	void savePerson(PersonRequestDTO request);

}

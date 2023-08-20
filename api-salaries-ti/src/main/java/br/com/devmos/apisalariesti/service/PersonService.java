package br.com.devmos.apisalariesti.service;

import java.util.List;

import br.com.devmos.apisalariesti.model.PersonDTO;
import br.com.devmos.apisalariesti.model.request.PersonRequestDTO;
import br.com.devmos.apisalariesti.model.response.PersonSavedResponseDTO;

public interface PersonService {
	
	List<PersonDTO> getAll();
	PersonDTO getPerson(Long id);
	PersonSavedResponseDTO savePerson(PersonRequestDTO request);
	List<PersonDTO> getByGender(String gender);

}

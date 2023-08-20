package br.com.devmos.apisalariesti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.devmos.apisalariesti.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}

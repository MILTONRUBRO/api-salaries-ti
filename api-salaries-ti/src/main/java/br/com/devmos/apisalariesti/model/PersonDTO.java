package br.com.devmos.apisalariesti.model;

import java.util.List;
import java.util.stream.Collectors;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class PersonDTO {
	private int age;
	private String gender;
	private String educationLevel;
	private String jobTitle;
	private Double yearsOfExperience;
	private Double salary;
	
	public PersonDTO(int age, String gender, String educationLevel, String jobTitle, Double yearsOfExperience,
			Double salary) {
		this.age = age;
		this.gender = gender;
		this.educationLevel = educationLevel;
		this.jobTitle = jobTitle;
		this.yearsOfExperience = yearsOfExperience;
		this.salary = salary;
	}
	

	public static List<PersonDTO> toDtos(List<Person> persons) {
        return persons.stream().map(person -> new PersonDTO(person.getAge(), person.getGender(),person.getEducationLevel(), person.getJobTitle(), person.getYearsOfExperience(), person.getSalary()))
        		.collect(Collectors.toList());
    }

}

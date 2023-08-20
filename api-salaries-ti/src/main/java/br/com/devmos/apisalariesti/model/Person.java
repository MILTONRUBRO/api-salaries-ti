package br.com.devmos.apisalariesti.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Builder
@ToString
@Table(name="PERSON")
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="AGE")
	private int age;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="EDUCATION_LEVEL")
	private String educationLevel;
	
	@Column(name="JOB_TITLE")
	private String jobTitle;
	
	@Column(name="YEARS_OF_EXPERIENCE")
	private Double yearsOfExperience;
	
	@Column(name="SALARY")
	private Double salary;

	public Person() {
		
	}

	public Person(Long id, int age, String gender, String educationLevel, String jobTitle, Double yearsOfExperience,
			Double salary) {
		this.id = id;
		this.age = age;
		this.gender = gender;
		this.educationLevel = educationLevel;
		this.jobTitle = jobTitle;
		this.yearsOfExperience = yearsOfExperience;
		this.salary = salary;
	}

}

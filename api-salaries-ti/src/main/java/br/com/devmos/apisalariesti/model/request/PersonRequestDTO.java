package br.com.devmos.apisalariesti.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PersonRequestDTO {
	
	@NotNull(message = "A idade não pode ser nula")
	@Size(min = 18)
	private int age;
	
	@NotBlank(message = "O genero não pode ser vazio")
	private String gender;
	
	@NotBlank(message = "O nivel de educação não pode ser vazio")
	private String educationLevel;
	
	@NotBlank(message = "O titulo de trabalho não pode ser vazio")
	private String jobTitle;
	
	@NotNull(message = "Os anos de experiencias não pode ser nulo")
	private Double yearsOfExperience;
	
	@NotNull(message = "O salario não pode ser nulo")
	private Double salary;

}

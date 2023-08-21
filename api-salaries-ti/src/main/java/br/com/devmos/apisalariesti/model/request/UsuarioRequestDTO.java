package br.com.devmos.apisalariesti.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
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
public class UsuarioRequestDTO {
	
    @NotNull(message = "Campo e-mail não pode ser nulo")
    @Email
    private String email;

    @JsonProperty("password")
    @NotBlank(message = "Password é obrigatório")
    @Size(min = 8, max = 64, message = "Password deve conter de 8 a 64 caracteres")
    private String pass;

    @NotBlank(message = "O campo nome não pode ser vazio")
    @Size(min = 3, message = "O campo nome deve possuir no mínimo três caracteres")
    private String nome;

}

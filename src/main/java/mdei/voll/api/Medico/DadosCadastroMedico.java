package mdei.voll.api.Medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import mdei.voll.api.Endereco.DadosEndereco;

public record DadosCadastroMedico(
		
		@NotBlank
		String nome, 
		
		@NotBlank
		@Email
		String email,
		
		@NotBlank
		String telefone,
		
		@NotBlank
		@Pattern(regexp = "\\d{6,7}")
		String crm, 
		
		@NotNull
		Especialidade especialidade,
		
		@NotNull
		@Valid
		DadosEndereco endereco
		) {

}

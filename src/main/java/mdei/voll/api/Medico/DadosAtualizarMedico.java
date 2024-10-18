package mdei.voll.api.Medico;

import jakarta.validation.constraints.NotNull;
import mdei.voll.api.Endereco.DadosEndereco;

public record DadosAtualizarMedico(
		@NotNull
		Long id, 
		String nome, 
		String telefone, 
		DadosEndereco endereco) {

}

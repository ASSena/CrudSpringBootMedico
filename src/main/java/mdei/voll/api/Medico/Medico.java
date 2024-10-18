package mdei.voll.api.Medico;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import mdei.voll.api.Endereco.Endereco;


@Table(name="medicos")
@Entity(name="Medico")
@AllArgsConstructor
@EqualsAndHashCode(of= "id")
public class Medico {
	
	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String crm;
	private String telefone;
	private Boolean ativo = true;
	
	
	@Enumerated(EnumType.STRING)
	private Especialidade especialidade;
	
	@Embedded
	private Endereco endereco;
	
	public Medico(DadosCadastroMedico dados) {
		this.nome = dados.nome();
		this.email = dados.email();
		this.crm = dados.crm();
		this.especialidade = dados.especialidade();
		this.endereco = new Endereco(dados.endereco());
		this.telefone = dados.telefone();
		
	}

	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getCrm() {
		return crm;
	}

	public String getTelefone() {
		return telefone;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}


	public Endereco getEndereco() {
		return endereco;
	}
	
	public Medico() {}
	
	public void atualizarDados(DadosAtualizarMedico dados) {
		if(dados.nome() != null) {
			this.nome = dados.nome();
		}
		if(dados.telefone() != null) {
			this.telefone = dados.telefone();
		}
		if(dados.endereco() != null) {
			this.endereco.atualizarInformacoes(dados.endereco());
		}
	}
	
	public void excluir() {
		this.ativo = false;
	}

}

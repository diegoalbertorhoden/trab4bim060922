package br.univel.diego.pessoa.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.univel.diego.model.PessoaModel;
import br.univel.diego.repository.PessoaRepository;
import br.univel.diego.usuario.controller.UsuarioController;
import br.univel.diego.uteis.Uteis;

/**
 * @author Diego Rhoden
 * classe que possui controle de escopo e método para salvar nova pessoa também
 * 21 de nov de 2016 às 00:31:09
 */
@Named(value="cadastrarPessoaController")
@RequestScoped
public class CadastrarPessoaController {
	
	@Inject
	PessoaModel pessoaModel;
 
	@Inject
	UsuarioController usuarioController;
 
	@Inject
	PessoaRepository pessoaRepository;
 
 
	public PessoaModel getPessoaModel() {
		return pessoaModel;
	}
 
	public void setPessoaModel(PessoaModel pessoaModel) {
		this.pessoaModel = pessoaModel;
	}
 
	/**
	 *SALVA UM NOVO REGISTRO VIA INPUT 
	 */
	public void SalvarNovaPessoa(){
 
		pessoaModel.setUsuarioModel(this.usuarioController.GetUsuarioSession());
 
		//INFORMANDO QUE O CADASTRO FOI VIA INPUT
		pessoaModel.setOrigemCadastro("I");
 
		pessoaRepository.SalvarNovoRegistro(this.pessoaModel);
 
		this.pessoaModel = null;
 
		Uteis.MensagemInfo("Registro cadastrado com sucesso"); 
	}	
}
package br.univel.diego.pessoa.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.univel.diego.model.PessoaModel;
import br.univel.diego.repository.PessoaRepository;

/**
 * @author Diego Rhoden
 *classe criada com o @viewscoped que é destruído juntamente com a destruição da sessão
 * o @produces será o construtor relacionado com a injecão de dependencia(aquele conceito de tirar a responsabilidade)
 * 25 de nov de 2016 às 00:44:03
 */

@Named(value="consultarPessoaCarouselController")
@ViewScoped
public class ConsultarPessoaCarouselController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject transient
	private PessoaRepository pessoaRepository;

	@Produces 
	private List<PessoaModel> pessoas;

	public List<PessoaModel> getPessoas() {
		return pessoas;
	}

	@PostConstruct
	private void init(){

		this.pessoas = pessoaRepository.GetPessoas();
	}
}
package br.univel.diego.repository;

import java.time.LocalDateTime;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.univel.diego.model.PessoaModel;
import br.univel.diego.repository.entity.PessoaEntity;
import br.univel.diego.repository.entity.UsuarioEntity;
import br.univel.diego.uteis.Uteis;

/**
 * @author Diego Rhoden
 *aqui informações de persistência da tabela pessoa entity
 * 21 de nov de 2016 às 00:28:01
 */
public class PessoaRepository {
	
	@Inject
	PessoaEntity pessoaEntity;
 
	EntityManager entityManager;
 
	/***
	 * MÉTODO RESPONSÁVEL POR SALVAR UMA NOVA PESSOA
	 * @param pessoaModel
	 */
	public void SalvarNovoRegistro(PessoaModel pessoaModel){
 
		entityManager =  Uteis.JpaEntityManager();
 
		pessoaEntity = new PessoaEntity();
		pessoaEntity.setDataCadastro(LocalDateTime.now());
		pessoaEntity.setEmail(pessoaModel.getEmail());
		pessoaEntity.setEndereco(pessoaModel.getEndereco());
		pessoaEntity.setNome(pessoaModel.getNome());
		pessoaEntity.setOrigemCadastro(pessoaModel.getOrigemCadastro());
		pessoaEntity.setSexo(pessoaModel.getSexo());
 
		UsuarioEntity usuarioEntity = entityManager.find(UsuarioEntity.class, pessoaModel.getUsuarioModel().getCodigo()); 
 
		pessoaEntity.setUsuarioEntity(usuarioEntity);
 
		entityManager.persist(pessoaEntity);
 
	}
	
}

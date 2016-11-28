package br.com.adriel.repository;

import java.time.LocalDateTime;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.adriel.model.PessoaModel;
import br.com.adriel.repository.entity.PessoaEntity;
import br.com.adriel.repository.entity.UsuarioEntity;
import br.com.adriel.uteis.Uteis;
/*Autor: adriel
 * esse e o modelo de pessoas, terao o metodo que vai salvar a pessoa no banco */
public class PessoaRepository {

	@Inject
	PessoaEntity pessoaEntity;
	
	EntityManager entityManager;
	
	/***
	 * Esse será o metodo usado para salvar uma nova pessoa
	 */
	public void SalvarNovoRegistro(PessoaModel pessoaModel){
		entityManager 	= Uteis.JpaEntityManager();
		pessoaEntity = 	new PessoaEntity();
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

package br.com.adriel.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.adriel.model.PessoaModel;
import br.com.adriel.model.UsuarioModel;
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
	 *  * Esse será o metodo usado para salvar uma nova pessoa  
	 */
	public void SalvarNovoRegistro(PessoaModel pessoaModel) {
		entityManager = Uteis.JpaEntityManager();
		pessoaEntity = new PessoaEntity();
		pessoaEntity.setDataCadastro(LocalDateTime.now());
		pessoaEntity.setEmail(pessoaModel.getEmail());
		pessoaEntity.setEndereco(pessoaModel.getEndereco());
		pessoaEntity.setNome(pessoaModel.getNome());
		pessoaEntity.setOrigemCadastro(pessoaModel.getOrigemCadastro());
		pessoaEntity.setSexo(pessoaModel.getSexo());

		UsuarioEntity usuarioEntity = entityManager.find(UsuarioEntity.class,
				pessoaModel.getUsuarioModel().getCodigo());
		pessoaEntity.setUsuarioEntity(usuarioEntity);

		entityManager.persist(pessoaEntity);
	}

	/* Esse metodo vai fazer a consulta das pessoas no banco */

	public List<PessoaModel> GetPessoas() {

		List<PessoaModel> pessoasModel = new ArrayList<PessoaModel>();

		entityManager = Uteis.JpaEntityManager();

		Query query = entityManager.createNamedQuery("PessoaEntity.findAll");

		@SuppressWarnings("unchecked")
		Collection<PessoaEntity> pessoasEntity = (Collection<PessoaEntity>) query.getResultList();

		PessoaModel pessoaModel = null;

		for (PessoaEntity pessoaEntity : pessoasEntity) {

			pessoaModel = new PessoaModel();
			pessoaModel.setCodigo(pessoaEntity.getCodigo());
			pessoaModel.setDataCadastro(pessoaEntity.getDataCadastro());
			pessoaModel.setEmail(pessoaEntity.getEmail());
			pessoaModel.setEndereco(pessoaEntity.getEndereco());
			pessoaModel.setNome(pessoaEntity.getNome());

			if (pessoaEntity.getOrigemCadastro().equals("X"))
				pessoaModel.setOrigemCadastro("XML");
			else
				pessoaModel.setOrigemCadastro("INPUT");

			if (pessoaEntity.getSexo().equals("M"))
				pessoaModel.setSexo("Masculino");
			else
				pessoaModel.setSexo("Feminino");

			UsuarioEntity usuarioEntity = pessoaEntity.getUsuarioEntity();

			UsuarioModel usuarioModel = new UsuarioModel();
			usuarioModel.setUsuario(usuarioEntity.getUsuario());

			pessoaModel.setUsuarioModel(usuarioModel);

			pessoasModel.add(pessoaModel);
		}

		return pessoasModel;

	}
	/* Esse metodo vai fazer a consulta das pessoas */

	private PessoaEntity GetPessoa(int codigo) {

		entityManager = Uteis.JpaEntityManager();

		return entityManager.find(PessoaEntity.class, codigo);
	}

	/* Esse metodo vai fazer a alteraçao dos registros */
	public void AlterarRegistro(PessoaModel pessoaModel) {

		entityManager = Uteis.JpaEntityManager();

		PessoaEntity pessoaEntity = this.GetPessoa(pessoaModel.getCodigo());

		pessoaEntity.setEmail(pessoaModel.getEmail());
		pessoaEntity.setEndereco(pessoaModel.getEndereco());
		pessoaEntity.setNome(pessoaModel.getNome());
		pessoaEntity.setSexo(pessoaModel.getSexo());

		entityManager.merge(pessoaEntity);
	}

	/*
	 * Metodo para excluir pessoas, metodo mais legal do sul do mundo remove os
	 * registross do banco e tals
	 */
	public void ExcluirRegistro(int codigo) {

		entityManager = Uteis.JpaEntityManager();

		PessoaEntity pessoaEntity = this.GetPessoa(codigo);

		entityManager.remove(pessoaEntity);
	}

}

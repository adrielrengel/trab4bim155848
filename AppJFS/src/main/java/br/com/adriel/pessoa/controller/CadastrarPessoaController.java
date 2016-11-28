package br.com.adriel.pessoa.controller;
/*autor: Adriel
 * esse será o controller da pessoa, que juntamente com os demais 
 * que foram criados hoje fazerm aprte do cadastro de pessoas*/

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.adriel.model.PessoaModel;
import br.com.adriel.repository.PessoaRepository;
import br.com.adriel.usuario.controller.UsuarioController;
import br.com.adriel.uteis.Uteis;

@Named(value="cadastrarPessoaController")
@RequestScoped
public class CadastrarPessoaController {

	@Inject
	PessoaModel pessoaModel;
	
	@Inject
	UsuarioController usuarioController;
	
	@Inject
	PessoaRepository pessoaRepository;
	
	public PessoaModel getPessoaModel(){
		return pessoaModel;
	}
	
	public void setPessoaModel(PessoaModel pessoaModel){
		this.pessoaModel = pessoaModel;
	}
	
	
	/*Esse metodo salva um novo registro via imput*/
	
	public void salvarNovaPessoa(){
		pessoaModel.setUsuarioModel(this.usuarioController.GetUsuarioSession()); /*VALIDAR ISSO assim que tiver acesso a internet*/
		
		//INFORMANDO QUE O CADASTRO FOI VIA INPUT
		pessoaModel.setOrigemCadastro("I");
		pessoaRepository.SalvarNovoRegistro(this.pessoaModel);
		this.pessoaModel = null;
		Uteis.MensagemInfo("Registro cadastrado com sucesso");;

	}
	
}

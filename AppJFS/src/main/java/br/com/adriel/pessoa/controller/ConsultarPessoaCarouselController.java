package br.com.adriel.pessoa.controller;
import java.io.Serializable;
import java.util.List;
 
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
 
import br.com.adriel.model.PessoaModel;
import br.com.adriel.repository.PessoaRepository;

/*AUOR: Adriel rengel
 * Esse sera o controller do nosso Carrousel
 * */
 
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
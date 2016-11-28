package br.com.adriel.pessoa.controller;
/*AUTOR Adriel
 * esse metodo é o responsavel pelo grafico
 * ele faz as consultas e retorna os dados
 * necessarios para a criaçao dos graficons no sistema
 */

import java.util.Hashtable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.PieChartModel;

import br.com.adriel.repository.PessoaRepository;

@Named(value = "graficoPizzaPessoaController")
@RequestScoped
public class GraficoPizzaPessoaController {

	@Inject
	private PessoaRepository pessoaRepository;

	private PieChartModel pieChartModel;

	public PieChartModel getPieChartModel() {
		return pieChartModel;
	}

	@PostConstruct
	public void init() {

		this.pieChartModel = new PieChartModel();

		this.MontaGrafico();
	}

	/***
	 * MONTA O GRÁFICO NA PÁGINA
	 */
	private void MontaGrafico() {

		// CONSULTA OS DADOS PARA MONTAR O GRÁFICO
		Hashtable<String, Integer> hashtableRegistros = pessoaRepository.GetOrigemPessoa();

		// INFORMANDO OS VALORES PARA MONTAR O GRÁFICO
		hashtableRegistros.forEach((chave, valor) -> {

			pieChartModel.set(chave, valor);

		});

		pieChartModel.setTitle("Total de Pessoas cadastrado por Tipo");
		pieChartModel.setShowDataLabels(true);
		pieChartModel.setLegendPosition("e");

	}
}
package br.com.bianeck.leilao.servico;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import br.com.bianeck.leilao.dominio.Lance;
import br.com.bianeck.leilao.dominio.Leilao;
import br.com.bianeck.leilao.dominio.Usuario;

public class AvaliadorTest {

	@Test
	public void deveEntenderLancesEmOrdemCrescente() {
		// cenário de 3 lances em ordem crescente
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("Jose");
		Usuario maria = new Usuario("Maria");

		Leilao leilao = new Leilao("Playstation 3 novo");

		leilao.propoe(new Lance(joao, 250.0));
		leilao.propoe(new Lance(jose, 300.0));
		leilao.propoe(new Lance(maria, 400.0));

		// Executando a ação
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		// comparando a saída com o esperado

		double maiorEsperado = 400;
		double menorEsperado = 250;

		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);
	}

	@Test
	public void deveCalcularAMedia() {
		// cenário de 3 lances em ordem crescente
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("Jose");
		Usuario maria = new Usuario("Maria");

		Leilao leilao = new Leilao("Playstation 3 novo");

		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(jose, 400.0));
		leilao.propoe(new Lance(maria, 500.0));

		// Executando a ação
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		// comparando a saída com o esperado

		Assert.assertEquals(400.0, leiloeiro.getMedia(), 0.0001);
	}
	
	@Test
	public void testaMediaDeZeroLance() {
		
		//cenario
		Usuario ewertom = new Usuario("Ewertom");
		
		//acao
		Leilao leilao = new Leilao("Iphone 7");
		
		Avaliador avaliador = new Avaliador();
		
		avaliador.avalia(leilao);
		
		//validação
		assertEquals(0, avaliador.getMedia(), 0.0001);
	}

}

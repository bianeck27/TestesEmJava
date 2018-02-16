package br.com.bianeck.leilao.dominio;

import br.com.bianeck.leilao.servico.Avaliador;

public class TesteDoAvaliador {
	
	public static void main(String[] args) {
		
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("Jose");
		Usuario maria = new Usuario("Maria");
		
		Leilao leilao = new Leilao("Playstation 3 novo");
		
		leilao.propoe(new Lance(joao, 250.0));
		leilao.propoe(new Lance(jose, 300.0));
		leilao.propoe(new Lance(maria, 400.0));
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		System.out.println(leiloeiro.getMaiorLance());
		System.out.println(leiloeiro.getMenorLance());
	}

}

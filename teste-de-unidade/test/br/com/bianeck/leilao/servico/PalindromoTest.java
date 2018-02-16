package br.com.bianeck.leilao.servico;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.bianeck.leilao.dominio.Palindromo;

public class PalindromoTest {
	
	@Test
	public void verificaSeEhPalindromo() {
		
		Palindromo palindromo = new Palindromo();
		
		boolean ehPalindromo = palindromo.ehPalindromo("Socorram-me subi no onibus em marrocos");
		
		assertTrue(ehPalindromo);
	}
	
	@Test
	public void deveIdentificarSeNaoEhPalindromo() {
		
		Palindromo palindromo = new Palindromo();
		
		boolean resultado = palindromo.ehPalindromo("Thiago Bianeck");
		
		assertFalse(resultado);
	}

}

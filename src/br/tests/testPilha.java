package br.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.codigo.Pilha;

public class testPilha {
	Pilha pilha;
	
	@Before
	public void inicializaPilha() {
		pilha = new Pilha();
	}
	
	@Test
	public void testaPush() {
		pilha.push("7");
		assertEquals(1, pilha.size());
	}
	
	@Test
	public void testaPop() {
		pilha.push("7");
		pilha.push("8");
		pilha.push("9");
		
		assertEquals("9", pilha.pop());
		assertEquals("8", pilha.pop());
		assertEquals("7", pilha.pop());
	} 

	@Test
	public void testaTop() {		
		pilha.push("100");
		assertEquals("100", pilha.top());
		
		pilha.push("200");
		assertEquals("200", pilha.top());
		
		pilha.pop();
		assertEquals("100", pilha.top());
	}
 
	@Test
	public void testaSize() {
		assertEquals(0, pilha.size());
		
		pilha.push("88");
		assertEquals(1, pilha.size());
		
		pilha.pop();
		assertEquals(0, pilha.size());
	}

	@Test
	public void testaIsEmpty() {
		assertEquals(true, pilha.isEmpty());
		
		pilha.push("51");
		assertEquals(false, pilha.isEmpty());
		
		pilha.pop();
		assertEquals(true, pilha.isEmpty());
	}

	@Test
	public void testaClear() {
		pilha.push("10");
		int tamanhoAntes = pilha.size();
		
		pilha.clear();
		int tamanhoDepois = pilha.size();
		
		assertEquals(tamanhoAntes == tamanhoDepois, false);
		assertEquals(1, tamanhoAntes);
		assertEquals(0, tamanhoDepois);
	}
	
	@Test
	public void testaAtualizaTamanhoMaximoAtingido() {
		assertEquals(0, pilha.atualizaTamanhoMaximoAtingido());
		
		pilha.push("99");
		assertEquals(1, pilha.atualizaTamanhoMaximoAtingido());
		
		pilha.pop();
		assertEquals(1, pilha.atualizaTamanhoMaximoAtingido());
		
		pilha.push("88");
		assertEquals(1, pilha.atualizaTamanhoMaximoAtingido());
		
		pilha.push("77");
		assertEquals(2, pilha.atualizaTamanhoMaximoAtingido());
		
		pilha.push("66");
		assertEquals(3, pilha.atualizaTamanhoMaximoAtingido());
		
		pilha.pop();
		pilha.pop();
		assertEquals(3, pilha.atualizaTamanhoMaximoAtingido());
	}
}

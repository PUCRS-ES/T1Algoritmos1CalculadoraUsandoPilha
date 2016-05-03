package br.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import br.codigo.Pilha;

public class testPilha {
	
	@Test
	public void testaPush() {
		Pilha pilha = new Pilha();
		pilha.push(7);
		assertEquals(1, pilha.size());
	}
	
	@Test
	public void testaPop() {
		Pilha pilha = new Pilha();
		pilha.push(7);
		pilha.push(8);
		pilha.push(9);
		
		assertEquals(9, pilha.pop());
		assertEquals(8, pilha.pop());
		assertEquals(7, pilha.pop());
	} 

	@Test
	public void testaTop() {
		Pilha pilha = new Pilha();
		assertEquals(null, pilha.top());
		
		pilha.push(100);
		assertEquals(100, pilha.top());
		
		pilha.push(200);
		assertEquals(200, pilha.top());
		
		pilha.pop();
		assertEquals(100, pilha.top());
		
		pilha.pop();
		assertEquals(null, pilha.top());
	}
 
	@Test
	public void testaSize() {
		Pilha pilha = new Pilha();
		assertEquals(0, pilha.size());
		
		pilha.push(88);
		assertEquals(1, pilha.size());
		
		pilha.pop();
		assertEquals(0, pilha.size());
	}

	@Test
	public void testaIsEmpty() {
		Pilha pilha = new Pilha();
		assertEquals(true, pilha.isEmpty());
		
		pilha.push(51);
		assertEquals(false, pilha.isEmpty());
		
		pilha.pop();
		assertEquals(true, pilha.isEmpty());
	}

	@Test
	public void testaClear() {
		Pilha pilha = new Pilha();
		pilha.push(10);
		int tamanhoAntes = pilha.size();
		
		pilha.clear();
		int tamanhoDepois = pilha.size();
		
		assertNotEquals(tamanhoAntes, tamanhoDepois);
		assertEquals(1, tamanhoAntes);
		assertEquals(0, tamanhoDepois);
	}
}

package br.codigo;

import java.util.ArrayList;

public class Pilha {
	private ArrayList<Node> pilha;
	private Node head;
	private int count = 0;
	private static final int TAMANHO_MAXIMO_PILHA = 8;
	
	public Pilha() {
		pilha = new ArrayList<Node>();
	}
	
	public void push(String valor) {
		Node novoElemento = new Node(valor);
		if(count > 0)
			novoElemento.setNext(head);
		pilha.add(novoElemento);
		head = novoElemento;
		count++;
	}

	public int size() {
		return count;
	}

	public String pop() {
		String valor = head.getElement();
		head = head.getNext();
		count--;
		pilha.remove(pilha.size() - 1);
		return valor;
	}

	public String top() {
		return head.getElement();
	}

	public boolean isEmpty() {
		if (count == 0)
			return true;
		else
			return false;
	}

	public void clear() {
		pilha.clear();
		count = 0;
		head = null;
	}
}

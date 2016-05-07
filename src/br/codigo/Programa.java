package br.codigo;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Programa {

	public static void main(String[] args) {
		Leitor leitor = null;
		Pilha pilha = new Pilha();
		Calculadora calc = new Calculadora();
		try {
			leitor = new Leitor("expressoes.txt");
			String linhaAtual = leitor.leProximaLinha();
			while(linhaAtual != null) {
				//System.out.println(linhaAtual);
				
				String[] termos = linhaAtual.split(" ");
				for(String proximoTermo : termos) {
					if(proximoTermo.equals(")")) {
						calc.setOperador2(Double.parseDouble(pilha.pop()));
						calc.setOperando(pilha.pop().charAt(0));
						calc.setOperador1(Double.parseDouble(pilha.pop()));
						//elimina o "abre-parentesis" excedente 
						pilha.pop();
						pilha.push(String.format("%f", calc.calcula()).replace(',','.'));
					}
					else
						pilha.push(proximoTermo);
					System.out.println(pilha.toString());
				}
				
				
				linhaAtual = leitor.leProximaLinha();
				pilha.clear();
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo nao encontrado.");
		} catch (IOException e) {
			System.out.println("Erro na leitura do arquivo");
		} catch (Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				leitor.fechaArquivo();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

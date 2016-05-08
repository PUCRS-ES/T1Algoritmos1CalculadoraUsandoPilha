package br.codigo;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Programa {

	public static void main(String[] args) {
		Leitor leitor = null;
		Escritor escritor = null;
		Pilha pilha = new Pilha();
		Calculadora calc = new Calculadora();
		try {
			leitor = new Leitor("expressoes.txt");
			escritor = new Escritor("resultados.txt");
			String linhaAtual = leitor.leProximaLinha();
			while(linhaAtual != null) {
				boolean erro = false;
				escritor.escreveProximaLinha("Expressao: " + linhaAtual);
				
				String[] termos = linhaAtual.split(" ");
				for(String proximoTermo : termos) {
					if(proximoTermo.equals(")")) {
						try {
							calc.setOperador2(Double.parseDouble(pilha.pop()));
							calc.setOperando(pilha.pop().charAt(0));
							calc.setOperador1(Double.parseDouble(pilha.pop()));
							//elimina o "abre parenteses" excedente
							pilha.pop();
							pilha.push(String.format("%f", calc.calcula()).replace(',','.'));
						}
						catch (Exception e) {
							erro = true;
							System.out.println(e);
							escritor.escreveProximaLinha("Erro de sintaxe");
							escritor.escreveProximaLinha("Tamanho maximo da pilha: " + pilha.getTamanhoMaximoAtingido());
							escritor.escreveProximaLinha("");
							break;
						}
					}
					else
						pilha.push(proximoTermo);
				}
				
				if (!erro) {
					escritor.escreveProximaLinha("Resultado: " + pilha.pop());
					escritor.escreveProximaLinha("Tamanho maximo da pilha: " + pilha.getTamanhoMaximoAtingido());
					escritor.escreveProximaLinha("");
				}
				linhaAtual = leitor.leProximaLinha();
				pilha.clear();
			}
			
		} 
		catch (FileNotFoundException e) {
			System.out.println("Arquivo nao encontrado.");
		} catch (IOException e) {
			System.out.println("Erro na leitura do arquivo");
		}
		finally {
			try {
				leitor.fechaArquivo();
				escritor.fechaArquivo();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

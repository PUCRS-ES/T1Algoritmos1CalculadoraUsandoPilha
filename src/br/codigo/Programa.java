package br.codigo;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Programa {

	public static void main(String[] args) {
		Leitor leitor = null;
		try {
			leitor = new Leitor("expressoes.txt");
			String linhaAtual = leitor.leProximaLinha();
			while(linhaAtual != null) {
				System.out.println(linhaAtual);
				linhaAtual = leitor.leProximaLinha();
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado.");
		} catch (IOException e) {
			System.out.println("Erro na leitura do arquivo");
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

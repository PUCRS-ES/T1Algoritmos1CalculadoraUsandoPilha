package br.codigo;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Programa {

	public static void main(String[] args) {
		Leitor leitor = null;
		try {
			String linhaAtual;
			leitor = new Leitor("expressoes.txt");
			do {
				linhaAtual = leitor.leProximaLinha();
				System.out.println(linhaAtual);
			}
			while(linhaAtual != null);
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

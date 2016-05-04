package br.codigo;

public class Calculadora {

	private int operador1, operador2;

	public void setOperador1(int valor1) {
		this.operador1 = valor1;
	}

	public void setOperador2(int valor2) {
		this.operador2 = valor2;
	}

	public int soma() {
		return (operador1 + operador2);
	}

	public int subtracao() {
		return (operador1 - operador2);
	}

	public int produto() {
		return (operador1 * operador2);
	}

	public double divisao() {
		return (operador1 * 1.0 / operador2);
	}

	public long potencia() {
		return (long)Math.pow(operador1, operador2);
	}
}

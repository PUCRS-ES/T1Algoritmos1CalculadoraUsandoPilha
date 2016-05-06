package br.codigo;

public class Calculadora {

	private double operador1, operador2;

	public void setOperador1(double valor1) {
		this.operador1 = valor1;
	}

	public void setOperador2(double valor2) {
		this.operador2 = valor2;
	}

	public double soma() {
		return (operador1 + operador2);
	}

	public double subtracao() {
		return (operador1 - operador2);
	}

	public double produto() {
		return (operador1 * operador2);
	}

	public double divisao() {
		return (operador1 / operador2);
	}

	public double potencia() {
		return Math.pow(operador1, operador2);
	}
}

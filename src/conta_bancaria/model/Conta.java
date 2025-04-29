package conta_bancaria.model;

import java.text.NumberFormat;
import java.util.Locale;

import conta_bancaria.util.Cores;

public abstract class Conta {
	
	//Cores
	public String corBackground = Cores.ANSI_BLACK_BACKGROUND;
	public String corMoldura = Cores.TEXT_PURPLE_BOLD_BRIGHT;
	public String corTextoNormal = Cores.TEXT_WHITE_BOLD_BRIGHT;
	public String corTextoDestaque = Cores.TEXT_GREEN_BOLD_BRIGHT;

	// Atributos da classe
	private int numero;
	private int agencia;
	private int tipo;
	private String titular;
	private double saldo;
	
	// Método Construtor
	public Conta(int numero, int agencia, int tipo, String titular, double saldo) {
		this.numero = numero;
		this.agencia = agencia;
		this.tipo = tipo;
		this.titular = titular;
		this.saldo = saldo;
	}
	
	// Getters e Setters
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	// Métodos Bancários
	public boolean sacar(double valor) {
		if (this.saldo < valor) {
			System.out.printf("%s╔══════════════════════════════════════╗             %n", corMoldura);
			System.out.printf("%s║  %sSaldo Insuficiente!                 %s║             %n", corMoldura, corTextoNormal, corMoldura);
			System.out.printf("%s╚══════════════════════════════════════╝             %n", corMoldura);
			return false;
		}
		
		this.saldo -= valor;
		return true;
	}
	
	public void depositar(double valor) {
		this.saldo += valor;
	}
	
	// Método para visualizar dados da conta
	public void visualizar() {
		
		NumberFormat nfMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		
		String tipo = "";
		
		switch(this.tipo) {
		case 1 -> tipo = "Conta Corrente";
		case 2 -> tipo = "Conta Poupança";
		default -> tipo = "Inválido";
		}
		
		System.out.print(corBackground);
		System.out.printf("%s╔═══════════════════════════════════════════════════╗%n", corMoldura);
		System.out.printf("%s║               %sDADOS DA CONTA BANCÁRIA%20s║%n", corMoldura, corTextoNormal, corMoldura);
		System.out.printf("%s╠═══════════════════════════════════════════════════╣%n", corMoldura);

		System.out.printf("%s║  %sTitular:%s %-40s%s║%n", corMoldura, corTextoDestaque, corTextoNormal, this.titular, corMoldura);
		System.out.printf("%s║  %sAgência:%s %-40d%s║%n", corMoldura, corTextoDestaque, corTextoNormal, this.agencia, corMoldura);
		System.out.printf("%s║  %sNúmero da Conta:%s %-32d%s║%n", corMoldura, corTextoDestaque, corTextoNormal, this.numero, corMoldura);
		System.out.printf("%s║  %sTipo de Conta:%s %-34s%s║%n", corMoldura, corTextoDestaque, corTextoNormal, tipo, corMoldura);
		System.out.printf("%s║  %sSaldo:%s %-42s%s║%n", corMoldura, corTextoDestaque, corTextoNormal, nfMoeda.format(this.saldo), corMoldura);

		System.out.printf("%s╚═══════════════════════════════════════════════════╝%n", corMoldura);

        
	}
	
	
}

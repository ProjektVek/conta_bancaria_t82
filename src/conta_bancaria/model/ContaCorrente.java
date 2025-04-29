package conta_bancaria.model;

import java.text.NumberFormat;
import java.util.Locale;

public class ContaCorrente extends Conta {

	private double limite;

	public ContaCorrente(int numero, int agencia, int tipo, String titular, double saldo, double limite) {
		super(numero, agencia, tipo, titular, saldo);
		this.limite = limite;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}
	
	@Override
	public void visualizar () {
		NumberFormat nfMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		
		String tipo = "";
		
		switch(this.getTipo()) {
		case 1 -> tipo = "Conta Corrente";
		case 2 -> tipo = "Conta Poupança";
		default -> tipo = "Inválido";
		}
		
		System.out.print(corBackground);
		System.out.printf("%s╔═══════════════════════════════════════════════════╗%n", corMoldura);
		System.out.printf("%s║               %sDADOS DA CONTA BANCÁRIA%20s║%n", corMoldura, corTextoNormal, corMoldura);
		System.out.printf("%s╠═══════════════════════════════════════════════════╣%n", corMoldura);

		System.out.printf("%s║  %sTitular:%s %-40s%s║%n", corMoldura, corTextoDestaque, corTextoNormal, this.getTitular(), corMoldura);
		System.out.printf("%s║  %sAgência:%s %-40d%s║%n", corMoldura, corTextoDestaque, corTextoNormal, this.getAgencia(), corMoldura);
		System.out.printf("%s║  %sNúmero da Conta:%s %-32d%s║%n", corMoldura, corTextoDestaque, corTextoNormal, this.getNumero(), corMoldura);
		System.out.printf("%s║  %sTipo de Conta:%s %-34s%s║%n", corMoldura, corTextoDestaque, corTextoNormal, tipo, corMoldura);
		System.out.printf("%s║  %sSaldo:%s %-42s%s║%n", corMoldura, corTextoDestaque, corTextoNormal, nfMoeda.format(this.getSaldo()), corMoldura);
		System.out.printf("%s║  %sLimite:%s %-41s%s║%n", corMoldura, corTextoDestaque, corTextoNormal, nfMoeda.format(this.getLimite()), corMoldura);

		System.out.printf("%s╚═══════════════════════════════════════════════════╝%n", corMoldura);
	}
	
	@Override
	public boolean sacar(double valor) {
		if ((this.getSaldo() + this.limite) < valor) {
			System.out.printf("%s╔══════════════════════════════════════╗             %n", corMoldura);
			System.out.printf("%s║  %sSaldo Insuficiente!                 %s║             %n", corMoldura, corTextoNormal, corMoldura);
			System.out.printf("%s╚══════════════════════════════════════╝             %n", corMoldura);
			return false;
		}
		
		this.setSaldo(this.getSaldo() - valor);
		return true;
	}
}

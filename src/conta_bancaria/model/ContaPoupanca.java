package conta_bancaria.model;

import java.text.NumberFormat;
import java.util.Locale;

public class ContaPoupanca extends Conta {
	
	private int aniversario;

	public ContaPoupanca(int numero, int agencia, int tipo, String titular, double saldo, int aniversario) {
		super(numero, agencia, tipo, titular, saldo);
		this.aniversario = aniversario;
	}

	public int getAniversario() {
		return aniversario;
	}

	public void setAniversario(int aniversario) {
		this.aniversario = aniversario;
	}
	
	@Override
	public void visualizar() {
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
		System.out.printf("%s║  %sAniversário da conta:%s %-27s%s║%n", corMoldura, corTextoDestaque, corTextoNormal, this.aniversario, corMoldura);

		System.out.printf("%s╚═══════════════════════════════════════════════════╝%n", corMoldura);
	}

}

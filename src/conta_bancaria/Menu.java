package conta_bancaria;

import conta_bancaria.model.Conta;
import conta_bancaria.util.Cores;

public class Menu {

	public static void main(String[] args) {
		System.out.println(Cores.TEXT_GREEN_BOLD + Cores.ANSI_BLACK_BACKGROUND);
		
		Conta conta = new Conta(1, 1, 1, "Victor", 100000000);
		conta.visualizar();
		
		conta.depositar(80000);
		conta.visualizar();
		
		conta.sacar(1000000000);
		conta.sacar(50000);
		conta.visualizar();
		
	}

}

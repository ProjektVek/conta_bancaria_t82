package conta_bancaria;

import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {

	public static void main(String[] args) {
		
		Scanner leia = new Scanner(System.in);
		
		ContaController contas = new ContaController();
		
		int numero, agencia, tipo, aniversario;
		String titular;
		double saldo, limite, valor;
		
		String corBackground = Cores.ANSI_BLACK_BACKGROUND;
		String corMoldura = Cores.TEXT_PURPLE_BOLD_BRIGHT;
		String corTextoNormal = Cores.TEXT_WHITE_BOLD_BRIGHT;
		String corTextoDestaque = Cores.TEXT_GREEN_BOLD_BRIGHT;
		String amareloBrazil = Cores.TEXT_YELLOW_BOLD_BRIGHT;
		
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000.00f, 100.00f);
		contas.cadastrar(cc1);
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 123, 2, "Maria da Silva", 1000.00f, 12);
		contas.cadastrar(cp1);
		
		while(true) {
			
			System.out.print(corBackground);
			System.out.printf("%s╔═══════════════════════════════════════════════════╗%n", corMoldura);
			System.out.printf("%s║                                                   ║%n", corMoldura);
			System.out.printf("%s║%s              Banco do %sBra%sz%sil%s com %sZ                %s║%n", corMoldura, corTextoNormal,
					amareloBrazil, corTextoDestaque, amareloBrazil, corTextoNormal, corTextoDestaque, corMoldura);
			System.out.printf("%s║                                                   ║%n", corMoldura);
			System.out.printf("%s╠═══════════════════════════════════════════════════╣%n", corMoldura);
			System.out.printf("%s║                                                   ║%n", corMoldura);
			System.out.printf("%s║%s           %s1%s - Criar Conta                         %s║%n", corMoldura, corTextoNormal, corTextoDestaque, corTextoNormal, corMoldura);
			System.out.printf("%s║%s           %s2%s - Listar todas as Contas              %s║%n", corMoldura, corTextoNormal, corTextoDestaque, corTextoNormal, corMoldura);
			System.out.printf("%s║%s           %s3%s - Buscar Conta por Número             %s║%n", corMoldura, corTextoNormal, corTextoDestaque, corTextoNormal, corMoldura);
			System.out.printf("%s║%s           %s4%s - Atualizar Dados da Conta            %s║%n", corMoldura, corTextoNormal, corTextoDestaque, corTextoNormal, corMoldura);
			System.out.printf("%s║%s           %s5%s - Apagar Conta                        %s║%n", corMoldura, corTextoNormal, corTextoDestaque, corTextoNormal, corMoldura);
			System.out.printf("%s║%s           %s6%s - Sacar                               %s║%n", corMoldura, corTextoNormal, corTextoDestaque, corTextoNormal, corMoldura);
			System.out.printf("%s║%s           %s7%s - Depositar                           %s║%n", corMoldura, corTextoNormal, corTextoDestaque, corTextoNormal, corMoldura);
			System.out.printf("%s║%s           %s8%s - Transferir Valores entre Contas     %s║%n", corMoldura, corTextoNormal, corTextoDestaque, corTextoNormal, corMoldura);
			System.out.printf("%s║%s           %s9%s - Sair                                %s║%n", corMoldura, corTextoNormal, corTextoDestaque, corTextoNormal, corMoldura);
			System.out.printf("%s║                                                   ║%n", corMoldura);
			System.out.printf("%s╚═══════════════════════════════════════════════════╝%n", corMoldura);

			
			int opcao = 0;
			
			do {
				
				System.out.printf("%s╔══════════════════════════════╗                     %n", corMoldura);
				System.out.printf("%s║   %sDigite a opção desejada: %s", corMoldura, corTextoNormal, corTextoDestaque);
				opcao = leia.nextInt();
				System.out.printf("%s╚══════════════════════════════╝                     %n", corMoldura);
				
				if(opcao==9) {
					leia.close();
					finalizar();
				}
					
				
				switch(opcao) {
				case 1:
					System.out.printf("%s╔══════════════════════════════════════╗             %n", corMoldura);
					System.out.printf("%s║           %sCriar Conta                %s║             %n", corMoldura, corTextoNormal, corMoldura);
					System.out.printf("%s╠══════════════════════════════════════╣             %n", corMoldura);
					
					System.out.printf("%s║ %sDigite o número da Agência:%s ", corMoldura, corTextoNormal, corTextoDestaque);
					agencia = leia.nextInt();

					System.out.printf("%s║ %sDigite o nome do Titular:%s ", corMoldura, corTextoNormal, corTextoDestaque);
					leia.skip("\\R");
					titular = leia.nextLine();

					System.out.printf("%s║ %sDigite o tipo da Conta (1 - CC | 2 - CP):%s ", corMoldura, corTextoNormal, corTextoDestaque);
					tipo = leia.nextInt();

					System.out.printf("%s║ %sDigite o saldo inicial da conta:%s ", corMoldura, corTextoNormal, corTextoDestaque);
					saldo = leia.nextDouble();

					switch(tipo) {
						case 1 -> {
							System.out.printf("%s║ %sDigite o limite da conta:%s ", corMoldura, corTextoNormal, corTextoDestaque);
							limite = leia.nextDouble();
							System.out.printf("%s╚══════════════════════════════════════╝             %n", corMoldura);
							contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
						}
						case 2 -> {
							System.out.printf("%s║ %sDigite o dia do aniversário da conta:%s ", corMoldura, corTextoNormal, corTextoDestaque);
							aniversario = leia.nextInt();
							System.out.printf("%s╚══════════════════════════════════════╝             %n", corMoldura);
							contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
						}
					}
					
					keyPress();
					break;

				case 2:
					System.out.printf("%s╔═══════════════════════════════════════════════════╗%n", corMoldura);
					System.out.printf("%s║               %sListar todas as Contas              %s║%n", corMoldura, corTextoNormal, corMoldura);
					System.out.printf("%s╚═══════════════════════════════════════════════════╝%n", corMoldura);
					
					contas.listarTodas();
					
					keyPress();
					break;

				case 3:
					System.out.printf("%s╔═══════════════════════════════════════════════════╗%n", corMoldura);
					System.out.printf("%s║        %sConsultar dados da Conta - por número%s      ║%n", corMoldura, corTextoNormal, corMoldura);
					System.out.printf("%s╠═══════════════════════════════════════════════════╣%n", corMoldura);
					System.out.printf("%s║ %sDigite o número da Conta:%s ", corMoldura, corTextoNormal, corTextoDestaque);
					numero = leia.nextInt();
					System.out.printf("%s╚═══════════════════════════════════════════════════╝%n", corMoldura);
					
					contas.procurarPorNumero(numero);
					keyPress();
					break;

				case 4:
					System.out.printf("%s╔═══════════════════════════════════════════════════╗%n", corMoldura);
					System.out.printf("%s║                   %sAtualizar conta%s                 ║%n", corMoldura, corTextoNormal, corMoldura);
					System.out.printf("%s╠═══════════════════════════════════════════════════╣%n", corMoldura);
					System.out.printf("%s║ %sDigite o número da Conta:%s ", corMoldura, corTextoNormal, corTextoDestaque);
					numero = leia.nextInt();
					System.out.printf("%s╚═══════════════════════════════════════════════════╝%n", corMoldura);
					
					Optional<Conta> conta = contas.buscarNaCollection(numero);
					
					if(conta.isPresent()) {
						System.out.printf("%s╔═══════════════════════════════════════════════════╗%n", corMoldura);
						System.out.printf("%s║ %sDigite o número da Agência:%s ", corMoldura, corTextoNormal, corTextoDestaque);
						agencia = leia.nextInt();

						System.out.printf("%s║ %sDigite o nome do Titular:%s ", corMoldura, corTextoNormal, corTextoDestaque);
						leia.skip("\\R");
						titular = leia.nextLine();

						System.out.printf("%s║ %sDigite o tipo da Conta (1 - CC | 2 - CP):%s ", corMoldura, corTextoNormal, corTextoDestaque);
						tipo = leia.nextInt();

						System.out.printf("%s║ %sDigite o saldo inicial da conta:%s ", corMoldura, corTextoNormal, corTextoDestaque);
						saldo = leia.nextDouble();
						
						switch(tipo) {
						case 1 -> {
							System.out.printf("%s║ %sDigite o limite da conta:%s ", corMoldura, corTextoNormal, corTextoDestaque);
							limite = leia.nextDouble();
							System.out.printf("%s╚════════════════════════════════════════════════╝%n", corMoldura);
							contas.atualizar(new ContaCorrente(conta.get().getNumero(), agencia, tipo, titular, saldo, limite));
						}
						case 2 -> {
							System.out.printf("%s║ %sDigite o dia do aniversário da conta:%s ", corMoldura, corTextoNormal, corTextoDestaque);
							aniversario = leia.nextInt();
							System.out.printf("%s╚══════════════════════════════════════╝             %n", corMoldura);
							contas.atualizar(new ContaPoupanca(conta.get().getNumero(), agencia, tipo, titular, saldo, aniversario));
						}
					}
						
					} else {
						System.out.printf("%s╔═══════════════════════════════════════════════════╗%n", corMoldura);
						System.out.printf("%s║            %sA conta %d não foi encontada!      %s   ║%n", corMoldura, corTextoNormal, numero, corMoldura);
						System.out.printf("%s╚═══════════════════════════════════════════════════╝%n", corMoldura);
					}
					

					
					keyPress();
					break;

				case 5:
					System.out.printf("%s╔═══════════════════════════════════════════════════╗%n", corMoldura);
					System.out.printf("%s║        %sApagar a Conta%s                             ║%n", corMoldura, corTextoNormal, corMoldura);
					System.out.printf("%s╠═══════════════════════════════════════════════════╣%n", corMoldura);
					System.out.printf("%s║ %sDigite o número da Conta:%s ", corMoldura, corTextoNormal, corTextoDestaque);
					numero = leia.nextInt();
					System.out.printf("%s╚═══════════════════════════════════════════════════╝%n", corMoldura);
					
					contas.deletar(numero);
					
					keyPress();
					break;

				case 6:
					System.out.printf("%s╔═══════════════════════════════════════════════════╗%n", corMoldura);
					System.out.printf("%s║                 %sSacar%s                             ║%n", corMoldura, corTextoNormal, corMoldura);
					System.out.printf("%s╠═══════════════════════════════════════════════════╣%n", corMoldura);
					
					System.out.printf("%s║ %sDigite o número da Conta:%s ", corMoldura, corTextoNormal, corTextoDestaque);
					numero = leia.nextInt();
					
					System.out.printf("%s║ %sDigite o valor do saque:%s ", corMoldura, corTextoNormal, corTextoDestaque);
					valor = leia.nextDouble();
					
					System.out.printf("%s╚═══════════════════════════════════════════════════╝%n", corMoldura);
					
					contas.sacar(numero, valor);
					
					keyPress();
					break;

				case 7:
					System.out.printf("%s╔═══════════════════════════════════════════════════╗%n", corMoldura);
					System.out.printf("%s║                 %sDepositar%s                         ║%n", corMoldura, corTextoNormal, corMoldura);
					System.out.printf("%s╠═══════════════════════════════════════════════════╣%n", corMoldura);
					
					System.out.printf("%s║ %sDigite o número da Conta:%s ", corMoldura, corTextoNormal, corTextoDestaque);
					numero = leia.nextInt();
					
					System.out.printf("%s║ %sDigite o valor do depósito:%s ", corMoldura, corTextoNormal, corTextoDestaque);
					valor = leia.nextDouble();
					
					System.out.printf("%s╚═══════════════════════════════════════════════════╝%n", corMoldura);
					
					contas.depositar(numero, valor);
					
					keyPress();
					break;

				case 8:
					System.out.printf("%s╔═══════════════════════════════════════════════════╗%n", corMoldura);
					System.out.printf("%s║                 %sTranferência%s                      ║%n", corMoldura, corTextoNormal, corMoldura);
					System.out.printf("%s╠═══════════════════════════════════════════════════╣%n", corMoldura);
					
					System.out.printf("%s║ %sDigite o número da Conta de Origem:%s ", corMoldura, corTextoNormal, corTextoDestaque);
					int numeroOrigem = leia.nextInt();
					
					System.out.printf("%s║ %sDigite o número da Conta de Destino:%s ", corMoldura, corTextoNormal, corTextoDestaque);
					int numeroDestino = leia.nextInt();
					
					System.out.printf("%s║ %sDigite o valor do depósito:%s ", corMoldura, corTextoNormal, corTextoDestaque);
					valor = leia.nextDouble();
					
					System.out.printf("%s╚═══════════════════════════════════════════════════╝%n", corMoldura);
					
					contas.transferir(numeroOrigem, numeroDestino, valor);
					keyPress();
					break;

				default:
					System.out.printf("%s╔══════════════════════════════════════╗             %n", corMoldura);
					System.out.printf("%s║  %sOpção inválida! Digite novamente!   %s║             %n", corMoldura, corTextoNormal, corMoldura);
					System.out.printf("%s╚══════════════════════════════════════╝             %n", corMoldura);
					keyPress();
					break;

				}
				
			} while(opcao<1||opcao>9);	
		}
		
	}
	
	public static void sobre() {
		
		String corMoldura = Cores.TEXT_PURPLE_BOLD_BRIGHT;
		String corTextoNormal = Cores.TEXT_WHITE_BOLD_BRIGHT;
		String corTextoDestaque = Cores.TEXT_GREEN_BOLD_BRIGHT;
		
		System.out.printf("%s╔═══════════════════════════════════════════════════╗%n", corMoldura);
		System.out.printf("%s║                                                   ║%n", corMoldura);
		System.out.printf("%s║  %sProjeto Desenvolvido Por:%s                        ║%n", corMoldura, corTextoDestaque, corMoldura);
		System.out.printf("%s║                                                   ║%n", corMoldura);
		System.out.printf("%s║  Victor Hugo Souza Ferreira                       ║%n", corMoldura);
		System.out.printf("%s║  %sEmail:%s victor.sz.ferreira@gmail.com%s              ║%n", corMoldura, corTextoDestaque, corTextoNormal, corMoldura);
		System.out.printf("%s║  %sGitHub:%s https://github.com/ProjektVek%s            ║%n", corMoldura, corTextoDestaque, corTextoNormal, corMoldura);
		System.out.printf("%s║                                                   ║%n", corMoldura);
		System.out.printf("%s╚═══════════════════════════════════════════════════╝%n", corMoldura);

		
	}
	
	public static void keyPress() {
		String corMoldura = Cores.TEXT_PURPLE_BOLD_BRIGHT;
		String corTextoNormal = Cores.TEXT_WHITE_BOLD_BRIGHT;
		
		try {
			System.out.printf("%s╔═══════════════════════════════════════════════════╗%n", corMoldura);
			System.out.printf("%s║        %sPressione Enter para Continuar...%s          ║%n", corMoldura, corTextoNormal, corMoldura);
			System.out.printf("%s╚═══════════════════════════════════════════════════╝%n", corMoldura);
			System.in.read();
		} catch (IOException e) {
			System.err.println("Ocorreu um erro ao ler o teclado!");
		}
	}
	
	public static void finalizar() {
		
		String corMoldura = Cores.TEXT_PURPLE_BOLD_BRIGHT;
		String corTextoNormal = Cores.TEXT_WHITE_BOLD_BRIGHT;
		String corTextoDestaque = Cores.TEXT_GREEN_BOLD_BRIGHT;
		String amareloBrazil = Cores.TEXT_YELLOW_BOLD_BRIGHT;
		
		System.out.printf("%s╔═══════════════════════════════════════════════════╗%n", corMoldura);
		System.out.printf("%s║                                                   ║%n", corMoldura);
		System.out.printf("%s║ %sBanco do %sBra%sz%sil%s com %sZ%s - O seu Futuro começa aqui! %s║%n", corMoldura, corTextoNormal,
				amareloBrazil, corTextoDestaque, amareloBrazil, corTextoNormal, corTextoDestaque, corTextoNormal, corMoldura);
		System.out.printf("%s║                                                   ║%n", corMoldura);
		System.out.printf("%s╚═══════════════════════════════════════════════════╝%n", corMoldura);

		
		sobre();
		
		System.exit(0);
	}

}
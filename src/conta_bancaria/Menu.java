package conta_bancaria;

import java.util.Scanner;

import conta_bancaria.model.Conta;
import conta_bancaria.util.Cores;

public class Menu {

	public static void main(String[] args) {
		
		Scanner leia = new Scanner(System.in);
		
		String corBackground = Cores.ANSI_BLACK_BACKGROUND;
		String corMoldura = Cores.TEXT_PURPLE_BOLD_BRIGHT;
		String corTextoNormal = Cores.TEXT_WHITE_BOLD_BRIGHT;
		String corTextoDestaque = Cores.TEXT_GREEN_BOLD_BRIGHT;
		String amareloBrazil = Cores.TEXT_YELLOW_BOLD_BRIGHT;
		
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
				
				if(opcao==9)
					finalizar();
				
				switch(opcao) {
				case 1:
					System.out.printf("%s╔══════════════════════════════════════╗             %n", corMoldura);
					System.out.printf("%s║  %sCriar Conta                         %s║             %n", corMoldura, corTextoNormal, corMoldura);
					System.out.printf("%s╚══════════════════════════════════════╝             %n", corMoldura);
					break;

				case 2:
					System.out.printf("%s╔══════════════════════════════════════╗             %n", corMoldura);
					System.out.printf("%s║  %sListar todas as Contas              %s║             %n", corMoldura, corTextoNormal, corMoldura);
					System.out.printf("%s╚══════════════════════════════════════╝             %n", corMoldura);
					break;

				case 3:
					System.out.printf("%s╔═════════════════════════════════════════╗          %n", corMoldura);
					System.out.printf("%s║  %sConsultar dados da Conta - por número  %s║          %n", corMoldura, corTextoNormal, corMoldura);
					System.out.printf("%s╚═════════════════════════════════════════╝          %n", corMoldura);
					break;

				case 4:
					System.out.printf("%s╔══════════════════════════════════════╗             %n", corMoldura);
					System.out.printf("%s║  %sAtualizar dados da Conta            %s║             %n", corMoldura, corTextoNormal, corMoldura);
					System.out.printf("%s╚══════════════════════════════════════╝             %n", corMoldura);
					break;

				case 5:
					System.out.printf("%s╔══════════════════════════════════════╗             %n", corMoldura);
					System.out.printf("%s║  %sApagar a Conta                      %s║             %n", corMoldura, corTextoNormal, corMoldura);
					System.out.printf("%s╚══════════════════════════════════════╝             %n", corMoldura);
					break;

				case 6:
					System.out.printf("%s╔══════════════════════════════════════╗             %n", corMoldura);
					System.out.printf("%s║  %sSaque                               %s║             %n", corMoldura, corTextoNormal, corMoldura);
					System.out.printf("%s╚══════════════════════════════════════╝             %n", corMoldura);
					break;

				case 7:
					System.out.printf("%s╔══════════════════════════════════════╗             %n", corMoldura);
					System.out.printf("%s║  %sDepósito                            %s║             %n", corMoldura, corTextoNormal, corMoldura);
					System.out.printf("%s╚══════════════════════════════════════╝             %n", corMoldura);
					break;

				case 8:
					System.out.printf("%s╔══════════════════════════════════════╗             %n", corMoldura);
					System.out.printf("%s║  %sTransferência entre Contas          %s║             %n", corMoldura, corTextoNormal, corMoldura);
					System.out.printf("%s╚══════════════════════════════════════╝             %n", corMoldura);
					break;

				default:
					System.out.printf("%s╔══════════════════════════════════════╗             %n", corMoldura);
					System.out.printf("%s║  %sOpção inválida! Digite novamente!   %s║             %n", corMoldura, corTextoNormal, corMoldura);
					System.out.printf("%s╚══════════════════════════════════════╝             %n", corMoldura);
					break;

				}
				
			} while(opcao<1||opcao>9);	
		}
		
	}
	
	public static void sobre() {
		
		String corBackground = Cores.ANSI_BLACK_BACKGROUND;
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
	
	public static void finalizar() {
		
		String corBackground = Cores.ANSI_BLACK_BACKGROUND;
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
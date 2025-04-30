package conta_bancaria.controller;

import java.util.ArrayList;

import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;
import conta_bancaria.util.Cores;

public class ContaController implements ContaRepository {
	
	// Criar a Collection ArrayList
	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	
	// Variável para controlar o número de contas
	int numero = 0;
	
	@Override
	public void procurarPorNumero(int numero) {
		var conta = buscarNaCollection(numero);
		
		if(conta != null)
			conta.visualizar();
		else {
			String corMoldura = Cores.TEXT_PURPLE_BOLD_BRIGHT;
			String corTextoNormal = Cores.TEXT_WHITE_BOLD_BRIGHT;
			
			System.out.printf("%s╔═══════════════════════════════════════════════════╗%n", corMoldura);
			System.out.printf("%s║        %sA conta número %d não foi encontrada!%s         ║%n", corMoldura, corTextoNormal, numero, corMoldura);
			System.out.printf("%s╚═══════════════════════════════════════════════════╝%n", corMoldura);
		}
	}

	@Override
	public void listarTodas() {
		for(var conta : listaContas) {
			conta.visualizar();
		}
		
	}

	@Override
	public void cadastrar(Conta conta) {
		String corMoldura = Cores.TEXT_PURPLE_BOLD_BRIGHT;
		String corTextoNormal = Cores.TEXT_WHITE_BOLD_BRIGHT;
		
		listaContas.add(conta);
		
		System.out.printf("%s╔═══════════════════════════════════════════════════╗%n", corMoldura);
		System.out.printf("%s║        %sA conta foi criada com sucesso!...%s         ║%n", corMoldura, corTextoNormal, corMoldura);
		System.out.printf("%s╚═══════════════════════════════════════════════════╝%n", corMoldura);
	}

	@Override
	public void atualizar(Conta conta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(int numero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sacar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void depositar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		// TODO Auto-generated method stub
		
	}

	// Métodos Auxiliares
	
	public int gerarNumero() {
		return ++numero;
	}
	
	public Conta buscarNaCollection(int numero) {
		for(var conta: listaContas) {
			if(conta.getNumero() == numero)
				return conta;
		}
		
		return null;
	}
}

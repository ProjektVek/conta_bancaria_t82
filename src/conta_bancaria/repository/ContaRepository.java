package conta_bancaria.repository;

import conta_bancaria.model.Conta;

public interface ContaRepository {
	
	// Métodos do CRUD (Create, Read, Update, Delete)
	
	public void procurarPorNumero(int numero);
	public void listarTodas();
	public void cadastrar(Conta conta);
	public void atualizar(Conta conta);
	public void deletar(int numero);
	
	// Métodos Bancários
	public void sacar(int numero, double valor);
	public void depositar(int numero, double valor);
	public void transferir(int numeroOrigem, int numeroDestino, double valor);
	
}

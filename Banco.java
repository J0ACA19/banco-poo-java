package ContaBancaria;

public class Banco {
	private Conta[] contas = new Conta[0];
	
	public Conta criarConta(String nome) {
		int numero = 1001 + contas.length;
		Conta nova = new Conta(nome, numero);
		
		Conta[] maior = new Conta[contas.length+1];
 		for (int i = 0; i < contas.length; i++) {
			maior[i] = contas[i];
		}
 		maior[maior.length - 1] = nova;
 		
 		contas = maior;
 		return nova;
	}
	
	public Conta buscarConta(int numero) {
		for (int i = 0; i < contas.length; i++) {
			if (contas[i].getNumeroConta() == numero) {
				return contas[i];
			}
		}
		return null;
	}
	
	public boolean transferir(int origem, int destino, double valor) {
		Conta contaOrigem = buscarConta(origem);
		Conta contaDestino = buscarConta(destino);
		
		if (origem == destino ) {
			return false;
		}
		
		if (contaOrigem == null || contaDestino == null) {
            return false;
        }
		
		if (contaOrigem.saqueConta(valor)) {
			contaDestino.depositoConta(valor);
			return true;
		}
		
		return false;	
	}
	
	public void listarConta() {
		if (contas.length == 0) {
			System.out.println("Banco de dados vazio");
			return;
		}
		for(int i = 0; i < contas.length; i++) {
			System.out.println(contas[i].getNumeroConta() + " - " + contas[i].getNome() + " - Saldo: " + contas[i].verSaldo());
		}
			
	}
}


package ContaBancaria;

import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Banco banco = new Banco();
		
		int op;
		do {
			System.out.println("===== BANCO =====");
			System.out.println();
			System.out.println("1 - Criar conta");
			System.out.println("2 - Depositar");
			System.out.println("3 - Sacar");
			System.out.println("4 - Transferir");
			System.out.println("5 - Consultar saldo");
			System.out.println("6 - Listar contas");
			System.out.println("7 - Encerrar");
			System.out.print("Insira sua opção: ");
			op = input.nextInt();
			input.nextLine();
			
			switch (op) {
				case 1:
					System.out.print("Insira o nome: ");
					String nomeConta = input.nextLine();
					Conta novaConta = banco.criarConta(nomeConta);
					
					System.out.println("Conta criada! Número da conta: " + novaConta.getNumeroConta());
					System.out.println();
					break;
					
				case 2:
					System.out.print("Número da conta: ");
					int numeroDeposito = input.nextInt();
					
					Conta contaDeposito = banco.buscarConta(numeroDeposito);
					
					if (contaDeposito == null) {
						System.out.println("Conta não encontrada!");
						System.out.println();
					}else {
						System.out.print("Valor do depósito: ");
						double valorDeposito = input.nextDouble();
						
						if (contaDeposito.depositoConta(valorDeposito)) {
							System.out.println("Depósito realizado. Saldo: " + contaDeposito.verSaldo());
							System.out.println();
						}else {
							System.out.println("Valor inválido.");
							System.out.println();
						}
					}
					break;
					
				case 3:
					System.out.print("Número da conta: ");
					int numeroSaque = input.nextInt();
					
					Conta contaSaque = banco.buscarConta(numeroSaque);
					
					if (contaSaque == null) {
						System.out.println("Conta não encontrada!");
						System.out.println();
					}else {
						System.out.print("Valor do saque: ");
						double valorSaque = input.nextDouble();
						
						if (valorSaque <=0) {
							System.out.println("Valor inválido.");
							System.out.println();
						}else if(contaSaque.saqueConta(valorSaque)) {
							System.out.println("Saque realizado. Saldo: " + contaSaque.verSaldo());
							System.out.println();
						}else {
							System.out.println("Saldo insuficiente. Saldo: " + contaSaque.verSaldo());
							System.out.println();
						}
					}
					break;
					
				case 4: 
					System.out.print("Número da conta de origem: ");
					int numeroOrigem = input.nextInt();
					System.out.print("Número da conta de destino: ");
					int numeroDestino = input.nextInt();
					
					Conta contaOrigem = banco.buscarConta(numeroOrigem);
					Conta contaDestino = banco.buscarConta(numeroDestino);
					
					if (contaOrigem == null || contaDestino == null) {
						System.out.println("Conta não encontrada.");
					}else if (numeroOrigem == numeroDestino){
						System.out.println("Não é possível transferir para a mesma conta!");
					}else {
						System.out.print("Valor da trasferência: ");
						double valorTransferencia = input.nextDouble();
						
						 if(valorTransferencia <=0) {
							 System.out.println("Valor inválido");
						 }else if(banco.transferir(numeroOrigem, numeroDestino, valorTransferencia)) {
							 System.out.println("Transferência realizada.");
							 System.out.println("Saldo da conta de Origem: " + contaOrigem.verSaldo());
							 System.out.println("Saldo da conta de Destino: " + contaDestino.verSaldo());
							 System.out.println();
						 }else {
							 System.out.println("Saldo insuficiente! Transferência cancelada");
						 }
					}
					System.out.println();
					break;
					
				case 5:
					System.out.print("Número da conta: ");
					int numeroConta = input.nextInt();
					
					Conta contaVerSaldo = banco.buscarConta(numeroConta);
					
					if (contaVerSaldo == null) {
						System.out.println("Conta não encontrada.");
						System.out.println();
					}else {
						System.out.println("Saldo da conta " + numeroConta + ": " + contaVerSaldo.verSaldo());
						System.out.println();
					}
					break;
					
				case 6:
					System.out.println("Lista de contas");
					banco.listarConta();
					System.out.println();
					
					break;
					
				case 7: 
					System.out.println("Fechando o banco");
					System.out.println();
					break;
				default:
					System.out.println("Opção inválida. Tente Novamente");
					System.out.println();
			}
			
		}while(op != 7);
	}
}

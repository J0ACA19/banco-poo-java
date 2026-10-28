package ContaBancaria;

import java.util.Scanner;

public class Principal {
	private static Scanner input = new Scanner(System.in);
	private static Banco banco = new Banco();
	
	public static void main(String[] args) {
		int op;
		do {
			exibirMenu();
			op = input.nextInt();
			input.nextLine();
			
			switch (op) {
				case 1 -> criarConta();
				case 2 -> depositar();
				case 3 -> sacar();
				case 4 -> transferir();
				case 5 -> consultarSaldo();
				case 6 -> listarContas();
				case 7 -> encerrarConta();
				case 8 -> {
					System.out.println("Fechando banco");
				}
				default -> {
					System.out.println("Opção inválida. Tente novamente");
					System.out.println();
				}
			}
		}while (op != 8);
	}
		
		private static void exibirMenu() {
			System.out.println("===== Banco =====");
			System.out.println();
			System.out.println("1 - Criar conta");
			System.out.println("2 - Depositar");
			System.out.println("3 - Sacar");
			System.out.println("4 - Transferir");
			System.out.println("5 - Consultar saldo");
			System.out.println("6 - Listar contas");
			System.out.println("7 - Encerrar conta");
			System.out.println("8 - Encerrar");
			System.out.print("Insira sua opção: ");
		}
		
		private static void criarConta() {
			System.out.print("Insira o nome: ");
			String nomeConta = input.nextLine();
			Conta novaConta = banco.criarConta(nomeConta);
			
			System.out.println("Conta criada! Número da conta: " + novaConta.getNumeroConta());
			System.out.println();
		}
		
		private static void depositar() {
			System.out.print("Número da conta: ");
			int numeroDeposito = input.nextInt();
			
			Conta contaDeposito = banco.buscarConta(numeroDeposito);
			
			if (contaDeposito == null) {
				System.out.println("Conta não encontrada!");
				System.out.println();
			}else {
				System.out.print("Valor do depósito: ");
				int valorDeposito = input.nextInt();
				
				if (contaDeposito.depositoConta(valorDeposito)) {
					System.out.println("Depósito realizado. Saldo: " + contaDeposito.verSaldo());
					System.out.println();
				}else {
					System.out.println("Valor inválido");
					System.out.println();
				}
			}
		}
		

		private static void sacar() {
			System.out.print("Número da conta: ");
			int numeroSaque = input.nextInt();
	 
			Conta contaSaque = banco.buscarConta(numeroSaque);
	 
			if (contaSaque == null) {
				System.out.println("Conta não encontrada!");
				System.out.println();
			} else {
				System.out.print("Valor do saque: ");
				double valorSaque = input.nextDouble();
	 
				if (valorSaque <= 0) {
					System.out.println("Valor inválido.");
					System.out.println();
				} else if (contaSaque.saqueConta(valorSaque)) {
					System.out.println("Saque realizado. Saldo: " + contaSaque.verSaldo());
					System.out.println();
				} else {
					System.out.println("Saldo insuficiente. Saldo: " + contaSaque.verSaldo());
					System.out.println();
				}
			}
		}
	 
		private static void transferir() {
			System.out.print("Número da conta de origem: ");
			int numeroOrigem = input.nextInt();
			System.out.print("Número da conta de destino: ");
			int numeroDestino = input.nextInt();
	 
			Conta contaOrigem = banco.buscarConta(numeroOrigem);
			Conta contaDestino = banco.buscarConta(numeroDestino);
	 
			if (contaOrigem == null || contaDestino == null) {
				System.out.println("Conta não encontrada.");
			} else if (numeroOrigem == numeroDestino) {
				System.out.println("Não é possível transferir para a mesma conta!");
			} else {
				System.out.print("Valor da transferência: ");
				double valorTransferencia = input.nextDouble();
	 
				if (valorTransferencia <= 0) {
					System.out.println("Valor inválido");
				} else if (banco.transferir(numeroOrigem, numeroDestino, valorTransferencia)) {
					System.out.println("Transferência realizada.");
					System.out.println("Saldo da conta de Origem: " + contaOrigem.verSaldo());
					System.out.println("Saldo da conta de Destino: " + contaDestino.verSaldo());
					System.out.println();
				} else {
					System.out.println("Saldo insuficiente! Transferência cancelada");
				}
			}
			System.out.println();
		}
	 
		private static void consultarSaldo() {
			System.out.print("Número da conta: ");
			int numeroConta = input.nextInt();
	 
			Conta contaVerSaldo = banco.buscarConta(numeroConta);
	 
			if (contaVerSaldo == null) {
				System.out.println("Conta não encontrada.");
				System.out.println();
			} else {
				System.out.println("Saldo da conta " + numeroConta + ": " + contaVerSaldo.verSaldo());
				System.out.println();
			}
		}
	 
		private static void listarContas() {
			System.out.println("Lista de contas");
			banco.listarConta();
		}
	 
		private static void encerrarConta() {
			System.out.print("Insira o numero da conta para encerrar: ");
			int numeroParaEncerrar = input.nextInt();
	 
			if (banco.cancelarConta(numeroParaEncerrar)) {
				System.out.println("Conta cancelada com sucesso!");
			} else {
				System.out.println("Não foi possível encontrar a conta!");
			}
		}
}



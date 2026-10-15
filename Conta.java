package ContaBancaria;

public class Conta {
	private int numeroConta;
	private String nome;
	private double saldo = 0;
	
	Conta(String nome, int numeroConta){
		this.nome = nome;
		this.numeroConta = numeroConta;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getNumeroConta() {
		return numeroConta;
	}
	
	public boolean depositoConta(double valor) {
		if (valor > 0) {
			saldo += valor;
			return true;
		}
		
		return false;
	}
	
	public boolean saqueConta(double valor) {
		if (valor > 0 && valor <= saldo) {
				saldo -= valor;
				return true;
		}
		return false;
	}
	
	public double verSaldo() {
		return saldo;
	}
}

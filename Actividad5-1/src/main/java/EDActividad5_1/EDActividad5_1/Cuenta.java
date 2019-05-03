package EDActividad5_1.EDActividad5_1;

public class Cuenta {
	private String id;
	private float saldo;
	private Cliente cliente;
	private Banco banco;
	
	public Cuenta(String id, float saldo, Cliente cliente, Banco banco) {
		this.id = banco.getIdentificador() +" "+ id;
		this.saldo = saldo;
		this.cliente = cliente;
		this.banco = banco;
	}

	public String getId() {
		return id;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}
	
	
	
}

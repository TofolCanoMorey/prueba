package EDActividad5_1.EDActividad5_1;

public class Traspaso {

	private Cuenta origen;
	private Cuenta destino;
	private float cantidad;
	private boolean resultado;
	
	private Traspaso(Cuenta origen, Cuenta destino, float cantidad) {
		this.origen = origen;
		this.destino = destino;
		this.cantidad = cantidad;
	}
	
	public static Traspaso traspasar(Cuenta origen, Cuenta destino, float cantidad) {
		float saldoInicialOrigen = origen.getSaldo();
		
		String clienteOrigen = origen.getCliente().getDni();
		String bancoOrigen = origen.getBanco().getIdentificador();
		
		String clienteDestino = destino.getCliente().getDni();
		String bancoDestino = destino.getBanco().getIdentificador();
		
		float saldoFinalOrigen;
		float saldoFinalDestino;
		
		Traspaso result = new Traspaso(origen, destino, cantidad);
		
		if(saldoInicialOrigen-cantidad >= 0 && clienteOrigen.equals(clienteDestino) && bancoOrigen.equals(bancoDestino)) {
			saldoFinalOrigen = origen.getSaldo()-cantidad;
			saldoFinalDestino = destino.getSaldo()+cantidad;
			origen.setSaldo(saldoFinalOrigen);
			destino.setSaldo(saldoFinalDestino);
			result.setResultado(true);
		} else {
			result.setCantidad(0);
			result.setResultado(false);
		}
		
		return result;
	}

	public Cuenta getOrigen() {
		return origen;
	}

	public void setOrigen(Cuenta origen) {
		this.origen = origen;
	}

	public Cuenta getDestino() {
		return destino;
	}

	public void setDestino(Cuenta destino) {
		this.destino = destino;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public boolean getResultado() {
		return resultado;
	}

	public void setResultado(boolean resultado) {
		this.resultado = resultado;
	}
	
	
	
}

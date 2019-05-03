package EDActividad5_1.EDActividad5_1;

public class Transferencia {

	private Cuenta origen;
	private Cuenta destino;
	private float cantidad;
	private boolean resultado;
	
	private Transferencia(Cuenta origen, Cuenta destino, float cantidad) {
		this.origen = origen;
		this.destino = destino;
		this.cantidad = cantidad;
		
	}
	
	public static Transferencia transferir(Cuenta origen, Cuenta destino, float cantidad) {
		
		float saldoInicialOrigen = origen.getSaldo();
				
		float saldoFinalOrigen;
		float saldoFinalDestino;
		
		Transferencia result = new Transferencia(origen, destino, cantidad);
		
		if(saldoInicialOrigen-cantidad >=0 && !origen.getId().equals(destino.getId())) {
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

	
	
	public boolean getResultado() {
		return resultado;
	}

	public void setResultado(boolean resultado) {
		this.resultado = resultado;
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
	
	
	
}

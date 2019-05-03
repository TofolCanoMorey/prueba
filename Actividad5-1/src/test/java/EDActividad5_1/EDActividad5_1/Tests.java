package EDActividad5_1.EDActividad5_1;

import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

	public Cliente cl1 = new Cliente("Tofol", "Cano Morey", "45610470k", "aquí", 123456789);
	public Cliente cl2 = new Cliente("Pep", "Montserrat Gonzalez", "41586478F", "allí", 987654321);
	public Cliente cl3 = new Cliente("n3", "as3", "dni3", "d3", 333333333);
	public Cliente cl4 = new Cliente("n4", "as4", "dni4", "d12", 444444444);
    
	public Banco b1 = new Banco("LaCaixa", "0049");
	public Banco b2 = new Banco("Santander", "0023");
	public Banco b3 = new Banco("BBVA", "0014");
    
	public Cuenta cu1 = new Cuenta("1111 2222 3333 4444", 0.5f, cl1, b1);
	public Cuenta cu2 = new Cuenta("1112 2223 3334 4444", 5000.42f, cl2, b2);
	public Cuenta cu3 = new Cuenta("2222 3333 4444 5555", 300f, cl2, b2);
	public Cuenta cu4 = new Cuenta("1234 5678 9012 3456", 70900f, cl3, b3);
	public Cuenta cu5 = new Cuenta("4321 8765 2109 6543", 57f, cl3, b1);
	public Cuenta cu6 = new Cuenta("4444 4444 4444 4444", 14f, cl4, b3);
	
	@Test
	public void comparaClientesIgualesDeDosCuentas() {
		assertEquals(cu2.getCliente(), cu3.getCliente());
	}
	
	@Test
	public void compruebaSaldoOrigenDespuesDeTransferenciaCorrecta() {
		float saldoInicial = cu4.getSaldo();
		float cantidad = 900f;
		Transferencia.transferir(cu4, cu2, cantidad);
		float saldoFinal = cu4.getSaldo();
		assertEquals(saldoFinal, saldoInicial - cantidad, 0);
	}
	
	@Test
	public void compruebaSaldoDestinoDespuesDeTransferenciaCorrecta() {
		float saldoInicial = cu6.getSaldo();
		float cantidad = 1000f;
		Transferencia.transferir(cu4, cu6, cantidad);
		float saldoFinal = cu6.getSaldo();
		assertEquals(saldoFinal, saldoInicial + cantidad, 0);
	}
	
	@Test
	public void conSaldoSuficiente() {
		float cantidad = 50f;
		Transferencia transferencia = Transferencia.transferir(cu5, cu6, cantidad);
		assertTrue(transferencia.getResultado());
	}
	
	@Test
	public void conSaldoInsuficiente() {
		float cantidad = 50f;
		Transferencia transferencia = Transferencia.transferir(cu1, cu6, cantidad);
		assertFalse(transferencia.getResultado());
	}
	
	@Test
	public void traspasoAOtraCuentaDelMismoClienteYBanco() {
		float cantidad = 80f;
		Traspaso traspaso = Traspaso.traspasar(cu2, cu3, cantidad);
		assertTrue(traspaso.getResultado());
	}
	
}

package Clases;

public class convertirDivisas {
	private double Moneda;
	
	
	
	public void convertir(String moneda) {
		Moneda = Double.parseDouble(moneda);
		Moneda = Moneda*1000;
	}
	public double getMoneda(){
		return this.Moneda;
	}
	

}

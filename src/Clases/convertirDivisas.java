package Clases;

public class convertirDivisas {
	private double Moneda;
	
	
	// Este seria un metodo get y set para convertir variables de tipo String a Double
	
	public void convertir(String moneda) {
		Moneda = Double.parseDouble(moneda);
		Moneda = Moneda*1000;
	}
	public double getMoneda(){
		return this.Moneda;
	}
	
	

}

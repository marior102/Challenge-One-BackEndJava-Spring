package Clases;


public class ConvertirDivisas {
	private double moneda;
	private double resultado;
	
	

	public ConvertirDivisas() {
		// Constructor vacío
	}

	public void convertirMoneda(String valorMoneda) {
		try {
			
			moneda = Double.parseDouble(valorMoneda);
			if(moneda < 10) {
				moneda = moneda *1000;
				
			}
		} catch (NumberFormatException e) {
			moneda = 0;
			System.out.println("El valor de la moneda debe ser numérico");
		}
	}
	public void calcularDivisio(double montoConvertir, double valor) {
		resultado= montoConvertir/valor;	
	}
	public void calcularMultiplicacion(double montoConvertir, double valor) {
		resultado = montoConvertir*valor;
		
	}

	// Renombrar el método para que tenga un nombre más descriptivo
	public double obtenerValorMoneda() {
		// Devolver el valor actual de la variable moneda
		
			return moneda;
		
			
			
		
	}
	
	public double getResultado() {
			return resultado;
		}
		
}
package modelo.longitud;


import interfaces.UnidadMedida;

public class Millas  implements UnidadMedida{
	private String nombre;
	 private double longitud;
	 private String simbolo;
	
		
	
	public Millas(String nombre, String simbolo) {
		this.nombre = nombre;
		this.simbolo= simbolo;

	}
	
	@Override
	public double conversorMutifuncional(String unidad) {
		double resultado = 0.0;
        switch(unidad.toLowerCase()) {
            case "kilometro":
                resultado = getLongitud() * 1609;
                simbolo = "km";
                break;
            case "metro":
                resultado = getLongitud() *1609;
                simbolo = "mts";
                break;
            case "pie":
                resultado = getLongitud() * 5280;
                break;
            case "yarda":
                resultado = getLongitud() * 1760;
                break;
            case "pulgada":
                resultado = getLongitud() * 63360;
                break;
            case "millas nauticas":
                resultado = getLongitud()/1.151;
                break;
            default:
                throw new IllegalArgumentException("Unidad desconocida: " + unidad);
        }
        return resultado;
	}

	@Override
	public String getSimbolo() {
		// TODO Auto-generated method stub
		return simbolo;
	}

	@Override
	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
		
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}

	@Override
	public void setNombre(String nombre) {
		this.nombre=nombre;// TODO Auto-generated method stub
		
	}

	@Override
	public double getLongitud() {
		// TODO Auto-generated method stub
		return longitud;
	}

	@Override
	public void setLongitud(double longitud) {
		this.longitud = longitud;// TODO Auto-generated method stub
		
	}
	
	@Override
	public String toString() {
		return nombre;
	}

}

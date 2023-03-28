package modelo.longitud;


import interfaces.UnidadMedida;

public class Pie   implements UnidadMedida{
	private String nombre;
	 private double longitud;
	 private String simbolo;
	
	public Pie( String nombre, String simbolo) {
		this.nombre = nombre;
		this.simbolo= simbolo;
	}

	@Override
	public double conversorMutifuncional(String unidad) {
		double resultado = 0.0;
        switch(unidad.toLowerCase()) {
            case "metro":
                resultado = getLongitud() / 3.281;
                simbolo = "mts";
                break;
            case "millas":
                resultado = getLongitud() /5820;
                simbolo = "mi";
                break;
            case "kilometro":
                resultado = getLongitud() / 3281;
                simbolo = "km";
                break;
            case "yarda":
                resultado = getLongitud() /3;
                simbolo = "yd";
                break;
            case "pulgada":
                resultado = getLongitud() * 12;
                simbolo = "in";
                break;
            case "millas nauticas":
                resultado = getLongitud()/6076;
                simbolo = "mn";
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

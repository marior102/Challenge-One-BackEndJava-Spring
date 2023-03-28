package modelo.longitud;


import interfaces.UnidadMedida;

public class Pulgada   implements UnidadMedida{
	private String nombre;
	 private double longitud;
	 private String simbolo;
	
	public Pulgada(String nombre,String simbolo) {
		this.nombre = nombre;
		this.simbolo= simbolo;
		// TODO Auto-generated constructor stub
	}
	@Override
	public double conversorMutifuncional(String unidad) {
		double resultado = 0.0;
        switch(unidad.toLowerCase()) {
            case "metro":
                resultado = getLongitud() / 39.7;
                simbolo = "mts";
                break;
            case "millas":
                resultado = getLongitud() /63360;
                simbolo = "mi";
                break;
            case "pie":
                resultado = getLongitud() /12;
                simbolo = "ft";
                break;
            case "yarda":
                resultado = getLongitud() / 36;
                simbolo = "yd";
                break;
            case "kilometro":
                resultado = getLongitud() / 39370;
                simbolo = "km";
                break;
            case "millas nauticas":
                resultado = getLongitud()/72910;
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

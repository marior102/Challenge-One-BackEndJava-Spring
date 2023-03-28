package modelo.longitud;

import java.util.HashMap;
import java.util.Map;

import interfaces.UnidadMedida;

public class Metro   implements UnidadMedida{
	private double resultado;
	private String nombre;
	 private double longitud;
	 private String simbolo;
	
	public double getResultado() {
		return resultado;
	}

	public Metro(String nombre, String simbolo) {
		this.nombre = nombre;
		this.simbolo= simbolo;
	}

	@Override
	public double conversorMutifuncional(String unidad) {
		
		Map<String, Double> conversiones = new HashMap<>();
	    conversiones.put("kilometro", 0.001);
	    conversiones.put("millas", 0.00062);
	    conversiones.put("pie", 3.28);
	    conversiones.put("yarda", 1.09);
	    conversiones.put("pulgada", 39.37);
	    conversiones.put("millas nauticas", 0.00054);

	    Double conversion = conversiones.get(unidad.toLowerCase());
	    if (conversion == null) {
	        throw new IllegalArgumentException("Unidad desconocida: " + unidad);
	    }

	    resultado = getLongitud() * conversion;
	    simbolo = unidad.substring(0, 2); // asumimos que la abreviación es las dos primeras letras
	    return resultado;
	/**	 resultado = 0.0;
        switch(unidad.toLowerCase()) {
            case "kilometro":
                resultado = getLongitud() / 1000;
                simbolo = "km";
                break;
            case "millas":
                resultado = getLongitud() /1609;
                simbolo = "mi";
                break;
            case "pie":
                resultado = getLongitud() * 3.281;
                simbolo = "ft";
                break;
            case "yarda":
                resultado = getLongitud() * 1.094;
                simbolo = "yd";
                break;
            case "pulgada":
                resultado = getLongitud() * 39.37;
                simbolo = "in";
                break;
            case "millas nauticas":
                resultado = getLongitud()/1852;
                simbolo = "mn";
                break;
            default:
                throw new IllegalArgumentException("Unidad desconocida: " + unidad);
        }
        return resultado;**/
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
	public String getSimbolo() {
		// TODO Auto-generated method stub
		return simbolo;
	}
	@Override
	public String toString() {
		return nombre;
	}
}



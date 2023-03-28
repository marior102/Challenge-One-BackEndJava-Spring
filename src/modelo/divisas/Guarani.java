package modelo.divisas;

import java.util.HashMap;
import java.util.Map;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import controlador.Utilidades;
import interfaces.Monedas;

public class Guarani  implements Monedas {
	private String compraDivisa;
	private String ventaDivisa;
	private String simboloDivisa;
	private double monto;
	private String nombreDivisa;
	private Icon icon;
	private boolean validar;
	private Map<String, String> tablaDivisa;
	
	public Guarani() {
		this.setNombreDivisa("Guarani");
		this.setSimboloDivisa("₲");
		this.setCompraDivisa("0");
		this.setVentaDivisa("0");
		this.setIcon((ImageIcon) Utilidades.setImage(new ImageIcon(getClass().getResource("/Imagenes/PYG.png")), 25));
		
	}
	public Guarani(String nombreDivisa, String simboloDivisa, String compra, String venta) {
		
		this.setNombreDivisa(nombreDivisa);
		this.setSimboloDivisa(simboloDivisa);
		this.setCompraDivisa(compra);
		this.setVentaDivisa(venta);
		this.setIcon((ImageIcon) Utilidades.setImage(new ImageIcon(getClass().getResource("/Imagenes/dollar.png")), 25));
		
		
		
		
	}
	public Guarani(String nombreDivisa, String simboloDivisa) {
			
			this.setNombreDivisa(nombreDivisa);
			this.setSimboloDivisa(simboloDivisa);
				
		}
	
	@Override
	public void setCompraDivisa(String compraDivisa) {
		this.compraDivisa = compraDivisa;
		
	}

	@Override
	public String getCompraDivisa() {
		
		return this.compraDivisa;
	}

	@Override
	public void setVentaDivisa(String ventaDivisa) {
		this.ventaDivisa = ventaDivisa;
		
	}

	@Override
	public String getVentaDivisa() {
		
		return this.ventaDivisa;
	}

	@Override
	public void setMonto(double monto) {
		this.monto = monto;
		
	}

	@Override
	public double getMonto() {
		return this.monto;
	}

	@Override
	public double conversorMutifuncional(String elemento) {
		double resultado = 0.0;
		Map<String, Map<String, String>> elementosMonedas = Utilidades.leerElementosMonedas();
		this.setTablaDivisa(elementosMonedas.get(elemento));
		double venta = Double.parseDouble(this.getVentaDivisa());
		double compra = Double.parseDouble(this.getCompraDivisa());
		if (venta < 10 && compra < 10) {
			venta = venta * 1000;
			compra = compra *1000;
		}
		Map<String, Double> conversiones = new HashMap<>();
	    conversiones.put("compra", compra);
	    conversiones.put("venta", venta);
		resultado = this.getMonto() / venta;
	    return resultado;
	}

	
	@Override
	public void setSimboloDivisa(String simboloDivisa) {
		this.simboloDivisa = simboloDivisa;
		
	}

	@Override
	public String getSimboloDivisa() {
		
		return this.simboloDivisa;
	}

	@Override
	public void setNombreDivisa(String nombreDivisa) {
		this.nombreDivisa = nombreDivisa;
		
	}

	@Override
	public String getNombreDivisa() {
		// TODO Auto-generated method stub
		return this.nombreDivisa;
	}

	@Override
	public String toString() {
		
		return nombreDivisa;
		//return nombreDivisa + " (" + simboloDivisa + ")";
	}
	public void setIcon(Icon icon) {
		this.icon= icon;
		
	}
	@Override
	public Icon getIcon() {
		// TODO Auto-generated method stub
		return this.icon;
	}
	@Override
	public double convertirDivisasSinConexion(String divisas) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void setVerificarConexion(boolean validar) {
		this.validar= validar;
		
	}
	@Override
	public boolean getVerificarConexion() {
		
		return this.validar;
	}
	@Override
	public void setTablaDivisa(Map<String, String> tablaDivisa) {
		this.tablaDivisa = tablaDivisa;
        this.setNombreDivisa(tablaDivisa.get("Nombre"));
        this.setSimboloDivisa(tablaDivisa.get("Símbolo"));
        this.setCompraDivisa(tablaDivisa.get("Compra"));
        this.setVentaDivisa(tablaDivisa.get("Venta"));
		
	}
	@Override
	public Map<String, String> getTablaDivisa() {
	
        
        return tablaDivisa;
	}
	
}

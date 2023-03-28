package modelo.divisas;

import java.util.HashMap;
import java.util.Map;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import controlador.CapturarCotizacionMonedas;
import controlador.Utilidades;
import interfaces.Monedas;

public class YenJapones  implements Monedas {
	private String compraDivisa;
	private String ventaDivisa;
	private String simboloDivisa;
	private double monto;
	private String nombreDivisa;
	private boolean validar;
	private CapturarCotizacionMonedas obtenerCotizacion;
	
	private String url = "#exchange-jpy";
	private Icon icon;
	private Map<String, String> tablaDivisa;
	
	public YenJapones() {
		this.setNombreDivisa("Yen Japones");
		this.setSimboloDivisa("¥");
		obtenerCotizacion = new CapturarCotizacionMonedas(url);
		this.setCompraDivisa( obtenerCotizacion.getCompra());
		this.setVentaDivisa(obtenerCotizacion.getVenta());
		this.setIcon((ImageIcon) Utilidades.setImage(new ImageIcon(getClass().getResource("/Imagenes/JPY.png")), 25));
		
	}
	public YenJapones(String nombreDivisa, String simboloDivisa, String compra, String venta) {
		
		this.setNombreDivisa(nombreDivisa);
		this.setSimboloDivisa(simboloDivisa);
		this.setCompraDivisa(compra);
		this.setVentaDivisa(venta);
		this.setIcon((ImageIcon) Utilidades.setImage(new ImageIcon(getClass().getResource("/Imagenes/JPY.png")), 25));
		
		
		
		
	}
	public YenJapones(String nombreDivisa, String simboloDivisa) {
		
		this.setNombreDivisa(nombreDivisa);
		this.setSimboloDivisa(simboloDivisa);
		obtenerCotizacion = new CapturarCotizacionMonedas(url);
		this.setCompraDivisa( obtenerCotizacion.getCompra());
		this.setVentaDivisa(obtenerCotizacion.getVenta());
		
		
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
		double compra = Double.parseDouble(this.getCompraDivisa());
		double venta = Double.parseDouble(this.getVentaDivisa());
		if(compra < 10   && venta < 10) {
			compra = compra *1000;
			venta = venta *1000;
		}
		String tipoCambio = "compra";
		Map<String, Double> conversiones = new HashMap<>();
	    conversiones.put("compra", compra);
	    conversiones.put("venta", venta);
	    Double conversion = conversiones.get(tipoCambio.toLowerCase());
	    if (conversion == null) {
	        throw new IllegalArgumentException("Unidad desconocida: " + elemento);
	    }

	    double resultado = getMonto() * conversion ;
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
		 return nombreDivisa ;
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

package interfaces;

import java.util.Map;

import javax.swing.Icon;

public interface Monedas extends ElementoConvertible{
	void setNombreDivisa(String nombreDivisa);
	String getNombreDivisa();
	void setCompraDivisa(String compraDivisa);
	String getCompraDivisa();
	void setVentaDivisa(String compraVenta);
	String getVentaDivisa();
	void setMonto(double monto);
	double getMonto();
	void setVerificarConexion(boolean validar);
	boolean getVerificarConexion();
	void setSimboloDivisa(String simboloDivisa);
	String getSimboloDivisa();
	void setIcon(Icon icon);
	Icon getIcon();
	double convertirDivisasSinConexion(String divisas);
	void setTablaDivisa(Map<String, String> tablaDivisa);
	Map<String, String> getTablaDivisa();

}

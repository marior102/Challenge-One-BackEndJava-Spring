package Scrap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Dolar {
	private static String Compra;
	private static String Venta;
	public static String guardarCompra;
	public static String guardarVenta;
	public static String Fecha;

	public static Document getHTML(String url) {
		Document html = null;
		try {

			html = Jsoup.connect(url).get();

		} catch (Exception e) {
			System.out.println("Error al obtener el codigo HTML");
		}
		return html;
	}

	public static void setExraerDatos(String url1, String url2) {
		// obtine los articlos de la pagina
		Elements divisa = Dolar.getHTML(url1).select(url2);
		try {
			Compra = divisa.select("span.purchase").text();
			Venta = divisa.select("span.sale").text();
			//System.out.println("Dolar compra esta: " + Compra);
			//System.out.println("Dolar compra esta: " + Venta);

		} catch (Exception e) {
			System.out.println("Error al entrar en la notica");
		}
		}
	public String getCompra() {
		return Compra;
	}
	public String GetVenta() {
		return Venta;
	}
	
	// Aca traemos ese dato
	public void SetGuardarCompra(String guardarCom) {
		guardarCompra = guardarCom;
		
	}
	public void SetGuardarVenta(String guardarVen) {
		guardarVenta = guardarVen;
	}
	//y con metodo get guardamos para poder utilizarlo
	
	public String getguardarCompra() {
		return guardarCompra;
	}
	public String getguardarVenta() {
		return guardarVenta;
	}
	public void setGuardarFecha(String fech) {
		Fecha = fech;
	}
	public String getGuardarFecha() {
		return Fecha;
	}
}

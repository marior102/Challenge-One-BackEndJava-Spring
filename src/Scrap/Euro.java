package Scrap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Euro {
	public static String Compra;
	public static String Venta;
	public static String guardarCompra;
	public static String guardarVenta;
	
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
		Elements divisa = Euro.getHTML(url1).select(url2);
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
	public void SetGuardarCompra(String guardarCom) {
		guardarCompra = guardarCom;
	}
	public void SetGuardarVenta(String guardarVen) {
		guardarVenta = guardarVen;
	}
	public String getguardarCompra() {
		return guardarCompra;
	}
	public String getguardarVenta() {
		return guardarVenta;
	}

}


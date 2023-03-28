package controlador;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class CapturarCotizacionMonedas {
	private String compra;
	private String venta;
	private boolean conectar;
	private Document html;
	private String BASE_URL = "https://www.cambioschaco.com.py/"; 
	
	public CapturarCotizacionMonedas( String url2) {
        html = obtenerDatosHTML(BASE_URL);

        if (html != null) {
            Elements divisa = html.select(url2);
            this.compra = divisa.select("span.purchase").text();
            this.venta = divisa.select("span.sale").text();
            this.conectar = true;
        } else {
            this.conectar = false;
        }
    }
	
	  private Document obtenerDatosHTML(String url) {
	        Document html;

	        try {
	            html = Jsoup.connect(url).get();
	        } catch (Exception e) {
	            System.err.println("Error al conectar con la URL: " + e.getMessage());
	            return null;
	        }

	        return html;
	    }



	public Document getHtml() {
		return html;
	}

	public String getCompra() {
		return compra;
	}

	public String getVenta() {
		return venta;
	}

	public boolean isConectar() {
		return conectar;
	}

}

package Clases;



public class MonedasGuardadas {
	private String dolarCompra;
	private String dolarVenta;
	private String euroCompra;
	private String euroVenta;
	private String libraCompra;
	private String libraVenta;
	private String yenCompra;
	private String yenVenta;
	private String realCompra;
	private String realVenta;
	private String fecha;
	

	

	public  MonedasGuardadas(String dolarCompra, String dolarVenta, String euroCompra, String euroVenta,
			String libraCompra, String libraVenta, String yenCompra, String yenVenta, String realCompra,
			String realVenta, String fecha) {
		this.dolarCompra = dolarCompra;
		this.dolarVenta = dolarVenta;
		this.euroCompra = euroCompra;
		this.euroVenta = euroVenta;
		this.libraCompra = libraVenta;
		this.libraVenta = libraVenta;
		this.yenCompra = yenCompra;
		this.yenVenta = yenVenta;
		this.realCompra = realCompra;
		this.realVenta = realVenta;
		this.fecha = fecha;
		

	}
	

	public String getDolarCompra() {
		return dolarCompra;
	}


	public String getDolarVenta() {
		return dolarVenta;
	}


	public String getEuroCompra() {
		return euroCompra;
	}


	public String getEuroVenta() {
		return euroVenta;
	}


	public String getLibraCompra() {
		return libraCompra;
	}


	public String getLibraVenta() {
		return libraVenta;
	}


	public String getYenCompra() {
		return yenCompra;
	}

	

	public String getYenVenta() {
		return yenVenta;
	}

	
	public String getRealCompra() {
		return realCompra;
	}


	public String getRealVenta() {
		return realVenta;
	}

	public String getFecha() {
		return fecha;
	}

	

}

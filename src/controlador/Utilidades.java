package controlador;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import interfaces.Monedas;
import interfaces.UnidadMedida;
import modelo.divisas.Dolar;
import modelo.divisas.Euro;
import modelo.divisas.Guarani;
import modelo.divisas.Libra;
import modelo.divisas.RealBrasil;
import modelo.divisas.YenJapones;
import modelo.longitud.Kilometro;
import modelo.longitud.Metro;
import modelo.longitud.Millas;
import modelo.longitud.MillasNauticas;
import modelo.longitud.Pie;
import modelo.longitud.Pulgada;
import modelo.longitud.Yarda;

public class Utilidades {
	public static final Color COLOR_BLUE = new Color(0, 75, 255);
	public static final Color COLOR_LIGHTGREY = new Color(236, 236, 236);
	public static final Color COLOR_GREY = new Color(80, 80, 80);
	public static final Font PRIMARY_SEGOE = new Font("Segoe UI", Font.BOLD, 14);
	public static final Font SECOND_SEGOE = new Font("Segoe UI", Font.PLAIN, 14);

	public static Icon setImage(ImageIcon imageIcon, int size) {
		Icon icon = new ImageIcon(imageIcon.getImage().getScaledInstance(size, size, Image.SCALE_DEFAULT));
		return icon;
	}

	public static final ArrayList<UnidadMedida> UNIDADES = new ArrayList<>(List.of(new Metro("Metro", "mts"),
			new Kilometro("Kilometro", "km"), new Millas("Millas", "mi"), new Yarda("Yarda", "yd"),
			new Pie("Pie", "ft"), new Pulgada("Pulgada", "in"), new MillasNauticas("Millas Nauticas", "nm")

	));

	public static final Map<Monedas, String> DIVISAS_CARGAR_COMBOBOX = new HashMap<Monedas, String>() {
		/**
		* 
		*/
		private static final long serialVersionUID = 1L;
		{
			put(new Dolar("Dolar", "$"), "USD");
			put(new Euro("Euro", "€"), "EUR");
			put(new Libra("Libra", "£"), "GBP");
			put(new YenJapones("Yen Japones", "¥"), "JPY");
			put(new RealBrasil("Real Brasil", "R$"), "BRL");
			put(new Guarani("Guarani", "₲"), "PYG");
		}
	};
	public static boolean validarCampos(String text){
        if (!validateText(text)){
            return false;
        } 
        return true;
    }
  	private static boolean validateText(String text){
       try{
           Double.parseDouble(text);
           return true;
       }catch (NumberFormatException | NullPointerException e){
           e.printStackTrace();
           return false;
       }
   }

	public static ArrayList<Monedas> cargarArrayList() {
		ArrayList<Monedas> monedasList = new ArrayList<>();
		monedasList = new ArrayList<>();

		if (Utilidades.verificarConexionInternet()) {
			monedasList.add(new Dolar());
			monedasList.add(new Euro());
			monedasList.add(new Libra());
			monedasList.add(new YenJapones());
			monedasList.add(new RealBrasil());
			monedasList.add(new Guarani());

		} else {
			Map<String, Map<String, String>>  elementosMonedasMap = leerElementosMonedas();
			Map<String, String> mapaEuro = elementosMonedasMap.get("Euro");
			Map<String, String> mapaDolar = elementosMonedasMap.get("Dolar");
			Map<String, String> mapaLibra = elementosMonedasMap.get("Libra");
			Map<String, String> mapaYenJapones = elementosMonedasMap.get("Yen Japones");
			Map<String, String> mapaReal = elementosMonedasMap.get("Real Brasil");
			Map<String, String> mapaGuarani = elementosMonedasMap.get("Guarani");
			monedasList.add(new Dolar(mapaDolar.get("Nombre"), mapaDolar.get("Simbolo"), mapaDolar.get("Compra"), mapaDolar.get("Venta")));
	        monedasList.add(new Euro(mapaEuro.get("Nombre"), mapaEuro.get("Simbolo"), mapaEuro.get("Compra"), mapaEuro.get("Venta")));
	        monedasList.add(new Libra(mapaLibra.get("Nombre"), mapaLibra.get("Simbolo"), mapaLibra.get("Compra"), mapaLibra.get("Venta")));
	        monedasList.add(new YenJapones(mapaYenJapones.get("Nombre"), mapaYenJapones.get("Simbolo"), mapaYenJapones.get("Compra"), mapaYenJapones.get("Venta")));
	        monedasList.add(new RealBrasil(mapaReal.get("Nombre"), mapaReal.get("Simbolo"), mapaReal.get("Compra"), mapaReal.get("Venta")));
	        monedasList.add(new Guarani(mapaGuarani.get("Nombre"), mapaGuarani.get("Simbolo"), mapaGuarani.get("Compra"), mapaGuarani.get("Venta")));
		}

		return monedasList;
	}
	public static ArrayList<Monedas> cargarTabla() {
		ArrayList<Monedas> monedasList = new ArrayList<>();
		monedasList = new ArrayList<>();

		if (Utilidades.verificarConexionInternet()) {
			monedasList.add(new Dolar());
			monedasList.add(new Euro());
			monedasList.add(new Libra());
			monedasList.add(new YenJapones());
			monedasList.add(new RealBrasil());
			

		} else {
			Map<String, Map<String, String>>  elementosMonedasMap = leerElementosMonedas();
			Map<String, String> mapaEuro = elementosMonedasMap.get("Euro");
			Map<String, String> mapaDolar = elementosMonedasMap.get("Dolar");
			Map<String, String> mapaLibra = elementosMonedasMap.get("Libra");
			Map<String, String> mapaYenJapones = elementosMonedasMap.get("Yen Japones");
			Map<String, String> mapaReal = elementosMonedasMap.get("Real Brasil");
			monedasList.add(new Dolar(mapaDolar.get("Nombre"), mapaDolar.get("Simbolo"), mapaDolar.get("Compra"), mapaDolar.get("Venta")));
	        monedasList.add(new Euro(mapaEuro.get("Nombre"), mapaEuro.get("Simbolo"), mapaEuro.get("Compra"), mapaEuro.get("Venta")));
	        monedasList.add(new Libra(mapaLibra.get("Nombre"), mapaLibra.get("Simbolo"), mapaLibra.get("Compra"), mapaLibra.get("Venta")));
	        monedasList.add(new YenJapones(mapaYenJapones.get("Nombre"), mapaYenJapones.get("Simbolo"), mapaYenJapones.get("Compra"), mapaYenJapones.get("Venta")));
	        monedasList.add(new RealBrasil(mapaReal.get("Nombre"), mapaReal.get("Simbolo"), mapaReal.get("Compra"), mapaReal.get("Venta")));
	       
		}

		return monedasList;
	}

	public static Map<String, Map<String, String>> obtenerElementosMonedas() {
		ArrayList<Monedas> monedasList = cargarArrayList();
		DefaultTableModel modeloTabla = new DefaultTableModel();
		Object[] encabezados = { "Nombre", "Simbolo", "Compra", "Venta", "Icono" };
		modeloTabla.setColumnIdentifiers(encabezados);

		for (Monedas moneda : monedasList) {
			Object[] fila = new Object[5];
			fila[0] = moneda.getNombreDivisa();
			fila[1] = moneda.getSimboloDivisa();
			fila[2] = moneda.getCompraDivisa();
			fila[3] = moneda.getVentaDivisa();
			fila[4] = moneda.getIcon();
			modeloTabla.addRow(fila);
		}

		Map<String, Map<String, String>> elementosMonedas = new HashMap<>();
		Map<String, String> elementoMoneda;
		for (int i = 0; i < modeloTabla.getRowCount(); i++) {
			elementoMoneda = new HashMap<>();
			String nombreDivisa = (String) modeloTabla.getValueAt(i, 0);
			for (int j = 0; j < modeloTabla.getColumnCount(); j++) {
				elementoMoneda.put((String) encabezados[j], modeloTabla.getValueAt(i, j).toString());
			}
			elementosMonedas.put(nombreDivisa, convertirAString(elementoMoneda));
		}

		return elementosMonedas;
	}

	public static Map<String, List<HashMap<String, String>>> getTablasDivisas(List<Monedas> monedasList) {
		Map<String, List<HashMap<String, String>>> tablasDivisas = new HashMap<>();

		for (Monedas moneda : monedasList) {
			List<HashMap<String, String>> tablaDivisa = new ArrayList<>();
			tablaDivisa.add((HashMap<String, String>) moneda.getTablaDivisa());
			tablasDivisas.put(moneda.getNombreDivisa(), tablaDivisa);
		}

		return tablasDivisas;
	}

	public static String convertirIconoAString(Icon icon) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			ImageIO.write((RenderedImage) ((ImageIcon) icon).getImage(), "png", bos);
			byte[] bytes = bos.toByteArray();
			return Base64.getEncoder().encodeToString(bytes);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static ImageIcon convertirStringAIcono(String iconoCodificado) {
		try {
			byte[] bytesIcono = Base64.getDecoder().decode(iconoCodificado);
			ByteArrayInputStream bais = new ByteArrayInputStream(bytesIcono);
			BufferedImage imagen = ImageIO.read(bais);
			return new ImageIcon(imagen);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Map<String, String> convertirAString(Map<String, String> valoresFila) {
		Map<String, String> valoresFilaString = new HashMap<>();
		for (Map.Entry<String, String> entry : valoresFila.entrySet()) {
			valoresFilaString.put(entry.getKey(), entry.getValue().toString());
		}
		return valoresFilaString;
	}

	public static String convertirAString2(Map<String, String> valoresFila) {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, String> entry : valoresFila.entrySet()) {
			sb.append(entry.getKey()).append(": ").append(entry.getValue()).append(", ");
		}
		// Eliminar la coma y el espacio adicionales al final de la cadena
		sb.setLength(sb.length() - 2);
		return sb.toString();
	}
	public static Map<String, Map<String, String>> leerElementosMonedas() {
	    Map<String, Map<String, String>> elementosMonedas = new HashMap<>();
	    Map<String, String> elementoMoneda = new HashMap<>();

	    try {
	        BufferedReader br = new BufferedReader(new FileReader("elementosMonedas.txt"));
	        String linea;

	        while ((linea = br.readLine()) != null) {
	            // Ignorar líneas vacías
	            if (linea.trim().isEmpty()) {
	                continue;
	            }

	            // Analizar la línea utilizando expresiones regulares
	            Pattern patron = Pattern.compile("Nombre: (.*) Icono: (.*) Simbolo: (.*) Venta: (.*) Compra: (.*) Fecha Registro (.*)");
	            java.util.regex.Matcher matcher = patron.matcher(linea);
	            if (matcher.matches()) {
	                // Extraer los datos de la línea y agregarlos al mapa
	                String nombre = matcher.group(1);
	                String icono = matcher.group(2);
	                String simbolo = matcher.group(3);
	                String venta = matcher.group(4);
	                String compra = matcher.group(5);
	                String fecha = matcher.group(6);

	                elementoMoneda.put("Nombre", nombre);
	                elementoMoneda.put("Icono", icono);
	                elementoMoneda.put("Simbolo", simbolo);
	                elementoMoneda.put("Venta", venta);
	                elementoMoneda.put("Compra", compra);
	                elementoMoneda.put("Fecha Registro", fecha);

	                elementosMonedas.put(nombre, elementoMoneda);
	                elementoMoneda = new HashMap<>();
	            } else {
	                // La línea no coincide con el patrón esperado, imprimir un error
	                System.err.println("Error: Formato inválido en línea: " + linea);
	            }
	        }

	        br.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return elementosMonedas;
	}
	public static String convertirAString3(Map<String, String> valoresFila) {
	    // Agregar las claves requeridas si no están presentes en el mapa
	    if (!valoresFila.containsKey("Nombre")) {
	        valoresFila.put("Nombre", "");
	    }
	    if (!valoresFila.containsKey("Símbolo")) {
	        valoresFila.put("Símbolo", "");
	    }
	    if (!valoresFila.containsKey("Compra")) {
	        valoresFila.put("Compra", "");
	    }
	    if (!valoresFila.containsKey("Venta")) {
	        valoresFila.put("Venta", "");
	    }

	    // Crear la cadena de caracteres
	    StringBuilder sb = new StringBuilder();
	    for (Map.Entry<String, String> entry : valoresFila.entrySet()) {
	        sb.append(entry.getKey()).append(": ").append(entry.getValue()).append(", ");
	    }
	    // Eliminar la coma y el espacio adicionales al final de la cadena
	    sb.setLength(sb.length() - 2);
	    return sb.toString();
	}

	public static void setTextoAjustado(JLabel jLabel, String texto, Color color) {
		FontMetrics metrics = jLabel.getFontMetrics(jLabel.getFont());
		int anchoTexto = metrics.stringWidth(texto);
		int anchoDisponible = jLabel.getWidth();
		if (anchoTexto > anchoDisponible)
			jLabel.setFont(ajustarFuente(jLabel.getFont(), anchoTexto, anchoDisponible));

		jLabel.setText(texto);
		jLabel.setForeground(color);
	}

	private static Font ajustarFuente(Font fuenteActual, int anchoTexto, int anchoDisponible) {
		int tamanoFuente = fuenteActual.getSize();
		int nuevoTamano = (int) (tamanoFuente * ((double) anchoDisponible / (double) anchoTexto));
		return fuenteActual.deriveFont((float) nuevoTamano);
	}

	public static void cleanTextFields(JTextField jTextField) {
		if (jTextField.getText().equals("Ingrese un valor"))
			jTextField.setText("");
	}

	public static void setTextIfEmpty(JTextField jTextField) {
		if (jTextField.getText().isEmpty()) {
			jTextField.setText("Ingrese un valor");
			jTextField.setForeground(Utilidades.COLOR_LIGHTGREY);
		}
	}

	public static boolean verificarConexionInternet() {
		boolean hayConexion = true; // variable para guardar si hay conexión a internet o no
		try {
			// Intentamos hacer una conexión a una URL cualquiera
			URL url = new URL("https://www.cambioschaco.com.py/");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.connect();
			con.disconnect();
		} catch (IOException e) {
			// Si hay una excepción, no hay conexión a internet
			hayConexion = false;
		}
		return hayConexion;
	}

}

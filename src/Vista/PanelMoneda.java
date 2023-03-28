
package Vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.awt.Color;
import java.awt.Desktop;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import controlador.EncabezadoTabla;
import controlador.Fecha;
import controlador.ColocarImagenATabla;
import controlador.Utilidades;
import interfaces.Monedas;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.JEditorPane;
import javax.swing.event.HyperlinkListener;
import javax.swing.event.HyperlinkEvent;

/**
 *
 * @author Mario Rodriguez
 */
public class PanelMoneda extends javax.swing.JPanel {

	public PanelMoneda() {
		initComponents();
		cargarComboBox();
		actualizartablaCotizaciones();
		listener();

	}
	private void listener() {
		itemListener();
		cargarIconos();
		actionListener();
		keyListener();
		mouseListener();
	}
	private void actualizartablaCotizaciones() {
		List<Monedas> monedasList = Utilidades.cargarTabla();
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
		Map<String, String> elementoMoneda;
		Map<String, Map<String, String>> elementosMonedas = new HashMap<>();

		for (int i = 0; i < modeloTabla.getRowCount(); i++) {
		    elementoMoneda = new HashMap<>();
		    String nombreDivisa = (String) modeloTabla.getValueAt(i, 0);
		    for (int j = 0; j < modeloTabla.getColumnCount(); j++) {
		        elementoMoneda.put((String) encabezados[j], modeloTabla.getValueAt(i, j).toString());
		    }
		    elementosMonedas.put(nombreDivisa, Utilidades.convertirAString(elementoMoneda));
		}
		tableCotizaciones.setModel(modeloTabla);

		tableCotizaciones.getColumnModel().getColumn(4).setCellRenderer(new ColocarImagenATabla());

		ajustarTabla();
		

	}
	
	public void ajustarTabla() {
		tableCotizaciones.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
		for (int i = 0; i < tableCotizaciones.getColumnCount(); i++) {
			tableCotizaciones.getColumnModel().getColumn(i).setPreferredWidth(50); 
			tableCotizaciones.getColumnModel().getColumn(i).setMinWidth(50); 
			tableCotizaciones.getColumnModel().getColumn(i).setMaxWidth(200);
			tableCotizaciones.getColumnModel().getColumn(i).setResizable(true); 
		}
		tableCotizaciones.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN); 
		tableCotizaciones.setRowHeight(50); 
		tableCotizaciones.setFillsViewportHeight(true);
		EncabezadoTabla header = new EncabezadoTabla(tableCotizaciones.getColumnModel());
		tableCotizaciones.setTableHeader(header);
		tableCotizaciones.setFocusable(false);
		tableCotizaciones.setEnabled(false);
		
		// Ajustar la altura de la fila automáticamente
	}


	
	public void cargarComboBox() {

		
		
		Utilidades.DIVISAS_CARGAR_COMBOBOX.keySet().forEach(deDivisaComboBox::addItem);
		deDivisaComboBox.getSelectedIndex();
	}
	private void cargarIconos() {
		lblflecha.setIcon((ImageIcon) Utilidades
				.setImage(new ImageIcon(getClass().getResource("/Imagenes/flecha-derecha.png")), 35));
		// Cargamos Iconos a los botones
		btnLimpiar.setIcon(
				(ImageIcon) Utilidades.setImage(new ImageIcon(getClass().getResource("/Imagenes/clean.png")), 35));
		btnConvertir.setIcon((ImageIcon) Utilidades
				.setImage(new ImageIcon(getClass().getResource("/Imagenes/icons8-moneda-64-2.png")), 60));
		btnGuardarDatos.setIcon(
				(ImageIcon) Utilidades.setImage(new ImageIcon(getClass().getResource("/Imagenes/Save.png")), 35));

	}

	private void keyListener() {
		txtMonto.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				btnConvertir.setIcon((ImageIcon) Utilidades.setImage(new ImageIcon(getClass().getResource("/Imagenes/icons8-moneda-64.png")), 60));
				char c = (char) e.getKeyChar();
				if (!Character.isDigit(c) && c != '.') {
					e.consume();

				}
				if (c == '.' && txtMonto.getText().contains(".")) {
					e.consume();
					JOptionPane.showMessageDialog(null, "No se puede agregar dos puntos decimales a un numero");

				}

			}
		});

	}
	private void mouseListener() {
		deDivisaComboBox.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnConvertir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnConvertir.setIcon((ImageIcon) Utilidades.setImage(new ImageIcon(getClass().getResource("/Imagenes/icons8-moneda-64.png")), 60));
			}
			public void mouseExited(MouseEvent e) {
				btnConvertir.setIcon((ImageIcon) Utilidades.setImage(new ImageIcon(getClass().getResource("/Imagenes/icons8-moneda-64-2.png")), 60));
			}
			
		});
		btnGuardarDatos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnGuardarDatos.setIcon(
						(ImageIcon) Utilidades.setImage(new ImageIcon(getClass().getResource("/Imagenes/save2.png")), 45));
				btnGuardarDatos.setBackground(Color.green);
			}
			public void mouseExited(MouseEvent e) {
				btnGuardarDatos.setIcon(
						(ImageIcon) Utilidades.setImage(new ImageIcon(getClass().getResource("/Imagenes/save.png")), 35));
				btnGuardarDatos.setBackground(Color.WHITE);
			}
			
		});
		
	}

	private void actionListener() {
		// Evento Performed del boton Convertir
		btnConvertir.addActionListener(e -> {
			if (txtMonto.getText().length() != 0) {
				double monto = Double.parseDouble(txtMonto.getText());
				if (monto > 0) {
					calcularDivisa2();
				} else {
					JOptionPane.showMessageDialog(null, "Ingrese valores mayores a 0");
					limpiar();
				}
			} else {
				JOptionPane.showMessageDialog(null, "No se puede calcular porque el monto esta vacio");
				limpiar();
			}
		});
		// Evento performed del boton Limpiar
		btnLimpiar.addActionListener(e -> {
			limpiar();
			txtMonto.requestFocus();
		});
		// Evento Performed de la caja de texto Monto
			txtMonto.addActionListener(e -> {
			btnConvertir.requestFocus();
			btnConvertir.doClick();
		});
		// Evento Performed del boton guardar Datos
		btnGuardarDatos.addActionListener(e -> {
			guardarElementosMonedas(Utilidades.obtenerElementosMonedas());
			btnGuardarDatos.setText("Ya se guardo la cotizacion");
			btnGuardarDatos.setEnabled(false);
		});
	}

	private void itemListener() {
		deDivisaComboBox.addItemListener(e -> {
			String dDivisa = deDivisaComboBox.getSelectedItem().toString();
			if (dDivisa.equals("Guarani")) {
				List<Monedas> listaMonedas = Utilidades.DIVISAS_CARGAR_COMBOBOX.keySet().stream()
		                .filter(Monedas -> !Monedas.getNombreDivisa().equals("Guarani"))
		                .collect(Collectors.toList());
				aDivisaComboBox.setModel(new DefaultComboBoxModel<>(listaMonedas.toArray(new Monedas[0])));
				aDivisaComboBox.setEnabled(true);
				aDivisaComboBox.requestFocus();
			} else {
				List<Monedas> listaMonedas = Utilidades.DIVISAS_CARGAR_COMBOBOX.keySet().stream()
		                .filter(Monedas -> !Monedas.getNombreDivisa().equals("Dolar"))
		                .filter(Monedas -> !Monedas.getNombreDivisa().equals("Libra"))
		                .filter(Monedas -> !Monedas.getNombreDivisa().equals("Yen Japones"))
		                .filter(Monedas -> !Monedas.getNombreDivisa().equals("Real Brasil"))
		                .filter(Monedas -> !Monedas.getNombreDivisa().equals("Euro"))
		                .collect(Collectors.toList());
				aDivisaComboBox.setModel(new DefaultComboBoxModel<>(listaMonedas.toArray(new Monedas[0])));
				aDivisaComboBox.setEnabled(true);
				aDivisaComboBox.requestFocus();
				aDivisaComboBox.setEnabled(false);
				txtMonto.requestFocus();	
			}	
		});
		aDivisaComboBox.addItemListener(e -> {
			txtMonto.requestFocus();

		});
	}

	private void calcularDivisa2() {
   	 String cantidad = txtMonto.getText().replace(",", ".");
   	    if(Utilidades.validarCampos(cantidad)) {
   	    	Map<String, Map<String, String>>  elementosMonedasMap = Utilidades.leerElementosMonedas();
   	    	String toUnidad = aDivisaComboBox.getSelectedItem().toString();
   	    	String aUnidad = deDivisaComboBox.getSelectedItem().toString();
   	    	Map<String, String> mapaADivisa = elementosMonedasMap.get(toUnidad);
   	        Monedas divisaMonto =  (Monedas) deDivisaComboBox.getSelectedItem();
   	        Objects.requireNonNull(divisaMonto).setMonto(Double.parseDouble(cantidad));
   	        Objects.requireNonNull(divisaMonto).setVerificarConexion(verificarConexion);
   	        Map<String, Map<String, String>> setTabla = Utilidades.obtenerElementosMonedas();
   	        Objects.requireNonNull(divisaMonto).setTablaDivisa(setTabla.get(aUnidad));
   	        String simbolo = mapaADivisa.get("Simbolo");
   	        double valor = divisaMonto.conversorMutifuncional(toUnidad);   	        
   	        DecimalFormat formatea = new DecimalFormat("###,###.##");
   	        txtResultado.setText(String.valueOf(formatea.format(valor)) + " " + simbolo);
   	    }
	}
   	 
	private void limpiar() {
		txtMonto.setText("");

		txtResultado.setText("");

	}

	private void guardarElementosMonedas(Map<String, Map<String, String>> elementosMonedas) {
	    try {
	        FileWriter archivo = new FileWriter("elementosMonedas.txt");
	        String idRegistro = Fecha.getFecha() + " : " + Fecha.getHora();
           
	        for (String nombreDivisa : elementosMonedas.keySet()) {
	        	
	            Map<String, String> elementoMoneda = elementosMonedas.get(nombreDivisa);
	            for (String encabezado : elementoMoneda.keySet()) {
	                String valor = elementoMoneda.get(encabezado);
	                archivo.write(encabezado + ": " + valor+ " " );
	                
	            }
	            archivo.write("Fecha Registro "+idRegistro+ " \n" );
	        }
	        archivo.close();
	        JOptionPane.showMessageDialog(null, "Datos guardados con éxito.");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	private void initComponents() {

		setBackground(new java.awt.Color(255, 255, 255));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowWeights = new double[] { 1.0 };
		gridBagLayout.columnWeights = new double[] { 1.0 };
		setLayout(gridBagLayout);

		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
		GridBagConstraints gbc_contentPane = new GridBagConstraints();
		gbc_contentPane.fill = GridBagConstraints.BOTH;
		gbc_contentPane.gridx = 0;
		gbc_contentPane.gridy = 0;
		add(contentPane, gbc_contentPane);

		panelConversor = new JPanel();
		panelConversor.setLayout(null);
		panelConversor.setBackground(new Color(204, 255, 204));
		panelConversor.setBounds(297, 59, 353, 332);
		contentPane.add(panelConversor);
			btnConvertir = new JButton();
			
			btnConvertir.setBorder(null);
			btnConvertir.setBackground(new Color(204, 255, 204));
			btnConvertir.setBounds(244, 197, 60, 60);
			btnConvertir.setFocusPainted(false);
			btnConvertir.setContentAreaFilled(false);
			//
			panelConversor.add(btnConvertir);
			txtMonto = new JTextField();
			txtMonto.addFocusListener( new FocusListener() {
			    
			    public void focusGained(FocusEvent e) {
			        if (txtMonto.getText().equals("Introduce el valor")) {
			            txtMonto.setText("");
			            txtMonto.setForeground(Color.BLACK);
			        }
			    }

			 
			    public void focusLost(FocusEvent e) {
			        if (txtMonto.getText().isEmpty()) {
			            txtMonto.setForeground(Color.LIGHT_GRAY);
			            txtMonto.setText("Introduce el valor");
			        }
			    }
			});

			txtMonto.setColumns(10);
			txtMonto.setBounds(0, 197, 234, 60);
			panelConversor.add(txtMonto);
			//
			lblResultado = new JLabel("RESULTADO\r\n");
			lblResultado.setFont(new Font("Roboto", Font.BOLD, 14));
			lblResultado.setBounds(0, 255, 353, 28);
			panelConversor.add(lblResultado);	
			//
			lbltengo = new JLabel("De");
			lbltengo.setFont(new Font("Roboto", Font.BOLD, 14));
			lbltengo.setBounds(53, 70, 28, 28);
			panelConversor.add(lbltengo);
			//
			lblQuiero = new JLabel("A");
			lblQuiero.setFont(new Font("Roboto", Font.BOLD, 14));
			lblQuiero.setBounds(252, 70, 59, 28);
			panelConversor.add(lblQuiero);
			//
			lblflecha = new JLabel("");
			lblflecha.setFont(new Font("Roboto", Font.BOLD, 14));
			lblflecha.setBounds(153, 108, 50, 50);
			panelConversor.add(lblflecha);
			//
			deDivisaComboBox = new JComboBox<Monedas>();
			deDivisaComboBox.setFont(new Font("Arial", Font.BOLD, 13));
			deDivisaComboBox.setBackground(new Color(204, 255, 153));
			deDivisaComboBox.setBounds(0, 97, 143, 61);
			panelConversor.add(deDivisaComboBox);
			//
			lblCalculaadora = new JLabel("CONVERSOR");
			lblCalculaadora.setFont(new Font("Roboto", Font.BOLD, 17));
			lblCalculaadora.setBounds(90, 0, 192, 28);
			panelConversor.add(lblCalculaadora);
			//
			aDivisaComboBox = new JComboBox<Monedas>();
			aDivisaComboBox.setFont(new Font("Arial", Font.BOLD, 11));
			aDivisaComboBox.setEnabled(false);
			aDivisaComboBox.setBackground(new Color(255, 51, 51));
			aDivisaComboBox.setBounds(210, 97, 143, 61);
			panelConversor.add(aDivisaComboBox);
			//
			lblMontoAConvertir = new JLabel("MONTO A CONVERTIR");
			lblMontoAConvertir.setFont(new Font("Roboto", Font.BOLD, 14));
			lblMontoAConvertir.setBounds(0, 158, 234, 28);
			panelConversor.add(lblMontoAConvertir);
			//
			lblNewLabel_1 = new JLabel("Selecciona las monedas y el monto de cotización.");
			lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 12));
			lblNewLabel_1.setBounds(34, 61, 290, 14);
			panelConversor.add(lblNewLabel_1);
			//
			btnLimpiar = new JButton("");
			btnLimpiar.setBounds(314, 217, 40, 40);
			panelConversor.add(btnLimpiar);
			btnLimpiar.setContentAreaFilled(false);
			btnLimpiar.setFont(new Font("Roboto Black", Font.BOLD | Font.ITALIC, 11));
			btnLimpiar.setBorder(null);
			btnLimpiar.setBackground(new Color(204, 255, 204));
			//
	
		//Panel de Cotizaciones
		JPanel panelCotizaciones = new JPanel();
		panelCotizaciones.setBackground(new Color(204, 255, 153));
		panelCotizaciones.setBounds(20, 59, 267, 332);
		contentPane.add(panelCotizaciones);
		panelCotizaciones.setLayout(null);
			//
			lblSeleccioneLasMonedas = new JLabel("COTIZACIONES\r\n");
			lblSeleccioneLasMonedas.setBounds(48, 2, 128, 21);
			panelCotizaciones.add(lblSeleccioneLasMonedas);
			lblSeleccioneLasMonedas.setForeground(Color.BLACK);
			lblSeleccioneLasMonedas.setFont(new Font("Roboto Black", Font.BOLD, 17));
			//
			txtResultado = new JTextField();
			txtResultado.setHorizontalAlignment(SwingConstants.CENTER);
			txtResultado.setForeground(new Color(255, 69, 0));
			txtResultado.setFont(new Font("Times New Roman", Font.BOLD, 16));
			txtResultado.setColumns(10);
			txtResultado.setBorder(null);
			txtResultado.setBackground(new Color(51, 204, 255));
			txtResultado.setBounds(0, 282, 353, 50);
			panelConversor.add(txtResultado);
			
			JEditorPane paneTexDescripcion = new JEditorPane();
			paneTexDescripcion.addHyperlinkListener(new HyperlinkListener() {
				public void hyperlinkUpdate(HyperlinkEvent e) {
					if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
			            try {
			                Desktop.getDesktop().browse(e.getURL().toURI());
			            } catch (Exception ex) {
			                ex.printStackTrace();
			            }
			        }
				}
			});
			paneTexDescripcion.setEditable(false);
			paneTexDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 10));
			paneTexDescripcion.setEditable(false);
			paneTexDescripcion.setBackground(new Color(204, 255, 204));
			StringBuilder sb = new StringBuilder();
			sb.append("Se utiliza como valor referencial las tasas de la casa de cambio de la página: ");
			sb.append("<font color='#0000FF'>");
			sb.append("<a href='https://www.cambioschaco.com.py/'>CAMBIOS CHACO PY </a>");
			sb.append("</font>");
			sb.append("Las tasas pueden variar en otras casas de cambio");
			paneTexDescripcion.setContentType("text/html");
			paneTexDescripcion.setText(sb.toString());
			paneTexDescripcion.setBounds(0, 23, 353, 40);
			panelConversor.add(paneTexDescripcion);
			//
			btnGuardarDatos = new JButton("Actualizar datos guardados");
			btnGuardarDatos.setBounds(10, 297, 242, 35);
			panelCotizaciones.add(btnGuardarDatos);
			btnGuardarDatos.setFont(new Font("Roboto Black", Font.BOLD | Font.ITALIC, 11));
			btnGuardarDatos.setBorder(null);
			btnGuardarDatos.setContentAreaFilled(false);
			btnGuardarDatos.setBackground(Color.WHITE);
			
			scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 22, 267, 246);
			panelCotizaciones.add(scrollPane);
			
			
			tableCotizaciones = new JTable();
			tableCotizaciones.setBorder(new CompoundBorder(new EmptyBorder(2, 2, 2, 2), new LineBorder(new Color(0, 0, 0))));
			scrollPane.setViewportView(tableCotizaciones);
			tableCotizaciones.setBackground(new Color(255, 255, 255));
			tableCotizaciones.setFont(new Font("Tahoma", Font.PLAIN, 8));
			tableCotizaciones.getTableHeader().setReorderingAllowed(false);
			tableCotizaciones.setGridColor(new java.awt.Color(0, 0, 0));
			tableCotizaciones.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			
			 editorPaneFecha = new JEditorPane();
			editorPaneFecha.setForeground(new Color(250, 128, 114));
			editorPaneFecha.setFont(new Font("Roboto Black", Font.BOLD, 10));
			editorPaneFecha.setEditable(false);
			editorPaneFecha.setBackground(new Color(220, 20, 60));
			editorPaneFecha.setBounds(0, 268, 267, 64);
			panelCotizaciones.add(editorPaneFecha);
			
			panelTitulo = new JPanel();
			panelTitulo.setBackground(new Color(204, 255, 204));
			panelTitulo.setBounds(20, 11, 631, 43);
			contentPane.add(panelTitulo);
			panelTitulo.setLayout(null);
			
			lblNewLabel_2 = new JLabel("CONVERTIDOR MONEDAS");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setFont(new Font("Roboto", Font.BOLD, 30));
			lblNewLabel_2.setBounds(108, 0, 442, 43);
			panelTitulo.add(lblNewLabel_2);
	}
private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel lblSeleccioneLasMonedas;
	private JButton btnLimpiar;
	private JButton btnGuardarDatos;
	private JPanel panelConversor;
	private JTextField txtResultado;
	private JButton btnConvertir;
	private JTextField txtMonto;
	private JLabel lblResultado;
	private JLabel lbltengo;
	private JLabel lblQuiero;
	private JLabel lblflecha;
	private JComboBox<Monedas> deDivisaComboBox;
	private JLabel lblCalculaadora;
	private JComboBox<Monedas> aDivisaComboBox;
	private JLabel lblMontoAConvertir;
	private JLabel lblNewLabel_1;
	public List<String> lista;
	public Map<String, List<String>> mapa;
	private boolean verificarConexion;
	private JPanel panelTitulo;
	private JLabel lblNewLabel_2;
	Map<String, List<HashMap<String, String>>> tablasDivisas;
	private JTable tableCotizaciones;
	private JScrollPane scrollPane;
	JEditorPane editorPaneFecha;
	
}

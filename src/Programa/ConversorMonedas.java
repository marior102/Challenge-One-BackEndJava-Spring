package Programa;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.util.Arrays;
import javax.swing.border.EmptyBorder;

import Clases.TextPrompt;
import Clases.convertirDivisas;
import Scrap.*;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ConversorMonedas extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtDollarCompra;
	Dolar dolar, doG;
	Euro euro, euG;
	Libra libra, libG;
	YenJapones yen, yenG;
	RealBrasil realB, reG;
	List<String> lista;
	private JTextField txtdollarVenta;
	private JTextField txteuroCompra;
	private JTextField texeuroVenta;
	private JTextField txtlibraCompra;
	private JTextField txtlibraVenta;
	private JTextField txtyenCompra;
	private JTextField txtYenVenta;
	private JTextField txxrealCompra;
	private JTextField txtrealVenta;
	private JLabel lblNewLabel;
	private JLabel lblCompra;
	private JLabel lblVenta;
	private JLabel lbltengo;
	private JLabel lblQuiero;
	private JTextField txtMonto;
	private JTextField txtResultado;
	private JButton btnSalir;
	private JButton btnLimpiar;
	private JButton btnConvertir;
	String comboquiero, combotengo, fechaCargar;
	DecimalFormat df, formatea, fecha;
	private JTextField txtFechaActual;
	private JLabel lblflecha;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*
		try {
			ConversorMonedas dialog = new ConversorMonedas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ConversorMonedas() {
		try {
			System.out.println("Entro aqui");
			cargarCotizaciones();
			//cargarCamposCotizaciones();
		} catch (NullPointerException ex) {
            Object[] opciones = {"si", "no"};
			int ret = JOptionPane.showOptionDialog(this, "No tienes accesar a internet. Desea recuperar datos guardados?", "Pregunta", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            if (ret == JOptionPane.YES_NO_OPTION) {
                recuperarDatosGuardados2();
                enviarDatos();
            }else {
            	System.exit(0);// TODO: handle exception
            }
		}
		dolar = new Dolar();
		euro = new Euro();
		libra = new Libra();
		yen = new YenJapones();
		realB = new RealBrasil();
		
		//df = new DecimalFormat("#.00");
		formatea = new DecimalFormat("###,###.##");
		setTitle("Conversor de Monedas");
		setBounds(100, 100, 570, 461);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(new Color(255, 255, 255));
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblSeleccioneLasMonedas = new JLabel("COTIZACIONES\r\n");
			lblSeleccioneLasMonedas.setForeground(Color.BLACK);
			lblSeleccioneLasMonedas.setFont(new Font("Roboto Black", Font.BOLD, 17));
			lblSeleccioneLasMonedas.setBounds(10, 11, 136, 27);
			contentPanel.add(lblSeleccioneLasMonedas);
		}
		
		JLabel lbldollar = new JLabel("");
		lbldollar.setFont(new Font("Roboto Light", Font.BOLD, 11));
		
		lbldollar.setBounds(10, 65, 59, 40);
		ImageIcon icoDol = new ImageIcon(getClass().getResource("/Imagenes/dollar.png"));
		ImageIcon imgDol = new ImageIcon(icoDol.getImage().getScaledInstance(lbldollar.getWidth(), lbldollar.getHeight(), Image.SCALE_SMOOTH));
		lbldollar.setIcon(imgDol);
		contentPanel.add(lbldollar);
		
		txtDollarCompra = new JTextField();
		txtDollarCompra.setHorizontalAlignment(SwingConstants.CENTER);
		txtDollarCompra.setColumns(10);
		txtDollarCompra.setBackground(new Color(255, 255, 255));
		txtDollarCompra.setForeground(new Color(0, 0, 0));
		txtDollarCompra.setFont(new Font("Roboto Light", Font.ITALIC, 10));
		txtDollarCompra.setEditable(false);
		txtDollarCompra.setBorder(null);
		txtDollarCompra.setBounds(79, 65, 46, 40);
		if (dolar.getCompra() != null) {
			txtDollarCompra.setText(dolar.getCompra());
		}else {
			txtDollarCompra.setText(doG.getguardarCompra());
		}
			
		
		
		contentPanel.add(txtDollarCompra);
		{
			txtdollarVenta = new JTextField();
			txtdollarVenta.setHorizontalAlignment(SwingConstants.CENTER);
			txtdollarVenta.setText((String) null);
			txtdollarVenta.setForeground(new Color(0, 0, 0));
			txtdollarVenta.setFont(new Font("Roboto Light", Font.ITALIC, 10));
			txtdollarVenta.setEditable(false);
			txtdollarVenta.setColumns(10);
			txtdollarVenta.setBackground(Color.WHITE);
			txtdollarVenta.setBounds(135, 65, 46, 40);
			txtdollarVenta.setBorder(null);
			if (dolar.GetVenta()!= null) {
				txtdollarVenta.setText(dolar.GetVenta());
			}else {
				txtdollarVenta.setText(doG.getguardarVenta());
			}
			
			// TODO: handle exception
			
			
			contentPanel.add(txtdollarVenta);
		}
		{
			JLabel lbleuro = new JLabel("");
			lbleuro.setFont(new Font("Roboto Light", Font.BOLD, 11));
			lbleuro.setBounds(10, 116, 59, 44);
			ImageIcon icoeu = new ImageIcon(getClass().getResource("/Imagenes/EUR.png"));
			ImageIcon imgEU = new ImageIcon(icoeu.getImage().getScaledInstance(lbleuro.getWidth(), lbleuro.getHeight(), Image.SCALE_SMOOTH));
			lbleuro.setIcon(imgEU);
			contentPanel.add(lbleuro);
		}
		{
			JLabel lbllibra = new JLabel("");
			lbllibra.setFont(new Font("Roboto Light", Font.BOLD, 11));
			lbllibra.setBounds(10, 171, 59, 44);
			ImageIcon icolib = new ImageIcon(getClass().getResource("/Imagenes/GBP.png"));
			ImageIcon imglib = new ImageIcon(icolib.getImage().getScaledInstance(lbllibra.getWidth(), lbllibra.getHeight(), Image.SCALE_SMOOTH));
			lbllibra.setIcon(imglib);
			contentPanel.add(lbllibra);
		}
		{
			JLabel lblyen = new JLabel("");
			lblyen.setFont(new Font("Roboto Light", Font.BOLD, 11));
			lblyen.setBounds(10, 226, 59, 44);
			ImageIcon icoyen = new ImageIcon(getClass().getResource("/Imagenes/JPY.png"));
			ImageIcon imgyen = new ImageIcon(icoyen.getImage().getScaledInstance(lblyen.getWidth(), lblyen.getHeight(), Image.SCALE_SMOOTH));
			lblyen.setIcon(imgyen);
			contentPanel.add(lblyen);
		}
		{
			JLabel lblreal = new JLabel("");
			lblreal.setFont(new Font("Roboto Light", Font.BOLD, 11));
			lblreal.setBounds(10, 289, 59, 44);
			ImageIcon icowon = new ImageIcon(getClass().getResource("/Imagenes/BRL.png"));
			ImageIcon imgwon = new ImageIcon(icowon.getImage().getScaledInstance(lblreal.getWidth(), lblreal.getHeight(), Image.SCALE_SMOOTH));
			lblreal.setIcon(imgwon);
			contentPanel.add(lblreal);
		}
		{
			txteuroCompra = new JTextField();
			txteuroCompra.setText((String) null);
			txteuroCompra.setHorizontalAlignment(SwingConstants.CENTER);
			txteuroCompra.setForeground(Color.BLACK);
			txteuroCompra.setFont(new Font("Roboto Light", Font.ITALIC, 10));
			txteuroCompra.setEditable(false);
			txteuroCompra.setColumns(10);
			txteuroCompra.setBorder(null);
			txteuroCompra.setBackground(Color.WHITE);
			txteuroCompra.setBounds(79, 116, 46, 44);
			if (euro.getCompra()!= null) {
				txteuroCompra.setText(euro.getCompra());
			}else {
				txteuroCompra.setText(euG.getguardarCompra());
			}
			
			contentPanel.add(txteuroCompra);
		}
		{
			texeuroVenta = new JTextField();
			texeuroVenta.setText((String) null);
			texeuroVenta.setHorizontalAlignment(SwingConstants.CENTER);
			texeuroVenta.setForeground(Color.BLACK);
			texeuroVenta.setFont(new Font("Roboto Light", Font.ITALIC, 10));
			texeuroVenta.setEditable(false);
			texeuroVenta.setColumns(10);
			texeuroVenta.setBorder(null);
			texeuroVenta.setBackground(Color.WHITE);
			texeuroVenta.setBounds(135, 116, 46, 44);
			if(euro.GetVenta()!= null) {
				texeuroVenta.setText(euro.GetVenta());
			}else {
				texeuroVenta.setText(euG.getguardarVenta());
			}
			
			contentPanel.add(texeuroVenta);
		}
		{
			txtlibraCompra = new JTextField();
			txtlibraCompra.setText((String) null);
			txtlibraCompra.setHorizontalAlignment(SwingConstants.CENTER);
			txtlibraCompra.setForeground(Color.BLACK);
			txtlibraCompra.setFont(new Font("Roboto Light", Font.ITALIC, 10));
			txtlibraCompra.setEditable(false);
			txtlibraCompra.setColumns(10);
			txtlibraCompra.setBorder(null);
			txtlibraCompra.setBackground(Color.WHITE);
			txtlibraCompra.setBounds(79, 171, 46, 44);
			if(libra.getCompra()!= null) {
				txtlibraCompra.setText(libra.getCompra());
			}else {
				txtlibraCompra.setText(libG.getguardarCompra());
			}
			
			contentPanel.add(txtlibraCompra);
		}
		{
			txtlibraVenta = new JTextField();
			txtlibraVenta.setText((String) null);
			txtlibraVenta.setHorizontalAlignment(SwingConstants.CENTER);
			txtlibraVenta.setForeground(Color.BLACK);
			txtlibraVenta.setFont(new Font("Roboto Light", Font.ITALIC, 10));
			txtlibraVenta.setEditable(false);
			txtlibraVenta.setColumns(10);
			txtlibraVenta.setBorder(null);
			txtlibraVenta.setBackground(Color.WHITE);
			txtlibraVenta.setBounds(135, 171, 46, 44);
			if(libra.getCompra()!=null) {
				txtlibraVenta.setText(libra.GetVenta());
			}else {
				txtlibraVenta.setText(libG.getguardarVenta());
			}
			
			contentPanel.add(txtlibraVenta);
		}
		{
			txtyenCompra = new JTextField();
			txtyenCompra.setText((String) null);
			txtyenCompra.setHorizontalAlignment(SwingConstants.CENTER);
			txtyenCompra.setForeground(Color.BLACK);
			txtyenCompra.setFont(new Font("Roboto Light", Font.ITALIC, 10));
			txtyenCompra.setEditable(false);
			txtyenCompra.setColumns(10);
			txtyenCompra.setBorder(null);
			txtyenCompra.setBackground(Color.WHITE);
			txtyenCompra.setBounds(79, 227, 46, 43);
			if(yen.getCompra()!= null) {
				txtyenCompra.setText(yen.getCompra());
			}else {
				txtyenCompra.setText(yenG.getguardarCompra());
			}
			
			contentPanel.add(txtyenCompra);
		}
		{
			txtYenVenta = new JTextField();
			txtYenVenta.setText((String) null);
			txtYenVenta.setHorizontalAlignment(SwingConstants.CENTER);
			txtYenVenta.setForeground(Color.BLACK);
			txtYenVenta.setFont(new Font("Roboto Light", Font.ITALIC, 10));
			txtYenVenta.setEditable(false);
			txtYenVenta.setColumns(10);
			txtYenVenta.setBorder(null);
			txtYenVenta.setBackground(Color.WHITE);
			txtYenVenta.setBounds(135, 226, 46, 44);
			if(yen.GetVenta()!=null) {
				txtYenVenta.setText(yen.GetVenta());
			}else {
				txtYenVenta.setText(yenG.getguardarVenta());
			}
			//
			contentPanel.add(txtYenVenta);
		}
		{
			txxrealCompra = new JTextField();
			txxrealCompra.setText((String) null);
			txxrealCompra.setHorizontalAlignment(SwingConstants.CENTER);
			txxrealCompra.setForeground(Color.BLACK);
			txxrealCompra.setFont(new Font("Roboto Light", Font.ITALIC, 10));
			txxrealCompra.setEditable(false);
			txxrealCompra.setColumns(10);
			txxrealCompra.setBorder(null);
			txxrealCompra.setBackground(Color.WHITE);
			txxrealCompra.setBounds(79, 292, 46, 41);
			if(realB.getCompra()!= null) {
				txxrealCompra.setText(realB.getCompra());
			}else {
				txxrealCompra.setText(reG.getguardarCompra());
			}
			
			contentPanel.add(txxrealCompra);
		}
		{
			txtrealVenta = new JTextField();
			txtrealVenta.setText((String) null);
			txtrealVenta.setHorizontalAlignment(SwingConstants.CENTER);
			txtrealVenta.setForeground(Color.BLACK);
			txtrealVenta.setFont(new Font("Roboto Light", Font.ITALIC, 10));
			txtrealVenta.setEditable(false);
			txtrealVenta.setColumns(10);
			txtrealVenta.setBorder(null);
			txtrealVenta.setBackground(Color.WHITE);
			txtrealVenta.setBounds(135, 289, 46, 44);
			if(realB.GetVenta()!= null) {
				txtrealVenta.setText(realB.GetVenta());
			}else {
				txtrealVenta.setText(reG.getguardarVenta());
			}
			
			contentPanel.add(txtrealVenta);
		}
		{
		txtFechaActual = new JTextField();
		txtFechaActual.setText((String) null);
		txtFechaActual.setHorizontalAlignment(SwingConstants.CENTER);
		txtFechaActual.setForeground(Color.BLACK);
		txtFechaActual.setFont(new Font("Roboto Light", Font.ITALIC, 10));
		txtFechaActual.setEditable(false);
		txtFechaActual.setColumns(10);
		txtFechaActual.setBorder(null);
		txtFechaActual.setBackground(Color.WHITE);
		txtFechaActual.setBounds(10, 344, 184, 27);
		
		try {
			if(doG.getGuardarFecha()!=null) {
				txtFechaActual.setText("Ultima Actualizacion: "+doG.getGuardarFecha());
			}else {
				txtFechaActual.setText("Ultima Actualizacion: ");
			}
		} catch (NullPointerException e) {
			System.out.println("Fecha no ingresada ");// TODO: handle exception
		}
		
		contentPanel.add(txtFechaActual);
		}
		{
			lblNewLabel = new JLabel("MONEDA");
			lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 11));
			lblNewLabel.setBounds(10, 40, 59, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			lblCompra = new JLabel("COMPRA");
			lblCompra.setFont(new Font("Roboto", Font.PLAIN, 11));
			lblCompra.setBounds(79, 40, 59, 14);
			contentPanel.add(lblCompra);
		}
		{
			lblVenta = new JLabel("VENTA");
			lblVenta.setFont(new Font("Roboto", Font.PLAIN, 11));
			lblVenta.setBounds(148, 40, 59, 14);
			contentPanel.add(lblVenta);
		}
		{
			lbltengo = new JLabel("De");
			lbltengo.setFont(new Font("Roboto", Font.BOLD, 14));
			lbltengo.setBounds(315, 77, 28, 28);
			contentPanel.add(lbltengo);
		}
		{
			lblQuiero = new JLabel("A");
			lblQuiero.setFont(new Font("Roboto", Font.BOLD, 14));
			lblQuiero.setBounds(485, 65, 59, 28);
			contentPanel.add(lblQuiero);
		}
		
		JComboBox cmbTengo = new JComboBox();
		cmbTengo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				limpiar();
				txtMonto.requestFocus();
			}
		});
		cmbTengo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				limpiar();
			}
		});
		
		cmbTengo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//txtMonto.setText("");
			}
		});
		cmbTengo.setEditable(true);
		cmbTengo.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		cmbTengo.setBackground(new Color(255, 255, 255));
		cmbTengo.setBorder(null);
		cmbTengo.setModel(new DefaultComboBoxModel(new String[] {"Guarani", "Dollar", "Euro", "Libra Esterlina", "Yen Japones", "Real Brasil"}));
		cmbTengo.setSelectedIndex(0);
		cmbTengo.setBounds(266, 110, 125, 40);
		contentPanel.add(cmbTengo);
		
		
		JComboBox cmbquiero = new JComboBox();
		cmbquiero.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
		//	limpiar();
			//txtMonto.requestFocus();
			
			
			}
		});
		cmbquiero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		cmbquiero.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		cmbquiero.setEditable(true);
		cmbquiero.setBackground(new Color(51, 255, 255));
		cmbquiero.setBorder(null);
		cmbquiero.setModel(new DefaultComboBoxModel(new String[] {"Guarani", "Dollar", "Euro", "Libra Esterlina", "Yen Japones", "Real Brasil"}));
		cmbquiero.setBounds(435, 110, 115, 40);
		contentPanel.add(cmbquiero);
		
		
		JLabel lblMonto = new JLabel("Monto");
		lblMonto.setFont(new Font("Roboto", Font.BOLD, 14));
		lblMonto.setBounds(332, 160, 59, 28);
		contentPanel.add(lblMonto);
		
		txtMonto = new JTextField();
		@SuppressWarnings("unused")
		TextPrompt mon = new TextPrompt("Escriba el monto", txtMonto);
		txtMonto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConvertir.requestFocus();
				btnConvertir.doClick();
			}
		});
		txtMonto.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!Character.isDigit(c) && c !='.') {
					e.consume();
					JOptionPane.showMessageDialog(null, "Solo se acepta valores numericos");
					
					
				}
				if (c=='.' && txtMonto.getText().contains(".")) {
					e.consume();
					JOptionPane.showMessageDialog(null, "No se puede agregar dos puntos decimales a un numero");
					
				}
			
			}
		});
		    
		txtMonto.setBounds(315, 187, 119, 40);
		contentPanel.add(txtMonto);
		txtMonto.setColumns(10);
		
		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setFont(new Font("Roboto", Font.BOLD, 14));
		lblResultado.setBounds(335, 234, 92, 28);
		contentPanel.add(lblResultado);
		
		txtResultado = new JTextField();
		txtResultado.setHorizontalAlignment(SwingConstants.CENTER);
		txtResultado.setBackground(new Color(240, 255, 255));
		txtResultado.setForeground(new Color(255, 69, 0));
		txtResultado.setFont(new Font("Times New Roman", Font.BOLD, 16));
		txtResultado.setEditable(false);
		txtResultado.setColumns(10);
		txtResultado.setBounds(315, 273, 235, 40);
		txtResultado.setBorder(null);
		TextPrompt res = new TextPrompt("Aparecera el resultado", txtResultado);
		res.setHorizontalAlignment(SwingConstants.CENTER);
		res.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		contentPanel.add(txtResultado);
		
		{
			btnSalir = new JButton("Salir");
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					salir();
				}
			});
			btnSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Exit.png")));
			btnSalir.setFont(new Font("Roboto Black", Font.BOLD | Font.ITALIC, 11));
			btnSalir.setBackground(new Color(255, 255, 255));
			btnSalir.setBounds(435, 365, 119, 57);
			btnSalir.setBorder(null);
			contentPanel.add(btnSalir);
		}
		{
			btnLimpiar = new JButton("Limpiar");
			btnLimpiar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					limpiar();
					txtMonto.requestFocus();
				}
			});
			btnLimpiar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/clean2.png")));
			btnLimpiar.setFont(new Font("Roboto Black", Font.BOLD | Font.ITALIC, 11));
			btnLimpiar.setBorder(null);
			btnLimpiar.setBackground(Color.WHITE);
			btnLimpiar.setBounds(291, 365, 119, 57);
			contentPanel.add(btnLimpiar);
		}
		
		btnConvertir = new JButton("CONVERTIR");
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
						if (txtMonto.getText().length() !=0) {
							double monto = Double.parseDouble(txtMonto.getText());
								if(monto > 0 ) {
									comboquiero = cmbquiero.getSelectedItem().toString();
									combotengo = cmbTengo.getSelectedItem().toString();
									convertirDivisas(combotengo, comboquiero);
								}else {
									JOptionPane.showMessageDialog(null, "No se puede calcular con un monto negativo");
									limpiar();
								}
								
						}else {
							JOptionPane.showMessageDialog(null, "No se puede calcular porque el monto esta vacio");
							limpiar();
						}
					
				
				
				
				
			}
		});
		btnConvertir.setFont(new Font("Roboto Black", Font.BOLD | Font.ITALIC, 11));
		btnConvertir.setBorder(null);
		btnConvertir.setBackground(new Color(204, 255, 255));
		btnConvertir.setBounds(435, 188, 119, 40);
		contentPanel.add(btnConvertir);
		
		JButton btnGuardarDatos = new JButton("Actualizar datos guardados");
		btnGuardarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if (txtdollarVenta.getText().length() != 0 && txteuroCompra.getText().length()!= 0 &&  txtlibraCompra.getText().length()!=0
					&&txtyenCompra.getText().length()!=0 && txxrealCompra.getText().length()!=0) {
				guadarDatos();
				crearArchivoCotizacion();
				agregarRegistrosCotizacion();
			}else {
				JOptionPane.showMessageDialog(null, "No se puede guardar campos vacios");
			}
			}
		});
		btnGuardarDatos.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Save.png")));
		btnGuardarDatos.setFont(new Font("Roboto Black", Font.BOLD | Font.ITALIC, 11));
		btnGuardarDatos.setBorder(null);
		btnGuardarDatos.setBackground(Color.WHITE);
		btnGuardarDatos.setBounds(0, 365, 207, 57);
		contentPanel.add(btnGuardarDatos);
		{
			lblflecha = new JLabel("");
			lblflecha.setFont(new Font("Roboto", Font.BOLD, 14));
			lblflecha.setBounds(391, 110, 36, 40);
			ImageIcon ico = new ImageIcon(getClass().getResource("/Imagenes/flechaa.png"));
			ImageIcon img = new ImageIcon(ico.getImage().getScaledInstance(lblflecha.getWidth(), lblflecha.getHeight(), Image.SCALE_SMOOTH));
			lblflecha.setIcon(img);
			contentPanel.add(lblflecha);
		}
		
		
		
		
	}
	
	
	//aca primeramente convertimos las monedas de tipo String a Double
	private void convertirDivisas(String tengo, String quiero) {
		/*Guarani
		Dollar
		Euro
		Libra Esterlina
		Yen Japones
		Real Brasil*/
		convertirDivisas doCompra = new convertirDivisas();
		doCompra.convertir(txtDollarCompra.getText());
		double compraDolar = doCompra.getMoneda();
		
		convertirDivisas doVenta = new convertirDivisas();
		doVenta.convertir(txtdollarVenta.getText());
		double ventaDolar = doVenta.getMoneda();
		
		convertirDivisas euCompra = new convertirDivisas();
		euCompra.convertir(txteuroCompra.getText());
		double compraEuro = euCompra.getMoneda();
		
		convertirDivisas euVenta = new convertirDivisas();
		euVenta.convertir(texeuroVenta.getText());
		double ventaEuro = euVenta.getMoneda();
		
		convertirDivisas liCompra = new convertirDivisas();
		liCompra.convertir(txtlibraCompra.getText());
		double compraLibra = liCompra.getMoneda();
		
		convertirDivisas liventa = new convertirDivisas();
		liventa.convertir(txtlibraVenta.getText());
		double ventaLibra = liventa.getMoneda();
		
		convertirDivisas yeCompra = new convertirDivisas();
		yeCompra.convertir(txtyenCompra.getText());
		double compraYen = yeCompra.getMoneda()/1000;
		
		convertirDivisas yeventa = new convertirDivisas();
		yeventa.convertir(txtYenVenta.getText());
		double ventaYen = yeventa.getMoneda()/1000;
		
		convertirDivisas rCompra = new convertirDivisas();
		rCompra.convertir(txxrealCompra.getText());
		double compraReal = rCompra.getMoneda();
		
		convertirDivisas rVenta = new convertirDivisas();
		rVenta.convertir(txtrealVenta.getText());
		double ventaReal = rVenta.getMoneda();
		
		System.out.println(quiero + tengo);
			//Compra de Dolar
		
		//Y aca con el Switch if/else ponemos las condiciones para que puedan hacer los calculos
		
		if(tengo == "Guarani" || quiero == "Guarani") {
			if (tengo.equalsIgnoreCase("Guarani") && quiero.equalsIgnoreCase("Guarani")) {
				double monto = Double.parseDouble(txtMonto.getText());
				
				double resultado = monto*1;
				//JOptionPane.showMessageDialog(null, "Es l");
				System.out.println("resultado " + resultado);
				
				txtResultado.setText(""+ formatea.format(resultado) + " ₲");
				
				
			}
			if (tengo.equalsIgnoreCase("Guarani") && quiero.equalsIgnoreCase("Dollar")) {
				double monto = Double.parseDouble(txtMonto.getText());
				
				double resultado = monto/compraDolar;
				System.out.println("resultado " + resultado);
				
				txtResultado.setText(""+ formatea.format(resultado) + " $");
				
				
			}
			//venta de dolar
			if (tengo.equalsIgnoreCase("Dollar") && quiero.equalsIgnoreCase("Guarani")) {
				double monto = Double.parseDouble(txtMonto.getText());
				
				double resultado = monto*ventaDolar;
				System.out.println("resultado " + resultado);
				
				txtResultado.setText(""+ formatea.format(resultado) + " ₲");
				
				
			}
			//Compra de euro
			if (tengo.equalsIgnoreCase("Guarani") && quiero.equalsIgnoreCase("Euro")) {
				double monto = Double.parseDouble(txtMonto.getText());
				
				double resultado = monto/compraEuro;
				System.out.println("resultado " + resultado);
				
				txtResultado.setText(""+ formatea.format(resultado) + " €");
				
				
			}
			//venta de euro
			if (tengo.equalsIgnoreCase("Euro") && quiero.equalsIgnoreCase("Guarani")) {
				double monto = Double.parseDouble(txtMonto.getText());
				
				double resultado = monto*ventaEuro;
				System.out.println("resultado " + resultado);
				
				txtResultado.setText(""+ formatea.format(resultado) + " ₲");
				
				
			}
			//compra de libra
			if (tengo.equalsIgnoreCase("Guarani") && quiero.equalsIgnoreCase("Libra Esterlina")) {
				double monto = Double.parseDouble(txtMonto.getText());
				
				double resultado = monto/compraLibra;
				System.out.println("resultado " + resultado);
				
				txtResultado.setText(""+ formatea.format(resultado) + " £");
				
				
			}
			//venta de libra
			if (tengo.equalsIgnoreCase("Libra Esterlina") && quiero.equalsIgnoreCase("Guarani")) {
				double monto = Double.parseDouble(txtMonto.getText());
				
				double resultado = monto*ventaLibra;
				System.out.println("resultado " + resultado);
				
				txtResultado.setText(""+ formatea.format(resultado) + " ₲");
				
				
			}
			//compra de yen japones
			if (tengo.equalsIgnoreCase("Guarani") && quiero.equalsIgnoreCase("Yen Japones")) {
				double monto = Double.parseDouble(txtMonto.getText());
				
				double resultado = monto/compraYen;
				System.out.println("resultado " + resultado);
				
				txtResultado.setText(""+ formatea.format(resultado) + " ¥");
				
				
			}
			//venta de jen japones
			if (tengo.equalsIgnoreCase("Yen Japones") && quiero.equalsIgnoreCase("Guarani")) {
				double monto = Double.parseDouble(txtMonto.getText());
				
				double resultado = monto*ventaYen;
				System.out.println("resultado " + resultado);
				
				txtResultado.setText(""+ formatea.format(resultado) + " ₲");
				
				
			}
			//compra de real brasileno
			if (tengo.equalsIgnoreCase("Guarani") && quiero.equalsIgnoreCase("Real Brasil")) {
				double monto = Double.parseDouble(txtMonto.getText());
				
				double resultado = monto/compraReal;
				System.out.println("resultado " + resultado);
				
				txtResultado.setText(""+ formatea.format(resultado)+ " R$");
				
				
			}
			//venta real brasilero
			if (tengo.equalsIgnoreCase("Real Brasil") && quiero.equalsIgnoreCase("Guarani")) {
				double monto = Double.parseDouble(txtMonto.getText());
				
				double resultado = monto*ventaReal;
				System.out.println("resultado " + resultado);
				
				txtResultado.setText("Son: "+ formatea.format(resultado) + " ₲");
				
				
			}
		}else {
			JOptionPane.showMessageDialog(null,"Solo se puede realizar calculos entre monedas de Paraguay 'Guarani' y otras monedas");
			limpiar();
			
		}
		
		/// Y asi funciona nuestro programa, espero que les haya gustado y espero algunas sugerencias
		
		//Por cierto,  este ya es un repositorio de Git y ya alzamos de manera remota
		
	
		
		
		
		
	}
	@SuppressWarnings("static-access")
	private void cargarCotizaciones() {
		/**
		 * Cargamos dolar
		 */
		dolar = new Dolar();
		dolar.setExraerDatos("https://www.cambioschaco.com.py/", "#exchange-usd");
		/**
		 * Cargamos euro
		 */
		euro = new Euro();
		euro.setExraerDatos("https://www.cambioschaco.com.py/", "#exchange-eur");
		
		/**
		 * Cargamos Libra
		 */
		libra = new Libra();
		libra.setExraerDatos("https://www.cambioschaco.com.py/", "#exchange-gbp");
		
		/**
		 * Cargamos Yen
		 */
		yen = new YenJapones();
		yen.setExraerDatos("https://www.cambioschaco.com.py/", "#exchange-jpy");
		
		/**
		 * Cargamos Real brasil
		 */
		realB = new RealBrasil();
		realB.setExraerDatos("https://www.cambioschaco.com.py/", "#exchange-brl");
		
		//cargarCamposCotizaciones();
		
		
		
	}
	/*private void cargarCamposCotizaciones() {

		txtDollarCompra.setText(dolar.getCompra());
		txtdollarVenta.setText(dolar.GetVenta());
		txteuroCompra.setText(euro.getCompra());
		texeuroVenta.setText(euro.GetVenta());
		txtlibraCompra.setText(libra.getCompra());
		txtlibraVenta.setText(libra.GetVenta());
		txtyenCompra.setText(yen.getCompra());
		txtYenVenta.setText(yen.GetVenta());
		txxrealCompra.setText(realB.getCompra());
		txtrealVenta.setText(realB.GetVenta());	
		
		
	}*/
	
	/*private void cargarCamposguardados() {

		txtDollarCompra.setText(doG.getguardarCompra());
		txtdollarVenta.setText(doG.getguardarVenta());
		txteuroCompra.setText(euG.getguardarCompra());
		texeuroVenta.setText(euG.getguardarVenta());
		txtlibraCompra.setText(libG.getguardarCompra());
		txtlibraVenta.setText(libG.getguardarVenta());
		txtyenCompra.setText(yenG.getguardarCompra());
		txtYenVenta.setText(yenG.getguardarVenta());
		txxrealCompra.setText(reG.getguardarCompra());
		txtrealVenta.setText(reG.getguardarVenta());
		txtFechaActual.setText(doG.getGuardarFecha());
		
		
		
		
		
	}*/
	
	private void limpiar() {
		txtMonto.setText("");
		//TextPrompt mon = new TextPrompt("Escriba el monto", txtMonto);
		txtResultado.setText("");
		//TextPrompt res = new TextPrompt("Aparecera el resultado", txtResultado);
	}
	private void guadarDatos() {
		String guardarDolarCompra = txtDollarCompra.getText();
		String guardarDolarVenta = txtdollarVenta.getText();
		String guardarEuroCompra = txteuroCompra.getText();
		String guardarEuroVenta = texeuroVenta.getText();
		String guardarLibraCompra = txtlibraCompra.getText();
		String guardarLibraVenta = txtlibraVenta.getText();
		String guardarYenCompra = txtyenCompra.getText();
		String guardarYenVenta = txtYenVenta.getText();
		String guardarRealCompra= txxrealCompra.getText();
		String guardarRealVenta = txtrealVenta.getText();
		dolar.SetGuardarCompra(guardarDolarCompra);
		dolar.SetGuardarVenta(guardarDolarVenta);
		euro.SetGuardarCompra(guardarEuroCompra);
		euro.SetGuardarVenta(guardarEuroVenta);
		libra.SetGuardarCompra(guardarLibraCompra);
		libra.SetGuardarVenta(guardarLibraVenta);
		yen.SetGuardarCompra(guardarYenCompra);
		yen.SetGuardarVenta(guardarYenVenta);
		realB.SetGuardarCompra(guardarRealCompra);
		realB.SetGuardarVenta(guardarRealVenta);
		
		
		 System.out.println("Datos guardados son:"+ realB.getguardarCompra()+ libra.getguardarCompra());
	}
	private void recuperarDatosGuardados2() {
		
		String nombreArchivo = "Cotizacionesguardadas.txt";
		
		File file = new File(nombreArchivo);
		
		try {
			System.out.println("Entro aqui1");
			
			try (BufferedReader lectorArchivo = new BufferedReader(new FileReader(file))) {
				if(lectorArchivo.ready()) {
					//String primeraLinea = lectorArchivo.readLine();
					System.out.println("Entro aqui2 " );
					String cadena;
					
					//ArrayList<String> cargarDatos = new ArrayList<String>();
					//Leemos la ultima linea
					
					while ((cadena = lectorArchivo.readLine()) != null) {
						// Aca ponemos como condicional que cada campo estara separado por "," 
						// y agregamos esos datos en un Arrayslist
						lista = new ArrayList<>(Arrays.asList(cadena.split(",")));
						System.out.println("Entro aqui e imprime esto: " + lista + "Solo ejecuto ");
					}
				
				}else {
					System.out.println("El archivo no esa listo para leerse");
				}
			}
			
			
				
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Ocurrio un error"+ e.toString());
			
		}
	}
	
	public void enviarDatos() {
		
		//Luego enviamos esos datos a clases que encapsulan datos
		
		
		doG = new Dolar();
		euG= new Euro();
		libG = new Libra();
		yenG = new YenJapones();
		reG = new RealBrasil();
		doG.SetGuardarCompra(lista.get(0));
		System.out.println(lista.get(0));
		doG.SetGuardarVenta(lista.get(1));
		System.out.println(lista.get(1));
		System.out.println(lista.get(2));
		euG.SetGuardarCompra(lista.get(2));
		System.out.println(lista.get(3));
		euG.SetGuardarVenta(lista.get(3));
		libG.SetGuardarCompra(lista.get(4));
		libG.SetGuardarVenta(lista.get(5));
		yenG.SetGuardarCompra(lista.get(6));
		yenG.SetGuardarVenta(lista.get(7));
		reG.SetGuardarCompra(lista.get(8));
		reG.SetGuardarVenta(lista.get(9));
		doG.setGuardarFecha(lista.get(10));
	}
	
	
	public void crearArchivoCotizacion() {
		try {
			File objetoArchivo = new File("Cotizacionesguardadas.txt");
			if(objetoArchivo.createNewFile()) {
				JOptionPane.showMessageDialog(null,"Se ha creado correctamente el archivo: "+  objetoArchivo.getName());
			}
			else {
				System.out.println("El archivo ya fue creado ");
				//JOptionPane.showMessageDialog(null, "El archivo ya fue creado ");
			}
			
		} catch (Exception e) {
			System.out.println("Ocurrio un error al crear el archivo");
			
		}
	}
	@SuppressWarnings("static-access")
	public void agregarRegistrosCotizacion() {
		try {
			FileWriter fw = new FileWriter("Cotizacionesguardadas.txt",true);
			Fecha fecha = new Fecha();
			
			fw.write(dolar.getguardarCompra());
			fw.write(",");
			fw.write(dolar.getguardarVenta());
			fw.write(",");
			fw.write(euro.getguardarCompra());
			fw.write(",");
			fw.write(euro.getguardarVenta());
			fw.write(",");
			fw.write(libra.getguardarCompra());
			fw.write(",");
			fw.write(libra.getguardarVenta());
			fw.write(",");
			fw.write(yen.getguardarCompra());
			fw.write(",");
			fw.write(yen.getguardarVenta());
			fw.write(",");
			fw.write(realB.getguardarCompra());
			fw.write(",");
			fw.write(realB.getguardarVenta());
			fw.write(",");
			fw.write(fecha.getFecha()+" : "+fecha.getHora());
			fw.write("\n");
			fw.close();
			
			JOptionPane.showMessageDialog(null,"Se registro correctamente");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Ocurrio un error al registrar aca" + e.toString());
		}
	}
	private void salir() {
        Object[] opciones = {"si", "no"};
        int ret = JOptionPane.showOptionDialog(this, "Desea salir?", "Pregunta", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
        if (ret == JOptionPane.YES_NO_OPTION) {
        	dispose();
        	MenuConversor mc = new MenuConversor();
        	mc.setVisible(true);
        	//System.exit(0);
            
        }
		
		
	}
	
	
}

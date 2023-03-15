package Programa;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.TextPrompt;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;

public class ConversorUnidadMedida extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCantidad;
	private JTextField txtResultado;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbUnidad1;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbUnidad2;
	String unidad1, unidad2;
	double cantidadEscrita;
	DecimalFormat formatea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ConversorUnidadMedida() {
		formatea = new DecimalFormat("###,###.##");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(null);
		contentPanel.setForeground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBounds(0, 0, 554, 422);
		contentPane.add(contentPanel);
		
		JLabel lblConvertirUnidadDe = new JLabel("CONVERTIR UNIDAD DE MEDIDA-LONGITUD");
		lblConvertirUnidadDe.setForeground(Color.BLACK);
		lblConvertirUnidadDe.setFont(new Font("Roboto Black", Font.BOLD, 17));
		lblConvertirUnidadDe.setBounds(10, 11, 444, 27);
		contentPanel.add(lblConvertirUnidadDe);
		
		JLabel lblUnidad = new JLabel("DE");
		lblUnidad.setFont(new Font("Roboto", Font.BOLD, 14));
		lblUnidad.setBounds(297, 59, 45, 28);
		contentPanel.add(lblUnidad);
		
		JLabel lblUnidad_1 = new JLabel("A");
		lblUnidad_1.setFont(new Font("Roboto", Font.BOLD, 14));
		lblUnidad_1.setBounds(484, 59, 45, 28);
		contentPanel.add(lblUnidad_1);
		
		cmbUnidad1 = new JComboBox();
		cmbUnidad1.setModel(new DefaultComboBoxModel(new String[] {"Kilometro", "Metro", "Milla", "Yarda", "Pie", "Pulgada", "MillaNautica"}));
		cmbUnidad1.setSelectedIndex(0);
		cmbUnidad1.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		cmbUnidad1.setEditable(true);
		cmbUnidad1.setBorder(null);
		cmbUnidad1.setBackground(Color.WHITE);
		cmbUnidad1.setBounds(274, 91, 92, 40);
		contentPanel.add(cmbUnidad1);
		
		cmbUnidad2 = new JComboBox();
		cmbUnidad2.setModel(new DefaultComboBoxModel(new String[] {"Kilometro", "Metro", "Milla", "Yarda", "Pie", "Pulgada", "MillaNautica"}));
		cmbUnidad2.setFont(new Font("Roboto Light", Font.PLAIN, 11));
		cmbUnidad2.setEditable(true);
		cmbUnidad2.setBorder(null);
		cmbUnidad2.setBackground(new Color(220, 20, 60));
		cmbUnidad2.setBounds(452, 91, 92, 40);
		contentPanel.add(cmbUnidad2);
		
		JLabel lblCantidad = new JLabel("CANTIDAD");
		lblCantidad.setFont(new Font("Roboto", Font.BOLD, 14));
		lblCantidad.setBounds(274, 142, 119, 28);
		contentPanel.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(274, 181, 119, 40);
		contentPanel.add(txtCantidad);
		txtCantidad.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!Character.isDigit(c) && c !='.') {
					e.consume();
					JOptionPane.showMessageDialog(null, "Solo se acepta valores numericos");
					
					
				}
				if (c=='.' && txtCantidad.getText().contains(".")) {
					e.consume();
					JOptionPane.showMessageDialog(null, "No se puede agregar dos puntos decimales a un numero");
					
				}
			
			}
		});
		
		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setFont(new Font("Roboto", Font.BOLD, 14));
		lblResultado.setBounds(274, 235, 92, 28);
		contentPanel.add(lblResultado);
		
		txtResultado = new JTextField();
		txtResultado.setHorizontalAlignment(SwingConstants.CENTER);
		txtResultado.setForeground(new Color(240, 248, 255));
		txtResultado.setFont(new Font("Times New Roman", Font.BOLD, 16));
		txtResultado.setEditable(false);
		txtResultado.setColumns(10);
		txtResultado.setBorder(null);
		txtResultado.setBackground(new Color(220, 20, 60));
		txtResultado.setBounds(274, 274, 276, 40);
		TextPrompt res = new TextPrompt("Aparecera el resultado", txtResultado);
		res.setFont(new Font("Roboto Black", Font.BOLD | Font.ITALIC, 16));
		res.setHorizontalAlignment(SwingConstants.CENTER);
		res.setForeground(new Color(255, 250, 240));
		contentPanel.add(txtResultado);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Exit.png")));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salir();
			}
		});
		btnSalir.setFont(new Font("Roboto Black", Font.BOLD | Font.ITALIC, 11));
		btnSalir.setBorder(null);
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setBounds(435, 365, 119, 57);
		contentPanel.add(btnSalir);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/clean2.png")));
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCantidad.setText("");
				txtResultado.setText("");
				txtCantidad.requestFocus();
			}
		});
		btnLimpiar.setFont(new Font("Roboto Black", Font.BOLD | Font.ITALIC, 11));
		btnLimpiar.setBackground(new Color(255, 255, 255));
		btnLimpiar.setBounds(291, 365, 119, 57);
		btnLimpiar.setBorder(null);
		contentPanel.add(btnLimpiar);
		
		JButton btnConvertir = new JButton("CONVERTIR");
		btnConvertir.setForeground(new Color(245, 245, 220));
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtCantidad.getText().length() !=0) {
					double cantidad = Double.parseDouble(txtCantidad.getText());
						if(cantidad > 0) {
							unidad1 = cmbUnidad1.getSelectedItem().toString();
							unidad2 = cmbUnidad2.getSelectedItem().toString();
							calcularUnidad(unidad1, unidad2, cantidad);
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
		btnConvertir.setBackground(new Color(220, 20, 60));
		btnConvertir.setBounds(431, 181, 119, 40);
		contentPanel.add(btnConvertir);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setBounds(10, 59, 256, 255);
		lblImagen.setBorder(null);
		ImageIcon icoMon = new ImageIcon(getClass().getResource("/Imagenes/conversor-longitud.jpg"));
		ImageIcon imgMon = new ImageIcon(icoMon.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH));
		lblImagen.setIcon(imgMon);
		contentPanel.add(lblImagen);
		
		JLabel lblflecha = new JLabel("");
		
		lblflecha.setFont(new Font("Roboto", Font.BOLD, 14));
		lblflecha.setBounds(376, 91, 62, 40);
		ImageIcon ico = new ImageIcon(getClass().getResource("/Imagenes/FLECHA.png"));
		ImageIcon img = new ImageIcon(ico.getImage().getScaledInstance(lblflecha.getWidth(), lblflecha.getHeight(), Image.SCALE_SMOOTH));
		lblflecha.setIcon(img);
		contentPanel.add(lblflecha);
	}
	
	private void calcularUnidad(String combo1, String combo2, double canti) {
		unidad1= combo1;
		unidad2= combo2;
		cantidadEscrita= canti;
		//"Kilometro", "Metro", "Milla", "Yarda", "Pie", "Pulgada", "MillaNautica"
		
		//km a m
		
		if (unidad1 != unidad2) {
			if (unidad1.equalsIgnoreCase("Kilometro") && unidad2.equalsIgnoreCase("Metro")) {
				
				double resultado = cantidadEscrita*1000;
				//JOptionPane.showMessageDialog(null, "Es l");
				System.out.println("resultado " + resultado);
				txtResultado.setText(""+ formatea.format(resultado) + " mts");	
			}
			//m a km
			if (unidad1.equalsIgnoreCase("Metro") && unidad2.equalsIgnoreCase("Kilometro")) {
				
				double resultado = cantidadEscrita/1000;
				//JOptionPane.showMessageDialog(null, "Es l");
				System.out.println("resultado " + resultado);
				txtResultado.setText(""+ formatea.format(resultado) + " km");	
			}
			if (unidad1.equalsIgnoreCase("Kilometro") && unidad2.equalsIgnoreCase("Milla")) {
				
				double resultado = cantidadEscrita/1.609;
				//JOptionPane.showMessageDialog(null, "Es l");
				System.out.println("resultado " + resultado);
				txtResultado.setText(""+ formatea.format(resultado) + " mi");	
			}
			if (unidad1.equalsIgnoreCase("Milla") && unidad2.equalsIgnoreCase("Kilometro")) {
				
				double resultado = cantidadEscrita*1.609;
				//JOptionPane.showMessageDialog(null, "Es l");
				System.out.println("resultado " + resultado);
				txtResultado.setText(""+ formatea.format(resultado) + " km");	
			}
			if (unidad1.equalsIgnoreCase("Kilometro") && unidad2.equalsIgnoreCase("Yarda")) {
				
				double resultado = cantidadEscrita*1094;
				//JOptionPane.showMessageDialog(null, "Es l");
				System.out.println("resultado " + resultado);
				txtResultado.setText(""+ formatea.format(resultado) + " yd");	
			}
			if (unidad1.equalsIgnoreCase("Yarda") && unidad2.equalsIgnoreCase("Kilometro")) {
				
				double resultado = cantidadEscrita/1094;
				//JOptionPane.showMessageDialog(null, "Es l");
				System.out.println("resultado " + resultado);
				txtResultado.setText(""+ formatea.format(resultado) + " km");	
			}
			if (unidad1.equalsIgnoreCase("Kilometro") && unidad2.equalsIgnoreCase("Pie")) {
				
				double resultado = cantidadEscrita*3281;
				//JOptionPane.showMessageDialog(null, "Es l");
				System.out.println("resultado " + resultado);
				txtResultado.setText(""+ formatea.format(resultado) + " ft");	
			}
			if (unidad1.equalsIgnoreCase("Pie") && unidad2.equalsIgnoreCase("Kilometro")) {
				
				double resultado = cantidadEscrita/3281;
				//JOptionPane.showMessageDialog(null, "Es l");
				System.out.println("resultado " + resultado);
				txtResultado.setText(""+ formatea.format(resultado) + " km");	
			}
			if (unidad1.equalsIgnoreCase("Kilometro") && unidad2.equalsIgnoreCase("Pulgada")) {
				
				double resultado = cantidadEscrita*39370;
				//JOptionPane.showMessageDialog(null, "Es l");
				System.out.println("resultado " + resultado);
				txtResultado.setText(""+ formatea.format(resultado) + " in");	
			}
			if (unidad1.equalsIgnoreCase("Pulgada") && unidad2.equalsIgnoreCase("Kilometro")) {
				
				double resultado = cantidadEscrita/39370;
				//JOptionPane.showMessageDialog(null, "Es l");
				System.out.println("resultado " + resultado);
				txtResultado.setText(""+ formatea.format(resultado) + " km");	
			}
			if (unidad1.equalsIgnoreCase("Kilometro") && unidad2.equalsIgnoreCase("MillaNautica")) {
				
				double resultado = cantidadEscrita/1.852;
				//JOptionPane.showMessageDialog(null, "Es l");
				System.out.println("resultado " + resultado);
				txtResultado.setText(""+ formatea.format(resultado) + " km");	
			}
			if (unidad1.equalsIgnoreCase("MillaNautica") && unidad2.equalsIgnoreCase("Kilometro")) {
				
				double resultado = cantidadEscrita*1.852;
				//JOptionPane.showMessageDialog(null, "Es l");
				System.out.println("resultado " + resultado);
				txtResultado.setText(""+ formatea.format(resultado) + " nm");	
			}
			if (unidad1.equalsIgnoreCase("Metro") && unidad2.equalsIgnoreCase("Milla")) {
				
				double resultado = cantidadEscrita/1609;
				//JOptionPane.showMessageDialog(null, "Es l");
				System.out.println("resultado " + resultado);
				txtResultado.setText(""+ formatea.format(resultado) + " mi");	
			}
			if (unidad1.equalsIgnoreCase("Milla") && unidad2.equalsIgnoreCase("Metro")) {
				
				double resultado = cantidadEscrita*1609;
				//JOptionPane.showMessageDialog(null, "Es l");
				System.out.println("resultado " + resultado);
				txtResultado.setText(""+ formatea.format(resultado) + " mts");	
			}
			if (unidad1.equalsIgnoreCase("Metro") && unidad2.equalsIgnoreCase("Yarda")) {
				
				double resultado = cantidadEscrita*1.094;
				//JOptionPane.showMessageDialog(null, "Es l");
				System.out.println("resultado " + resultado);
				txtResultado.setText(""+ formatea.format(resultado) + " yd");	
			}
			if (unidad1.equalsIgnoreCase("Yarda") && unidad2.equalsIgnoreCase("Metro")) {
				
				double resultado = cantidadEscrita/1.094;
				//JOptionPane.showMessageDialog(null, "Es l");
				System.out.println("resultado " + resultado);
				txtResultado.setText(""+ formatea.format(resultado) + " mts");	
			}
			if (unidad1.equalsIgnoreCase("Metro") && unidad2.equalsIgnoreCase("Pie")) {
				
				double resultado = cantidadEscrita*3.281;
				//JOptionPane.showMessageDialog(null, "Es l");
				System.out.println("resultado " + resultado);
				txtResultado.setText(""+ formatea.format(resultado) + " ft");	
			}
			if (unidad1.equalsIgnoreCase("Pie") && unidad2.equalsIgnoreCase("Metro")) {
				
				double resultado = cantidadEscrita/3.281;
				//JOptionPane.showMessageDialog(null, "Es l");
				System.out.println("resultado " + resultado);
				txtResultado.setText(""+ formatea.format(resultado) + " mts");	
			}
			if (unidad1.equalsIgnoreCase("Metro") && unidad2.equalsIgnoreCase("Pulgada")) {
				
				double resultado = cantidadEscrita*39.37;
				//JOptionPane.showMessageDialog(null, "Es l");
				System.out.println("resultado " + resultado);
				txtResultado.setText(""+ formatea.format(resultado) + " in");	
			}
			if (unidad1.equalsIgnoreCase("Pulgada") && unidad2.equalsIgnoreCase("Metro")) {
				
				double resultado = cantidadEscrita/39.37;
				//JOptionPane.showMessageDialog(null, "Es l");
				System.out.println("resultado " + resultado);
				txtResultado.setText(""+ formatea.format(resultado) + " mts");	
			}
			if (unidad1.equalsIgnoreCase("Metro") && unidad2.equalsIgnoreCase("MillaNautica")) {
				
				double resultado = cantidadEscrita/1852;
				//JOptionPane.showMessageDialog(null, "Es l");
				System.out.println("resultado " + resultado);
				txtResultado.setText(""+ formatea.format(resultado) + " nm");	
			}
			if (unidad1.equalsIgnoreCase("MillaNautica") && unidad2.equalsIgnoreCase("Metro")) {
				
				double resultado = cantidadEscrita*1852;
				//JOptionPane.showMessageDialog(null, "Es l");
				System.out.println("resultado " + resultado);
				txtResultado.setText(""+ formatea.format(resultado) + " mts");	
			}
			//"Kilometro", "Metro", "Milla", "Yarda", "Pie", "Pulgada", "MillaNautica"
			if (unidad1.equalsIgnoreCase("Milla") && unidad2.equalsIgnoreCase("Yarda")) {
				
				double resultado = cantidadEscrita*1760;
				//JOptionPane.showMessageDialog(null, "Es l");
				System.out.println("resultado " + resultado);
				txtResultado.setText(""+ formatea.format(resultado) + " yd");	
			}
			if (unidad1.equalsIgnoreCase("Yarda") && unidad2.equalsIgnoreCase("Milla")) {
				
				double resultado = cantidadEscrita/1760;
				//JOptionPane.showMessageDialog(null, "Es l");
				System.out.println("resultado " + resultado);
				txtResultado.setText(""+ formatea.format(resultado) + " mi");	
			}
			if (unidad1.equalsIgnoreCase("Milla") && unidad2.equalsIgnoreCase("Pie")) {
				
				double resultado = cantidadEscrita*5280;
				//JOptionPane.showMessageDialog(null, "Es l");
				System.out.println("resultado " + resultado);
				txtResultado.setText(""+ formatea.format(resultado) + " ft");	
			}
			if (unidad1.equalsIgnoreCase("Pie") && unidad2.equalsIgnoreCase("Milla")) {
				
				double resultado = cantidadEscrita/5280;
				//JOptionPane.showMessageDialog(null, "Es l");
				System.out.println("resultado " + resultado);
				txtResultado.setText(""+ formatea.format(resultado) + " mi");	
			}
			if (unidad1.equalsIgnoreCase("Milla") && unidad2.equalsIgnoreCase("Pulgada")) {
				
				double resultado = cantidadEscrita*63360;
				//JOptionPane.showMessageDialog(null, "Es l");
				System.out.println("resultado " + resultado);
				txtResultado.setText(""+ formatea.format(resultado) + " in");	
			}
			if (unidad1.equalsIgnoreCase("Pulgada") && unidad2.equalsIgnoreCase("Milla")) {
				
				double resultado = cantidadEscrita/63360;
				//JOptionPane.showMessageDialog(null, "Es l");
				System.out.println("resultado " + resultado);
				txtResultado.setText(""+ formatea.format(resultado) + " mi");	
			}
			if (unidad1.equalsIgnoreCase("Milla") && unidad2.equalsIgnoreCase("MillaNautica")) {
				
				double resultado = cantidadEscrita/1.151;
				//JOptionPane.showMessageDialog(null, "Es l");
				System.out.println("resultado " + resultado);
				txtResultado.setText(""+ formatea.format(resultado) + " nm");	
			}
			if (unidad1.equalsIgnoreCase("MillaNautica") && unidad2.equalsIgnoreCase("Milla")) {
				
				double resultado = cantidadEscrita*1.151;
				//JOptionPane.showMessageDialog(null, "Es l");
				System.out.println("resultado " + resultado);
				txtResultado.setText(""+ formatea.format(resultado) + " mi");	
			}
			//"Kilometro", "Metro", "Milla", "Yarda", "Pie", "Pulgada", "MillaNautica"
			if (unidad1.equalsIgnoreCase("Yarda") && unidad2.equalsIgnoreCase("Pie")) {
				
				double resultado = cantidadEscrita/3;
				//JOptionPane.showMessageDialog(null, "Es l");
				System.out.println("resultado " + resultado);
				txtResultado.setText(""+ formatea.format(resultado) + " ft");	
			}
			if (unidad1.equalsIgnoreCase("Pie") && unidad2.equalsIgnoreCase("Yarda")) {
				
				double resultado = cantidadEscrita*1.151;
				//JOptionPane.showMessageDialog(null, "Es l");
				System.out.println("resultado " + resultado);
				txtResultado.setText(""+ formatea.format(resultado) + " yd");	
			}
			if (unidad1.equalsIgnoreCase("Yarda") && unidad2.equalsIgnoreCase("Pie")) {
				
				double resultado = cantidadEscrita*3;
				//JOptionPane.showMessageDialog(null, "Es l");
				System.out.println("resultado " + resultado);
				txtResultado.setText(""+ formatea.format(resultado) + " ft");	
			}
			if (unidad1.equalsIgnoreCase("Pie") && unidad2.equalsIgnoreCase("Yarda")) {
				
				double resultado = cantidadEscrita/3;
				//JOptionPane.showMessageDialog(null, "Es l");
				System.out.println("resultado " + resultado);
				txtResultado.setText(""+ formatea.format(resultado) + " yd");	
			}
			if (unidad1.equalsIgnoreCase("Yarda") && unidad2.equalsIgnoreCase("Pulgada")) {
				
				double resultado = cantidadEscrita*36;
				//JOptionPane.showMessageDialog(null, "Es l");
				System.out.println("resultado " + resultado);
				txtResultado.setText(""+ formatea.format(resultado) + " in");	
			}
			if (unidad1.equalsIgnoreCase("Pulgada") && unidad2.equalsIgnoreCase("Yarda")) {
				
				double resultado = cantidadEscrita/36;
				//JOptionPane.showMessageDialog(null, "Es l");
				System.out.println("resultado " + resultado);
				txtResultado.setText(""+ formatea.format(resultado) + " yd");	
			}
			if (unidad1.equalsIgnoreCase("Yarda") && unidad2.equalsIgnoreCase("MillaNautica")) {
				
				double resultado = cantidadEscrita/2025;
				//JOptionPane.showMessageDialog(null, "Es l");
				System.out.println("resultado " + resultado);
				txtResultado.setText(""+ formatea.format(resultado) + " nm");	
			}
			if (unidad1.equalsIgnoreCase("MillaNautica") && unidad2.equalsIgnoreCase("Yarda")) {
				
				double resultado = cantidadEscrita*2025;
				//JOptionPane.showMessageDialog(null, "Es l");
				System.out.println("resultado " + resultado);
				txtResultado.setText(""+ formatea.format(resultado) + " yd");	
			}
			// "Pie", "Pulgada", "MillaNautica"
			
			if (unidad1.equalsIgnoreCase("Pie") && unidad2.equalsIgnoreCase("Pulgada")) {
				
				double resultado = cantidadEscrita*12;
				//JOptionPane.showMessageDialog(null, "Es l");
				System.out.println("resultado " + resultado);
				txtResultado.setText(""+ formatea.format(resultado) + " in");	
			}
			if (unidad1.equalsIgnoreCase("Pulgada") && unidad2.equalsIgnoreCase("Pie")) {
				
				double resultado = cantidadEscrita/12;
				//JOptionPane.showMessageDialog(null, "Es l");
				System.out.println("resultado " + resultado);
				txtResultado.setText(""+ formatea.format(resultado) + " ft");	
			}
			if (unidad1.equalsIgnoreCase("Pie") && unidad2.equalsIgnoreCase("MillaNautica")) {
				double resultado = cantidadEscrita/6076;
				//JOptionPane.showMessageDialog(null, "Es l");
				System.out.println("resultado " + resultado);
				txtResultado.setText(""+ formatea.format(resultado) + " nm");	
			}
			if (unidad1.equalsIgnoreCase("MillaNautica") && unidad2.equalsIgnoreCase("Pie")) {
				
				double resultado = cantidadEscrita*6076;
				//JOptionPane.showMessageDialog(null, "Es l");
				System.out.println("resultado " + resultado);
				txtResultado.setText(""+ formatea.format(resultado) + " ft");
			}
			if (unidad1.equalsIgnoreCase("Pulgada") && unidad2.equalsIgnoreCase("MillaNautica")) {
				double resultado = cantidadEscrita/72910;
				//JOptionPane.showMessageDialog(null, "Es l");
				System.out.println("resultado " + resultado);
				txtResultado.setText(""+ formatea.format(resultado) + " nm");	
			}
			if (unidad1.equalsIgnoreCase("MillaNautica") && unidad2.equalsIgnoreCase("Pulgada")) {
				
				double resultado = cantidadEscrita*72910;
				//JOptionPane.showMessageDialog(null, "Es l");
				System.out.println("resultado " + resultado);
				txtResultado.setText(""+ formatea.format(resultado) + " in");
			}
			
		}else {
			JOptionPane.showMessageDialog(null, "Al ser iguales UM seleccionadas, el valor a calcular siempre sera igual al valor ingresado."
					+ " Por favor seleccione otro UM para calcular");
			limpiar();
		}
		
		
		
	}
	private void limpiar() {
		txtCantidad.setText("");
		txtResultado.setText("");
		txtCantidad.requestFocus();
		
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

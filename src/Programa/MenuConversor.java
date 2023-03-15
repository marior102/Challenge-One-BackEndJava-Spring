package Programa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class MenuConversor extends JFrame {

	/**
	 * Este es el menu principal, decargamos el Plugins de Jframe para poder disenhar el formulario.
	 * LEs muestro ahora el disenho
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuConversor frame = new MenuConversor();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	
	
	
	
	
/**
	 * Create the frame.
	 */
	public MenuConversor() {
		setTitle("Programa de Conversor - Menu Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 321);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setForeground(new Color(102, 51, 153));
		panel.setBounds(0, 0, 434, 282);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblConversorMonedas = new JLabel("");
		lblConversorMonedas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ConversorMonedas cm = new ConversorMonedas();
				cm.setVisible(true);
				dispose();
			}
		});
		
		lblConversorMonedas.setLabelFor(lblConversorMonedas);
		
		lblConversorMonedas.setBounds(26, 76, 158, 137);
		ImageIcon icoMon = new ImageIcon(getClass().getResource("/Imagenes/converter.jpg"));
		ImageIcon imgMon = new ImageIcon(icoMon.getImage().getScaledInstance(lblConversorMonedas.getWidth(), lblConversorMonedas.getHeight(), Image.SCALE_SMOOTH));
		lblConversorMonedas.setIcon(imgMon);
		lblConversorMonedas.setToolTipText("Para convertir monedas");
		panel.add(lblConversorMonedas);
		
		
		JLabel lblConversorLongitud = new JLabel("");
		lblConversorLongitud.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ConversorUnidadMedida cu = new ConversorUnidadMedida();
				cu.setVisible(true);
				dispose();
			}
			public void mouseEntered(MouseEvent es) {
				/*ImageIcon icoLon = new ImageIcon(getClass().getResource("/Imagenes/Longitud2.png"));
				ImageIcon imgLon = new ImageIcon(icoLon.getImage().getScaledInstance(lblConversorLongitud.getWidth(), lblConversorLongitud.getHeight(), Image.SCALE_SMOOTH));
				lblConversorLongitud.setIcon(imgLon);*/
				
			}
		});
		
		lblConversorLongitud.setBounds(235, 76, 158, 137);
		ImageIcon icoLon = new ImageIcon(getClass().getResource("/Imagenes/Longitud.png"));
		ImageIcon imgLon = new ImageIcon(icoLon.getImage().getScaledInstance(lblConversorLongitud.getWidth(), lblConversorLongitud.getHeight(), Image.SCALE_SMOOTH));
		lblConversorLongitud.setIcon(imgLon);
		lblConversorLongitud.setToolTipText("Para convertir Longitudes");
		panel.add(lblConversorLongitud);
		
		JLabel lblSeleccioneTipo = new JLabel("Seleccione tipo de Conversion");
		lblSeleccioneTipo.setForeground(Color.BLACK);
		lblSeleccioneTipo.setFont(new Font("Papyrus", Font.BOLD, 17));
		lblSeleccioneTipo.setBounds(81, 38, 307, 27);
		panel.add(lblSeleccioneTipo);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salir();
			}
			
		});
		btnSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Exit.png")));
		btnSalir.setFont(new Font("Roboto Black", Font.BOLD | Font.ITALIC, 11));
		btnSalir.setBorder(null);
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setBounds(315, 224, 119, 57);
		panel.add(btnSalir);
			
	}


		private void salir() {
			
	
	
		Object[] opciones = {"si", "no"};
		int ret = JOptionPane.showOptionDialog(this, "Desea salir?", "Pregunta", JOptionPane.YES_NO_OPTION,
		        JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
		if (ret == JOptionPane.YES_NO_OPTION) {
			dispose();
			
			//System.exit(0);
		    
		}

}
}


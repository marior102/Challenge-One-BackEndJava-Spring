package controlador;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Vista.MenuConversor2;
import Vista.PanelLongitud;
import Vista.PanelMoneda;


public class ControlFormularioMenu implements ActionListener {
	MenuConversor2 menuPrincipal;
	PanelLongitud conversorUnidad;
	PanelMoneda conversorMoneda;
	
	public final void eventos() {
		menuPrincipal.btnInicio.addActionListener(this);
		menuPrincipal.btnMoneda.addActionListener(this);
		menuPrincipal.btnUnidades.addActionListener(this);
		menuPrincipal.btnSalir.addActionListener(this);
	}
	 public ControlFormularioMenu(MenuConversor2 menuPrincipal){
	        this.menuPrincipal=menuPrincipal;
	        eventos();
	        
	        /*inicializamos los respectivos objetos pertenecientes a la clase JPanel*/
	        conversorMoneda = new PanelMoneda();
	        conversorUnidad = new PanelLongitud();
	       
	    }
	 public void addPanel(JPanel panel){
	        
	        GridBagConstraints  gridBagConstraints = new java.awt.GridBagConstraints();
	        gridBagConstraints.gridx = 0;
	        gridBagConstraints.gridy = 0;
	        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
	        gridBagConstraints.weightx = 1.0;
	        gridBagConstraints.weighty = 1.0;
	        menuPrincipal.panelOperaciones.add(panel, gridBagConstraints);
	                
	    }
	 public void visualizarPanel(String nombrePanel){
	        
	        /*trabamos con la estructura de control switch*/
	        switch (nombrePanel){
	            
	            case "Inicio":
	                menuPrincipal.panelInicio.setVisible(true);  
	                conversorMoneda.setVisible(false);
	                conversorUnidad.setVisible(false);
	        
	            break;
	            
	            case "Moneda":
	            	conversorMoneda.setVisible(true);
	            	menuPrincipal.panelInicio.setVisible(false);
	                conversorUnidad.setVisible(false);
	            break;
	            
	            case "Longitud":
	            	conversorUnidad.setVisible(true);
	            	menuPrincipal.panelInicio.setVisible(false);
	                conversorMoneda.setVisible(false);
	                
	            break;
	            
	     
	            
	            default:
	                JOptionPane.showMessageDialog(null, "Opcion Invalida", "Error", JOptionPane.ERROR_MESSAGE);
	                menuPrincipal.panelInicio.setVisible(true);
	                conversorMoneda.setVisible(false);
	                conversorUnidad.setVisible(false);
	            break;
	        }
	    
	    }
	 
	 @Override
	    public void actionPerformed(ActionEvent e) {

	        Object evt = e.getSource();
	        
	        /*Condicionales pertenecientes a los botonees del menu principal
	        dependiendo el boton seleccionado se ejecutaran las lineas de codigo dentro
	        de los respectivos condicionales*/
	        
	        if(evt.equals(menuPrincipal.btnInicio)){
	            
	            //llamamos al metodo addPanel y lo agregamos al JPanel padre de nuestra vista
	            addPanel(menuPrincipal.panelInicio);
	            visualizarPanel("Inicio");
	            
	            //agregamos una barra de desplzamiento a el nuevo JPanel 
	            menuPrincipal.barraDesplazamientoPanelOperaciones.setViewportView(menuPrincipal.panelInicio);
	            menuPrincipal.panelOperaciones.validate();
	            
	        }else if(evt.equals(menuPrincipal.btnMoneda)){
	            
	            addPanel(conversorMoneda);
	       
	            visualizarPanel("Moneda");
	            menuPrincipal.barraDesplazamientoPanelOperaciones.setViewportView(conversorMoneda);
	            menuPrincipal.panelOperaciones.validate();
	        
	        }else if(evt.equals(menuPrincipal.btnUnidades)){
	            
	            addPanel(conversorUnidad);
	            visualizarPanel("Longitud");
	            menuPrincipal.barraDesplazamientoPanelOperaciones.setViewportView(conversorUnidad);
	            menuPrincipal.panelOperaciones.validate();
	        
	        }else if(evt.equals(menuPrincipal.btnSalir)){
	            
	            /*confirmamos si deseamos salir de la aplicación haciendo uso del metodo 
	            showConfirmDialog de la clase JOptionPane*/
	            
	            int confirmar = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea salir?", "Alerta", JOptionPane.INFORMATION_MESSAGE);
	            if(confirmar==JOptionPane.YES_OPTION){
	                System.exit(0);
	            }
	        }
	        
	        
	        
	    }
	

}

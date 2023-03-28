package controlador;

import Vista.MenuConversor2;

public class mainPrincipal {
	public static void main(String[] args) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(MenuConversor2.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}

		MenuConversor2 Principal = new MenuConversor2();
		Principal.setVisible(true);
	}

	//javac mainPrincipal.java
}
	

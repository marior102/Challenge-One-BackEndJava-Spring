package controlador;
import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

public class ColocarImagenATabla extends DefaultTableCellRenderer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Border BORDER = BorderFactory.createLineBorder(Color.BLACK);
	public Component getTableCellRendererComponent(JTable table, Object value,
	       
			boolean isSelected, boolean hasFocus, int row, int column) {
		 
	        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value,
	            isSelected, hasFocus, row, column);
	        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	        ((JComponent) c).setBorder(BORDER);
	        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	        label.setBorder(new EmptyBorder(0, 5, 0, 5));
	        if (value instanceof Icon) {
	            label.setIcon((Icon) value);
	            label.setText("");
	        } else {
	            label.setIcon(null);
	            label.setText(value == null ? "" : value.toString());
	        }
	        return label;
	    }
	
	

}

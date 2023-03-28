package controlador;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

public class EncabezadoTabla extends JTableHeader {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EncabezadoTabla(TableColumnModel columnModel) {
        super(columnModel);
        setPreferredSize(new Dimension(100, 30));
    }
    
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(Color.WHITE); // establecer color de fondo del encabezado
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.setColor(Color.BLACK); // establecer color de texto del encabezado
        g2.setFont(new Font("Arial", Font.BOLD, 12)); // establecer fuente del encabezado
        JTable table = getTable();
        TableColumnModel columnModel = table.getColumnModel();
        int columnCount = columnModel.getColumnCount();
        for (int i = 0; i < columnCount; i++) {
            int columnWidth = columnModel.getColumn(i).getWidth();
            g2.drawString(columnModel.getColumn(i).getHeaderValue().toString(), i * columnWidth, getHeight() - 5);
        }
        g2.dispose();
    }
    
 
}


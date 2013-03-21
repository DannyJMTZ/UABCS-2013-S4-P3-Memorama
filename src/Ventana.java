import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Ventana extends JFrame{
	
	private Controlador controlador;
	
	public Ventana(int x, int y, int dificultad, String usuario) {
		
		controlador = new Controlador( x , y , dificultad , usuario);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout( null );
		this.getContentPane().setBackground( Color.DARK_GRAY );
		this.setIconImage( Toolkit.getDefaultToolkit().getImage("img/19.png"));
		this.setLayout( new BorderLayout() );
		this.setSize( 690, 710 );
		this.setTitle("Memorama");
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		this.add( controlador.getPanelBotones(), BorderLayout.CENTER );
		this.add( controlador.getPanelInfo(), BorderLayout.NORTH);
		this.add( controlador.getPanelSouth(), BorderLayout.SOUTH );
		this.repaint();
	}
	
	public Controlador getControlador(){ return controlador; }
	
}

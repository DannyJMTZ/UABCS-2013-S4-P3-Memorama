import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;


public class DButton extends JButton{
	
	
	public DButton(){
		
		this.setFocusable(false);
		this.setBorderPainted(false);
		this.setBackground( Color.DARK_GRAY );
		//this.setBackground( new Color(0,0,0,200));
		this.setForeground( Color.LIGHT_GRAY );
		
		Font fuente = new Font("Corbel", this.getFont().getStyle() , 30);
		this.setFont(fuente);
		
	}
	
	
	
}

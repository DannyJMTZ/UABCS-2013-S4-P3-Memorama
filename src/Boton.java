import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

// MODELO
public class Boton extends JButton{
	
	private int imgNumero;
	private boolean volteado;
	private boolean encontrado;
	
	public Boton(int imagen){
		this.setFocusable(false);
		this.setBorderPainted(false);
		this.setBackground( Color.DARK_GRAY );
		this.setIcon(new ImageIcon("img/18.png"));
		this.imgNumero = imagen;
		volteado = false;
		encontrado = false;
	}
	
	public Boton getBoton(){ return this; }
	public boolean getVolteado(){ return volteado; }
	public boolean getEncontrado(){ return encontrado; }
	public int getImgNumero(){ return imgNumero; }
	
	public void setVolteado(boolean volteado){ this.volteado = volteado; }
	public void setEncontrado(boolean encontrado){ this.encontrado = encontrado; }
	public void voltearArriba(){ 
		this.setIcon(new ImageIcon("img/" + imgNumero + ".png"));
		this.volteado = true;
	}
	public void voltearAbajo() { 
		this.setIcon(new ImageIcon("img/18.png"));
		this.volteado = false;
	}
	
	
}

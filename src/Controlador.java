import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Controlador implements MouseListener, Runnable, ActionListener{
	
	private Boton[][] botones;
	private JPanel panelBotones;
	private JPanel panelInfo;
	private JPanel panelSouth;
	private DButton juegoIcono;
	private DButton usuario;
	private DButton tiempo;
	private DButton score;
	private DButton dif;
	private DButton mult;
	private int multiplicador;
	private boolean gameOver = false;
	private Thread crono;
	private int dificultad;
	private int segundos = 0, minutos = 0;
	private javax.swing.Timer timer;
	
	public Controlador(int x, int y, int dificultad, String usuario){
		
		this.dificultad = dificultad;
		this.multiplicador = 1;
		 timer = new javax.swing.Timer( 0 , this);

		String dif = "";
		
		switch(dificultad){
		case 1:
			dif = "Fácil";
			break;
		case 2:
			dif = "Intermedio";
			break;
		case 3:
			dif = "Avanzado";
			break;
		}
		
		panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout( x , y ));
		
		panelInfo = new JPanel();
		panelInfo.setLayout(new GridLayout( 1, 3 ));
		
		panelSouth = new JPanel();
		panelSouth.setLayout(new GridLayout( 1 , 3 ));
		
		juegoIcono = new DButton();
		this.usuario = new DButton();
		tiempo = new DButton();
		score = new DButton();
		this.dif = new DButton();
		this.mult = new DButton();
		
		juegoIcono.setIcon( new ImageIcon("img/19.png") );
		this.usuario.setText(usuario);
		this.dif.setText(dif);
		
		Font fuente = new Font("Tahoma", score.getFont().getStyle() , 35);
		score.setText("0");
		score.setFont(fuente);
		tiempo.setFont(fuente);
		mult.setText("x1");
		mult.setFont(fuente);
		
		panelInfo.add(this.dif);
		panelInfo.add(tiempo);
		panelInfo.add(this.usuario);
		
		panelSouth.add(juegoIcono);
		panelSouth.add(score);
		panelSouth.add(mult);
		
		botones = new Boton[x][y];
		
		java.util.Random random = new java.util.Random();
		int azar;
		int p1;
		int p2;
		int repetidos;
		
		// CREA EL PANEL DE BOTONES SEGUN LA DIFICULTAD
		switch(dificultad){
			case 1:
				// escoger al azar cuales serán los 2 pares que contendrá todo el arreglo
				// ir ingresando al azar uno por uno y contar hasta que uno llegue a 18 
				// se dejará de ingresar esa imagen
				
				p1 = random.nextInt(18);
				
				do{
					p2 = random.nextInt(18);
				}while(p2 == p1);
				
				
				for(int x1 = 0; x1 < botones.length; x1++){
					for(int y1 = 0; y1 < botones[x1].length; y1++){
						
						do{
							azar = random.nextInt(2);
							repetidos = 0;
							
							for(int x2 = 0; x2 < botones.length; x2++){
								for(int y2 = 0; y2 < botones[x1].length; y2++){
									
									if(botones[x2][y2] != null && azar == 0 && botones[x2][y2].getImgNumero() == p1)
										repetidos++;
									
									if(botones[x2][y2] != null && azar == 1 && botones[x2][y2].getImgNumero() == p2)
										repetidos++;
									
								}
							}
							
						}while(repetidos >= 18);
						
						if(azar == 0)
							botones[x1][y1] = new Boton(p1);
						
						if(azar == 1)
							botones[x1][y1] = new Boton(p2);
						
						botones[x1][y1].addMouseListener(this);
						panelBotones.add(botones[x1][y1]);
					}
				}
				break;
			case 2:
				
				for(int x1 = 0; x1 < botones.length; x1++){
					for(int y1 = 0; y1 < botones[x1].length; y1++){
						
						do{
							azar = random.nextInt(9);
							repetidos = 0;
							
							for(int x2 = 0; x2 < botones.length; x2++){
								for(int y2 = 0; y2 < botones[x2].length; y2++){
									
									if(botones[x2][y2] != null && botones[x2][y2].getImgNumero() == azar)
										repetidos++;
									
								}
							}
							
						}while(repetidos > 3);
						
						botones[x1][y1] = new Boton(azar);
						
						botones[x1][y1].addMouseListener(this);
						panelBotones.add(botones[x1][y1]);
					}
				}
				
				break;
			case 3:
				
				for(int x1 = 0; x1 < botones.length; x1++){
					for(int y1 = 0; y1 < botones[x1].length; y1++){
						
						do{
							azar = random.nextInt(18);
							repetidos = 0;
							
							for(int x2 = 0; x2 < botones.length; x2++){
								for(int y2 = 0; y2 < botones[x2].length; y2++){
									
									if(botones[x2][y2] != null && botones[x2][y2].getImgNumero() == azar)
										repetidos++;
									
								}
							}
							
						}while(repetidos > 1);
						
						botones[x1][y1] = new Boton(azar);
						
						botones[x1][y1].addMouseListener(this);
						panelBotones.add(botones[x1][y1]);
					}
				}
				break;
		
		}
		
		crono = new Thread(this);
		crono.start();
		timer.start();
	}
	
	public JPanel getPanelBotones(){ return panelBotones; }
	public JPanel getPanelInfo(){ return panelInfo; }
	public JPanel getPanelSouth(){ return panelSouth; }
	public DButton getUsuario(){ return usuario; }
	public DButton getScore(){ return score; }
	public boolean getGameOver(){ return gameOver; }	
	public void setMult(int num){ mult.setText(String.format("x%d", num)); }
	public String getTime(){return String.format("%02d : %02d", minutos, segundos);}
	public javax.swing.Timer getSwingTimer(){return timer;}
	
	public int botonesVolteados(){
		int counter = 0;
		
		for(int x = 0; x < botones.length; x++)
			for(int y = 0; y < botones[x].length; y++){
				
				if(botones[x][y] != null && !botones[x][y].getEncontrado() && botones[x][y].getVolteado())
					counter++;
			}
		
		return counter;
	}
	
	public void run() {
		try{
			for(;;){
				
				if(segundos == 60){
					segundos = 0;
					minutos++;
				}
				
				this.tiempo.setText(String.format("%02d : %02d", minutos, segundos));
				
				if(minutos == 2 && dificultad == 1){
					crono.interrupt();
					gameOver = true;
				}
				
				if(minutos == 2 && segundos == 30 && dificultad == 2){
					crono.interrupt();
					gameOver = true;
				}
				
				if(minutos == 1 && dificultad == 3){
					crono.interrupt();
					gameOver = true;
				}
				
				crono.sleep(1000);
				
				segundos++;
				
			}
		}
		catch(InterruptedException e){

		}
	}
	
	public boolean cartasEncontradas(){
		boolean found = true;
		
		for(int x = 0; x < botones.length; x++){
			for(int y = 0; y < botones[x].length; y++){
				
				if(botones[x][y] != null && !botones[x][y].getEncontrado())
					found = false;
			}
		}
		
		return found;
	}
	
	public void mouseClicked(MouseEvent arg0) { 
		
		Boton btn = ((Boton)arg0.getSource());
		
		/* checar si el boton cliqueado esta "encontrado"
		 * 		si está "encontrado" no se hará nada
		 * si no esta encontrado entonces se hará lo siguiente
		 * 	si no esta volteada la carta la voltea y checa lo siguiente
		 * 		si solo existe una carta volteada no hace nada mas
		 * 			si existen 2 cartas volteadas compara si son iguales
		 * 				si son iguales las pone como encontradas
		 * 				y las deja bocaarriba
		 * 				
		 * 				checar si todas las cartas estan encontradas, entonces finalizar el juego
		 * 			sino
		 * 				las regresa bocaabajo
		 * 				y pone el volteado en false
		 * si esta volteada la carta no hace nada
		 * */
		
		if(!gameOver && !btn.getEncontrado()){
			
			if(!btn.getVolteado()){
				
				btn.voltearArriba();
				
				/*if(this.botonesVolteados() == 2){
					Boton btnAux = null;
					
					for(int x = 0; x < botones.length; x++){
						for(int y = 0; y < botones[x].length; y++){
							
							if(botones[x][y] != null && !botones[x][y].getEncontrado() &&
							   botones[x][y].getVolteado() && botones[x][y] != btn){
								btnAux = botones[x][y];
							}
						}
					}
					
					if(btn.getImgNumero() == btnAux.getImgNumero()){
						btn.setEncontrado(true);
						btnAux.setEncontrado(true);
						
						score.setText(String.valueOf(Integer.parseInt(score.getText()) + (100 * multiplicador)));
						
						this.multiplicador++;
						this.setMult(multiplicador);
						
						if(this.cartasEncontradas()){
							gameOver = true;
							crono.interrupt();
						}
					}
					else{
						
						btn.repaint();
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
						this.multiplicador = 1;
						this.setMult(multiplicador);
						
						btn.voltearAbajo();
						btnAux.voltearAbajo();
						
						
					}
				}*/
				
			}
		}

	}
	
	public void mouseEntered(MouseEvent arg0) { }
	public void mouseExited(MouseEvent arg0) { }
	public void mousePressed(MouseEvent arg0) { }
	public void mouseReleased(MouseEvent arg0) { }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(this.botonesVolteados() == 2){
			
			Boton btn = null;
			for(int x = 0; x < botones.length; x++){
				for(int y = 0; y < botones[x].length; y++){
					
					if(botones[x][y] != null && !botones[x][y].getEncontrado() &&
					   botones[x][y].getVolteado()){
						btn = botones[x][y];
					}
				}
			}
			
			Boton btnAux = null;
			for(int x = 0; x < botones.length; x++){
				for(int y = 0; y < botones[x].length; y++){
					
					if(botones[x][y] != null && !botones[x][y].getEncontrado() &&
					   botones[x][y].getVolteado() && botones[x][y] != btn){
						btnAux = botones[x][y];
					}
				}
			}
			
			if(btn.getImgNumero() == btnAux.getImgNumero()){
				btn.setEncontrado(true);
				btnAux.setEncontrado(true);
				
				score.setText(String.valueOf(Integer.parseInt(score.getText()) + (100 * multiplicador)));
				
				this.multiplicador++;
				this.setMult(multiplicador);
				
				if(this.cartasEncontradas()){
					gameOver = true;
					crono.interrupt();
				}
			}
			else{
				
				try {
					Thread.sleep(750);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				this.multiplicador = 1;
				this.setMult(multiplicador);
				
				btn.voltearAbajo();
				btnAux.voltearAbajo();
				
			}
			
		}
		
	}
	
}

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class VentanaFinal extends JFrame implements MouseListener {
	
	private boolean playAgain;
	private boolean btnNo;
	
	public VentanaFinal(boolean game, String user, int dif, String time ,int puntuacion){
		
		this.setLayout( null );
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("Memorama");
		this.setIconImage( Toolkit.getDefaultToolkit().getImage("img/19.png"));
		this.getContentPane().setBackground( Color.DARK_GRAY );
		
		playAgain = false;
		btnNo = false;
		
		// JUEGO ICONO
		JLabel titulo = new JLabel("Memorama");
		Font fuente = new Font("Corbel", titulo.getFont().getStyle(), 30);
		titulo.setForeground( Color.LIGHT_GRAY );
		titulo.setFont(fuente);
		titulo.setBounds(180, 20, 200, 50);
		
		JLabel iconoJuego = new JLabel();
		iconoJuego.setIcon(new ImageIcon("img/20.png"));
		iconoJuego.setBounds(185, 80, 130, 130);
		
		// GANO O PERDIO
		JLabel gameWL;
		
		if(game)
			gameWL = new JLabel("Ganaste");
		else
			gameWL = new JLabel("Perdiste");
		fuente = new Font("Corbel", gameWL.getFont().getStyle(), 30);
		gameWL.setForeground( Color.LIGHT_GRAY );
		gameWL.setFont(fuente);
		gameWL.setBounds(190, 250, 200, 50);
		
		// USUARIO
		JLabel usuarioPrompt = new JLabel("Nombre:");
		fuente = new Font("Corbel", usuarioPrompt.getFont().getStyle(), 30);
		usuarioPrompt.setForeground( Color.LIGHT_GRAY );
		usuarioPrompt.setFont(fuente);
		usuarioPrompt.setBounds(130, 300, 200, 50);
		
		JLabel usuario = new JLabel(user);
		fuente = new Font("Corbel", usuario.getFont().getStyle(), 30);
		usuario.setForeground( Color.LIGHT_GRAY );
		usuario.setFont(fuente);
		usuario.setBounds(260, 300, 200, 50);
		
		// DIFICULTAD
		JLabel difPrompt = new JLabel("Dificultad:");
		fuente = new Font("Corbel", difPrompt.getFont().getStyle(), 30);
		difPrompt.setForeground( Color.LIGHT_GRAY );
		difPrompt.setFont(fuente);
		difPrompt.setBounds(112, 340, 200, 50);
		
		JLabel dificultad = new JLabel();
		if(dif == 1) { dificultad.setText("Fácil");}
		if(dif == 2) { dificultad.setText("Intermedio");}
		if(dif == 3) { dificultad.setText("Avanzado");}
		
		fuente = new Font("Corbel", dificultad.getFont().getStyle(), 30);
		dificultad.setForeground( Color.LIGHT_GRAY );
		dificultad.setFont(fuente);
		dificultad.setBounds(260, 340, 200, 50);
		
		
		// TIEMPO
		JLabel tiempoPrompt = new JLabel("Tiempo:");
		fuente = new Font("Corbel", tiempoPrompt.getFont().getStyle(), 30);
		tiempoPrompt.setForeground( Color.LIGHT_GRAY );
		tiempoPrompt.setFont(fuente);
		tiempoPrompt.setBounds(138, 380, 200, 50);
		
		JLabel tiempo = new JLabel(time);
		fuente = new Font("Corbel", tiempo.getFont().getStyle(), 30);
		tiempo.setForeground( Color.LIGHT_GRAY );
		tiempo.setFont(fuente);
		tiempo.setBounds(260, 380, 200, 50);
		
		// SCORE
		JLabel scorePrompt = new JLabel("Score:");
		fuente = new Font("Corbel", scorePrompt.getFont().getStyle(), 30);
		scorePrompt.setForeground( Color.LIGHT_GRAY );
		scorePrompt.setFont(fuente);
		scorePrompt.setBounds(165, 420, 200, 50);
		
		JLabel score = new JLabel("" + puntuacion);
		fuente = new Font("Corbel", usuario.getFont().getStyle(), 30);
		score.setForeground( Color.LIGHT_GRAY );
		score.setFont(fuente);
		score.setBounds(260, 420, 200, 50);
		
		// JUGAR OTRA VEZ SI NO
		JLabel playPrompt = new JLabel("Desea Jugar Otra Vez");
		fuente = new Font("Corbel", scorePrompt.getFont().getStyle(), 30);
		playPrompt.setForeground( Color.LIGHT_GRAY );
		playPrompt.setFont(fuente);
		playPrompt.setBounds(100, 460, 300, 50);
		
		DButton btnSi = new DButton();
		btnSi.setText("Si");
		btnSi.setBounds(150, 500, 100, 80);
		
		DButton btnNo = new DButton();
		btnNo.setText("No");
		btnNo.setBounds(250, 500, 100, 80);
		
		btnSi.addMouseListener(this);
		btnNo.addMouseListener(this);
		
		// AGREGAR TODO AL JFRAME
		this.add(titulo);
		this.add(iconoJuego);
		this.add(gameWL);
		this.add(usuarioPrompt);
		this.add(usuario);
		this.add(difPrompt);
		this.add(dificultad);
		this.add(tiempoPrompt);
		this.add(tiempo);
		this.add(scorePrompt);
		this.add(score);
		this.add(playPrompt);
		this.add(btnSi);
		this.add(btnNo);
		
	}
	
	public boolean getPlayAgain(){ return playAgain; }
	public boolean getBtnNo(){ return btnNo; }
	
	public void mouseClicked(MouseEvent arg0) { 
		
		if(((DButton)arg0.getSource()).getText().equalsIgnoreCase("Si"))
			playAgain = true;
		
		if(((DButton)arg0.getSource()).getText().equalsIgnoreCase("No"))
			btnNo = true;
		
	}
	public void mouseEntered(MouseEvent arg0) { }
	public void mouseExited(MouseEvent arg0) { }
	public void mousePressed(MouseEvent arg0) { }
	public void mouseReleased(MouseEvent arg0) { }
	
}

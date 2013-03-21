import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class VentanaIntro extends JFrame implements ActionListener{
	
	private JTextField usuario;
	private boolean start;
	private int dificultad;
	
	public VentanaIntro(){
		start = false;
		dificultad = 1;
		
		this.setLayout( null );
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("Memorama");
		this.setIconImage( Toolkit.getDefaultToolkit().getImage("img/19.png"));
		this.getContentPane().setBackground( Color.DARK_GRAY );
		
		JLabel iconoJuego = new JLabel();
		iconoJuego.setIcon(new ImageIcon("img/20.png"));
		iconoJuego.setBounds(185, 80, 130, 130);
		
		JLabel titulo = new JLabel("Memorama");
		Font fuente = new Font("Corbel", titulo.getFont().getStyle(), 30);
		titulo.setForeground( Color.LIGHT_GRAY );
		titulo.setFont(fuente);
		titulo.setBounds(180, 30, 200, 50);
		
		
		// USUARIO
		JLabel usuarioPrompt = new JLabel("Nombre");
		fuente = new Font("Corbel", usuarioPrompt.getFont().getStyle(), 30);
		usuarioPrompt.setForeground( Color.LIGHT_GRAY );
		usuarioPrompt.setFont(fuente);
		usuarioPrompt.setBounds(80, 300, 200, 50);
		
		usuario = new JTextField();
		usuario.setBackground( Color.DARK_GRAY );
		usuario.setForeground( Color.LIGHT_GRAY );
		fuente = new Font("Corbel", usuario.getFont().getStyle(), 30);
		usuario.setFont(fuente);
		usuario.setBounds(230, 300, 200, 50);
		
		// RADIOBUTTONS DE LAS DIFICULTADES
		JLabel difPrompt = new JLabel("Dificultades");
		fuente = new Font("Corbel", difPrompt.getFont().getStyle(), 30);
		difPrompt.setForeground( Color.LIGHT_GRAY );
		difPrompt.setFont(fuente);
		difPrompt.setBounds(40, 417, 200, 50);
		
		JRadioButton facil = new JRadioButton("Fácil", true);
		JRadioButton intermedio = new JRadioButton("Intermedio", false);
		JRadioButton avanzado = new JRadioButton("Avanzado", false);
		
		facil.setBounds(230, 400, 150, 30);
		facil.setFocusable(false);
		facil.setBorderPainted(false);
		facil.setBackground(Color.DARK_GRAY);
		facil.setForeground(Color.LIGHT_GRAY);
		fuente = new Font("Corbel", facil.getFont().getStyle(), 20);
		facil.setFont(fuente);
		
		intermedio.setBounds(230, 430, 150, 30);
		intermedio.setFocusable(false);
		intermedio.setBorderPainted(false);
		intermedio.setBackground(Color.DARK_GRAY);
		intermedio.setForeground(Color.LIGHT_GRAY);
		fuente = new Font("Corbel", intermedio.getFont().getStyle(), 20);
		intermedio.setFont(fuente);
		
		avanzado.setBounds(230, 460, 150, 30);
		avanzado.setFocusable(false);
		avanzado.setBorderPainted(false);
		avanzado.setBackground(Color.DARK_GRAY);
		avanzado.setForeground(Color.LIGHT_GRAY);
		fuente = new Font("Corbel", avanzado.getFont().getStyle(), 20);
		avanzado.setFont(fuente);
		
		// AGRUPA LOS RADIOBUTTONS
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(facil);
		btnGroup.add(intermedio);
		btnGroup.add(avanzado);
		
		DButton start = new DButton();
		start.setBounds(190, 500, 100, 50);
		start.setText("Start");
		
		facil.addActionListener(this);
		intermedio.addActionListener(this);
		avanzado.addActionListener(this);
		start.addActionListener(this);
		
		this.add(titulo);
		this.add(iconoJuego);
		this.add(usuarioPrompt);
		this.add(usuario);
		this.add(difPrompt);
		this.add(facil);
		this.add(intermedio);
		this.add(avanzado);
		this.add(start);
		
	}
	
	public String getUsuario(){ return usuario.getText(); }
	public int getDificultad(){ return dificultad; }
	public boolean getStart(){ return start; }
	
	public void actionPerformed(ActionEvent arg0) { 
		
		if(arg0.getActionCommand().equalsIgnoreCase("fácil"))
			dificultad = 1;
		if(arg0.getActionCommand().equalsIgnoreCase("intermedio"))
			dificultad = 2;
		if(arg0.getActionCommand().equalsIgnoreCase("avanzado"))
			dificultad = 3;
		
		if(arg0.getSource().getClass() == DButton.class)
			start = true;
	}
	
}

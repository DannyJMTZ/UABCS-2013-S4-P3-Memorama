import javax.swing.JFrame;


public class Main {
	
	/* Proyecto Examen
	 * Juego de Memoria
	 * 
	 * El juego consiste en realizar un juego de memoria en modo gráfico con Java, 
	 * el juego contiene 3 Niveles de dificultad, Fácil, Intermedio y Avanzado.
	 * 
	 * Nivel Fácil: contiene más pares de una misma figura para que sea más fácil el encontrarlas.
	 * 
	 * Nivel Intermedio: contiene menos pares de una misma figura para que sea 
	 * un poco más complicado encontrar el par.
	 * 
	 * Nivel Avanzado: contiene 1 par de la misma figura para que el nivel de 
	 * dificultad de encontrar el par sea más complicado.
	 * 
	 * Una vez que las cartas sean las correctas deben permanecer mostrando la figura.
	 * 
	 * El juego contiene una arreglo de 6x6 para colocar las figuras.
	 * 
	 * Cada nivel de dificultad tiene un tiempo distinto para resolver el tablero completo
	 * */
	
	
	public static void main(String[] args) {
		
		JFrame game;
		String usuario;
		int dificultad;
		boolean gameWL;
		int score;
		String time;
		boolean playAgain;
		
		do{
			
			// VENTANA INTRO
			game = new VentanaIntro();
			game.setVisible(true);
		
			while(!((VentanaIntro)game).getStart()){}
			
			usuario = ((VentanaIntro)game).getUsuario();
			dificultad = ((VentanaIntro)game).getDificultad();
			game.dispose();
			
			// VENTANA DEL JUEGO
			game = new Ventana( 6 , 6 , dificultad , usuario);
			game.setVisible(true);
			
			while(!((Ventana)game).getControlador().getGameOver()){}
			
			gameWL = ((Ventana)game).getControlador().cartasEncontradas();
			time = ((Ventana)game).getControlador().getTime();
			score = Integer.parseInt(((Ventana)game).getControlador().getScore().getText());
			((Ventana)game).getControlador().getSwingTimer().stop();
			game.dispose();
			
			// VENTANA FINAL
			game = new VentanaFinal(gameWL , usuario , dificultad, time, score);
			game.setVisible(true);
			
			while(!((VentanaFinal)game).getBtnNo() && !((VentanaFinal)game).getPlayAgain()){}
			playAgain = ((VentanaFinal)game).getPlayAgain();
			game.dispose();
			
		}while(playAgain);
		
	}
}

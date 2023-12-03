package src;

import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class GameManager
{  
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		Vector2 newPosPlayer;
		// Inizializzazione del schermo 
		GamePanel gamePanel = new GamePanel(new JFrame(), new JPanel(), new Vector2(512, 450), "Snes Bomberman");

		// Inizializzazione della mappa
		Map map = new Map("src/Resource/Maps/map_1.png", new Vector2(0, 0), new Vector2(512, 410));
		
		// Inizializzazione del Player 
		Player player = new Player("src/Resource/PlayerSprite/PlayerFront.png", new Vector2(60,100), new Vector2(30, 40));
		
		/*
		  Aggiungiamo degli elementi allo schermo
		  La mappa e il player
		*/
		gamePanel.addToPanel(player.returnLabel());
		gamePanel.addToPanel(map.returnLabel(), map.getPos());

		/*
		*  Movimento
		*/
		newPosPlayer = player.getPos();
		player.moveEntity(player.getPos());

		while (true)
		{	
			// Tasto a destra
			if (Keyboard.isKeyPressed(KeyEvent.VK_D))
				newPosPlayer = (new Vector2(player.getPos().x + player.returnMoveDistance(), player.getPos().y));
			// Tasto in alto
			if (Keyboard.isKeyPressed(KeyEvent.VK_W))
				newPosPlayer = (new Vector2(player.getPos().x ,player.getPos().y - player.returnMoveDistance()));
		
			// Tasto a sinistra
			if (Keyboard.isKeyPressed(KeyEvent.VK_A))
				newPosPlayer = (new Vector2(player.getPos().x - player.returnMoveDistance(), player.getPos().y));
		
			// Tasto in basso
			if (Keyboard.isKeyPressed(KeyEvent.VK_S))
				newPosPlayer = (new Vector2(player.getPos().x, player.getPos().y + player.returnMoveDistance()));
			
			if (map.checkPos(newPosPlayer))
				player.moveEntity(newPosPlayer);
			

			Thread.sleep(60);
		}	

	}

	//Testing
	private static void PrintPos(Vector2 pos) {
		System.out.println(" x :   ");
		System.out.println(String.valueOf(pos.x));
		System.out.println(" y :   ");
		System.out.println(String.valueOf(pos.y));
	}

	private static void PrintSize(Vector2 pos, double x, double y) 
	{
		System.out.println("pos :   ");
		System.out.println(String.valueOf(pos.x));
		System.out.println(String.valueOf(pos.y));
		System.out.println("size x :   ");
		System.out.println(String.valueOf(x));
		System.out.println("size y :   ");
		System.out.println(String.valueOf(y));
	}

}  
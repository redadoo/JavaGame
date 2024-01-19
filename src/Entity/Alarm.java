package Src.Entity;

import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import Src.Main.GamePanel;
import Src.Title.Title;
import Src.lib.Vector2;


/**
 * Class for the Alarms
 */
public class Alarm extends Entity
{

	private int			frameCount;
	private Boolean		haveTunnel;
	private GamePanel	gp;
	/**
	 * Costructor class Alarm
	 * @param SpritePath the path of all sprites
	 * @param pos the pos to set the entity
	 * @param size the size for the entity
	*/
	public Alarm (GamePanel gp,Vector2 pos, Vector2 size, Boolean haveTunnel)
	{
		super(pos,size);
		this.gp = gp;
		this.haveTunnel = haveTunnel;
		initAlarm();
	}

	/**
	 * Method to init all alarms
	*/
	public void initAlarm()
	{
		try {
			spriteList.add(ImageIO.read(getClass().getResourceAsStream("/Resource/Alarms/sprite_0.png")));
			spriteList.add(ImageIO.read(getClass().getResourceAsStream("/Resource/Alarms/sprite_1.png")));
			spriteList.add(ImageIO.read(getClass().getResourceAsStream("/Resource/Alarms/sprite_2.png")));
			spriteList.add(ImageIO.read(getClass().getResourceAsStream("/Resource/Alarms/sprite_3.png")));

			if(haveTunnel)
				spriteList.add(ImageIO.read(getClass().getResourceAsStream("/Resource/FinishTunnel/finishTunnel.png")));

		} catch (IOException e) {
			e.printStackTrace();
		}

		sprite = spriteList.get(spriteIndex);
	}

	/**
	 * Method that update the alarms
	 */
	public void Update()
	{
		if(frameCount % 5 == 0)
		{
			spriteIndex++;
			if (spriteIndex == 4)
				spriteIndex = 0;
			sprite = spriteList.get(spriteIndex);
		}

		frameCount++;
	}

	/**
	 * Method to draws the alarm on the provided Graphics2D object.
	 * @param g2 The Graphics2D object on which the player will be drawn.
	 */
	public void Draw(Graphics2D g2)
	{
		g2.drawImage(sprite, pos.x, pos.y, size.x, size.y, null);
	}

	public Boolean getIsTunnel(){ return haveTunnel; }

	public Title getTitle() { return gp.mapManager.GetTitleFromPos(pos,size);}
	
}
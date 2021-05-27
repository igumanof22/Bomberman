import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
import java.util.ArrayList;
/**
 * The default world is a width of 11, and height of 9, with a scale of 60.  The world places a block in every other cell, and randomly places 20 walls and 3 power ups in the world.
 * 
 * READE ME:
 * Player one starts in the bottom right hand corner and is controlled with the arrow keys and enter.  Player two starts in the opposite corner, and is controlled by wasd and space.
 * No, it is not pixel perfect.  I use cells. =/ To make up for that, I used a cool method (see PowerUp class), my explosions are semi-animated, my graphics are semi-custom, and I
 * used an abstract class (see Bomberman). =]
 * Also, power ups randomly spawn in the world while the game is in play.  This is because I had never played bomberman before and didn't know it wasn't supposed to do that. But it
 * is cool, so I left it.
 * The date throughout says 11/7/11.  I thought it was going to be due om 11/7/11 when I started and I was too lazy to change it afterward.
 * 
 * @author Jeffrey Scott	
 * @version 11/7/11
 */
public class Level extends World
{
    private Random rand = new Random();
    private final int WIDTH = 11, HEIGHT = 9, SCALE = 60;
    /**
     * Constructor for objects of class Level.
     * 
     */
    public Level()
    {  
        super(11, 9, 60); //660, 420, 1
        setBackground("sand.jpg");
        
        setPaintOrder(Explosion.class, Bomberman.class, Wall.class);
        
        for(int i = 1; i < HEIGHT; i += 2)
        {
            for(int j = 1; j < WIDTH; j += 2)
            {
                addObject(new Block(), j, i);
            }
        }
        
        addObject(new PlayerTwo(), 0, 0);
        addObject(new PlayerOne(), WIDTH, HEIGHT);
        
        for(int i = 0; i < 20; i++)
        {
            boolean objectAdded = false;
            int x = rand.nextInt(WIDTH);
            int y = rand.nextInt(HEIGHT);
            while(!objectAdded)
            {
                ArrayList<Object> objs = (ArrayList<Object>) getObjectsAt(x, y, Object.class);
                if(objs.size() <= 0)
                {
                    Wall wall = new Wall();
                    addObject(wall, x, y);
                    objectAdded = true;
                }
                else
                {
                    x = rand.nextInt(WIDTH);
                    y = rand.nextInt(HEIGHT);
                }
            }
        }
        
        PowerUp power = new PowerUp();
        addObject(power, 0, 0);
        power.getImage().clear();
        power.addPowerUp(Speed.class, NumberOfBombs.class, RadiusOfBomb.class);
    }
    
    /**
     * Gets the current scale of the world
     * 
     * @return An int value for the scale of the world (how many pixels per cell)
     */
    public int getScale()
    {
        return SCALE;
    }
}

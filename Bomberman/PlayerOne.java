import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * This is the first player on the board, controlled with the arrow keys and the enter button
 * 
 * @author Jeffrey Scott
 * @version 11/7/11
 */
public class PlayerOne extends Bomberman
{
    private int numBombs = 1, bombRadius = 1, speed = 0, speedCounter = 0; //upgrades
    private boolean firstAct = true;
    private ArrayList<Bomb> bombs;
    
    /**
     * The default constructor for PlayerOne
     */
    public PlayerOne()
    {
        bombs = new ArrayList<Bomb>();
    }
    
    /**
     * Act - do whatever the PlayerOne wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(firstAct)
        {
            firstActCheck();
            firstAct = false;
        }
        
        if(speedCounter <= speed)
        {
            if(Greenfoot.isKeyDown("left"))
            {
                if(canMove(getX() - 1, getY()))
                    setLocation(getX() - 1, getY());
            }
            else if(Greenfoot.isKeyDown("right"))
            {
                if(canMove(getX() + 1, getY()))
                    setLocation(getX() + 1, getY());
            }
            else if(Greenfoot.isKeyDown("up"))
            {
                if(canMove(getX(), getY() - 1))
                    setLocation(getX(), getY() - 1);
            }
            else if(Greenfoot.isKeyDown("down"))
            {
                if(canMove(getX(), getY() + 1))
                    setLocation(getX(), getY() + 1);
            }
            if(Greenfoot.isKeyDown("enter"))
            {
                if(bombs.size() < numBombs)
                {
                    bombs.add(new Bomb(bombRadius));
                    getWorld().addObject(bombs.get(bombs.size() - 1), getX(), getY());
               }
               Greenfoot.delay(3);
            }
    
            if(bombs.size() > 0)
            {
                for(int i = bombs.size() - 1; i >= 0; i--)
                {
                    if(bombs.get(i).isExploded())
                        bombs.remove(i);
                }
            }
            speedCounter++;
        }
        else
            speedCounter = 0;
    }    

    /**
     * Upgrades the number of bombs the player is allowed to drop
     */
    public void upgradeBombNumber()
    {
        numBombs++;
    }
    


    /**
     * Upgrades the radius of the bombs the player drops
     */
    public void upgradeBombRadius()
    {
        bombRadius++;
    }
    


    /**
     * Upgrades the speed of the player
     */
    public void upgradeSpeed()
    {
        if(speed < 200)
            speed += 20;
    }
}

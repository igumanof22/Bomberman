import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * A PowerUp that increases the number of bombs that the player can drop.
 * 
 * @author Jeffrey Scott
 * @version 11/7/11
 */
public class NumberOfBombs  extends PowerUp
{
    /**
     * Act - do whatever the NumberOfBombs wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        getPickedUp();
    }    
    
    /**
     * Determines if there is a Bomberman to pick up the power up, and applies the power up to the first Bomberman
     */
    public void getPickedUp()
    {
        ArrayList<Bomberman> objs = (ArrayList<Bomberman>) getIntersectingObjects(Bomberman.class);
        if(objs.size() > 0)
        {
            applyPowerUp(objs.get(0));
            getWorld().removeObject(this);
        }
    }
    
     /**
     * Applies the power up to the player that picked it up
     */
    public void applyPowerUp(Bomberman player)
    {
        Greenfoot.playSound("pointsup.wav");
        player.upgradeBombNumber();
    }
    
    
}

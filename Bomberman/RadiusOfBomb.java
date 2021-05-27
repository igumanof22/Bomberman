import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Upgrades the radius of the bombs of whichever player picks it up
 * 
 * @author Jeffrey Scott
 * @version 11/7/11
 */
public class RadiusOfBomb  extends PowerUp
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
     * Applies the powerup to whichever player picked it up
     */
    public void applyPowerUp(Bomberman player)
    {
        Greenfoot.playSound("pointsup.wav");
        player.upgradeBombRadius();
    }
}

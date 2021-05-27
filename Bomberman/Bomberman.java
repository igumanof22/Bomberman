import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * An abstract class for Bombermen that defines required methods.
 * 
 * @author Jeffrey Scott
 * @version 11/7/11
 */
public abstract class Bomberman extends Actor
{    
    /**
     * This method determines if the Bomberman can move to the location of x and y.
     * 
     * @param x The x coordinate
     * @param y The y oordinate
     * @return Returns true if the space is available, and false otherwise.
     */
    public boolean canMove(int x, int y)
    {
        ArrayList<Block> blks = (ArrayList<Block>)getWorld().getObjectsAt(x, y, Block.class);
        if(blks.size() != 0)
            return false;
        ArrayList<Bomb> bmbs = (ArrayList<Bomb>)getWorld().getObjectsAt(x, y, Bomb.class);
        if(bmbs.size() != 0)
            return false;
        ArrayList<Wall> walls = (ArrayList<Wall>)getWorld().getObjectsAt(x, y, Wall.class);
        if(walls.size() != 0)
            return false;
        return true;
    }
    
    /**
     * This void method is used by all Bombermen in their FIRST act, and their first act ONLY.  It determines if the
     * world immediately around the player (a radius of 2) is set up in a way that they player can actually participate
     * in the game.  The changes will not occur until the first act has passed.
     */
    public void firstActCheck()
    {
        ArrayList<Wall> objs = (ArrayList<Wall>) getObjectsInRange(2, Wall.class);
        for(int i = 0; i < objs.size(); i++)
            getWorld().removeObject(objs.get(i));
    }
    
    /**
     * Upgrades the number of bombs that the player is allowed to drop
     */
    public void upgradeBombNumber()
    {
        
    }
    
    /**
     * Upgrades the radius of the bombs
     */
    public void upgradeBombRadius()
    {
        
    }
    
    /**
     * Upgrades the speed of the player
     */
    public void upgradeSpeed()
    {
        
    }
}

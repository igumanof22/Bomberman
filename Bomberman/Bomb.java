import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * This class places a bomb in the world that explodes after a set time.
 * 
 * @author Jeffrey Scott
 * @version 11/7/11
 */
public class Bomb extends Actor
{        
    private int timer = 30, bombRadius;
    private boolean isExploded = false;
    
    /**
     * The contuctor for a bomb.  Required the radius of the explosion
     * 
     * @param radius This controls the radius of the explosion (by cell)
     */
    public Bomb(int radius)
    {
        bombRadius = radius;
    }
    
    /**
     * Act - do whatever the PlayerOne wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(timer > 0)
            timer--;
        else
        {
            explode();
        }
    } 
    
    /**
    *This method creates an explosion in the world
    *
    */
    public void explode()
    {
        boolean moveUp = true, moveDown = true, moveLeft = true, moveRight = true;
        getWorld().addObject(new Explosion(), getX(), getY());
        
        for(int i = 1; i <= bombRadius; i++)
        {
            if(canMove(getX() + i, getY()) && moveRight)
                getWorld().addObject(new Explosion(), getX() + i, getY());
            else
                moveRight = false;
            if(objectAt(getX() + i, getY()))
                moveRight = false;
            if(canMove(getX() - i, getY()) && moveLeft)
                getWorld().addObject(new Explosion(), getX() - i, getY());
            else
                moveLeft = false;
            if(objectAt(getX() - i, getY()))
                moveLeft = false;
            if(canMove(getX(), getY() + i) && moveUp)
                getWorld().addObject(new Explosion(), getX(), getY() + i);
            else
                moveUp = false;
            if(objectAt(getX(), getY() + i))
                moveUp = false;
            if(canMove(getX(), getY() - i) && moveDown)
                getWorld().addObject(new Explosion(), getX(), getY() - i);
            else
                moveDown = false;
            if(objectAt(getX(), getY() - i))
                moveDown = false;
        }
        isExploded = true;
        getWorld().removeObject(this);
        Greenfoot.playSound("explosion.wav");
    }
    

    /**This method sees if an object can be added at the specified location
    *
    *@param x The X coordinate to be checked
    *@param y The Y coordinate to be checked
    *
    *@return True if an object can be placed there, false otherwise.
    */
    public boolean canMove(int x, int y)
    {
        ArrayList<Block> blks = (ArrayList<Block>)getWorld().getObjectsAt(x, y, Block.class);
        if(blks.size() != 0)
            return false;
        ArrayList<Bomb> bmbs = (ArrayList<Bomb>)getWorld().getObjectsAt(x, y, Bomb.class);
        if(bmbs.size() != 0)
            return false;
        return true;
    }
    
    /**
     * This method determines if there is an object at the specified location
     * 
     *@param x The X coordinate to be checked
     *@param y The Y coordinate to be checked
     *
     *@return True if an object is present, false otherwise.
     */
    public boolean objectAt(int x, int y)
    {
        ArrayList<Object> objs = (ArrayList<Object>) getWorld().getObjectsAt(x, y, Wall.class);
        if(objs.size() > 0)
            return true;
        objs = (ArrayList<Object>) getWorld().getObjectsAt(x, y, Bomb.class);
        if(objs.size() > 0)
            return true;
        return false;
    }
    
    public boolean isExploded()
    {
        return isExploded;
    }
    
    
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * This class creates an explosion image for a set amount of time that removes all objects at its location
 * 
 * @author Jeffrey Scott
 * @version 11/7/11
 */
public class Explosion extends Actor
{
    private int explosionLength = 12, width = 150, height = 126, scale; //scale is used for animation
    
    /**
     * The default constructor for an explosion.
     */
    public Explosion()
    {
        scale = explosionLength/2;
        
        getImage().scale(width / scale, height / scale);
    }
    
    /**
     * Act - do whatever the Explosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {        
        ArrayList<Object> objs = (ArrayList<Object>) getWorld().getObjectsAt(getX(), getY(), Bomberman.class);
        if(objs.size() > 0)
        {
            for(int i = 0; i < objs.size(); i++)
                getWorld().removeObject((Actor)objs.get(i));
            Greenfoot.stop();
        }
        objs = (ArrayList<Object>) getWorld().getObjectsAt(getX(), getY(), Bomb.class);
        if(objs.size() > 0)
            for(int i = 0; i < objs.size(); i++)
                getWorld().removeObject((Actor)objs.get(i));
        objs = (ArrayList<Object>) getWorld().getObjectsAt(getX(), getY(), Wall.class);
        if(objs.size() > 0)
            for(int i = 0; i < objs.size(); i++)
                getWorld().removeObject((Actor)objs.get(i));
                
        if(explosionLength > 0)
            explosionLength--;
        else
            getWorld().removeObject(this);
            
        if(explosionLength != scale)
        {
            setImage("explosion.png");
            getImage().scale(width / Math.abs((explosionLength - scale)), height / Math.abs((explosionLength - scale)));
        }
    }    
}
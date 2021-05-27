import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
import java.util.ArrayList;
/**
 * This class randomly creates PowerUp subclass objects and puts them in the world.  This must be added to the world to randomly generate power ups.
 * 
 * @author Jeffrey Scott 
 * @version 11/7/11
 */
public class PowerUp  extends Actor
{
    private ArrayList<PowerUp> powerups;
    private int item;
    private Random rand;
    
    /**
     * The default contructor for PowerUp
     */
    public PowerUp()
    {
        rand = new Random();
    }
    
    /**
     * Act - do whatever the PowerUp wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        item = rand.nextInt(1000);//The larger the number, the less often powerups generate.
        if(item == 0)
            addPowerUp(NumberOfBombs.class);
        if(item == 1)
            addPowerUp(RadiusOfBomb.class);
        if(item == 2)
            addPowerUp(Speed.class);
    }   
    
    /**
     * This method, the coolest method in the whole program, adds a new power up object of the default contructor of the specified type
     * 
     * @param- The class of the desired power up.  Uses varargs, any number of classes accepted.
     */
    public void addPowerUp(Class... type)
    {
        for(int i = 0; i < type.length; i++)
        {
            boolean objectAdded = false;
            int x = rand.nextInt(getWorld().getWidth());
            int y = rand.nextInt(getWorld().getHeight());
            while(!objectAdded)
            {
                ArrayList<Object> objs = (ArrayList<Object>) getWorld().getObjectsAt(x, y, Object.class);
                if(objs.size() == 0)
                {
                    Object upgrade = new Object();
                    try 
                    {
                        upgrade = type[i].newInstance() ;
                    }
                    catch ( Exception e )
                    {
                        return;
                    }
                    getWorld().addObject((Actor)upgrade, x, y);
                    objectAdded = true;
                }
                else
                {
                    x = rand.nextInt(getWorld().getWidth());
                    y = rand.nextInt(getWorld().getHeight());
                }
            }
        }
    }
}

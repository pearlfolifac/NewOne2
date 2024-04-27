import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Platform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Platform extends Actor
{
    public Platform()
    {
        getImage().scale(getImage().getWidth()*2,getImage().getHeight());
    }
    /**
     * Act - do whatever the Platform wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("right")||Greenfoot.isKeyDown("d"))
        {
                move(-4);
        }
        
        if(Greenfoot.isKeyDown("left")|| Greenfoot.isKeyDown("a"))
        {
            move(4);
        }
        int x = getX();
        int worldWidth = getWorld().getWidth();
        if (x == 0) {
            setLocation(worldWidth - 1, Greenfoot.getRandomNumber(260) + 300);
        } else if (x >= worldWidth - 1) {
            setLocation(0, Greenfoot.getRandomNumber(260) + 300);
        }
    }    
}
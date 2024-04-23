import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Coin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coin extends Actor
{
    public Coin()
    {
        getImage().scale(getImage().getWidth()/20,getImage().getHeight()/20);
    }
    /**
     * Act - do whatever the Coin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
       if (Greenfoot.isKeyDown("right"))
       {
           move(-4);
       }
       if (Greenfoot.isKeyDown("left"))
       {
           move(4);
       }
       if(getX()==0)
       {
            getWorld().removeObject(this);
       }
    }
}

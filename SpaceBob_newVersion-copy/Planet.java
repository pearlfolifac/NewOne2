import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Planet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Planet extends Actor
{
    /**
     * Act - do whatever the Planet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("right")||Greenfoot.isKeyDown("d"))
        {
            move(-4);
        }
        if(Greenfoot.isKeyDown("left")||Greenfoot.isKeyDown("a"))
        {
            move(4);
        }
        if(getX()==0)
        {
            setLocation(getWorld().getWidth()+491,getWorld().getHeight()+491);
        }
    }
}

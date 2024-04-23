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
        if(Greenfoot.isKeyDown("right"))
        {
            move(-4);
        }
        if(Greenfoot.isKeyDown("left"))
        {
            move(4);
        }
        if(getX()==0)
        {
            setLocation(getWorld().getWidth()-1,Greenfoot.getRandomNumber(196)+353);
        }
    }
}
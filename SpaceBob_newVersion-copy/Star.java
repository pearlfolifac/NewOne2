import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Star here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Star extends Actor
{
    public Star()
    {
        getImage().scale(getImage().getWidth()/60,getImage().getHeight()/60);
    }
    /**
     * Act - do whatever the Star wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("right")||Greenfoot.isKeyDown("d"))
        {
            move(-1);
        }
        if(Greenfoot.isKeyDown("left")||Greenfoot.isKeyDown("a"))
        {
            move(1);
        }
        if(getX()==0)
        {
            setLocation(getWorld().getWidth()-1,Greenfoot.getRandomNumber(170)+30);
        }
    }
}

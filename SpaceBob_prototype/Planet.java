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
        int x = getX();
        int y = getY();
        int worldWidth = getWorld().getWidth();
        
        if (x == 0 || x >= worldWidth - 1) {
            setLocation(750, 750); // Coordonnées x et y fixes
        }
    }
}

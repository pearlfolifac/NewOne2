import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Spike here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spike extends BadGuys
{
    /**
     * Act - do whatever the Spike wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        int x = getX();
        int worldWidth = getWorld().getWidth();
          if (x == 0) {
            setLocation(worldWidth - 1, Greenfoot.getRandomNumber(1) + 623);
        } else if (x >= worldWidth - 1) {
            setLocation(0, Greenfoot.getRandomNumber(1) + 623);
        }
    }
}

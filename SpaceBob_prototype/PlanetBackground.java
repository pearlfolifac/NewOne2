import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlanetBackground here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlanetBackground extends BakgroundDecor
{
    /**
     * Act - do whatever the PlanetBackground wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public PlanetBackground()
    {
        getImage().scale(getImage().getWidth(),getImage().getHeight()/2);
    }
    public void act()
    {
        // Add your action code here.
    }
}

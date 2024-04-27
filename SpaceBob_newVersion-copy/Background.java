import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Background here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Background extends World
{
    /**
     * Constructor for objects of class Background.
     * 
     */
    public Background()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1); 
        prepare();
    }
    
    public void act()
    {
        if(Greenfoot.getRandomNumber(600)<=2)
        {
            addObject(new Coin(), getWidth()-1, Greenfoot.getRandomNumber(277)+343);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Cloud cloud = new Cloud();
        addObject(cloud,247,145);
        cloud.setLocation(311,43);
        Cloud cloud2 = new Cloud();
        addObject(cloud2,614,95);
        cloud2.setLocation(466,134);

        Star star = new Star();
        addObject(star,466,134);
        Star star2 = new Star();
        addObject(star2,865,144);
        Star star3 = new Star();
        addObject(star3,49,82);
        Star star4 = new Star();
        addObject(star4,243,281);
        Star star5 = new Star();
        addObject(star5,667,274);
        Star star6 = new Star();
        addObject(star6,754,43);
        Star star7 = new Star();
        addObject(star7,442,260);
        Star star8 = new Star();
        addObject(star8,311,43);
        Star star9 = new Star();
        addObject(star9,857,233);

        Platform platform = new Platform();
        addObject(platform,172,563);
        Platform platform2 = new Platform();
        addObject(platform2,600,499);

        Planet planet = new Planet();
        addObject(planet,500,738);
        planet.setLocation(490,758);
        Bob bob = new Bob();
        addObject(bob,184,523);
        bob.setLocation(201,469);
        Cloud cloud3 = new Cloud();
        addObject(cloud3,809,76);
        cloud.setLocation(443,119);
        cloud.setLocation(286,66);
        cloud2.setLocation(534,192);
        removeObject(cloud2);
        cloud3.setLocation(668,208);
        star.setLocation(492,112);
        cloud.setLocation(255,127);
        cloud3.setLocation(516,235);
    }
}

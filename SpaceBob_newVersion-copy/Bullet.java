import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    public int speed = 20;
    public void act()
    {
        move(speed);
        removeBullet();
    }
    
    public void removeBullet() {
        Actor wall = getOneIntersectingObject(Platform.class);
        if (wall != null)
        {
            getWorld().removeObject(this);
            
        }
        // Now remove bullet when it's on the edge of screen
        else if(getX() >= getWorld().getWidth() - 1) 
        {
            getWorld().removeObject(this);
        }
    }
}

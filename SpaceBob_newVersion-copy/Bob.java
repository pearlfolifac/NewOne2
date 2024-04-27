import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bob here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bob extends Actor
{
    private int vSpeed = 0;
    private int acceleration = 1;
    private int jumpHeight = -10;
    private int collect = 0;
    boolean TenCoinsCollected = false;
    public Bob()
    {
        getImage().scale(getImage().getWidth()*2,getImage().getHeight()*2);
    }
    
    /**
     * Act - do whatever the Bob wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
       moveAround();
       checkFalling();
       collect();
    }
    
    private void fall()
    {
        setLocation(getX(), getY() + vSpeed);
        vSpeed = vSpeed + acceleration;
    }
    
    public void moveAround ()
    {
       if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d"))
       {
           move(4);
       }
       if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a"))
       {
           move(-4);
       }
       if (Greenfoot.isKeyDown("space") || Greenfoot.isKeyDown("w"))
       {
           vSpeed = jumpHeight;
           fall();
           GreenfootSound jumpSound = new GreenfootSound("jump.wav");
           adjustVolume(jumpSound,70);
           jumpSound.play();
       }
       if (Greenfoot.mouseClicked(null)) {
           getWorld().addObject(new Bullet(), getX(), getY());
           GreenfootSound shootSound = new GreenfootSound("shoot.wav");
           adjustVolume(shootSound,70);
           shootSound.play();
        }
    }
    
    private void adjustVolume(GreenfootSound sound, int volume) {
        sound.setVolume(70);
    }
    
    boolean onGround()
    {
        Actor under = getOneObjectAtOffset(0, getImage().getHeight()/2, Platform.class);
        return under != null;
    }
    
    boolean onPlanet()
    {
        Actor under = getOneObjectAtOffset(0, getImage().getHeight()/2, Planet.class);
        return under != null;
    }
    
    public void checkFalling()
    {
        if (onGround() == false || onPlanet() == false)
        {
            fall();
        }
        if (onGround() == true || onPlanet() == true)
        {
            vSpeed = 0;
        }
    }
    
    public void collect()
    {
        Actor coin = getOneIntersectingObject(Coin.class);
        if(coin != null)
        {
            getWorld().removeObject(coin);
            collect++;
        }
        if(collect == 10 && TenCoinsCollected == false)
        {
            Greenfoot.setWorld(new Background2());
        }
    }
}

import greenfoot.*;

public class Bullet extends Actor {
    public int speed = 20;
    
    public Bullet()
    {
        getImage().scale(getImage().getWidth()/5,getImage().getHeight()/5);
    }
    
    public void act() {
        move(speed);
        removeBullet();
    }
    
    public void removeBullet() {
        // Check for collision with the world edge
        if (getX() >= getWorld().getWidth() - 1) {
            getWorld().removeObject(this);
            return;
        }
        
        // Check for collision with a platform
        Actor wall = getOneIntersectingObject(Platform.class);
        if (wall != null) {
            getWorld().removeObject(this);
            return;
        }
        
        // Check for collision with a minion
        Actor minion = getOneIntersectingObject(Minion.class);
        if (minion != null) {
            Minion m = (Minion)minion;
            m.handleCollision(); // Call a method in Minion to handle the collision
            getWorld().removeObject(this);
        }
    }
}

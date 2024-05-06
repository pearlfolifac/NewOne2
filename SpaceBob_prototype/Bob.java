import greenfoot.*; 
import java.util.List;

public class Bob extends Actor {
    private int vSpeed = 0;
    private int acceleration = 1;
    private int jumpHeight = -10;
    private int collect = 0;
    private int livesCount = 5;
    private boolean isTouchingSpike = false;
    private boolean collisionDetected = false;
    private boolean hasJumped = false;

    public Bob() {
        getImage().scale(getImage().getWidth() * 2, getImage().getHeight() * 2);
    }

    public void act() {
        moveAround();
        checkFalling();
        collect();
    
        if (!isTouchingSpike) {
            hasJumped = false;
        }
        adjustWorldPosition();
        checkCollision(); 
    }
    
    private void adjustWorldPosition() {
        // Get all objects in the world
        List<Actor> objects = getWorld().getObjects(Actor.class);

        // Loop through each object
        for (Actor object : objects) {
            // If the object is not Bob, move it to the left
            if (object != this && !(object instanceof Live) && !(object instanceof PlanetBackground) && !(object instanceof Castle) && !(object instanceof King) && !(object instanceof Mam)) {
                object.move(-3);
            }
        }
    }    

    private void fall() {
        setLocation(getX(), getY() + vSpeed);
        vSpeed = vSpeed + acceleration;
    }

    public void moveAround() {
        if (Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")) {
            move(3);
        }
        
        if (Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")) {
            move(-4);
        }
        
        if (Greenfoot.isKeyDown("space") || Greenfoot.isKeyDown("w")) {
            if (!hasJumped) {
                vSpeed = jumpHeight;
                fall();
                GreenfootSound jumpSound = new GreenfootSound("jump10.wav");
                adjustVolume(jumpSound, 70);
                jumpSound.play();
                hasJumped = true;
            }
        }
        
        if (Greenfoot.mouseClicked(null)) {
            getWorld().addObject(new Bullet(), getX(), getY());
            GreenfootSound shootSound = new GreenfootSound("shoot.wav");
            adjustVolume(shootSound, 70);
            shootSound.play();
        
            // Check for collision with Minion when the bullet is added
            Actor minion = getOneIntersectingObject(Minion.class);
            if (minion != null) {
                // If the bullet intersects with a Minion, remove the Minion
                getWorld().removeObject(minion); // Remove the minion from the world
            }
        }
    }

    private void adjustVolume(GreenfootSound sound, int volume) {
        sound.setVolume(volume);
    }

    boolean onGround() {
        Actor under = getOneObjectAtOffset(0, getImage().getHeight() / 2, Platform.class);
        boolean isOnGround = under != null;
        return isOnGround;
    }
    
    boolean onPlanet() {
        Actor under = getOneObjectAtOffset(0, getImage().getHeight() / 2, Planet.class);
        return under != null;
    }

    public void checkFalling() {
        if (!onGround() && !onPlanet()) {
            fall();
        } else {
            vSpeed = 0;
        }
    }

    public void collect() {
        Actor coin = getOneIntersectingObject(Coin.class);
        if (coin != null) {
            getWorld().removeObject(coin);
            collect++;
            GreenfootSound jumpSound = new GreenfootSound("pickupCoin.wav");
            adjustVolume(jumpSound, 70);
            jumpSound.play();
        }
    }
    private void checkCollision() {
        Actor badGuy = getOneIntersectingObject(BadGuys.class); // Détecter la collision avec un ennemi
        if (badGuy != null && !collisionDetected) { // Vérifier si une collision a été détectée et si Bob n'est pas déjà en collision
            if (badGuy instanceof Minion || badGuy instanceof Spike) {
                loseLife(); // Gérer la perte de vie
                collisionDetected = true; // Marquer la collision comme détectée
                GreenfootSound jumpSound = new GreenfootSound("hurt.wav");
                adjustVolume(jumpSound, 70);
                jumpSound.play();
            }
        } else if (badGuy == null) {
            collisionDetected = false; // Réinitialiser le détecteur de collision si Bob n'est plus en collision avec un ennemi
        }
    }

    private void loseLife() {
        livesCount--;
        removeLive(); // Remove one live heart
        if (livesCount == 0) {
            Greenfoot.setWorld(new Background2());
        }
    }

    private void removeLive() {
        List<Live> hearts = getWorld().getObjects(Live.class);
        if (!hearts.isEmpty()) {
            getWorld().removeObject(hearts.get(hearts.size() - 1)); // Remove the last live heart
        }
    }
}
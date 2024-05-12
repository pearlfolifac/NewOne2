import greenfoot.*; 
import java.util.List;

public class Background extends World {
    private GreenfootSound backgroundMusic;
     private int scrollOffset = 0;
     private int minionSpawnTimer = Greenfoot.getRandomNumber(200) + 100;
    public Background() {    
        super(1000, 800, 1); 
        prepare();
        setupBackgroundMusic();
    }
    
        private void respawnMinions() {
        int numMinions = getObjects(Minion.class).size();
        int maxMinions = 2; // Adjust this value as needed
    
        if (numMinions < maxMinions) {
            addMinions();
        }
    }
    
    public void act() {
     // Appeler les méthodes pour gérer les pièces de monnaie et les minions
    spawnCoins();
    spawnBullets();
    checkMinionRespawn();
    
    // Appeler la méthode act() de la classe parent
    super.act();
    
    // Ajuster la position des acteurs en fonction du défilement
    adjustActorPositions();
    
    minionAddedThisAct = false;
}

private void adjustActorPositions() {
    // Récupérer tous les acteurs dans le monde
    List<Actor> actors = getObjects(Actor.class);
    
    // Ajuster la position de chaque acteur en fonction du défilement
    for (Actor actor : actors) {
        actor.setLocation(actor.getX() - scrollOffset, actor.getY());
    }
    
    // Réinitialiser le décalage de défilement après avoir ajusté tous les objets
    scrollOffset = 0;
}

private boolean minionAddedThisAct = false;

private void checkMinionRespawn() {
    minionSpawnTimer--;
    if (minionSpawnTimer <= 0 && !minionAddedThisAct) {
        addMinions(); // Ajouter un nouveau Minion
        // Réinitialiser le minuteur avec une nouvelle valeur aléatoire
        minionSpawnTimer = Greenfoot.getRandomNumber(600) + 300;
        minionAddedThisAct = true;
    }
}

    
     public void scroll(int amount) {
        scrollOffset += amount;
    }
    
    private Planet getPlanet() {
        List<Planet> planets = getObjects(Planet.class);
        return planets.isEmpty() ? null : planets.get(0);
    }
    
    private Bob getBob() {
        List<Bob> bobs = getObjects(Bob.class);
        return bobs.isEmpty() ? null : bobs.get(0);
    }
        
    private void setupBackgroundMusic() {
        backgroundMusic = new GreenfootSound("background.mp3");
        adjustVolume(backgroundMusic, 50);
        playBackgroundMusic();
    }
    
    private void playBackgroundMusic() {
        if (!backgroundMusic.isPlaying()) {
            backgroundMusic.playLoop();
        }
    }
    
    private void adjustVolume(GreenfootSound sound, int volume) {
        sound.setVolume(volume);
    }
    
    public void stopped() {
        backgroundMusic.stop();
    }
    
    private void prepare() {
        addPlanetBackground();
        addKing();
        addMam();
        addCastle();
        addStars();
        addClouds();
        addPlatforms();
        addPlanet();
        addSpikes();
        addMinions();
        addBob();
        addLives();
        addBulletsDisplayedFirst();
    }
    
    private void addClouds() {
        Cloud cloud1 = new Cloud();
        addObject(cloud1, 311, 43);
        
        Cloud cloud2 = new Cloud();
        addObject(cloud2, 466, 134);
    }
    
    private void addPlanetBackground() {
        PlanetBackground planetbackground = new PlanetBackground();
        addObject(planetbackground, 530, 610);
    }
    
    private void addCastle() {
        Castle castle = new Castle();
        addObject(castle, 523, 533);
    }
    
    private void addMam() {
        Mam mam = new Mam();
        addObject(mam, 516, 539);
    }
    
    private void addKing() {
        King king = new King();
        addObject(king, 531, 539);
    }
    
    private void addStars() {
         Star star1 = new Star();
        addObject(star1, 621, 103);
    
        Star star2 = new Star();
        addObject(star2, 49, 82);
        
        Star star3 = new Star();
        addObject(star3, 320, 260);
        
        Star star4 = new Star();
        addObject(star4, 960, 170);
        
        Star star5 = new Star();
        addObject(star5, 732, 200);
    }
    
    private void addPlatforms() {
        Platform platform1 = new Platform();
        addObject(platform1, 172, 563);
    
        Platform platform2 = new Platform();
        addObject(platform2, 600, 499);
    }
    
    private void addPlanet() {
        Planet planet = new Planet();
        addObject(planet, 490, 758);   
    }
    
    private void addBob() {
        Bob bob = new Bob();
        addObject(bob, 172, 491);
    }
    
    private void addSpikes() {
        Spike spike1 = new Spike();
        addObject(spike1, 184, 626);
        
        Spike spike2 = new Spike();
        addObject(spike2, 925, 626);
    }
    
    private void addMinions() {
         Minion minion1 = new Minion();
    addObject(minion1, getWidth() - 1, 615);
    }
    
    private void addLives() {
        for (int i = 0; i < 5; i++) {
            Live live = new Live();
            addObject(live, 50 + i * 40, 50);
        }
    }
    
    private void addBulletsDisplayedFirst() {
    for (int i = 0; i < 10; i++) {
        BulletDisplayed bulletDisplayed = new BulletDisplayed();
        addObject(bulletDisplayed, 40 + i * 20, 90);
    }
}

    private void spawnCoins() {
        if (Greenfoot.getRandomNumber(600) <= 2) {
            addObject(new Coin(), getWidth() - 1, Greenfoot.getRandomNumber(277) + 343);
        }
    }
    
    private void spawnBullets() {
        if (Greenfoot.getRandomNumber(600) <= 2) {
            addObject(new BulletAppearing(), getWidth() - 1, Greenfoot.getRandomNumber(277) + 343);
        }
    }
}

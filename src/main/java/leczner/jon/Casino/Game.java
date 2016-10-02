package leczner.jon.Casino;

/**
 * Created by jonathanleczner on 10/2/16.
 */
public abstract class Game {
    private String name;
    private int numOfPlayers;
    private boolean running;
    private InputHandler input;

    public boolean isRunning() { return running; }
    public abstract void init();
    public abstract void handleInput();
    public abstract void update();
    public abstract void render();
}

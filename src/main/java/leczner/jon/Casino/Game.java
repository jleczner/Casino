package leczner.jon.Casino;

/**
 * Created by jonathanleczner on 10/2/16.
 */
public abstract class Game extends State {
    private int numOfPlayers;
    private boolean running;
    private InputHandler input;

    public boolean isRunning() { return running; }
    public abstract void init(InputHandler input);
    public abstract void handleInput();
    public abstract void update();
    public abstract void render();
}

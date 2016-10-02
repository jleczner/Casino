package leczner.jon.Casino;

/**
 * Created by jonathanleczner on 10/2/16.
 */
public abstract class State {
    public abstract void init();
    public abstract void handleInput();
    public abstract void update();
    public abstract void render();
}

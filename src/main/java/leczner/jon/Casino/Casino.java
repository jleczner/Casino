package leczner.jon.Casino;

import java.util.List;

/**
 * Created by jonathanleczner on 10/2/16.
 */
public class Casino {
    private WelcomeScreen welcomeScreen;
    private List<Player> players;
    private List<Game> games;
    private Game activeGame;
    private boolean running;

    public Casino() {
        init();
    }

    public boolean isRunning() { return running; }

    public void init() {
        running = true;
        activeGame = welcomeScreen.selectOption();
    }

    public void handleInput() {
        return;
    }

    public void update() {
        return;
    }

    public void render() { return; }

    public void run() { return; }

}

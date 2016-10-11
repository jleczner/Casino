package leczner.jon.Casino;

import java.util.Stack;

/**
 * Created by jonathanleczner on 10/2/16.
 */
public class Casino {
    private static Stack<State> states = new Stack<>();
    private boolean running;

    public Casino() {
        init();
    }

    public boolean isRunning() { return running; }
    public static Stack<State> getStates() { return states; }
    public static void pushState(State s) { states.push(s); }
    public static void popState() { states.pop(); }

    public void init() {
        running = true;
        State welcomeScreen = new WelcomeScreen();
        states.push(welcomeScreen);
    }

    public void handleInput() {
        states.lastElement().handleInput();
    }

    public void update() {
        states.lastElement().update();
    }

    public void render() { states.lastElement().render(); }

    public void run() {
        while (running) {
            handleInput();
            update();
            render();
        }
    }
}

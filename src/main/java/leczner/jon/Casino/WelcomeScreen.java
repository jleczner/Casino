package leczner.jon.Casino;

/**
 * Created by jonathanleczner on 10/2/16.
 */
public class WelcomeScreen extends State {
    private InputHandler input;
    private String output;
    private final String greeting = "Welcome to Hell Casino! We pray on the weak! Please select a game: ";
    private final String options =
            "(1) War" +
            "(2) Blackjack" +
            "(3) Slots";

    public WelcomeScreen() {
        init();
    }

    @Override
    public void init() {
        input = new ScannerInputHandler();
        displayGreeting();
        displayOptions();
        render();
    }

    @Override
    public void handleInput() {
        return;
    }

    @Override
    public void update() {
        return;
    }

    @Override
    public void render() {
        System.out.println(output);
    }

    public void run() {
        return;
    }

    public Game selectOption() { return null; }

    public void displayGreeting() {
        output += greeting;
    }

    public void displayOptions() {
        output += options;
    }
}

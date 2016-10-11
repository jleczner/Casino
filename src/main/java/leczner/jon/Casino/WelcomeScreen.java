package leczner.jon.Casino;

/**
 * Created by jonathanleczner on 10/2/16.
 */
public class WelcomeScreen extends State {
    private InputHandler input;
    private String inputString;
    private String outputString;
    private boolean prompted;
    private boolean playerCreated;
    private Game choice;
    private final String greeting = "Welcome to Hell Casino! We pray on the weak! Enter name:\n";
    private final String difficulty =
            "Choose difficulty:\n" +
            "(1) Easy - $500\n" +
            "(2) Normal - $250\n" +
            "(3) Hard - $100\n";
    private final String options =
            "(1) War\n" +
            "(2) Blackjack\n" +
            "(3) Slots\n";

    public WelcomeScreen() {
        init(new ScannerInputHandler());
    }

    @Override
    public void init(InputHandler input) {
        this.input = input;
        inputString = "";
        outputString = "";
        displayGreeting();
        prompted = false;
        playerCreated = false;
    }

    @Override
    public void handleInput() {
        if (prompted) {
            inputString = input.getInput();
        }
    }

    @Override
    public void update() {
        if (playerCreated) {
            chooseGame();
            switch (inputString) {
                case "1":
                    choice = selectOption(1);
                    break;
                case "2":
                    choice = selectOption(2);
                    break;
                case "3":
                    choice = selectOption(3);
                    break;
                default:
                    break;
            }
            if (choice != null) {
                Casino.pushState(choice);
            }
        } else {
            createPlayer();
        }
    }

    private void createPlayer() {
        Player p = new Player(inputString);
    }

    private void chooseGame() {

    }

    @Override
    public void render() {
        System.out.println(outputString);
        prompted = true;
    }

    public void displayGreeting() {
        outputString += greeting;
    }

    public void displayOptions() {
        outputString += options;
    }

    public Game selectOption(int option) {
        switch (option) {
            case 1:
                return new War();
            case 2:
                return new Blackjack();
            case 3:
                return new Slots();
            default: // shouldn't reach
                return null;
        }
    }
}

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
    private boolean difficultySet;
    private Game choice;

    private final String greeting = "Welcome to Hell Casino! We pray on the weak! Enter name:\n";
    private final String difficulty =
            "Choose difficulty:\n" +
            "(1) Easy - $500\n" +
            "(2) Normal - $250\n" +
            "(3) Hard - $100\n";
    private final String games =
            "Choose game:\n" +
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
        if (prompted) {
            if (playerCreated) {
                if (difficultySet) {
                    chooseGame();
                } else {
                    setDifficulty();
                    displayPlayerInfo();
                    displayOptions();
                }
            } else {
                createPlayer();
                displayDifficulty();
            }
        }
    }

    @Override
    public void render() {
        System.out.println(outputString);
        outputString = "";
        prompted = true;
    }

    public void displayGreeting() {
        outputString += greeting;
    }
    private void displayDifficulty() { outputString += difficulty; }
    private void displayPlayerInfo() {
        outputString += Casino.player.getName() + "\n" + "Balance: $" + Casino.player.getMoney() + "\n";
    }
    public void displayOptions() {
        outputString += games;
    }

    private void createPlayer() {
        Casino.player = new Player(inputString);
        playerCreated = true;
    }

    private void setDifficulty() {
        switch (inputString) {
            case "1":
                Casino.player.updateBalance(500);
                difficultySet = true;
                break;
            case "2":
                Casino.player.updateBalance(250);
                difficultySet = true;
                break;
            case "3":
                Casino.player.updateBalance(100);
                difficultySet = true;
                break;
            default:
                break;
        }
    }

    private void chooseGame() {
        switch (inputString) {
            case "1":
                choice = new War();
                break;
            case "2":
                choice = new Blackjack();
                break;
            case "3":
                choice = new Slots();
                break;
            default:
                break;
        }
        if (choice != null) {
            Casino.pushState(choice);
        }
    }
}

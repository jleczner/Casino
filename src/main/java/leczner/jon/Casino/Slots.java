package leczner.jon.Casino;

import java.util.Random;

/**
 * Created by jonathanleczner on 10/6/16.
 */
public class Slots extends Game {
    private InputHandler input;
    private String inputString;
    private String outputString;
    private boolean prompted;
    private boolean played;
    private String[] slotValues;
    private int winAmount;

    private final String greeting = "Welcome to Slots! Please select an option.\n";
    private final String options =
            "(1) Play\n" +
            "(2) Quit\n";


    public Slots() {
        init(new ScannerInputHandler());
    }

    public Slots(InputHandler input) {
        init(input);
    }

    public InputHandler getInput() {
        return input;
    }

    public String getInputString() {
        return inputString;
    }

    public String getOutputString() {
        return outputString;
    }

    public boolean isPrompted() {
        return prompted;
    }

    public boolean isPlayed() {
        return played;
    }

    public String[] getSlotValues() {
        return slotValues;
    }

    public int getWinAmount() {
        return winAmount;
    }


    // main functions
    @Override
    public void init(InputHandler input) {
        this.input = input;
        inputString = "";
        outputString = "";
        prompted = false;
        played = false;
        slotValues = new String[]{"7", "cherries", "bar"};
        winAmount = -1;

        displayStart();
    }

    @Override
    public void handleInput() {
        if (prompted && !played) {
            inputString = input.getInput();
        }
    }

    @Override
    public void update() {
        if (inputString != null) {
            if (!played) {
                playOrQuit();
                return;
            }
        }
        if (played) {
            determineWinnings();
            displayWinnings();
            displayPlayerInfo();
            displayEndPrompt();
            played = false;
        }
    }

    @Override
    public void render() {
        System.out.println(outputString);
        outputString = "";
        prompted = true;
    }

    // display functions
    private void displayStart() { outputString += greeting + options; }
    private void displaySlots() { outputString += slotValues[0] + " " + slotValues[1] + " " + slotValues[2]; }
    private void displayWinnings() { outputString += "You win $" + winAmount + "\n"; }
    private void displayEndPrompt() { outputString +=
            "Continue?\n" +
            "(1) Yes\n" +
            "(2) No\n";
    }
    private void displayPlayerInfo() { outputString += Casino.player.displayPlayerInfo() + "\n"; }


    // auxiliary functions
    private String getRandomSlotValue() {
        Random r = new Random();
        return getSlotValue(r.nextInt(slotValues.length));
    }

    private String getSlotValue(int index) {
        return slotValues[index];
    }

    private void playSlots() {
        for (int i = 0; i < 3; i++) {
            slotValues[i] = getRandomSlotValue();
        }
    }

    private void determineWinnings() {
        if (slotValues[0].equals(slotValues[1]) && slotValues[1].equals(slotValues[2])) {
            switch (slotValues[0]) {
                case "7":
                    winAmount = 500;
                    break;
                case "cherries":
                    winAmount = 50;
                    break;
                case "bar":
                    winAmount = 100;
                    break;
                default:
                    break;
            }
        } else {
            winAmount = 0;
        }
    }

    private void playOrQuit() {
        switch (inputString) {
            case "1":
                playSlots();
                displaySlots();
                played = true;
                break;
            case "2":
                quit();
                break;
            default:
                break;
        }
    }

    private void quit() {
        Casino.popState();
    }
}

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
                playSlots();
                displaySlots();
                played = true;
                return;
            }
        }
        if (played) {
            determineWinnings();
            displayWinnings();
            played = false;
        }
    }

    @Override
    public void render() {
        System.out.println(outputString);
        prompted = true;
    }

    private void displayStart() { outputString = "Welcome to Slots! Type 'start' to play."; }
    private void displaySlots() { outputString = slotValues[0] + " " + slotValues[1] + " " + slotValues[2]; }
    private void displayWinnings() { outputString = "You win $" + winAmount; }


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
                    winAmount = 1000;
                    break;
                case "cherries":
                    winAmount = 300;
                    break;
                case "bar":
                    winAmount = 500;
                    break;
                default:
                    break;
            }
        } else {
            winAmount = 0;
        }
    }
}

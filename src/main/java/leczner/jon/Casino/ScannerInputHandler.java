package leczner.jon.Casino;

import java.util.Scanner;

/**
 * Created by jonathanleczner on 10/2/16.
 */
public class ScannerInputHandler implements InputHandler {
    private String input;
    private Scanner scanner;

    public ScannerInputHandler() {
        init();
    }

    @Override
    public void init() {
        input = "";
        scanner = new Scanner(System.in);
    }

    @Override
    public String getInput() {
        return scanner.next();
    }
}

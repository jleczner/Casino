package leczner.jon.Casino;

/**
 * Created by jonathanleczner on 10/6/16.
 */
public class DummyInputHandler implements InputHandler {
    private String input;

    @Override
    public void init() {
        input = "";
    }

    @Override
    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }
}

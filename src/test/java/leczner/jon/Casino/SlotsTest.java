package leczner.jon.Casino;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by jonathanleczner on 10/6/16.
 */
public class SlotsTest {
    Slots s;

    @Test
    public void initTest() {
        s = new Slots();
        String expected = "Welcome to Slots! Type 'start' to play.";
        String actual = s.getOutputString();
        assertTrue(expected.equals(actual));
    }

    @Test
    public void updateTest() {
        s = new Slots(new DummyInputHandler());
        DummyInputHandler input = (DummyInputHandler) s.getInput();
        s.render();
        input.setInput("start");

        s.handleInput();
        s.update(); // plays slots
        s.update(); // displays winnings
        assertNotEquals(-1, s.getWinAmount()); // -1 is default value
    }

    @Test
    public void winningsTest() {
        s = new Slots(new DummyInputHandler());
        DummyInputHandler input = (DummyInputHandler) s.getInput();
        input.setInput("start");

        s.handleInput();
        while (s.getWinAmount() == -1 || s.getWinAmount() == 0) {
            s.update(); // plays slots
            s.update(); // displays winnings
        }
        String[] results = s.getSlotValues();
        assertEquals(results[0], results[1]);
        assertEquals(results[1], results[2]);
    }
}

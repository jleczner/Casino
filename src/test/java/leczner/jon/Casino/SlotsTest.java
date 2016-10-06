package leczner.jon.Casino;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by jonathanleczner on 10/6/16.
 */
public class SlotsTest {
    Slots s = new Slots();

    @Test
    public void initTest() {
        s = new Slots();
        assertTrue(s.getInputString().equals("Welcome to Slots! Type 'start' to play."));
    }

    @Test
    public void updateTest() {

    }
}

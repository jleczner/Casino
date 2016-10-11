package leczner.jon.Casino;

/**
 * Created by jonathanleczner on 10/2/16.
 */
public class Player {
    private String name;
    private double money;

    public Player(String name) {
        this.name = name;
        money = 0;
    }

    public String getName() {
        return name;
    }
    public double getMoney() {
        return money;
    }
    public void updateBalance(double amount) {
        money += amount;
    }
}

package leczner.jon.Casino;

/**
 * Created by jonathanleczner on 10/2/16.
 */
public class Player {
    private String name;
    private int money;

    public Player(String name) {
        this.name = name;
        money = 0;
    }

    public String getName() {
        return name;
    }
    public int getMoney() {
        return money;
    }
    public void updateBalance(int amount) {
        money += amount;
    }

    public String displayPlayerInfo() {
        return name + "\n" + "Balance: $" + money + "\n";
    }
}

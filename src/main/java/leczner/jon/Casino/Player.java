package leczner.jon.Casino;

/**
 * Created by jonathanleczner on 10/2/16.
 */
public class Player {
    private String name;
    private double money;

    public Player(String name, double money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }
}

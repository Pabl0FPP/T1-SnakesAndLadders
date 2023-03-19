package model;

import java.util.Random;

public class Dice {
    private int diceValue;

    public Dice() {
        rollDice();
    }

    public int getDiceValue() {
        return diceValue;
    }

    public int rollDice() {
        Random random = new Random();
        diceValue = random.nextInt(6) + 1;

        return diceValue;
    }
}

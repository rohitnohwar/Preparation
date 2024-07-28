package com;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiceService {
    private DiceService() {

    }

    private static class InitializationHolderSingleton {
        private static final Random random = new Random();
        private static final DiceService diceService = new DiceService();
    }


    public static DiceService returnDiceService() {
        return InitializationHolderSingleton.diceService;
    }

    public int rollDice() {
        return InitializationHolderSingleton.random.nextInt(6) + 1;
    }

}

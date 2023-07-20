package com.lpoo2021.g75.model.game.map;

import com.lpoo2021.g75.model.game.elements.dynamicElements.Pacman;
import com.lpoo2021.g75.model.game.elements.dynamicElements.ghosts.*;
import com.lpoo2021.g75.model.game.elements.fixedElements.collectable.Coin;
import com.lpoo2021.g75.model.game.elements.fixedElements.Wall;
import com.lpoo2021.g75.model.game.elements.fixedElements.collectable.keys.Key;
import com.lpoo2021.g75.model.game.elements.fixedElements.collectable.powerUps.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomMapBuilder extends MapBuilder {
    private final Random rng;

    private final int width;
    private final int height;
    private final int numberOfGhosts;
    private final int numberOfCoins;
    private final int numberOfPowerUps;

    public RandomMapBuilder() {
        this.rng = new Random();

        this.width = 40;
        this.height = 20;
        this.numberOfGhosts = 8;
        this.numberOfCoins = 20;
        this.numberOfPowerUps = 5;
    }

    public RandomMapBuilder(int width, int height, int numberOfGhosts, int numberOfCoins, int numberOfPowerUps) {
        this.rng = new Random();

        this.width = width;
        this.height = height;
        this.numberOfGhosts = numberOfGhosts;
        this.numberOfCoins = numberOfCoins;
        this.numberOfPowerUps = numberOfPowerUps;
    }

    @Override
    protected int getWidth() {
        return width;
    }

    @Override
    protected int getHeight() {
        return height;
    }

    @Override
    protected int getCoinValue() {
        return 10;
    }

    @Override
    protected int getMapNumber() {
        return 0;
    }

    @Override
    protected List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int x = 0; x < width; x++) {
            walls.add(new Wall(x, 0));
            walls.add(new Wall(x, height - 1));
        }

        for (int y = 1; y < height - 1; y++) {
            walls.add(new Wall(0, y));
            walls.add(new Wall(width - 1, y));
        }

        return walls;
    }

    @Override
    protected List<Coin> createCoins() {
        List<Coin> coins = new ArrayList<>();

        for (int x = 0; x < numberOfCoins; x++) {
            coins.add(new Coin(rng.nextInt(width - 2) + 1, rng.nextInt(height - 2) + 1));
        }

        return coins;
    }

    @Override
    protected List<Ghost> createGhosts() {
        List<Ghost> monsters = new ArrayList<>();

        while (monsters.size() < numberOfGhosts) {
            int n = this.rng.nextInt(4);
            if (0 == n) monsters.add(new KillerGhost(rng.nextInt(width - 2) + 1, rng.nextInt(height - 2) + 1));
            else if (n == 1) monsters.add(new ReduceScoreGhost(rng.nextInt(width - 2) + 1, rng.nextInt(height - 2) + 1));
            else if (n == 2) monsters.add(new ResetCoinsGhost(rng.nextInt(width - 2) + 1, rng.nextInt(height - 2) + 1));
            else monsters.add(new EliminatePowerUpsGhost(rng.nextInt(width - 2) + 1, rng.nextInt(height - 2) + 1));
        }

        return monsters;
    }

    @Override
    protected Pacman createPacman() {
        return new Pacman(width / 2, height / 2);
    }

    @Override
    protected List<Key> createKeys() {
        return new ArrayList<>();
    }

    @Override
    protected List<PowerUp> createPowerUps() {
        List<PowerUp> powerUps = new ArrayList<>();

        while (powerUps.size() < numberOfPowerUps) {
            int n = this.rng.nextInt(4);
            if (0 == n) powerUps.add(new Cherry(rng.nextInt(width - 2) + 1, rng.nextInt(height - 2) + 1));
            else if (n == 1) powerUps.add(new Apple(rng.nextInt(width - 2) + 1, rng.nextInt(height - 2) + 1));
            else if (n == 2) powerUps.add(new Orange(rng.nextInt(width - 2) + 1, rng.nextInt(height - 2) + 1));
            else powerUps.add(new Pear(rng.nextInt(width - 2) + 1, rng.nextInt(height - 2) + 1));
        }

        return powerUps;
    }
}

package com.lpoo2021.g75.model.game.map;

import com.lpoo2021.g75.model.game.Position;
import com.lpoo2021.g75.model.game.elements.dynamicElements.Pacman;
import com.lpoo2021.g75.model.game.elements.fixedElements.Door;
import com.lpoo2021.g75.model.game.elements.fixedElements.collectable.Coin;
import com.lpoo2021.g75.model.game.elements.fixedElements.Wall;
import com.lpoo2021.g75.model.game.elements.dynamicElements.ghosts.Ghost;
import com.lpoo2021.g75.model.game.elements.fixedElements.collectable.keys.Key;
import com.lpoo2021.g75.model.game.elements.fixedElements.collectable.keys.KeyObserver;
import com.lpoo2021.g75.model.game.elements.fixedElements.collectable.powerUps.PowerUp;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private final int width;
    private final int height;
    private final int coinValue;
    private final int number;

    private Pacman pacman;
    private List<Wall> walls;
    private List<Coin> coins;
    private List<Ghost> ghosts;
    private List<Key> keys;
    private List<Door> doors;
    private List<PowerUp> powerUps;

    public Map(int width, int height, int coinValue, int number) {
        this.width = width;
        this.height = height;
        this.coinValue = coinValue;
        this.number = number;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getCoinValue() {
        return this.coinValue;
    }

    public int getNumber() {
        return  this.number;
    }

    public Pacman getPacman() {
        return this.pacman;
    }

    public void setPacman(Pacman pacman) {
        this.pacman = pacman;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public List<Coin> getAllCoins() {
        return this.coins;
    }

    public List<Coin> getNotCollectedCoins() {
        List<Coin> coinsNotCollected = new ArrayList<>();
        for (Coin coin: coins)
            if (!coin.isCollected()) coinsNotCollected.add(coin);

        return coinsNotCollected;
    }

    public boolean hasNotCollectedCoins() {
        return (getNotCollectedCoins().size() > 0);
    }

    public void setCoins(List<Coin> coins) {
        this.coins = coins;
    }

    public List<Ghost> getGhosts() {
        return this.ghosts;
    }

    public void setGhosts(List<Ghost> ghosts) {
        this.ghosts = ghosts;
    }

    public List<Key> getKeys() {
        return this.keys;
    }

    public void setKeys(List<Key> keys) {
        this.keys = keys;
    }

    public List<Door> buildDoors() {
        List<Door> doors = new ArrayList<>();

        for (Key key : keys) {
            for (KeyObserver observer : key.getObservers())
                doors.add((Door) observer);
        }

        return doors;
    }

    public List<Door> getClosedDoors() {
        List<Door> closedDoors = new ArrayList<>();
        for (Door door: doors)
            if (door.isClosed()) closedDoors.add(door);

        return closedDoors;
    }

    public void setDoors(List<Door> doors) {
        this.doors = doors;
    }

    public List<PowerUp> getPowerUps() {
        return this.powerUps;
    }

    public void setPowerUps(List<PowerUp> powerUps) {
        this.powerUps = powerUps;
    }

    private void assertPosition(Position position) {
        assert position.getX() < this.width;
        assert position.getY() < this.height;
    }

    public boolean isEmpty(Position position) {
        this.assertPosition(position);

        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return false;

        for (Door door : doors)
            if (door.isClosed() && door.getPosition().equals(position))
                return false;

        return true;
    }

    public boolean isNotCollectedCoin(Position position) {
        this.assertPosition(position);

        for (Coin coin : this.getNotCollectedCoins())
            if (coin.getPosition().equals(position))
                return true;
        return false;
    }

    public void collectCoin(Position position) {
        this.assertPosition(position);

        for (Coin coin : this.getNotCollectedCoins())
            if (coin.getPosition().equals(position)) {
                coin.collect();
                return;
            }
    }

    public boolean isGhost(Position position) {
        this.assertPosition(position);

        for (Ghost ghost : ghosts)
            if (ghost.getPosition().equals(position))
                return true;
        return false;
    }

    public Ghost getGhost(Position position) {
        this.assertPosition(position);

        for (Ghost ghost : ghosts)
            if (ghost.getPosition().equals(position))
                return ghost;
        return null;
    }

    public boolean isKey(Position position) {
        this.assertPosition(position);

        for (Key key : keys)
            if (key.getPosition().equals(position))
                return true;
        return false;
    }

    public void collectKey(Position position) {
        this.assertPosition(position);

        for (Key key : keys)
            if (key.getPosition().equals(position)) {
                key.collect();
                keys.remove(key);
                return;
            }
    }

    public boolean isPowerUp(Position position) {
        this.assertPosition(position);

        for (PowerUp powerUp : powerUps)
            if (powerUp.getPosition().equals(position))
                return true;
        return false;
    }

    public PowerUp collectPowerUp(Position position) {
        this.assertPosition(position);

        for (PowerUp powerUp : powerUps)
            if (powerUp.getPosition().equals(position)) {
                powerUp.collect();
                powerUps.remove(powerUp);
                return powerUp;
            }

        return null;
    }

    public Position teleport(Position position) {
        if (position.getX() < 0 || position.getX() >= this.width) {
            int x = position.getX() < 0 ? this.width - 1 : 0;
            position = new Position(x, position.getY());
        }
        else if (position.getY() < 0 || position.getY() >= this.height) {
            int y = position.getY() < 0 ? this.height - 1 : 0;
            position = new Position(position.getX(), y);
        }

        return position;
    }
}

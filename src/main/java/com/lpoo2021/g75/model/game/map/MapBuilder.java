package com.lpoo2021.g75.model.game.map;

import com.lpoo2021.g75.model.game.elements.dynamicElements.Pacman;
import com.lpoo2021.g75.model.game.elements.dynamicElements.ghosts.Ghost;
import com.lpoo2021.g75.model.game.elements.fixedElements.collectable.Coin;
import com.lpoo2021.g75.model.game.elements.fixedElements.Wall;
import com.lpoo2021.g75.model.game.elements.fixedElements.collectable.keys.Key;
import com.lpoo2021.g75.model.game.elements.fixedElements.collectable.powerUps.PowerUp;

import java.util.List;

public abstract class MapBuilder {
    public Map createMap() {
        Map map = new Map(getWidth(), getHeight(), getCoinValue(), getMapNumber());

        map.setPacman(createPacman());
        map.setWalls(createWalls());
        map.setCoins(createCoins());
        map.setGhosts(createGhosts());
        map.setKeys(createKeys());
        map.setDoors(map.buildDoors());
        map.setPowerUps(createPowerUps());

        return map;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract int getCoinValue();

    protected abstract int getMapNumber();

    protected abstract Pacman createPacman();

    protected abstract List<Wall> createWalls();

    protected abstract List<Coin> createCoins();

    protected abstract List<Ghost> createGhosts();

    protected abstract List<Key> createKeys();

    protected abstract List<PowerUp> createPowerUps();
}

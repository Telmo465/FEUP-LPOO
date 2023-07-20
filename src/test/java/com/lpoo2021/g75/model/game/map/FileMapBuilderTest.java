package com.lpoo2021.g75.model.game.map;

import com.lpoo2021.g75.model.game.elements.dynamicElements.Pacman;
import com.lpoo2021.g75.model.game.elements.fixedElements.collectable.keys.Key;
import com.lpoo2021.g75.model.game.elements.fixedElements.collectable.keys.KeyObserver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileMapBuilderTest {
    private MapBuilder mapBuilder;

    @BeforeEach
    void setUp() throws IOException {
        mapBuilder = new FileMapBuilder(4);
    }

    @Test
    void createFileMap() {
        Map map = mapBuilder.createMap();

        assertEquals(mapBuilder.createPacman().getPosition().getX(), map.getPacman().getPosition().getX());
        assertEquals(mapBuilder.createPacman().getPosition().getY(), map.getPacman().getPosition().getY());
        assertEquals(mapBuilder.createPacman().getLives(), map.getPacman().getLives());
        assertEquals(mapBuilder.createPacman().getScore(), map.getPacman().getScore());

        assertEquals(mapBuilder.createWalls().size(), map.getWalls().size());

        assertEquals(mapBuilder.createCoins().size(), map.getAllCoins().size());
        assertEquals(mapBuilder.createCoins().size(), map.getNotCollectedCoins().size());

        assertEquals(mapBuilder.createGhosts().size(), map.getGhosts().size());
        assertEquals(mapBuilder.createPowerUps().size(), map.getPowerUps().size());

        assertEquals(mapBuilder.createKeys().size(), map.getKeys().size());
    }

    @Test
    void mapDimensions() {
        assertEquals(40, mapBuilder.getWidth());
        assertEquals(20, mapBuilder.getHeight());
    }

    @Test
    void mapInfo() {
        assertEquals(5, mapBuilder.getCoinValue());
        assertEquals(4, mapBuilder.getMapNumber());
    }

    @Test
    void createWalls() {
        assertEquals(436, mapBuilder.createWalls().size());
    }

    @Test
    void createCoins() {
        assertEquals(60, mapBuilder.createCoins().size());
    }

    @Test
    void createGhosts() {
        assertEquals(9, mapBuilder.createGhosts().size());
    }

    @Test
    void createPacman() {
        Pacman pacman = mapBuilder.createPacman();
        assertEquals(2, pacman.getPosition().getX());
        assertEquals(18, pacman.getPosition().getY());
    }

    @Test
    void createKeys() {
        assertEquals(2, mapBuilder.createKeys().size());

        List<KeyObserver> doors = new ArrayList<>();
        List<Key> keys = mapBuilder.createKeys();
        for (Key key : keys)
            doors.addAll(key.getObservers());

        assertEquals(4, doors.size());
    }

    @Test
    void createPowerUps() {
        assertEquals(7, mapBuilder.createPowerUps().size());
    }
}
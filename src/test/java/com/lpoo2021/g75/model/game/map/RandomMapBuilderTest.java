package com.lpoo2021.g75.model.game.map;

import com.lpoo2021.g75.model.game.elements.dynamicElements.Pacman;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomMapBuilderTest {
    private MapBuilder mapBuilder;

    @BeforeEach
    void setUp() {
        mapBuilder = new RandomMapBuilder(10, 10, 4, 8, 5);
    }

    @Test
    void createRandomMap() {
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
        assertEquals(10, mapBuilder.getWidth());
        assertEquals(10, mapBuilder.getHeight());
    }

    @Test
    void mapInfo() {
        assertEquals(10, mapBuilder.getCoinValue());
        assertEquals(0, mapBuilder.getMapNumber());
    }

    @Test
    void createWalls() {
        assertEquals(36, mapBuilder.createWalls().size());
    }

    @Test
    void createCoins() {
        assertEquals(8, mapBuilder.createCoins().size());
    }

    @Test
    void createGhosts() {
        assertEquals(4, mapBuilder.createGhosts().size());
    }

    @Test
    void createPacman() {
        Pacman pacman = mapBuilder.createPacman();
        assertEquals(5, pacman.getPosition().getX());
        assertEquals(5, pacman.getPosition().getY());
    }

    @Test
    void createKeys() {
        assertEquals(0, mapBuilder.createKeys().size());
    }

    @Test
    void createPowerUps() {
        assertEquals(5, mapBuilder.createPowerUps().size());
    }
}
package com.lpoo2021.g75.model.game.map;

import com.lpoo2021.g75.model.game.Position;
import com.lpoo2021.g75.model.game.elements.dynamicElements.Pacman;
import com.lpoo2021.g75.model.game.elements.dynamicElements.ghosts.EliminatePowerUpsGhost;
import com.lpoo2021.g75.model.game.elements.dynamicElements.ghosts.KillerGhost;
import com.lpoo2021.g75.model.game.elements.dynamicElements.ghosts.ReduceScoreGhost;
import com.lpoo2021.g75.model.game.elements.dynamicElements.ghosts.ResetCoinsGhost;
import com.lpoo2021.g75.model.game.elements.fixedElements.Door;
import com.lpoo2021.g75.model.game.elements.fixedElements.collectable.Coin;
import com.lpoo2021.g75.model.game.elements.fixedElements.Wall;
import com.lpoo2021.g75.model.game.elements.fixedElements.collectable.keys.Key;
import com.lpoo2021.g75.model.game.elements.fixedElements.collectable.powerUps.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MapTest {
    private Map map;

    @BeforeEach
    void setUp() {
        map = new Map(20, 15, 10, 0);

        map.setPacman(new Pacman(10, 10));
        map.setWalls(Arrays.asList(new Wall(2, 3), new Wall(3, 3), new Wall(4, 3)));
        map.setCoins(Arrays.asList(new Coin(9, 12), new Coin(11, 12)));
        map.setGhosts(Arrays.asList(new KillerGhost(17, 12), new ResetCoinsGhost(8, 7), new EliminatePowerUpsGhost(9, 14), new ReduceScoreGhost(13, 5)));

        List<PowerUp> powerUps = new ArrayList<>();
        powerUps.add(new Cherry(3, 13));
        powerUps.add(new Apple(18, 3));
        powerUps.add(new Orange(5, 9));
        powerUps.add(new Pear(18, 8));
        map.setPowerUps(powerUps);

        Key key = new Key(19, 12, "#58006E");
        key.addKeyObserver(new Door(5, 2, "#58006E"));
        List<Key> keys = new ArrayList<>();
        keys.add(key);
        map.setKeys(keys);
        map.setDoors(map.buildDoors());
    }

    @Test
    void createMap() {
        assertEquals(20, map.getWidth());
        assertEquals(15, map.getHeight());
        assertEquals(10, map.getCoinValue());
        assertEquals(0, map.getNumber());

        assertEquals(10, map.getPacman().getPosition().getX());
        assertEquals(10, map.getPacman().getPosition().getY());

        assertEquals(3, map.getWalls().size());

        assertEquals(2, map.getAllCoins().size());
        assertEquals(2, map.getNotCollectedCoins().size());
        assertTrue(map.hasNotCollectedCoins());

        assertEquals(4, map.getGhosts().size());

        assertEquals(4, map.getPowerUps().size());

        assertEquals(1, map.getKeys().size());
        assertEquals(1, map.buildDoors().size());
        assertEquals(1, map.getClosedDoors().size());
    }

    @Test
    void isEmpty() {
        assertTrue(map.isEmpty(new Position(10, 10)));

        assertFalse(map.isEmpty(new Position(2, 3)));
        assertFalse(map.isEmpty(new Position(3, 3)));
        assertFalse(map.isEmpty(new Position(4, 3)));

        assertTrue(map.isEmpty(new Position(13, 5)));
        assertTrue(map.isEmpty(new Position(9, 12)));
        assertTrue(map.isEmpty(new Position(17, 12)));
        assertTrue(map.isEmpty(new Position(3, 13)));
        assertTrue(map.isEmpty(new Position(19, 12)));
        assertTrue(map.isEmpty(new Position(6, 6)));

        assertFalse(map.isEmpty(new Position(5, 2)));
    }

    @Test
    void collectCoins() {
        assertFalse(map.isNotCollectedCoin(new Position(9, 14)));

        assertTrue(map.isNotCollectedCoin(new Position(9, 12)));
        map.collectCoin(new Position(9, 12));
        assertFalse(map.isNotCollectedCoin(new Position(9, 12)));
    }

    @Test
    void hasNotCollectedCoins() {
        map.collectCoin(new Position(9, 12));
        map.collectCoin(new Position(11, 12));

        assertFalse(map.hasNotCollectedCoins());
    }

    @Test
    void isGhost() {
        assertFalse(map.isGhost(new Position(10, 10)));
        assertFalse(map.isGhost(new Position(2, 3)));
        assertFalse(map.isGhost(new Position(9, 12)));
        assertFalse(map.isGhost(new Position(10, 12)));

        assertTrue(map.isGhost(new Position(17, 12)));
        assertTrue(map.isGhost(new Position(8, 7)));
        assertTrue(map.isGhost(new Position(9, 14)));
        assertTrue(map.isGhost(new Position(13, 5)));
    }

    @Test
    void getGhost() {
        assertNull(map.getGhost(new Position(10, 10)));

        assertEquals(KillerGhost.class, map.getGhost(new Position(17, 12)).getClass());
        assertEquals(ResetCoinsGhost.class, map.getGhost(new Position(8, 7)).getClass());
        assertEquals(EliminatePowerUpsGhost.class, map.getGhost(new Position(9, 14)).getClass());
        assertEquals(ReduceScoreGhost.class, map.getGhost(new Position(13, 5)).getClass());
    }

    @Test
    void isKey() {
        assertFalse(map.isKey(new Position(10, 12)));
        assertFalse(map.isKey(new Position(5, 2)));
        assertTrue(map.isKey(new Position(19, 12)));
    }

    @Test
    void collectKey() {
        assertTrue(map.isKey(new Position(19, 12)));
        assertFalse(map.isEmpty(new Position(5, 2)));
        map.collectKey(new Position(19, 12));
        assertFalse(map.isKey(new Position(19, 12)));
        assertTrue(map.isEmpty(new Position(5, 2)));

        assertEquals(0, map.getKeys().size());
        assertEquals(0, map.getClosedDoors().size());
    }

    @Test
    void isPowerUp() {
        assertFalse(map.isPowerUp(new Position(10, 10)));
        assertFalse(map.isPowerUp(new Position(2, 3)));
        assertFalse(map.isPowerUp(new Position(9, 12)));
        assertFalse(map.isPowerUp(new Position(10, 12)));

        assertTrue(map.isPowerUp(new Position(3, 13)));
        assertTrue(map.isPowerUp(new Position(5, 9)));
        assertTrue(map.isPowerUp(new Position(18, 3)));
        assertTrue(map.isPowerUp(new Position(18, 8)));
    }

    @Test
    void collectPowerUp() {
        assertNull(map.collectPowerUp(new Position(10, 10)));

        assertEquals(Cherry.class, map.collectPowerUp(new Position(3, 13)).getClass());
        assertEquals(Orange.class, map.collectPowerUp(new Position(5, 9)).getClass());
        assertEquals(Apple.class, map.collectPowerUp(new Position(18, 3)).getClass());
        assertEquals(Pear.class, map.collectPowerUp(new Position(18, 8)).getClass());
    }

    @Test
    void teleport() {
        assertEquals(new Position(0, 5), map.teleport(new Position(20, 5)));
        assertEquals(new Position(19, 5), map.teleport(new Position(-1, 5)));

        assertEquals(new Position(8, 0), map.teleport(new Position(8, 15)));
        assertEquals(new Position(8, 14), map.teleport(new Position(8, -1)));

        assertEquals(new Position(8, 5), map.teleport(new Position(8, 5)));
    }
}
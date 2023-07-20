package com.lpoo2021.g75.controller.game.elements;

import com.lpoo2021.g75.controller.game.elements.ghosts.AttackStrategy;
import com.lpoo2021.g75.controller.game.elements.ghosts.states.NormalGhostState;
import com.lpoo2021.g75.controller.game.elements.ghosts.states.ParalyzeGhostState;
import com.lpoo2021.g75.controller.game.elements.powerUps.PowerStrategy;
import com.lpoo2021.g75.model.game.Position;
import com.lpoo2021.g75.model.game.elements.fixedElements.Door;
import com.lpoo2021.g75.model.game.elements.fixedElements.collectable.keys.Key;
import com.lpoo2021.g75.model.game.elements.fixedElements.collectable.keys.KeyObserver;
import com.lpoo2021.g75.model.game.elements.fixedElements.collectable.powerUps.PowerUp;
import com.lpoo2021.g75.model.game.map.Map;
import com.lpoo2021.g75.model.game.elements.dynamicElements.Pacman;
import com.lpoo2021.g75.model.game.elements.dynamicElements.ghosts.Ghost;
import com.lpoo2021.g75.model.game.elements.fixedElements.collectable.Coin;
import com.lpoo2021.g75.model.game.elements.fixedElements.Wall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PacmanControllerTest {
    private PacmanController controller;
    private Pacman pacman;
    private Map map;

    private AttackStrategy attackStrategy;
    private Ghost ghost;

    private PowerStrategy powerStrategy;
    private PowerUp powerUp;

    private Key key;
    private KeyObserver keyObserver;

    @BeforeEach
    void setUp() {
        map = new Map(10, 10, 10, 0);

        pacman = new Pacman(5, 5);
        map.setPacman(pacman);
        map.setWalls(Collections.emptyList());
        map.setGhosts(Collections.emptyList());
        map.setCoins(Collections.emptyList());
        map.setKeys(Collections.emptyList());
        map.setDoors(Collections.emptyList());
        map.setPowerUps(Collections.emptyList());

        controller = new PacmanController(map);
    }

    @Test
    void moveRightEmpty() {
        controller.moveRight();
        assertEquals(new Position(6, 5), pacman.getPosition());
    }

    @Test
    void moveLeftEmpty() {
        controller.moveLeft();
        assertEquals(new Position(4, 5), pacman.getPosition());
    }

    @Test
    void moveUpEmpty() {
        controller.moveUp();
        assertEquals(new Position(5, 4), pacman.getPosition());
    }

    @Test
    void moveDownEmpty() {
        controller.moveDown();
        assertEquals(new Position(5, 6), pacman.getPosition());
    }

    @Test
    void moveRightCollideWall() {
        map.setWalls(Collections.singletonList(new Wall(6, 5)));
        controller.moveRight();
        assertEquals(new Position(5, 5), pacman.getPosition());
    }

    @Test
    void moveLeftCollideWall() {
        map.setWalls(Collections.singletonList(new Wall(4, 5)));
        controller.moveLeft();
        assertEquals(new Position(5, 5), pacman.getPosition());
    }

    @Test
    void moveUpCollideWall() {
        map.setWalls(Collections.singletonList(new Wall(5, 4)));
        controller.moveUp();
        assertEquals(new Position(5, 5), pacman.getPosition());
    }

    @Test
    void moveDownCollideWall() {
        map.setWalls(Collections.singletonList(new Wall(5, 6)));
        controller.moveDown();
        assertEquals(new Position(5, 5), pacman.getPosition());
    }

    @Test
    void moveRightCollideClosedDoor() {
        map.setDoors(Collections.singletonList(new Door(6, 5)));
        controller.moveRight();
        assertEquals(new Position(5, 5), pacman.getPosition());
    }

    @Test
    void moveLeftCollideClosedDoor() {
        map.setDoors(Collections.singletonList(new Door(4, 5)));
        controller.moveLeft();
        assertEquals(new Position(5, 5), pacman.getPosition());
    }

    @Test
    void moveUpCollideClosedDoor() {
        map.setDoors(Collections.singletonList(new Door(5, 4)));
        controller.moveUp();
        assertEquals(new Position(5, 5), pacman.getPosition());
    }

    @Test
    void moveDownCollideClosedDoor() {
        map.setDoors(Collections.singletonList(new Door(5, 6)));
        controller.moveDown();
        assertEquals(new Position(5, 5), pacman.getPosition());
    }

    @Test
    void moveRightCollectCoin() {
        map.setCoins(Collections.singletonList(new Coin(6, 5)));
        controller.moveRight();

        assertEquals(new Position(6, 5), pacman.getPosition());
        assertFalse(map.hasNotCollectedCoins());
        assertEquals(10, pacman.getScore());
    }

    @Test
    void moveLeftCollectCoin() {
        map.setCoins(Collections.singletonList(new Coin(4, 5)));
        controller.moveLeft();

        assertEquals(new Position(4, 5), pacman.getPosition());
        assertFalse(map.hasNotCollectedCoins());
        assertEquals(10, pacman.getScore());
    }

    @Test
    void moveUpCollectCoin() {
        map.setCoins(Collections.singletonList(new Coin(5, 4)));
        controller.moveUp();

        assertEquals(new Position(5, 4), pacman.getPosition());
        assertFalse(map.hasNotCollectedCoins());
        assertEquals(10, pacman.getScore());
    }

    @Test
    void moveDownCollectCoin() {
        map.setCoins(Collections.singletonList(new Coin(5, 6)));
        controller.moveDown();

        assertEquals(new Position(5, 6), pacman.getPosition());
        assertFalse(map.hasNotCollectedCoins());
        assertEquals(10, pacman.getScore());
    }

    private void mockGhost() {
        attackStrategy = Mockito.mock(AttackStrategy.class);
        ghost = Mockito.mock(Ghost.class);

        Mockito.when(ghost.getAttackStrategy()).thenReturn(attackStrategy);
    }

    @Test
    void moveRightCollideNormalGhost() {
        mockGhost();
        Mockito.when(ghost.getPosition()).thenReturn(new Position(6, 5));
        Mockito.when(ghost.getState()).thenReturn(new NormalGhostState(ghost));

        map.setGhosts(Collections.singletonList(ghost));
        controller.moveRight();

        assertEquals(new Position(6, 5), pacman.getPosition());
        Mockito.verify(ghost, Mockito.times(1)).getAttackStrategy();
        Mockito.verify(attackStrategy, Mockito.times(1)).attack(map);
    }

    @Test
    void moveLeftCollideNormalGhost() {
        mockGhost();
        Mockito.when(ghost.getPosition()).thenReturn(new Position(4, 5));
        Mockito.when(ghost.getState()).thenReturn(new NormalGhostState(ghost));

        map.setGhosts(Collections.singletonList(ghost));
        controller.moveLeft();

        assertEquals(new Position(4, 5), pacman.getPosition());
        Mockito.verify(ghost, Mockito.times(1)).getAttackStrategy();
        Mockito.verify(attackStrategy, Mockito.times(1)).attack(map);
    }

    @Test
    void moveUpCollideNormalGhost() {
        mockGhost();
        Mockito.when(ghost.getPosition()).thenReturn(new Position(5, 4));
        Mockito.when(ghost.getState()).thenReturn(new NormalGhostState(ghost));

        map.setGhosts(Collections.singletonList(ghost));
        controller.moveUp();

        assertEquals(new Position(5, 4), pacman.getPosition());
        Mockito.verify(ghost, Mockito.times(1)).getAttackStrategy();
        Mockito.verify(attackStrategy, Mockito.times(1)).attack(map);
    }

    @Test
    void moveDownCollideNormalGhost() {
        mockGhost();
        Mockito.when(ghost.getPosition()).thenReturn(new Position(5, 6));
        Mockito.when(ghost.getState()).thenReturn(new NormalGhostState(ghost));

        map.setGhosts(Collections.singletonList(ghost));
        controller.moveDown();

        assertEquals(new Position(5, 6), pacman.getPosition());
        Mockito.verify(ghost, Mockito.times(1)).getAttackStrategy();
        Mockito.verify(attackStrategy, Mockito.times(1)).attack(map);
    }

    @Test
    void moveRightCollideParalyzedGhost() {
        mockGhost();
        Mockito.when(ghost.getPosition()).thenReturn(new Position(6, 5));
        Mockito.when(ghost.getState()).thenReturn(new ParalyzeGhostState(ghost));

        map.setGhosts(Collections.singletonList(ghost));
        controller.moveRight();

        assertEquals(new Position(6, 5), pacman.getPosition());
        Mockito.verify(ghost, Mockito.times(0)).getAttackStrategy();
        Mockito.verify(attackStrategy, Mockito.times(0)).attack(map);
    }

    @Test
    void moveLeftCollideParalyzedGhost() {
        mockGhost();
        Mockito.when(ghost.getPosition()).thenReturn(new Position(4, 5));
        Mockito.when(ghost.getState()).thenReturn(new ParalyzeGhostState(ghost));

        map.setGhosts(Collections.singletonList(ghost));
        controller.moveLeft();

        assertEquals(new Position(4, 5), pacman.getPosition());
        Mockito.verify(ghost, Mockito.times(0)).getAttackStrategy();
        Mockito.verify(attackStrategy, Mockito.times(0)).attack(map);
    }

    @Test
    void moveUpCollideParalyzedGhost() {
        mockGhost();
        Mockito.when(ghost.getPosition()).thenReturn(new Position(5, 4));
        Mockito.when(ghost.getState()).thenReturn(new ParalyzeGhostState(ghost));

        map.setGhosts(Collections.singletonList(ghost));
        controller.moveUp();

        assertEquals(new Position(5, 4), pacman.getPosition());
        Mockito.verify(ghost, Mockito.times(0)).getAttackStrategy();
        Mockito.verify(attackStrategy, Mockito.times(0)).attack(map);
    }

    @Test
    void moveDownCollideParalyzedGhost() {
        mockGhost();
        Mockito.when(ghost.getPosition()).thenReturn(new Position(5, 6));
        Mockito.when(ghost.getState()).thenReturn(new ParalyzeGhostState(ghost));

        map.setGhosts(Collections.singletonList(ghost));
        controller.moveDown();

        assertEquals(new Position(5, 6), pacman.getPosition());
        Mockito.verify(ghost, Mockito.times(0)).getAttackStrategy();
        Mockito.verify(attackStrategy, Mockito.times(0)).attack(map);
    }

    private void mockPowerUp() {
        powerStrategy = Mockito.mock(PowerStrategy.class);
        powerUp = Mockito.mock(PowerUp.class);

        Mockito.when(powerUp.getPowerStrategy()).thenReturn(powerStrategy);
    }

    @Test
    void moveRightCollectPowerUp() {
        mockPowerUp();
        Mockito.when(powerUp.getPosition()).thenReturn(new Position(6, 5));

        List<PowerUp> powerUps = new ArrayList<>();
        powerUps.add(powerUp);
        map.setPowerUps(powerUps);
        controller.moveRight();

        assertEquals(new Position(6, 5), pacman.getPosition());
        Mockito.verify(powerUp, Mockito.times(1)).getPowerStrategy();
        Mockito.verify(powerStrategy, Mockito.times(1)).power(map);
    }

    @Test
    void moveLeftCollectPowerUp() {
        mockPowerUp();
        Mockito.when(powerUp.getPosition()).thenReturn(new Position(4, 5));

        List<PowerUp> powerUps = new ArrayList<>();
        powerUps.add(powerUp);
        map.setPowerUps(powerUps);
        controller.moveLeft();

        assertEquals(new Position(4, 5), pacman.getPosition());
        Mockito.verify(powerUp, Mockito.times(1)).getPowerStrategy();
        Mockito.verify(powerStrategy, Mockito.times(1)).power(map);
    }

    @Test
    void moveUpCollectPowerUp() {
        mockPowerUp();
        Mockito.when(powerUp.getPosition()).thenReturn(new Position(5, 4));

        List<PowerUp> powerUps = new ArrayList<>();
        powerUps.add(powerUp);
        map.setPowerUps(powerUps);
        controller.moveUp();

        assertEquals(new Position(5, 4), pacman.getPosition());
        Mockito.verify(powerUp, Mockito.times(1)).getPowerStrategy();
        Mockito.verify(powerStrategy, Mockito.times(1)).power(map);
    }

    @Test
    void moveDownCollectPowerUp() {
        mockPowerUp();
        Mockito.when(powerUp.getPosition()).thenReturn(new Position(5, 6));

        List<PowerUp> powerUps = new ArrayList<>();
        powerUps.add(powerUp);
        map.setPowerUps(powerUps);
        controller.moveDown();

        assertEquals(new Position(5, 6), pacman.getPosition());
        Mockito.verify(powerUp, Mockito.times(1)).getPowerStrategy();
        Mockito.verify(powerStrategy, Mockito.times(1)).power(map);
    }

    private void mockKeyObservers() {
        keyObserver = Mockito.mock(KeyObserver.class);

        key.addKeyObserver(keyObserver);
        key.addKeyObserver(keyObserver);
    }

    @Test
    void moveRightCollectKey() {
        key = new Key(6, 5);
        mockKeyObservers();

        List<Key> keys = new ArrayList<>();
        keys.add(key);
        map.setKeys(keys);
        controller.moveRight();

        assertEquals(new Position(6, 5), pacman.getPosition());
        assertTrue(key.isCollected());
        Mockito.verify(keyObserver, Mockito.times(2)).collected(key);
    }

    @Test
    void moveLeftCollectKey() {
        key = new Key(4, 5);
        mockKeyObservers();

        List<Key> keys = new ArrayList<>();
        keys.add(key);
        map.setKeys(keys);
        controller.moveLeft();

        assertEquals(new Position(4, 5), pacman.getPosition());
        assertTrue(key.isCollected());
        Mockito.verify(keyObserver, Mockito.times(2)).collected(key);
    }

    @Test
    void moveUpCollectKey() {
        key = new Key(5, 4);
        mockKeyObservers();

        List<Key> keys = new ArrayList<>();
        keys.add(key);
        map.setKeys(keys);
        controller.moveUp();

        assertEquals(new Position(5, 4), pacman.getPosition());
        assertTrue(key.isCollected());
        Mockito.verify(keyObserver, Mockito.times(2)).collected(key);
    }

    @Test
    void moveDownCollectKey() {
        key = new Key(5, 6);
        mockKeyObservers();

        List<Key> keys = new ArrayList<>();
        keys.add(key);
        map.setKeys(keys);
        controller.moveDown();

        assertEquals(new Position(5, 6), pacman.getPosition());
        assertTrue(key.isCollected());
        Mockito.verify(keyObserver, Mockito.times(2)).collected(key);
    }

    @Test
    void moveRightTeleportInBounds() {
        pacman.setPosition(new Position(9, 5));
        controller.moveRight();

        assertEquals(new Position(0, 5), pacman.getPosition());
    }

    @Test
    void moveLeftTeleportInBounds() {
        pacman.setPosition(new Position(0, 5));
        controller.moveLeft();

        assertEquals(new Position(9, 5), pacman.getPosition());
    }

    @Test
    void moveUpTeleportInBounds() {
        pacman.setPosition(new Position(5, 0));
        controller.moveUp();

        assertEquals(new Position(5, 9), pacman.getPosition());
    }

    @Test
    void moveDownTeleportInBounds() {
        pacman.setPosition(new Position(5, 9));
        controller.moveDown();

        assertEquals(new Position(5, 0), pacman.getPosition());
    }
}
package com.lpoo2021.g75.view.game;

import com.lpoo2021.g75.model.game.Position;
import com.lpoo2021.g75.model.game.elements.fixedElements.Door;
import com.lpoo2021.g75.model.game.elements.fixedElements.collectable.keys.Key;
import com.lpoo2021.g75.model.game.elements.fixedElements.collectable.powerUps.*;
import com.lpoo2021.g75.model.game.map.Map;
import com.lpoo2021.g75.model.game.elements.dynamicElements.Pacman;
import com.lpoo2021.g75.model.game.elements.dynamicElements.ghosts.*;
import com.lpoo2021.g75.model.game.elements.fixedElements.collectable.Coin;
import com.lpoo2021.g75.model.game.elements.fixedElements.Wall;
import com.lpoo2021.g75.view.game.GameViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.lpoo2021.g75.view.GUI.GUI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class GameViewerTest {
    private GUI gui;
    private GameViewer viewer;
    private Map map;

    @BeforeEach
    void setUp() {
        map = Mockito.mock(Map.class);
        gui = Mockito.mock(GUI.class);
        viewer = new GameViewer(map);

        Pacman pacman = new Pacman(10, 10);
        List<Wall> walls = Arrays.asList(new Wall(1, 1), new Wall(3, 4), new Wall(4, 5));
        List<Coin> coins = Arrays.asList(new Coin(10, 15), new Coin(15, 10));
        List<Ghost> ghosts = Arrays.asList(new KillerGhost(2, 7), new ReduceScoreGhost(7, 2), new ResetCoinsGhost(18, 17), new EliminatePowerUpsGhost(17, 18));
        List<PowerUp> powerUps = Arrays.asList(new Cherry(3, 13), new Apple(18, 3), new Orange(5, 9), new Pear(18, 8));
        List<Key> keys = Collections.singletonList(new Key(19, 12, "#58006E"));
        List<Door> doors = Collections.singletonList(new Door(5, 2, "#58006E"));

        Mockito.when(map.getPacman()).thenReturn(pacman);
        Mockito.when(map.getWalls()).thenReturn(walls);
        Mockito.when(map.getNotCollectedCoins()).thenReturn(coins);
        Mockito.when(map.getGhosts()).thenReturn(ghosts);
        Mockito.when(map.getPowerUps()).thenReturn(powerUps);
        Mockito.when(map.getKeys()).thenReturn(keys);
        Mockito.when(map.getClosedDoors()).thenReturn(doors);
    }

    @Test
    void drawPacman() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawPacman(Mockito.any(Position.class));
        Mockito.verify(gui, Mockito.times(1)).drawPacman(new Position(10, 10));
    }

    @Test
    void drawWalls() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(3)).drawWall(Mockito.any(Position.class));
        Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(1, 1));
        Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(3, 4));
        Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(4, 5));
    }

    @Test
    void drawNotCollectedCoins() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(2)).drawCoin(Mockito.any(Position.class));
        Mockito.verify(gui, Mockito.times(1)).drawCoin(new Position(10, 15));
        Mockito.verify(gui, Mockito.times(1)).drawCoin(new Position(15, 10));
    }

    @Test
    void drawNormalGhosts() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawKillerGhost(Mockito.any(Position.class), Mockito.any(Boolean.class));
        Mockito.verify(gui, Mockito.times(1)).drawKillerGhost(new Position(2, 7), Boolean.FALSE);

        Mockito.verify(gui, Mockito.times(1)).drawReduceScoreGhost(Mockito.any(Position.class), Mockito.any(Boolean.class));
        Mockito.verify(gui, Mockito.times(1)).drawReduceScoreGhost(new Position(7, 2), Boolean.FALSE);

        Mockito.verify(gui, Mockito.times(1)).drawResetCoinsGhost(Mockito.any(Position.class), Mockito.any(Boolean.class));
        Mockito.verify(gui, Mockito.times(1)).drawResetCoinsGhost(new Position(18, 17), Boolean.FALSE);

        Mockito.verify(gui, Mockito.times(1)).drawEliminatePwUGhost(Mockito.any(Position.class), Mockito.any(Boolean.class));
        Mockito.verify(gui, Mockito.times(1)).drawEliminatePwUGhost(new Position(17, 18), equals(false));
    }

    @Test
    void drawPowerUps() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawCherry(Mockito.any(Position.class));
        Mockito.verify(gui, Mockito.times(1)).drawCherry(new Position(3, 13));

        Mockito.verify(gui, Mockito.times(1)).drawApple(Mockito.any(Position.class));
        Mockito.verify(gui, Mockito.times(1)).drawApple(new Position(18, 3));

        Mockito.verify(gui, Mockito.times(1)).drawOrange(Mockito.any(Position.class));
        Mockito.verify(gui, Mockito.times(1)).drawOrange(new Position(5, 9));

        Mockito.verify(gui, Mockito.times(1)).drawPear(Mockito.any(Position.class));
        Mockito.verify(gui, Mockito.times(1)).drawPear(new Position(18, 8));
    }

    @Test
    void drawKeys() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawKey(Mockito.any(Position.class), Mockito.any(String.class));
        Mockito.verify(gui, Mockito.times(1)).drawKey(new Position(19, 12), "#58006E");
    }

    @Test
    void drawClosedDoors() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawDoor(Mockito.any(Position.class), Mockito.any(String.class));
        Mockito.verify(gui, Mockito.times(1)).drawDoor(new Position(5, 2), "#58006E");
    }

    @Test
    void drawLegendText() throws IOException {
        Pacman pacman = Mockito.mock(Pacman.class);
        Mockito.when(pacman.getLives()).thenReturn(3);
        Mockito.when(pacman.getScore()).thenReturn(150);
        Mockito.when(map.getPacman()).thenReturn(pacman);

        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(0, 0), "lives: 3   score: 150", "#FFD700");
    }

    @Test
    void guiCalls() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).clear();
        Mockito.verify(gui, Mockito.times(1)).refresh();
    }
}
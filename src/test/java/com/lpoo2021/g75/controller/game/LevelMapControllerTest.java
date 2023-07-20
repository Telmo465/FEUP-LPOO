package com.lpoo2021.g75.controller.game;

import com.lpoo2021.g75.Game;
import com.lpoo2021.g75.gamestates.*;
import com.lpoo2021.g75.model.game.map.Map;
import com.lpoo2021.g75.model.game.elements.dynamicElements.Pacman;
import com.lpoo2021.g75.view.GUI.GUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

class LevelMapControllerTest {
    private GameController controller;
    private Game game;
    private Map map;
    private Pacman pacman;

    @BeforeEach
    void setUp() {
        game = Mockito.mock(Game.class);
        map = Mockito.mock(Map.class);
        pacman = Mockito.mock(Pacman.class);

        Mockito.when(map.getPacman()).thenReturn(pacman);
        controller = new LevelMapController(map);
    }

    @Test
    void stepQuit() throws IOException {
        controller.step(game, GUI.ACTION.QUIT, 1000);

        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any(PauseLevelMenuState.class));
    }

    @Test
    void stepWin() throws IOException {
        Mockito.when(map.hasNotCollectedCoins()).thenReturn(false);

        controller.step(game, GUI.ACTION.NONE, 1000);

        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any(WinLevelMenuState.class));
    }

    @Test
    void stepLose() throws IOException {
        Mockito.when(map.hasNotCollectedCoins()).thenReturn(true);
        Mockito.when(pacman.hasLives()).thenReturn(false);

        controller.step(game, GUI.ACTION.NONE, 1000);

        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any(LoseLevelMenuState.class));
    }

    @Test
    void stepPlay() throws IOException {
        Mockito.when(map.hasNotCollectedCoins()).thenReturn(true);
        Mockito.when(pacman.hasLives()).thenReturn(true);

        controller.step(game, GUI.ACTION.NONE, 1000);

        Mockito.verify(game, Mockito.times(0)).setState(Mockito.any(PauseLevelMenuState.class));
        Mockito.verify(game, Mockito.times(0)).setState(Mockito.any(WinLevelMenuState.class));
        Mockito.verify(game, Mockito.times(0)).setState(Mockito.any(LoseLevelMenuState.class));
    }
}
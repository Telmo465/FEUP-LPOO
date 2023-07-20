package com.lpoo2021.g75.controller.menu;

import com.lpoo2021.g75.Game;
import com.lpoo2021.g75.gamestates.LevelGameState;
import com.lpoo2021.g75.gamestates.RndGameState;
import com.lpoo2021.g75.gamestates.State;
import com.lpoo2021.g75.model.menu.MainMenu;
import com.lpoo2021.g75.view.GUI.GUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MainMenuControllerTest {
    private MainMenuController controller;
    private MainMenu menu;
    private Game game;

    @BeforeEach
    void setUp() {
        menu = Mockito.mock(MainMenu.class);
        game = Mockito.mock(Game.class);
        Mockito.when(menu.getStartLevel()).thenReturn(1);

        controller = new MainMenuController(menu);
    }

    @Test
    void stepUp() throws IOException {
        controller.step(game, GUI.ACTION.UP, 1000);

        Mockito.verify(menu, Mockito.times(1)).previousEntry();
    }

    @Test
    void stepDown() throws IOException {
        controller.step(game, GUI.ACTION.DOWN, 1000);

        Mockito.verify(menu, Mockito.times(1)).nextEntry();
    }

    @Test
    void stepSelectRndGame() throws IOException {
        Mockito.when(menu.isSelectedStartRandom()).thenReturn(true);

        controller.step(game, GUI.ACTION.SELECT, 1000);

        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any(RndGameState.class));
    }

    @Test
    void stepSelectSequentialGame() throws IOException {
        Mockito.when(menu.isSelectedStartRandom()).thenReturn(false);
        Mockito.when(menu.isSelectedStartSequential()).thenReturn(true);

        controller.step(game, GUI.ACTION.SELECT, 1000);

        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any(LevelGameState.class));
    }

    @Test
    void stepSelectExit() throws IOException {
        Mockito.when(menu.isSelectedStartRandom()).thenReturn(false);
        Mockito.when(menu.isSelectedStartSequential()).thenReturn(false);
        Mockito.when(menu.isSelectedExit()).thenReturn(true);

        controller.step(game, GUI.ACTION.SELECT, 1000);

        Mockito.verify(game, Mockito.times(1)).setState(null);
    }

    @Test
    void stepNothing() throws IOException {
        Mockito.when(menu.isSelectedStartRandom()).thenReturn(false);
        Mockito.when(menu.isSelectedStartSequential()).thenReturn(false);
        Mockito.when(menu.isSelectedExit()).thenReturn(false);

        controller.step(game, GUI.ACTION.SELECT, 1000);

        Mockito.verify(game, Mockito.times(0)).setState(Mockito.any(State.class));
    }
}
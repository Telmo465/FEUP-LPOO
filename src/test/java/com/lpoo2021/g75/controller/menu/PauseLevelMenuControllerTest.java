package com.lpoo2021.g75.controller.menu;

import com.lpoo2021.g75.Game;
import com.lpoo2021.g75.gamestates.LevelGameState;
import com.lpoo2021.g75.gamestates.MainMenuState;
import com.lpoo2021.g75.gamestates.State;
import com.lpoo2021.g75.model.menu.PauseLevelMenu;
import com.lpoo2021.g75.view.GUI.GUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PauseLevelMenuControllerTest {
    private PauseLevelMenuController controller;
    private PauseLevelMenu menu;
    private Game game;

    @BeforeEach
    void setUp() {
        menu = Mockito.mock(PauseLevelMenu.class);
        game = Mockito.mock(Game.class);
        Mockito.when(menu.getLevel()).thenReturn(1);

        controller = new PauseLevelMenuController(menu);
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
    void stepSelectResume() throws IOException {
        Mockito.when(menu.isSelectedResume()).thenReturn(true);

        controller.step(game, GUI.ACTION.SELECT, 1000);

        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any(LevelGameState.class));
    }

    @Test
    void stepSelectRestart() throws IOException {
        Mockito.when(menu.isSelectedResume()).thenReturn(false);
        Mockito.when(menu.isSelectedRestart()).thenReturn(true);

        controller.step(game, GUI.ACTION.SELECT, 1000);

        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any(LevelGameState.class));
    }

    @Test
    void stepSelectBack() throws IOException {
        Mockito.when(menu.isSelectedResume()).thenReturn(false);
        Mockito.when(menu.isSelectedRestart()).thenReturn(false);
        Mockito.when(menu.isSelectedBack()).thenReturn(true);

        controller.step(game, GUI.ACTION.SELECT, 1000);

        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any(MainMenuState.class));
    }

    @Test
    void stepNothing() throws IOException {
        Mockito.when(menu.isSelectedResume()).thenReturn(false);
        Mockito.when(menu.isSelectedRestart()).thenReturn(false);
        Mockito.when(menu.isSelectedBack()).thenReturn(false);

        controller.step(game, GUI.ACTION.SELECT, 1000);

        Mockito.verify(game, Mockito.times(0)).setState(Mockito.any(State.class));
    }
}
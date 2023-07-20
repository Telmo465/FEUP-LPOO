package com.lpoo2021.g75.controller.menu;

import com.lpoo2021.g75.Game;
import com.lpoo2021.g75.gamestates.LevelGameState;
import com.lpoo2021.g75.gamestates.MainMenuState;
import com.lpoo2021.g75.gamestates.RndGameState;
import com.lpoo2021.g75.gamestates.State;
import com.lpoo2021.g75.model.game.map.FileMapBuilder;
import com.lpoo2021.g75.model.menu.LoseRndMenu;
import com.lpoo2021.g75.model.menu.MainMenu;
import com.lpoo2021.g75.model.menu.WinLevelMenu;
import com.lpoo2021.g75.view.GUI.GUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class WinLevelMenuControllerTest {
    private WinLevelMenuController controller;
    private WinLevelMenu menu;
    private Game game;

    @BeforeEach
    void setUp() {
        menu = Mockito.mock(WinLevelMenu.class);
        game = Mockito.mock(Game.class);

        controller = new WinLevelMenuController(menu);
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
    void stepSelectContinue() throws IOException {
        Mockito.when(menu.isSelectedContinue()).thenReturn(true);
        Mockito.when(menu.isLastLevel()).thenReturn(false);

        controller.step(game, GUI.ACTION.SELECT, 1000);

        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any(LevelGameState.class));
    }

    @Test
    void stepSelectContinueLastLevel() throws IOException {
        Mockito.when(menu.isSelectedContinue()).thenReturn(true);
        Mockito.when(menu.isLastLevel()).thenReturn(true);

        controller.step(game, GUI.ACTION.SELECT, 1000);

        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any(LevelGameState.class));
    }

    @Test
    void stepSelectBack() throws IOException {
        Mockito.when(menu.isSelectedContinue()).thenReturn(false);
        Mockito.when(menu.isSelectedBack()).thenReturn(true);
        Mockito.when(menu.isLastLevel()).thenReturn(false);

        controller.step(game, GUI.ACTION.SELECT, 1000);

        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any(MainMenuState.class));
    }

    @Test
    void stepSelectBackLastLevel() throws IOException {
        Mockito.when(menu.isSelectedContinue()).thenReturn(false);
        Mockito.when(menu.isSelectedBack()).thenReturn(true);
        Mockito.when(menu.isLastLevel()).thenReturn(true);

        controller.step(game, GUI.ACTION.SELECT, 1000);

        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any(MainMenuState.class));
    }

    @Test
    void stepSelectExit() throws IOException {
        Mockito.when(menu.isSelectedContinue()).thenReturn(false);
        Mockito.when(menu.isSelectedBack()).thenReturn(false);
        Mockito.when(menu.isSelectedExit()).thenReturn(true);

        controller.step(game, GUI.ACTION.SELECT, 1000);

        Mockito.verify(game, Mockito.times(1)).setState(null);
    }

    @Test
    void stepNothing() throws IOException {
        Mockito.when(menu.isSelectedContinue()).thenReturn(false);
        Mockito.when(menu.isSelectedBack()).thenReturn(false);
        Mockito.when(menu.isSelectedExit()).thenReturn(false);

        controller.step(game, GUI.ACTION.SELECT, 1000);

        Mockito.verify(game, Mockito.times(0)).setState(Mockito.any(State.class));
    }
}
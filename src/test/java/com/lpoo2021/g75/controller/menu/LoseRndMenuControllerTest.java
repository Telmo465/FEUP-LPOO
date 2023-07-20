package com.lpoo2021.g75.controller.menu;

import com.lpoo2021.g75.Game;
import com.lpoo2021.g75.gamestates.MainMenuState;
import com.lpoo2021.g75.gamestates.RndGameState;
import com.lpoo2021.g75.gamestates.State;
import com.lpoo2021.g75.model.menu.LoseRndMenu;
import com.lpoo2021.g75.view.GUI.GUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LoseRndMenuControllerTest {
    private LoseRndMenuController controller;
    private LoseRndMenu menu;
    private Game game;

    @BeforeEach
    void setUp() {
        menu = Mockito.mock(LoseRndMenu.class);
        game = Mockito.mock(Game.class);

        controller = new LoseRndMenuController(menu);
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
    void stepSelectTryAgain() throws IOException {
        Mockito.when(menu.isSelectedTryAgain()).thenReturn(true);

        controller.step(game, GUI.ACTION.SELECT, 1000);

        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any(RndGameState.class));
    }

    @Test
    void stepSelectBack() throws IOException {
        Mockito.when(menu.isSelectedTryAgain()).thenReturn(false);
        Mockito.when(menu.isSelectedBack()).thenReturn(true);

        controller.step(game, GUI.ACTION.SELECT, 1000);

        Mockito.verify(game, Mockito.times(1)).setState(Mockito.any(MainMenuState.class));
    }

    @Test
    void stepSelectExit() throws IOException {
        Mockito.when(menu.isSelectedTryAgain()).thenReturn(false);
        Mockito.when(menu.isSelectedBack()).thenReturn(false);
        Mockito.when(menu.isSelectedExit()).thenReturn(true);

        controller.step(game, GUI.ACTION.SELECT, 1000);

        Mockito.verify(game, Mockito.times(1)).setState(null);
    }

    @Test
    void stepNothing() throws IOException {
        Mockito.when(menu.isSelectedTryAgain()).thenReturn(false);
        Mockito.when(menu.isSelectedBack()).thenReturn(false);
        Mockito.when(menu.isSelectedExit()).thenReturn(false);

        controller.step(game, GUI.ACTION.SELECT, 1000);

        Mockito.verify(game, Mockito.times(0)).setState(Mockito.any(State.class));
    }
}
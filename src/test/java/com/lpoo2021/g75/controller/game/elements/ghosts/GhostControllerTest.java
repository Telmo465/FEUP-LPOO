package com.lpoo2021.g75.controller.game.elements.ghosts;

import com.lpoo2021.g75.Game;
import com.lpoo2021.g75.controller.game.elements.ghosts.states.NormalGhostState;
import com.lpoo2021.g75.model.game.Position;
import com.lpoo2021.g75.model.game.map.Map;
import com.lpoo2021.g75.model.game.elements.dynamicElements.Pacman;
import com.lpoo2021.g75.model.game.elements.dynamicElements.ghosts.Ghost;
import com.lpoo2021.g75.model.game.elements.fixedElements.Wall;
import com.lpoo2021.g75.view.GUI.GUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

class GhostControllerTest {
    private GhostController controller;
    private Map map;
    private Game game;

    private GhostState ghostState;
    private Ghost ghost;

    @BeforeEach
    void setUp() {
        map = Mockito.mock(Map.class);
        ghost = Mockito.mock(Ghost.class);
        ghostState = Mockito.mock(GhostState.class);

        Mockito.when(map.getGhosts()).thenReturn(Collections.singletonList(ghost));
        Mockito.when(ghost.getState()).thenReturn(ghostState);

        controller = new GhostController(map);
        game = Mockito.mock(Game.class);
    }

    @Test
    void step() throws IOException {
        controller.step(game, GUI.ACTION.NONE, 1000);
        controller.step(game, GUI.ACTION.NONE, 1300);

        Mockito.verify(ghostState, Mockito.times(1)).step(map);
    }

    @Test
    void timePasses() throws IOException {
        controller.step(game, GUI.ACTION.NONE, 1100);
        controller.step(game, GUI.ACTION.NONE, 1200);

        Mockito.verify(ghostState, Mockito.times(1)).timePasses();
    }
}
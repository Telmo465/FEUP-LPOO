package com.lpoo2021.g75.view.game;

import com.lpoo2021.g75.controller.game.elements.ghosts.states.ParalyzeGhostState;
import com.lpoo2021.g75.model.game.elements.dynamicElements.ghosts.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.lpoo2021.g75.view.GUI.GUI;

class GhostViewerTest {
    private Ghost ghost;
    private GhostViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        viewer = new GhostViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawNormalKillerGhost() {
        ghost = new KillerGhost(10, 10);
        viewer.draw(ghost, gui);

        Mockito.verify(gui, Mockito.times(1)).drawKillerGhost(ghost.getPosition(), false);
    }

    @Test
    void drawNormalResetCoinsGhost() {
        ghost = new ResetCoinsGhost(10, 10);
        viewer.draw(ghost, gui);

        Mockito.verify(gui, Mockito.times(1)).drawResetCoinsGhost(ghost.getPosition(), false);
    }

    @Test
    void drawNormalEliminatePowerUpsGhost() {
        ghost = new EliminatePowerUpsGhost(10, 10);
        viewer.draw(ghost, gui);

        Mockito.verify(gui, Mockito.times(1)).drawEliminatePwUGhost(ghost.getPosition(), false);
    }

    @Test
    void drawNormalReduceScoreGhost() {
        ghost = new ReduceScoreGhost(10, 10);
        viewer.draw(ghost, gui);

        Mockito.verify(gui, Mockito.times(1)).drawReduceScoreGhost(ghost.getPosition(), false);
    }

    @Test
    void drawParalyzedKillerGhost() {
        ghost = new KillerGhost(10, 10);
        ghost.setState(Mockito.mock(ParalyzeGhostState.class));
        viewer.draw(ghost, gui);

        Mockito.verify(gui, Mockito.times(1)).drawKillerGhost(ghost.getPosition(), true);
    }

    @Test
    void drawParalyzedResetCoinsGhost() {
        ghost = new ResetCoinsGhost(10, 10);
        ghost.setState(Mockito.mock(ParalyzeGhostState.class));
        viewer.draw(ghost, gui);

        Mockito.verify(gui, Mockito.times(1)).drawResetCoinsGhost(ghost.getPosition(), true);
    }

    @Test
    void drawParalyzedEliminatePowerUpsGhost() {
        ghost = new EliminatePowerUpsGhost(10, 10);
        ghost.setState(Mockito.mock(ParalyzeGhostState.class));
        viewer.draw(ghost, gui);

        Mockito.verify(gui, Mockito.times(1)).drawEliminatePwUGhost(ghost.getPosition(), true);
    }

    @Test
    void drawParalyzedReduceScoreGhost() {
        ghost = new ReduceScoreGhost(10, 10);
        ghost.setState(Mockito.mock(ParalyzeGhostState.class));
        viewer.draw(ghost, gui);

        Mockito.verify(gui, Mockito.times(1)).drawReduceScoreGhost(ghost.getPosition(), true);
    }
}
package com.lpoo2021.g75.view.game;

import com.lpoo2021.g75.model.game.elements.dynamicElements.Pacman;
import com.lpoo2021.g75.view.game.PacmanViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.lpoo2021.g75.view.GUI.GUI;

class PacmanViewerTest {
    private Pacman pacman;
    private PacmanViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        pacman = new Pacman(10, 10);
        viewer = new PacmanViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(pacman, gui);
        Mockito.verify(gui, Mockito.times(1)).drawPacman(pacman.getPosition());
    }
}
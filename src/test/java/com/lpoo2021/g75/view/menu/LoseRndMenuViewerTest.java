package com.lpoo2021.g75.view.menu;

import com.lpoo2021.g75.model.game.Position;
import com.lpoo2021.g75.model.menu.LoseRndMenu;
import com.lpoo2021.g75.view.GUI.GUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LoseRndMenuViewerTest {
    private LoseRndMenuViewer viewer;
    private LoseRndMenu menu;
    private GUI gui;

    @BeforeEach
    void setUp() {
        menu = new LoseRndMenu(350);
        viewer = new LoseRndMenuViewer(menu);
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElements() throws IOException {
        viewer.draw(gui);

        int nText = 1 + menu.getNumberEntries();
        Mockito.verify(gui, Mockito.times(1)).drawTitle(Mockito.any(Position.class));
        Mockito.verify(gui, Mockito.times(1)).drawGameSymbols(Mockito.any(Position.class));
        Mockito.verify(gui, Mockito.times(nText)).drawText(Mockito.any(Position.class), Mockito.any(String.class), Mockito.any(String.class));
        Mockito.verify(gui, Mockito.times(1)).drawCherry(Mockito.any(Position.class));
    }
}
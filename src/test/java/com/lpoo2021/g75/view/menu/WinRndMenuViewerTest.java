package com.lpoo2021.g75.view.menu;

import com.lpoo2021.g75.model.game.Position;
import com.lpoo2021.g75.model.menu.LoseLevelMenu;
import com.lpoo2021.g75.model.menu.WinRndMenu;
import com.lpoo2021.g75.view.GUI.GUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class WinRndMenuViewerTest {
    private WinRndMenuViewer viewer;
    private WinRndMenu menu;
    private GUI gui;

    @BeforeEach
    void setUp() {
        menu = new WinRndMenu(500, 2);
        viewer = new WinRndMenuViewer(menu);
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElements() throws IOException {
        viewer.draw(gui);

        int nText = 2 + menu.getNumberEntries();
        Mockito.verify(gui, Mockito.times(1)).drawTitle(Mockito.any(Position.class));
        Mockito.verify(gui, Mockito.times(1)).drawGameSymbols(Mockito.any(Position.class));
        Mockito.verify(gui, Mockito.times(nText)).drawText(Mockito.any(Position.class), Mockito.any(String.class), Mockito.any(String.class));
        Mockito.verify(gui, Mockito.times(1)).drawCherry(Mockito.any(Position.class));
    }
}
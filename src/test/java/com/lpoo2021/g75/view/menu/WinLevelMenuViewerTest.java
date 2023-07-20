package com.lpoo2021.g75.view.menu;

import com.lpoo2021.g75.model.game.Position;
import com.lpoo2021.g75.model.menu.LoseLevelMenu;
import com.lpoo2021.g75.model.menu.WinLevelMenu;
import com.lpoo2021.g75.view.GUI.GUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class WinLevelMenuViewerTest {
    private WinLevelMenuViewer viewer;
    private WinLevelMenu menu;
    private GUI gui;

    @BeforeEach
    void setUp() {
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElementsNotLastLevel() throws IOException {
        menu = new WinLevelMenu(1, 350, 2);
        viewer = new WinLevelMenuViewer(menu);

        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawTitle(Mockito.any(Position.class));
        Mockito.verify(gui, Mockito.times(1)).drawGameSymbols(Mockito.any(Position.class));
        Mockito.verify(gui, Mockito.times(2)).drawPacman(Mockito.any(Position.class));

        int nText = 2 + menu.getNumberEntries();
        Mockito.verify(gui, Mockito.times(nText)).drawText(Mockito.any(Position.class), Mockito.any(String.class), Mockito.any(String.class));
    }

    @Test
    void drawElementsLastLevel() throws IOException {
        menu = new WinLevelMenu(7, 350, 2);
        viewer = new WinLevelMenuViewer(menu);

        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawTitle(Mockito.any(Position.class));
        Mockito.verify(gui, Mockito.times(1)).drawGameSymbols(Mockito.any(Position.class));
        Mockito.verify(gui, Mockito.times(1)).drawCherry(Mockito.any(Position.class));

        int nText = 2 + menu.getNumberEntries();
        Mockito.verify(gui, Mockito.times(nText)).drawText(Mockito.any(Position.class), Mockito.any(String.class), Mockito.any(String.class));
    }
}
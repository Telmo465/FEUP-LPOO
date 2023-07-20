package com.lpoo2021.g75.view.menu;

import com.lpoo2021.g75.model.game.Position;
import com.lpoo2021.g75.model.game.map.Map;
import com.lpoo2021.g75.model.menu.PauseLevelMenu;
import com.lpoo2021.g75.view.GUI.GUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PauseLevelMenuViewerTest {
    private PauseLevelMenuViewer viewer;
    private PauseLevelMenu menu;
    private GUI gui;

    @BeforeEach
    void setUp() {
        Map map = Mockito.mock(Map.class);
        menu = new PauseLevelMenu(map, 1);
        viewer = new PauseLevelMenuViewer(menu);
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElements() throws IOException {
        viewer.draw(gui);

        int nText = 1 + menu.getNumberEntries();
        Mockito.verify(gui, Mockito.times(1)).drawTitle(Mockito.any(Position.class));
        Mockito.verify(gui, Mockito.times(1)).drawGameSymbols(Mockito.any(Position.class));
        Mockito.verify(gui, Mockito.times(nText)).drawText(Mockito.any(Position.class), Mockito.any(String.class), Mockito.any(String.class));
    }
}
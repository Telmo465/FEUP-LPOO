package com.lpoo2021.g75.gamestates;

import com.lpoo2021.g75.controller.menu.PauseRndMenuController;
import com.lpoo2021.g75.model.menu.PauseRndMenu;
import com.lpoo2021.g75.view.menu.PauseRndMenuViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class PauseRndMenuStateTest {
    @Test
    void initState() {
        PauseRndMenu menu = Mockito.mock(PauseRndMenu.class);
        PauseRndMenuState state = new PauseRndMenuState(menu);

        assertEquals(menu, state.getModel());
        assertEquals(PauseRndMenuViewer.class, state.getViewer().getClass());
        assertEquals(menu, state.getViewer().getModel());
        assertEquals(PauseRndMenuController.class, state.getController().getClass());
        assertEquals(menu, state.getController().getModel());
    }
}
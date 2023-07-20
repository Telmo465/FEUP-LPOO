package com.lpoo2021.g75.gamestates;

import com.lpoo2021.g75.controller.menu.LoseRndMenuController;
import com.lpoo2021.g75.model.menu.LoseRndMenu;
import com.lpoo2021.g75.view.menu.LoseRndMenuViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class LoseRndMenuStateTest {
    @Test
    void initState() {
        LoseRndMenu menu = Mockito.mock(LoseRndMenu.class);
        LoseRndMenuState state = new LoseRndMenuState(menu);

        assertEquals(menu, state.getModel());
        assertEquals(LoseRndMenuViewer.class, state.getViewer().getClass());
        assertEquals(menu, state.getViewer().getModel());
        assertEquals(LoseRndMenuController.class, state.getController().getClass());
        assertEquals(menu, state.getController().getModel());
    }
}
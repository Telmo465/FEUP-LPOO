package com.lpoo2021.g75.gamestates;

import com.lpoo2021.g75.controller.menu.WinRndMenuController;
import com.lpoo2021.g75.model.menu.WinRndMenu;
import com.lpoo2021.g75.view.menu.WinRndMenuViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class WinRndMenuStateTest {

    @Test
    void initState() {
        WinRndMenu menu = Mockito.mock(WinRndMenu.class);
        WinRndMenuState state = new WinRndMenuState(menu);

        assertEquals(menu, state.getModel());
        assertEquals(WinRndMenuViewer.class, state.getViewer().getClass());
        assertEquals(menu, state.getViewer().getModel());
        assertEquals(WinRndMenuController.class, state.getController().getClass());
        assertEquals(menu, state.getController().getModel());
    }
}

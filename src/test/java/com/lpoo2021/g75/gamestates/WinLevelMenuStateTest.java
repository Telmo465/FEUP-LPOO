package com.lpoo2021.g75.gamestates;

import com.lpoo2021.g75.controller.menu.WinLevelMenuController;
import com.lpoo2021.g75.model.menu.WinLevelMenu;
import com.lpoo2021.g75.view.menu.WinLevelMenuViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class WinLevelMenuStateTest {

    @Test
    void initState() {
        WinLevelMenu menu = Mockito.mock(WinLevelMenu.class);
        WinLevelMenuState state = new WinLevelMenuState(menu);

        assertEquals(menu, state.getModel());
        assertEquals(WinLevelMenuViewer.class, state.getViewer().getClass());
        assertEquals(menu, state.getViewer().getModel());
        assertEquals(WinLevelMenuController.class, state.getController().getClass());
        assertEquals(menu, state.getController().getModel());
    }
}
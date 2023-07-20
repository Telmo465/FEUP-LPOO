package com.lpoo2021.g75.gamestates;

import com.lpoo2021.g75.controller.menu.PauseLevelMenuController;
import com.lpoo2021.g75.model.menu.PauseLevelMenu;
import com.lpoo2021.g75.view.menu.PauseLevelMenuViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class PauseLevelMenuStateTest {
    @Test
    void initState() {
        PauseLevelMenu menu = Mockito.mock(PauseLevelMenu.class);
        PauseLevelMenuState state = new PauseLevelMenuState(menu);

        assertEquals(menu, state.getModel());
        assertEquals(PauseLevelMenuViewer.class, state.getViewer().getClass());
        assertEquals(menu, state.getViewer().getModel());
        assertEquals(PauseLevelMenuController.class, state.getController().getClass());
        assertEquals(menu, state.getController().getModel());
    }
}
package com.lpoo2021.g75.gamestates;

import com.lpoo2021.g75.controller.menu.LoseLevelMenuController;
import com.lpoo2021.g75.model.menu.LoseLevelMenu;
import com.lpoo2021.g75.view.menu.LoseLevelMenuViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class LoseLevelMenuStateTest {
    @Test
    void initState() {
        LoseLevelMenu menu = Mockito.mock(LoseLevelMenu.class);
        LoseLevelMenuState state = new LoseLevelMenuState(menu);

        assertEquals(menu, state.getModel());
        assertEquals(LoseLevelMenuViewer.class, state.getViewer().getClass());
        assertEquals(menu, state.getViewer().getModel());
        assertEquals(LoseLevelMenuController.class, state.getController().getClass());
        assertEquals(menu, state.getController().getModel());
    }
}
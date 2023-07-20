package com.lpoo2021.g75.gamestates;

import com.lpoo2021.g75.controller.menu.MainMenuController;
import com.lpoo2021.g75.model.menu.MainMenu;
import com.lpoo2021.g75.view.menu.MainMenuViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class MainMenuStateTest {
    @Test
    void initState() {
        MainMenu menu = Mockito.mock(MainMenu.class);
        MainMenuState state = new MainMenuState(menu);

        assertEquals(menu, state.getModel());
        assertEquals(MainMenuViewer.class, state.getViewer().getClass());
        assertEquals(menu, state.getViewer().getModel());
        assertEquals(MainMenuController.class, state.getController().getClass());
        assertEquals(menu, state.getController().getModel());
    }
}
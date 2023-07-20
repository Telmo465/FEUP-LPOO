package com.lpoo2021.g75.model.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LoseLevelMenuTest {
    private LoseLevelMenu loseLevelMenu;

    @BeforeEach
    void setUp() throws IOException {
        loseLevelMenu = new LoseLevelMenu(2, 200);
    }

    @Test
    void createLoseLevelMenu(){
        assertEquals(2, loseLevelMenu.getLevel());
        assertEquals(200, loseLevelMenu.getScore());
        assertEquals(3, loseLevelMenu.getNumberEntries());
        assertEquals("try again", loseLevelMenu.getEntry(0));
        assertTrue(loseLevelMenu.isSelectedTryAgain());
        assertTrue(loseLevelMenu.isSelected(0));
    }

    @Test
    void secondOption(){
        loseLevelMenu.nextEntry();
        assertTrue(loseLevelMenu.isSelectedBack());
        assertEquals("back", loseLevelMenu.getEntry(1));
    }

    @Test
    void lastOption(){
        loseLevelMenu.nextEntry();
        loseLevelMenu.nextEntry();
        assertTrue(loseLevelMenu.isSelectedExit());
        assertEquals("exit", loseLevelMenu.getEntry(2));
    }

    @Test
    void previousEntry() {
        loseLevelMenu.previousEntry();
        assertTrue(loseLevelMenu.isSelectedExit());
    }
}

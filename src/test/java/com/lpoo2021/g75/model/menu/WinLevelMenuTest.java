package com.lpoo2021.g75.model.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class WinLevelMenuTest {
    private WinLevelMenu winLevelMenu;

    @BeforeEach
    void setUp() throws IOException {
        winLevelMenu = new WinLevelMenu(1,250,2);
    }

    @Test
    void createWinLevelMenu(){
        assertEquals(1, winLevelMenu.getLevel());
        assertEquals(250,winLevelMenu.getScore());
        assertEquals(2,winLevelMenu.getLives());
        assertEquals(3, winLevelMenu.getNumberEntries());
        assertEquals("continue", winLevelMenu.getEntry(0));
        assertTrue(winLevelMenu.isSelectedContinue());
        assertTrue(winLevelMenu.isSelected(0));
        assertFalse(winLevelMenu.isLastLevel());
    }

    @Test
    void secondOption(){
        winLevelMenu.nextEntry();
        assertTrue(winLevelMenu.isSelectedBack());
        assertEquals("back", winLevelMenu.getEntry(1));
    }

    @Test
    void lastOption(){
        winLevelMenu.nextEntry();
        winLevelMenu.nextEntry();
        assertTrue(winLevelMenu.isSelectedExit());
        assertEquals("exit", winLevelMenu.getEntry(2));
    }

    @Test
    void previousEntry() {
        winLevelMenu.previousEntry();
        assertTrue(winLevelMenu.isSelectedExit());
    }
}

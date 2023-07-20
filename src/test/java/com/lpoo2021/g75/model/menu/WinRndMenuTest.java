package com.lpoo2021.g75.model.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WinRndMenuTest {
    private WinRndMenu winRndMenu;

    @BeforeEach
    void setUp() {
        winRndMenu = new WinRndMenu(250,2);
    }

    @Test
    void createWinLevelMenu(){
        assertEquals(250,winRndMenu.getScore());
        assertEquals(2,winRndMenu.getLives());
        assertEquals(3, winRndMenu.getNumberEntries());
        assertEquals("try again", winRndMenu.getEntry(0));
        assertTrue(winRndMenu.isSelectedTryAgain());
        assertTrue(winRndMenu.isSelected(0));
    }

    @Test
    void secondOption(){
        winRndMenu.nextEntry();
        assertTrue(winRndMenu.isSelectedBack());
        assertEquals("back", winRndMenu.getEntry(1));
    }

    @Test
    void lastOption(){
        winRndMenu.nextEntry();
        winRndMenu.nextEntry();
        assertTrue(winRndMenu.isSelectedExit());
        assertEquals("exit", winRndMenu.getEntry(2));
    }

    @Test
    void previousEntry() {
        winRndMenu.previousEntry();
        assertTrue(winRndMenu.isSelectedExit());
    }
}

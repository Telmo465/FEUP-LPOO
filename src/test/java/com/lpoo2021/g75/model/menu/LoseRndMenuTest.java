package com.lpoo2021.g75.model.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LoseRndMenuTest {
    private LoseRndMenu loseRndMenu;

    @BeforeEach
    void setUp() {
        loseRndMenu = new LoseRndMenu(200);
    }

    @Test
    void createLoseRndMenu(){
        assertEquals(200, loseRndMenu.getScore());
        assertEquals(3, loseRndMenu.getNumberEntries());
        assertEquals("try again", loseRndMenu.getEntry(0));
        assertTrue(loseRndMenu.isSelectedTryAgain());
        assertTrue(loseRndMenu.isSelected(0));
    }

    @Test
    void secondOption(){
        loseRndMenu.nextEntry();
        assertTrue(loseRndMenu.isSelectedBack());
        assertEquals("back", loseRndMenu.getEntry(1));
    }

    @Test
    void lastOption(){
        loseRndMenu.nextEntry();
        loseRndMenu.nextEntry();
        assertTrue(loseRndMenu.isSelectedExit());
        assertEquals("exit", loseRndMenu.getEntry(2));
    }

    @Test
    void previousEntry() {
        loseRndMenu.previousEntry();
        assertTrue(loseRndMenu.isSelectedExit());
    }
}

package com.lpoo2021.g75.model.menu;

import com.lpoo2021.g75.model.game.map.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class PauseRndMenuTest {
    private PauseRndMenu pauseRndMenu;
    private Map map;

    @BeforeEach
    void setUp() {
        map = Mockito.mock(Map.class);
        pauseRndMenu = new PauseRndMenu(map);
    }

    @Test
    void createPauseMenu(){
        assertEquals(map, pauseRndMenu.getMap());
        assertEquals(3, pauseRndMenu.getNumberEntries());
        assertEquals("resume", pauseRndMenu.getEntry(0));
        assertTrue(pauseRndMenu.isSelectedResume());
        assertTrue(pauseRndMenu.isSelected(0));
    }

    @Test
    void secondOption(){
        pauseRndMenu.nextEntry();
        assertTrue(pauseRndMenu.isSelectedRestart());
        assertEquals("restart", pauseRndMenu.getEntry(1));
    }

    @Test
    void lastOption(){
        pauseRndMenu.nextEntry();
        pauseRndMenu.nextEntry();
        assertTrue(pauseRndMenu.isSelectedBack());assertEquals("resume", pauseRndMenu.getEntry(0));
        assertEquals("back", pauseRndMenu.getEntry(2));
    }

    @Test
    void previousEntry() {
        pauseRndMenu.previousEntry();
        assertTrue(pauseRndMenu.isSelectedBack());
    }
}

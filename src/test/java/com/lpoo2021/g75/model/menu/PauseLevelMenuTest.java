package com.lpoo2021.g75.model.menu;

import com.lpoo2021.g75.model.game.map.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class PauseLevelMenuTest {
    private PauseLevelMenu pauseLevelMenu;
    private Map map;

    @BeforeEach
    void setUp() {
        map = Mockito.mock(Map.class);
        pauseLevelMenu = new PauseLevelMenu(map,0);
    }

    @Test
    void createPauseMenu(){
        assertEquals(map, pauseLevelMenu.getMap());
        assertEquals(0,pauseLevelMenu.getLevel());
        assertEquals(3, pauseLevelMenu.getNumberEntries());
        assertEquals("resume", pauseLevelMenu.getEntry(0));
        assertTrue(pauseLevelMenu.isSelectedResume());
        assertTrue(pauseLevelMenu.isSelected(0));
    }

    @Test
    void option1(){
        pauseLevelMenu.nextEntry();
        assertTrue(pauseLevelMenu.isSelectedRestart());
        assertEquals("restart", pauseLevelMenu.getEntry(1));
    }

    @Test
    void option2(){
        pauseLevelMenu.nextEntry();
        pauseLevelMenu.nextEntry();
        assertTrue(pauseLevelMenu.isSelectedBack());
        assertEquals("back", pauseLevelMenu.getEntry(2));
    }

    @Test
    void previousEntry() {
        pauseLevelMenu.previousEntry();
        assertTrue(pauseLevelMenu.isSelectedBack());
    }
}

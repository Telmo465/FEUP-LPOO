package com.lpoo2021.g75.model.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MainMenuTest {
    private MainMenu mainMenu;

    @BeforeEach
    void setUp() {
        mainMenu = new MainMenu(0);
    }

    @Test
    void createMainMenu(){
        assertEquals(0, mainMenu.getStartLevel());
        assertEquals(3, mainMenu.getNumberEntries());
        assertEquals("start random game", mainMenu.getEntry(0));
        assertTrue(mainMenu.isSelectedStartRandom());
        assertTrue(mainMenu.isSelected(0));
    }

    @Test
    void createMainMenuStartFile() throws IOException {
        MainMenu readMenu = new MainMenu();
        assertEquals(1, readMenu.getStartLevel());
    }

    @Test
    void secondOption(){
        mainMenu.nextEntry();
        assertTrue(mainMenu.isSelectedStartSequential());
        assertEquals("start sequential game", mainMenu.getEntry(1));
    }

    @Test
    void lastOption(){
        mainMenu.nextEntry();
        mainMenu.nextEntry();
        assertTrue(mainMenu.isSelectedExit());
        assertEquals("exit", mainMenu.getEntry(2));

    }

    @Test
    void previousEntry() {
        mainMenu.previousEntry();
        assertTrue(mainMenu.isSelectedExit());
    }
}

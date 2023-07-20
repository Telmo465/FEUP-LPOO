package com.lpoo2021.g75.view.game;

import com.lpoo2021.g75.model.game.elements.fixedElements.Door;
import com.lpoo2021.g75.model.game.elements.fixedElements.collectable.Coin;
import com.lpoo2021.g75.view.GUI.GUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class DoorViewerTest {
    private Door door;
    private DoorViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        door = new Door(10, 10);
        viewer = new DoorViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(door, gui);
        Mockito.verify(gui, Mockito.times(1)).drawDoor(door.getPosition(),door.getColor());
    }
}
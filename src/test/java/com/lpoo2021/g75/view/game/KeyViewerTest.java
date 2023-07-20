package com.lpoo2021.g75.view.game;

import com.lpoo2021.g75.model.game.elements.fixedElements.collectable.keys.Key;
import com.lpoo2021.g75.view.GUI.GUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class KeyViewerTest {
    private Key key;
    private KeyViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        key = new Key(10, 10);
        viewer = new KeyViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(key, gui);
        Mockito.verify(gui, Mockito.times(1)).drawKey(key.getPosition(), key.getColor());
    }
}
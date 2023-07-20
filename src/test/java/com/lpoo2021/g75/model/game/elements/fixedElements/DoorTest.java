package com.lpoo2021.g75.model.game.elements.fixedElements;

import com.lpoo2021.g75.model.game.elements.fixedElements.collectable.keys.Key;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class DoorTest {
    private Door door;
    private Key key;

    @BeforeEach
    void setUp() {
        door = new Door(2, 4, "#FFFFFF");
        key = Mockito.mock(Key.class);
    }

    @Test
    void createDoor(){
        assertEquals(2,door.getPosition().getX());
        assertEquals(4,door.getPosition().getY());
        assertEquals("#FFFFFF", door.getColor());
        assertTrue(door.isClosed());
    }

    @Test
    void changeColor(){
        door.setColor("#AAFFFF");
        assertEquals("#AAFFFF", door.getColor());
    }

    @Test
    void isOpen(){
        door.collected(key);
        assertFalse(door.isClosed());
    }
}
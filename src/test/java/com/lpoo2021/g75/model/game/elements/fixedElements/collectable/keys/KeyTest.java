package com.lpoo2021.g75.model.game.elements.fixedElements.collectable.keys;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class KeyTest {
    private Key key;

    @BeforeEach
    void setUp() {
        key = new Key(2, 4);
    }

    @Test
    void createKey() {
        assertEquals(2, key.getPosition().getX());
        assertEquals(4, key.getPosition().getY());
        assertEquals("#FFFFFF", key.getColor());
        assertFalse(key.isCollected());
    }

    @Test
    void changeColor(){
        key.setColor("#AAFFFF");
        assertEquals("#AAFFFF", key.getColor());
    }

    @Test
    void collectKey() {
        key.collect();
        assertTrue(key.isCollected());
    }

    @Test
    void placeKey(){
        key.place();
        assertFalse(key.isCollected());
    }

    @Test
    void keyObservers() {
        KeyObserver observer = Mockito.mock(KeyObserver.class);
        for (int i = 0; i < 5; i++)
            key.addKeyObserver(observer);
        key.collect();

        assertEquals(5, key.getObservers().size());
        Mockito.verify(observer, Mockito.times(5)).collected(key);
    }
}
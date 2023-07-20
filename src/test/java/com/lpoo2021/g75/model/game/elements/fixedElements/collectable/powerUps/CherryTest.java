package com.lpoo2021.g75.model.game.elements.fixedElements.collectable.powerUps;

import com.lpoo2021.g75.controller.game.elements.powerUps.powerStrategies.AddLivePowerStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CherryTest {
    private Cherry cherry;

    @BeforeEach
    void setUp() {
        cherry = new Cherry(2, 4);
    }

    @Test
    void createCherry() {
        assertEquals(2,cherry.getPosition().getX());
        assertEquals(4,cherry.getPosition().getY());
        assertFalse(cherry.isCollected());
        assertEquals(AddLivePowerStrategy.class, cherry.getPowerStrategy().getClass());
    }

    @Test
    void collectCherry(){
        cherry.collect();
        assertTrue(cherry.isCollected());
    }

    @Test
    void placeCherry() {
        cherry.place();
        assertFalse(cherry.isCollected());
    }
}
package com.lpoo2021.g75.model.game.elements.fixedElements.collectable.powerUps;

import com.lpoo2021.g75.controller.game.elements.powerUps.powerStrategies.ParalyzeGhostPowerStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrangeTest {
    private Orange orange;

    @BeforeEach
    void setUp() {
        orange = new Orange(2, 4);
    }

    @Test
    void createOrange() {
        assertEquals(2,orange.getPosition().getX());
        assertEquals(4,orange.getPosition().getY());
        assertFalse(orange.isCollected());
        assertEquals(ParalyzeGhostPowerStrategy.class, orange.getPowerStrategy().getClass());
    }

    @Test
    void collectOrange(){
        orange.collect();
        assertTrue(orange.isCollected());
    }

    @Test
    void placeOrange() {
        orange.place();
        assertFalse(orange.isCollected());
    }
}
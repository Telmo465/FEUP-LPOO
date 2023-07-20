package com.lpoo2021.g75.model.game.elements.fixedElements.collectable.powerUps;

import com.lpoo2021.g75.controller.game.elements.powerUps.powerStrategies.CombinePowerStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PearTest {
    private Pear pear;

    @BeforeEach
    void setUp() {
        pear = new Pear(2, 4);
    }

    @Test
    void createPear() {
        assertEquals(2,pear.getPosition().getX());
        assertEquals(4,pear.getPosition().getY());
        assertFalse(pear.isCollected());
        assertEquals(CombinePowerStrategy.class, pear.getPowerStrategy().getClass());
    }

    @Test
    void collectPear(){
        pear.collect();
        assertTrue(pear.isCollected());
    }

    @Test
    void placePear() {
        pear.place();
        assertFalse(pear.isCollected());
    }
}
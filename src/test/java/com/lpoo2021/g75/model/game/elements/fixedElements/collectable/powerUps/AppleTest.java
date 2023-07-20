package com.lpoo2021.g75.model.game.elements.fixedElements.collectable.powerUps;

import com.lpoo2021.g75.controller.game.elements.powerUps.powerStrategies.IncreaseScorePowerStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppleTest {
    private Apple apple;

    @BeforeEach
    void setUp() {
        apple = new Apple(2, 4);
    }

    @Test
    void createApple() {
        assertEquals(2,apple.getPosition().getX());
        assertEquals(4,apple.getPosition().getY());
        assertFalse(apple.isCollected());
        assertEquals(IncreaseScorePowerStrategy.class, apple.getPowerStrategy().getClass());
    }

    @Test
    void collectApple(){
        apple.collect();
        assertTrue(apple.isCollected());
    }

    @Test
    void placeApple() {
        apple.place();
        assertFalse(apple.isCollected());
    }
}
package com.lpoo2021.g75.model.game.elements.dynamicElements;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrientationTest {
    @Test
    void allOptions() {
        List<Orientation> allOptions = Orientation.allOptions();
        assertEquals(4, allOptions.size());
    }

    @Test
    void getOpposites() {
        assertEquals(Orientation.LEFT, Orientation.RIGHT.getOpposite());
        assertEquals(Orientation.RIGHT, Orientation.LEFT.getOpposite());
        assertEquals(Orientation.DOWN, Orientation.UP.getOpposite());
        assertEquals(Orientation.UP, Orientation.DOWN.getOpposite());
    }
}
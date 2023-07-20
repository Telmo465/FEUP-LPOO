package com.lpoo2021.g75.model.game.elements.fixedElements;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WallTest {
    @Test
    void createWall() {
        Wall wall = new Wall(10, 10);
        assertEquals(10, wall.getPosition().getX());
        assertEquals(10, wall.getPosition().getY());
    }
}
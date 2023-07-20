package com.lpoo2021.g75.model.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {
    private Position position;

    @BeforeEach
    void setUp() {
        position = new Position(20, 10);
    }

    @Test
    public void positionInit() {
        assertEquals(20, position.getX());
        assertEquals(10, position.getY());
    }

    @Test
    public void positionCopy() {
        Position copyPosition = new Position(position);
        assertEquals(position.getX(), copyPosition.getX());
        assertEquals(position.getY(), copyPosition.getY());
    }

    @Test
    void getRight() {
        assertEquals(21, position.getRight().getX());
        assertEquals(10, position.getRight().getY());
    }

    @Test
    void getLeft() {
        assertEquals(19, position.getLeft().getX());
        assertEquals(10, position.getLeft().getY());
    }

    @Test
    void getUp() {
        assertEquals(9, position.getUp().getY());
        assertEquals(20, position.getUp().getX());
    }

    @Test
    void getDown() {
        assertEquals(11, position.getDown().getY());
        assertEquals(20, position.getDown().getX());
    }

    @Test
    void getRandomNeighbour() {
        Position neighbour = position.getRandomNeighbour();
        assertNotEquals(position, neighbour);
    }
}
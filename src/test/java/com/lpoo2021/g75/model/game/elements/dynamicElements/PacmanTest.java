package com.lpoo2021.g75.model.game.elements.dynamicElements;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PacmanTest {
    private Pacman pacman;

    @BeforeEach
    void setUp() {
        pacman = new Pacman(10, 10, 3);
    }

    @Test
    void createPacman() {
        assertEquals(10, pacman.getPosition().getX());
        assertEquals(10, pacman.getPosition().getY());
        assertEquals(3, pacman.getLives());
        assertEquals(0, pacman.getScore());
        assertTrue(pacman.hasLives());
    }

    @Test
    void loseLive() {
        pacman.loseLive();
        assertEquals(2, pacman.getLives());
        assertTrue(pacman.hasLives());
    }

    @Test
    void receiveLive(){
        pacman.receiveLive();
        assertEquals(4,pacman.getLives());
        assertTrue(pacman.hasLives());
    }

    @Test
    void hasNoLives() {
        pacman.loseLive();
        pacman.loseLive();
        pacman.loseLive();
        assertFalse(pacman.hasLives());
    }

    @Test
    void increaseScore() {
        pacman.increaseScore(20);
        assertEquals(20, pacman.getScore());
    }

    @Test
    void decreaseScore() {
        pacman.decreaseScore(20);
        assertEquals(-20, pacman.getScore());
    }

    @Test
    void resetPositiveScore() {
        pacman.increaseScore(20);
        pacman.resetScore();
        assertEquals(0, pacman.getScore());
    }

    @Test
    void resetNegativeScore() {
        pacman.decreaseScore(20);
        pacman.resetScore();
        assertEquals(0, pacman.getScore());
    }
}
package com.lpoo2021.g75.model.game.elements.fixedElements.collectable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinTest {
    private Coin coin;

    @BeforeEach
    void setUp() {
        coin = new Coin(2, 4);
    }

    @Test
    void createCoin() {
        assertEquals(2, coin.getPosition().getX());
        assertEquals(4, coin.getPosition().getY());
        assertFalse(coin.isCollected());
    }

    @Test
    void collectCoin() {
        coin.collect();
        assertTrue(coin.isCollected());
    }

    @Test
    void placeCoin() {
        coin.place();
        assertFalse(coin.isCollected());
    }
}
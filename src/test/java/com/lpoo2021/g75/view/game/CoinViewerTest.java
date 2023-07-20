package com.lpoo2021.g75.view.game;

import com.lpoo2021.g75.model.game.elements.fixedElements.collectable.Coin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.lpoo2021.g75.view.GUI.GUI;

class CoinViewerTest {
    private Coin coin;
    private CoinViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        coin = new Coin(10, 10);
        viewer = new CoinViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(coin, gui);
        Mockito.verify(gui, Mockito.times(1)).drawCoin(coin.getPosition());
    }
}
package com.lpoo2021.g75.view.game;

import com.lpoo2021.g75.model.game.elements.fixedElements.collectable.powerUps.*;
import com.lpoo2021.g75.view.GUI.GUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PowerUpViewerTest {
    private PowerUp powerUp;
    private PowerUpViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        viewer = new PowerUpViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawCherryPowerUp() {
        powerUp = new Cherry(10, 10);
        viewer.draw(powerUp, gui);

        Mockito.verify(gui, Mockito.times(1)).drawCherry(powerUp.getPosition());
    }

    @Test
    void drawApplePowerUp() {
        powerUp = new Apple(10, 10);
        viewer.draw(powerUp, gui);

        Mockito.verify(gui, Mockito.times(1)).drawApple(powerUp.getPosition());
    }

    @Test
    void drawOrangePowerUp() {
        powerUp = new Orange(10, 10);
        viewer.draw(powerUp, gui);

        Mockito.verify(gui, Mockito.times(1)).drawOrange(powerUp.getPosition());
    }

    @Test
    void drawPearPowerUp() {
        powerUp = new Pear(10, 10);
        viewer.draw(powerUp, gui);

        Mockito.verify(gui, Mockito.times(1)).drawPear(powerUp.getPosition());
    }
}
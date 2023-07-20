package com.lpoo2021.g75.view.game;

import com.lpoo2021.g75.model.game.elements.fixedElements.collectable.powerUps.*;
import com.lpoo2021.g75.view.GUI.GUI;

public class PowerUpViewer implements ElementViewer<PowerUp> {
    @Override
    public void draw(PowerUp powerUp, GUI gui) {
        if (powerUp instanceof Cherry) gui.drawCherry(powerUp.getPosition());
        else if (powerUp instanceof Apple) gui.drawApple(powerUp.getPosition());
        else if (powerUp instanceof Orange) gui.drawOrange(powerUp.getPosition());
        else if (powerUp instanceof Pear) gui.drawPear(powerUp.getPosition());
    }
}
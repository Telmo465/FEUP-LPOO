package com.lpoo2021.g75.model.game.elements.fixedElements.collectable.powerUps;

import com.lpoo2021.g75.controller.game.elements.powerUps.PowerStrategy;
import com.lpoo2021.g75.controller.game.elements.powerUps.powerStrategies.ParalyzeGhostPowerStrategy;

public class Orange extends PowerUp {
    public Orange(int x, int y) {
        super(x, y);
    }

    @Override
    protected PowerStrategy createPowerStrategy() {
        return new ParalyzeGhostPowerStrategy();
    }
}

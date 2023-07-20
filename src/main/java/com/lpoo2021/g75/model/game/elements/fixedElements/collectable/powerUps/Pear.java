package com.lpoo2021.g75.model.game.elements.fixedElements.collectable.powerUps;

import com.lpoo2021.g75.controller.game.elements.powerUps.PowerStrategy;
import com.lpoo2021.g75.controller.game.elements.powerUps.powerStrategies.CombinePowerStrategy;

public class Pear extends PowerUp {
    public Pear(int x, int y) {
        super(x, y);
    }

    @Override
    protected PowerStrategy createPowerStrategy() {
        return new CombinePowerStrategy();
    }
}

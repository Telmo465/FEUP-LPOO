package com.lpoo2021.g75.controller.game.elements.powerUps.powerStrategies;

import com.lpoo2021.g75.controller.game.elements.powerUps.PowerStrategy;
import com.lpoo2021.g75.model.game.map.Map;

public class IncreaseScorePowerStrategy implements PowerStrategy {
    private final int increaseValue;

    public IncreaseScorePowerStrategy() {
        this.increaseValue = 50;
    }

    public IncreaseScorePowerStrategy(int increaseValue) {
        this.increaseValue = increaseValue;
    }

    @Override
    public void power(Map map) {
        map.getPacman().increaseScore(this.increaseValue);
    }
}

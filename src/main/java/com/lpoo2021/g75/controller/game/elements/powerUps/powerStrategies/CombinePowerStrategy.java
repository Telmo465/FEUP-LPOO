package com.lpoo2021.g75.controller.game.elements.powerUps.powerStrategies;

import com.lpoo2021.g75.controller.game.elements.powerUps.PowerStrategy;
import com.lpoo2021.g75.model.game.map.Map;

import java.util.Arrays;
import java.util.List;

public class CombinePowerStrategy implements PowerStrategy {
    private final List<PowerStrategy> powerStrategies;

    public CombinePowerStrategy() {
        this.powerStrategies = Arrays.asList(new AddLivePowerStrategy(), new IncreaseScorePowerStrategy(), new ParalyzeGhostPowerStrategy());
    }

    public CombinePowerStrategy(List<PowerStrategy> powerStrategies) {
        this.powerStrategies = powerStrategies;
    }

    public void addPowerStrategy(PowerStrategy powerStrategy) {
        this.powerStrategies.add(powerStrategy);
    }

    @Override
    public void power(Map map) {
        for (PowerStrategy powerStrategy : powerStrategies)
            powerStrategy.power(map);
    }
}

package com.lpoo2021.g75.controller.game.elements.powerUps.powerStrategies;

import com.lpoo2021.g75.controller.game.elements.powerUps.PowerStrategy;
import com.lpoo2021.g75.model.game.map.Map;

public class AddLivePowerStrategy implements PowerStrategy {
    @Override
    public void power(Map map) {
        map.getPacman().receiveLive();
    }
}

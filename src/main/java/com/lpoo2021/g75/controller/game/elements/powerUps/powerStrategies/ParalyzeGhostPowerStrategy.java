package com.lpoo2021.g75.controller.game.elements.powerUps.powerStrategies;

import com.lpoo2021.g75.controller.game.elements.powerUps.PowerStrategy;
import com.lpoo2021.g75.model.game.elements.dynamicElements.ghosts.Ghost;
import com.lpoo2021.g75.model.game.map.Map;

public class ParalyzeGhostPowerStrategy implements PowerStrategy {
    @Override
    public void power(Map map) {
        for (Ghost ghost : map.getGhosts()) {
            ghost.getState().paralyze();
        }
    }
}

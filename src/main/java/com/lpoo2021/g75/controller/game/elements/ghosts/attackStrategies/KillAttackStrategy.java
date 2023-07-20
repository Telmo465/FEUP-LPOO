package com.lpoo2021.g75.controller.game.elements.ghosts.attackStrategies;

import com.lpoo2021.g75.controller.game.elements.ghosts.AttackStrategy;
import com.lpoo2021.g75.model.game.map.Map;

public class KillAttackStrategy implements AttackStrategy {
    @Override
    public void attack(Map map) {
        map.getPacman().loseLive();
    }
}

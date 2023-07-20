package com.lpoo2021.g75.controller.game.elements.ghosts.attackStrategies;

import com.lpoo2021.g75.controller.game.elements.ghosts.AttackStrategy;
import com.lpoo2021.g75.model.game.map.Map;

public class ReduceScoreAttackStrategy implements AttackStrategy {
    private final int reduceValue;

    public ReduceScoreAttackStrategy() {
        this.reduceValue = 30;
    }

    public ReduceScoreAttackStrategy(int reduceValue) {
        this.reduceValue = reduceValue;
    }

    @Override
    public void attack(Map map) {
        map.getPacman().decreaseScore(this.reduceValue);
    }
}

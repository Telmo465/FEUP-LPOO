package com.lpoo2021.g75.model.game.elements.dynamicElements.ghosts;

import com.lpoo2021.g75.controller.game.elements.ghosts.AttackStrategy;
import com.lpoo2021.g75.controller.game.elements.ghosts.attackStrategies.ReduceScoreAttackStrategy;
import com.lpoo2021.g75.controller.game.elements.ghosts.MovementStrategy;
import com.lpoo2021.g75.controller.game.elements.ghosts.movementStrategies.HorizontalMovementStrategy;
import com.lpoo2021.g75.model.game.elements.dynamicElements.Orientation;

public class ReduceScoreGhost extends Ghost {
    public ReduceScoreGhost(int x, int y) {
        super(x, y);
    }

    @Override
    protected MovementStrategy createMovementStrategy() {
        return new HorizontalMovementStrategy(Orientation.RIGHT);
    }

    @Override
    protected AttackStrategy createAttackStrategy() {
        return new ReduceScoreAttackStrategy();
    }
}

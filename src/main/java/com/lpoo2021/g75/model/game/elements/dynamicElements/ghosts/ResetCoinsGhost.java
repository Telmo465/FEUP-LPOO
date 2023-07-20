package com.lpoo2021.g75.model.game.elements.dynamicElements.ghosts;

import com.lpoo2021.g75.controller.game.elements.ghosts.AttackStrategy;
import com.lpoo2021.g75.controller.game.elements.ghosts.attackStrategies.ResetCoinsAttackStrategy;
import com.lpoo2021.g75.controller.game.elements.ghosts.MovementStrategy;
import com.lpoo2021.g75.controller.game.elements.ghosts.movementStrategies.VerticalMovementStrategy;
import com.lpoo2021.g75.model.game.elements.dynamicElements.Orientation;

public class ResetCoinsGhost extends Ghost {
    public ResetCoinsGhost(int x, int y) {
        super(x, y);
    }

    @Override
    protected MovementStrategy createMovementStrategy() {
        return new VerticalMovementStrategy(Orientation.UP);
    }

    @Override
    protected AttackStrategy createAttackStrategy() {
        return new ResetCoinsAttackStrategy();
    }
}

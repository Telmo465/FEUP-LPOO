package com.lpoo2021.g75.model.game.elements.dynamicElements.ghosts;

import com.lpoo2021.g75.controller.game.elements.ghosts.AttackStrategy;
import com.lpoo2021.g75.controller.game.elements.ghosts.attackStrategies.KillAttackStrategy;
import com.lpoo2021.g75.controller.game.elements.ghosts.MovementStrategy;
import com.lpoo2021.g75.controller.game.elements.ghosts.movementStrategies.RandomMovementStrategy;

public class KillerGhost extends Ghost {
    public KillerGhost(int x, int y) {
        super(x, y);
    }

    @Override
    protected MovementStrategy createMovementStrategy() {
        return new RandomMovementStrategy();
    }

    @Override
    protected AttackStrategy createAttackStrategy() {
        return new KillAttackStrategy();
    }
}

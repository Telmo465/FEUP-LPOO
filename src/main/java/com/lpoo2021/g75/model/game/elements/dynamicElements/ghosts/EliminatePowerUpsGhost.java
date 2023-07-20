package com.lpoo2021.g75.model.game.elements.dynamicElements.ghosts;

import com.lpoo2021.g75.controller.game.elements.ghosts.AttackStrategy;
import com.lpoo2021.g75.controller.game.elements.ghosts.attackStrategies.EliminatePwUAttackStrategy;
import com.lpoo2021.g75.controller.game.elements.ghosts.MovementStrategy;
import com.lpoo2021.g75.controller.game.elements.ghosts.movementStrategies.RandomMovementStrategy;

public class EliminatePowerUpsGhost extends Ghost {

    public EliminatePowerUpsGhost(int x, int y) {
        super(x, y);
    }

    @Override
    protected MovementStrategy createMovementStrategy() {
        return new RandomMovementStrategy();
    }

    @Override
    protected AttackStrategy createAttackStrategy() {
        return new EliminatePwUAttackStrategy();
    }
}

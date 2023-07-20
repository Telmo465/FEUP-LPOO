package com.lpoo2021.g75.model.game.elements.dynamicElements.ghosts;

import com.lpoo2021.g75.controller.game.elements.ghosts.attackStrategies.EliminatePwUAttackStrategy;
import com.lpoo2021.g75.controller.game.elements.ghosts.movementStrategies.RandomMovementStrategy;
import com.lpoo2021.g75.controller.game.elements.ghosts.states.NormalGhostState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EliminatePowerUpsGhostTest {
    @Test
    void createEliminatePowerUpsGhost() {
        Ghost eliminatePwUps = new EliminatePowerUpsGhost(4, 8);

        assertEquals(4, eliminatePwUps.getPosition().getX());
        assertEquals(8, eliminatePwUps.getPosition().getY());
        assertEquals(RandomMovementStrategy.class, eliminatePwUps.getMovementStrategy().getClass());
        assertEquals(EliminatePwUAttackStrategy.class, eliminatePwUps.getAttackStrategy().getClass());
        assertEquals(NormalGhostState.class, eliminatePwUps.getState().getClass());
    }
}
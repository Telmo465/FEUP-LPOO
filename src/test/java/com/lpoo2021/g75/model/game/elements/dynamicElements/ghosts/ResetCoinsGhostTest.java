package com.lpoo2021.g75.model.game.elements.dynamicElements.ghosts;

import com.lpoo2021.g75.controller.game.elements.ghosts.attackStrategies.ResetCoinsAttackStrategy;
import com.lpoo2021.g75.controller.game.elements.ghosts.movementStrategies.VerticalMovementStrategy;
import com.lpoo2021.g75.controller.game.elements.ghosts.states.NormalGhostState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResetCoinsGhostTest {
    @Test
    void createResetCoinsGhost() {
        Ghost resetCoins = new ResetCoinsGhost(4, 8);

        assertEquals(4, resetCoins.getPosition().getX());
        assertEquals(8, resetCoins.getPosition().getY());
        assertEquals(VerticalMovementStrategy.class, resetCoins.getMovementStrategy().getClass());
        assertEquals(ResetCoinsAttackStrategy.class, resetCoins.getAttackStrategy().getClass());
        assertEquals(NormalGhostState.class, resetCoins.getState().getClass());
    }
}
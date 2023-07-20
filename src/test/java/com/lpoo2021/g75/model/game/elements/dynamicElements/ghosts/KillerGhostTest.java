package com.lpoo2021.g75.model.game.elements.dynamicElements.ghosts;

import com.lpoo2021.g75.controller.game.elements.ghosts.attackStrategies.KillAttackStrategy;
import com.lpoo2021.g75.controller.game.elements.ghosts.movementStrategies.RandomMovementStrategy;
import com.lpoo2021.g75.controller.game.elements.ghosts.states.NormalGhostState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KillerGhostTest {
    @Test
    void createKillerGhost() {
        Ghost killer = new KillerGhost(4, 8);

        assertEquals(4, killer.getPosition().getX());
        assertEquals(8, killer.getPosition().getY());
        assertEquals(RandomMovementStrategy.class, killer.getMovementStrategy().getClass());
        assertEquals(KillAttackStrategy.class, killer.getAttackStrategy().getClass());
        assertEquals(NormalGhostState.class, killer.getState().getClass());
    }
}
package com.lpoo2021.g75.model.game.elements.dynamicElements.ghosts;

import com.lpoo2021.g75.controller.game.elements.ghosts.attackStrategies.ReduceScoreAttackStrategy;
import com.lpoo2021.g75.controller.game.elements.ghosts.movementStrategies.HorizontalMovementStrategy;
import com.lpoo2021.g75.controller.game.elements.ghosts.states.NormalGhostState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReduceScoreGhostTest {
    @Test
    void createReduceScoreGhost() {
        Ghost reduceScore = new ReduceScoreGhost(4, 8);

        assertEquals(4, reduceScore.getPosition().getX());
        assertEquals(8, reduceScore.getPosition().getY());
        assertEquals(HorizontalMovementStrategy.class, reduceScore.getMovementStrategy().getClass());
        assertEquals(ReduceScoreAttackStrategy.class, reduceScore.getAttackStrategy().getClass());
        assertEquals(NormalGhostState.class, reduceScore.getState().getClass());
    }
}
package com.lpoo2021.g75.controller.game.elements.ghosts.movementStrategies;

import com.lpoo2021.g75.controller.game.elements.ghosts.MovementStrategy;
import com.lpoo2021.g75.model.game.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomMovementStrategyTest {
    @Test
    void nextPosition() {
        MovementStrategy movementStrategy = new RandomMovementStrategy();
        assertNotEquals(new Position(5, 5), movementStrategy.nextPosition(new Position(5, 5)));
    }
}
package com.lpoo2021.g75.controller.game.elements.ghosts.movementStrategies;

import com.lpoo2021.g75.controller.game.elements.ghosts.MovementStrategy;
import com.lpoo2021.g75.model.game.Position;
import com.lpoo2021.g75.model.game.elements.dynamicElements.Orientation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HorizontalMovementStrategyTest {
    @Test
    void nextPositionRight() {
        MovementStrategy strategy = new HorizontalMovementStrategy(Orientation.RIGHT);
        assertEquals(new Position(6, 5), strategy.nextPosition(new Position(5, 5)));
    }

    @Test
    void nextPositionLeft() {
        MovementStrategy strategy = new HorizontalMovementStrategy(Orientation.LEFT);
        assertEquals(new Position(4, 5), strategy.nextPosition(new Position(5, 5)));
    }

    @Test
    void consecutivePositions() {
        MovementStrategy strategy = new HorizontalMovementStrategy(Orientation.RIGHT);
        Position position1 = strategy.nextPosition(new Position(5, 5));
        Position position2 = strategy.nextPosition(position1);

        assertNotEquals(position1, position2);
    }
}
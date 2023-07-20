package com.lpoo2021.g75.controller.game.elements.ghosts.movementStrategies;

import com.lpoo2021.g75.controller.game.elements.ghosts.MovementStrategy;
import com.lpoo2021.g75.model.game.Position;
import com.lpoo2021.g75.model.game.elements.dynamicElements.Orientation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VerticalMovementStrategyTest {
    @Test
    void nextPositionUp() {
        MovementStrategy strategy = new VerticalMovementStrategy(Orientation.UP);
        assertEquals(new Position(5, 4), strategy.nextPosition(new Position(5, 5)));
    }

    @Test
    void nextPositionDown() {
        MovementStrategy strategy = new VerticalMovementStrategy(Orientation.DOWN);
        assertEquals(new Position(5, 6), strategy.nextPosition(new Position(5, 5)));
    }

    @Test
    void consecutivePositions() {
        MovementStrategy strategy = new VerticalMovementStrategy(Orientation.UP);
        Position position1 = strategy.nextPosition(new Position(5, 5));
        Position position2 = strategy.nextPosition(position1);

        assertNotEquals(position1, position2);
    }
}
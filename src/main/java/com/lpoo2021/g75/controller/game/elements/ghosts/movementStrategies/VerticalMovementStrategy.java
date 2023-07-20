package com.lpoo2021.g75.controller.game.elements.ghosts.movementStrategies;

import com.lpoo2021.g75.controller.game.elements.ghosts.MovementStrategy;
import com.lpoo2021.g75.model.game.Position;
import com.lpoo2021.g75.model.game.elements.dynamicElements.Orientation;

public class VerticalMovementStrategy implements MovementStrategy {
    private Orientation direction;

    public VerticalMovementStrategy(Orientation direction) {
        this.direction = direction;
    }

    @Override
    public Position nextPosition(Position position) {
        Position next = new Position(position);

        if (this.direction == Orientation.UP)
            next = position.getUp();
        else if (this.direction == Orientation.DOWN)
            next = position.getDown();

        int n = (int) (Math.random() * 2);
        if (n == 1) this.invertDirection();

        return next;
    }

    private void invertDirection() {
        this.direction = this.direction.getOpposite();
    }
}

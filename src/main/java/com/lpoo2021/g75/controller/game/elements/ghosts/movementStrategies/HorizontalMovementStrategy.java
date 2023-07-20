package com.lpoo2021.g75.controller.game.elements.ghosts.movementStrategies;

import com.lpoo2021.g75.controller.game.elements.ghosts.MovementStrategy;
import com.lpoo2021.g75.model.game.Position;
import com.lpoo2021.g75.model.game.elements.dynamicElements.Orientation;

public class HorizontalMovementStrategy implements MovementStrategy {
    private Orientation direction;

    public HorizontalMovementStrategy(Orientation direction) {
        this.direction = direction;
    }

    @Override
    public Position nextPosition(Position position) {
        Position next = new Position(position);

        if (this.direction == Orientation.RIGHT)
            next = position.getRight();
        else if (this.direction == Orientation.LEFT)
            next = position.getLeft();

        int n = (int) (Math.random() * 2);
        if (n == 1) this.invertDirection();

        return next;
    }

    private void invertDirection() {
        this.direction = this.direction.getOpposite();
    }
}

package com.lpoo2021.g75.controller.game.elements.ghosts.movementStrategies;

import com.lpoo2021.g75.controller.game.elements.ghosts.MovementStrategy;
import com.lpoo2021.g75.model.game.Position;

public class RandomMovementStrategy implements MovementStrategy {
    @Override
    public Position nextPosition(Position position) {
        return position.getRandomNeighbour();
    }
}

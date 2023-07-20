package com.lpoo2021.g75.controller.game.elements.ghosts;

import com.lpoo2021.g75.model.game.Position;

public interface MovementStrategy {

    Position nextPosition(Position position);
}

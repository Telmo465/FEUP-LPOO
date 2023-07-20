package com.lpoo2021.g75.controller.game.elements.ghosts.states;

import com.lpoo2021.g75.controller.game.elements.ghosts.GhostState;
import com.lpoo2021.g75.model.game.Position;
import com.lpoo2021.g75.model.game.elements.dynamicElements.ghosts.Ghost;
import com.lpoo2021.g75.model.game.map.Map;

public class NormalGhostState extends GhostState {
    public NormalGhostState(Ghost ghost) {
        super(ghost);
    }

    @Override
    public void step(Map map) {
        moveGhost(map, ghost.getMovementStrategy().nextPosition(ghost.getPosition()));
    }

    private void moveGhost(Map map, Position position) {
        position = map.teleport(position);

        if (map.isEmpty(position)) {
            ghost.setPosition(position);
            if (map.getPacman().getPosition().equals(position))
                this.attack(map);
        }
    }

    @Override
    public void attack(Map map) {
        ghost.getAttackStrategy().attack(map);
    }

    @Override
    public void paralyze() {
        ghost.setState(new ParalyzeGhostState(ghost, 5));
    }
}

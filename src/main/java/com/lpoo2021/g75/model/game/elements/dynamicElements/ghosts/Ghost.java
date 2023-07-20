package com.lpoo2021.g75.model.game.elements.dynamicElements.ghosts;

import com.lpoo2021.g75.controller.game.elements.ghosts.AttackStrategy;
import com.lpoo2021.g75.controller.game.elements.ghosts.GhostState;
import com.lpoo2021.g75.controller.game.elements.ghosts.MovementStrategy;
import com.lpoo2021.g75.controller.game.elements.ghosts.states.NormalGhostState;
import com.lpoo2021.g75.model.game.elements.DynamicElement;

public abstract class Ghost extends DynamicElement {
    private final MovementStrategy movementStrategy;
    private final AttackStrategy attackStrategy;
    private GhostState state;

    public Ghost(int x, int y) {
        super(x, y);
        this.movementStrategy = createMovementStrategy();
        this.attackStrategy = createAttackStrategy();
        this.state = new NormalGhostState(this);
    }

    public MovementStrategy getMovementStrategy() {
        return movementStrategy;
    }

    public AttackStrategy getAttackStrategy() {
        return attackStrategy;
    }

    protected abstract MovementStrategy createMovementStrategy();

    protected abstract AttackStrategy createAttackStrategy();

    public GhostState getState() {
        return state;
    }

    public void setState(GhostState state) {
        this.state = state;
    }
}

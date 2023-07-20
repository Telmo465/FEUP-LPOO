package com.lpoo2021.g75.controller.game.elements.ghosts.states;

import com.lpoo2021.g75.controller.game.elements.ghosts.GhostState;
import com.lpoo2021.g75.model.game.elements.dynamicElements.ghosts.Ghost;

public class ParalyzeGhostState extends GhostState {
    private int timeLeft;

    public ParalyzeGhostState(Ghost ghost) {
        super(ghost);
        this.timeLeft = 5;
    }

    public ParalyzeGhostState(Ghost ghost, int paralyzeTime) {
        super(ghost);
        this.timeLeft = paralyzeTime;
    }

    @Override
    public void timePasses() {
        timeLeft--;
        if (timeLeft <= 0) {
            ghost.setState(new NormalGhostState(ghost));
        }
    }

    @Override
    public void paralyze() {
        ghost.setState(new ParalyzeGhostState(ghost, timeLeft + 5));
    }
}

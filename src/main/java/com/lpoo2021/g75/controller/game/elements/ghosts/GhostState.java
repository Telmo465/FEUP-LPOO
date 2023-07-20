package com.lpoo2021.g75.controller.game.elements.ghosts;

import com.lpoo2021.g75.model.game.elements.dynamicElements.ghosts.Ghost;
import com.lpoo2021.g75.model.game.map.Map;

public abstract class GhostState {
    protected final Ghost ghost;

    public GhostState(Ghost ghost) {
        this.ghost = ghost;
    }

    public void step(Map map) { }

    public void attack(Map map) { }

    public void timePasses() { }

    public abstract void paralyze();
}

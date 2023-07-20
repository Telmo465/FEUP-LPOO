package com.lpoo2021.g75.model.game.elements.fixedElements.collectable.powerUps;

import com.lpoo2021.g75.controller.game.elements.powerUps.PowerStrategy;
import com.lpoo2021.g75.model.game.elements.fixedElements.collectable.CollectableElement;

public abstract class PowerUp extends CollectableElement {
    private final PowerStrategy powerStrategy;

    public PowerUp(int x, int y) {
        super(x, y);
        this.powerStrategy = createPowerStrategy();
    }

    @Override
    public void collect() {
        this.collected = true;
    }

    public PowerStrategy getPowerStrategy() {
        return powerStrategy;
    }

    protected abstract PowerStrategy createPowerStrategy();
}

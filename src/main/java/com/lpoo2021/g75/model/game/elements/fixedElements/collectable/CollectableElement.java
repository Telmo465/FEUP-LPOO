package com.lpoo2021.g75.model.game.elements.fixedElements.collectable;

import com.lpoo2021.g75.model.game.elements.FixedElement;

public abstract class CollectableElement extends FixedElement {
    protected boolean collected;

    public CollectableElement(int x, int y) {
        super(x, y);
        this.collected = false;
    }

    public boolean isCollected() {
        return this.collected;
    }

    public void place() {
        this.collected = false;
    }

    public abstract void collect();
}

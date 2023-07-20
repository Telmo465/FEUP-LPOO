package com.lpoo2021.g75.model.game.elements;

import com.lpoo2021.g75.model.game.Position;

public abstract class Element {
    protected Position position;

    public Element(int x, int y) {
        this.position = new Position(x, y);
    }

    public Position getPosition() {
        return this.position;
    }
}

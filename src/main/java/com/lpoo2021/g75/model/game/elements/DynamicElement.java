package com.lpoo2021.g75.model.game.elements;

import com.lpoo2021.g75.model.game.Position;

public class DynamicElement extends Element {
    public DynamicElement(int x, int y) {
        super(x, y);
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}

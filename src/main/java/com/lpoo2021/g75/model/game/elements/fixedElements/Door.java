package com.lpoo2021.g75.model.game.elements.fixedElements;

import com.lpoo2021.g75.model.game.elements.FixedElement;
import com.lpoo2021.g75.model.game.elements.fixedElements.collectable.keys.Key;
import com.lpoo2021.g75.model.game.elements.fixedElements.collectable.keys.KeyObserver;

public class Door extends FixedElement implements KeyObserver {
    private String color;
    private boolean close;

    public Door(int x, int y, String color) {
        super(x, y);
        this.color = color;
        this.close = true;
    }

    public Door(int x, int y) {
        super(x, y);
        this.color = "#FFFFFF";
        this.close = true;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isClosed() {
        return this.close;
    }

    @Override
    public void collected(Key key) {
        this.close = false;
    }
}

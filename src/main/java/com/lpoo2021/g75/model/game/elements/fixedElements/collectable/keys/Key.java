package com.lpoo2021.g75.model.game.elements.fixedElements.collectable.keys;

import com.lpoo2021.g75.model.game.elements.fixedElements.collectable.CollectableElement;

import java.util.ArrayList;
import java.util.List;

public class Key extends CollectableElement {
    private String color;
    private final List<KeyObserver> observers;

    public Key(int x, int y) {
        super(x, y);
        this.observers = new ArrayList<>();
        color = "#FFFFFF";
    }

    public Key(int x, int y, String color) {
        super(x, y);
        this.observers = new ArrayList<>();
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<KeyObserver> getObservers() {
        return this.observers;
    }

    public void addKeyObserver(KeyObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void collect() {
        this.collected = true;
        for (KeyObserver observer : observers)
            observer.collected(this);
    }
}

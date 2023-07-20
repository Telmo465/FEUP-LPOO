package com.lpoo2021.g75.model.game.elements.fixedElements.collectable;

public class Coin extends CollectableElement {
    public Coin(int x, int y){
        super(x,y);
    }

    @Override
    public void collect() {
        this.collected = true;
    }
}

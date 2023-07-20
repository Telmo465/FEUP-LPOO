package com.lpoo2021.g75.view.game;

import com.lpoo2021.g75.model.game.elements.fixedElements.collectable.Coin;
import com.lpoo2021.g75.view.GUI.GUI;

public class CoinViewer implements ElementViewer<Coin> {
    @Override
    public void draw(Coin coin, GUI gui){
        gui.drawCoin(coin.getPosition());
    }
}

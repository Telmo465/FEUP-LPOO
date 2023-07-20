package com.lpoo2021.g75.view.game;

import com.lpoo2021.g75.model.game.elements.fixedElements.collectable.keys.Key;
import com.lpoo2021.g75.view.GUI.GUI;

public class KeyViewer implements ElementViewer<Key> {

    @Override
    public void draw(Key key, GUI gui) {
        gui.drawKey(key.getPosition(), key.getColor());
    }
}

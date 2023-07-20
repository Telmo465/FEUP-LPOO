package com.lpoo2021.g75.view.game;

import com.lpoo2021.g75.model.game.elements.Element;
import com.lpoo2021.g75.view.GUI.GUI;

public interface ElementViewer<T extends Element> {
    void draw(T element, GUI gui);
}

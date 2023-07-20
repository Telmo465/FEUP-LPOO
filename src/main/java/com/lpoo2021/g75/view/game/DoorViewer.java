package com.lpoo2021.g75.view.game;

import com.lpoo2021.g75.model.game.elements.fixedElements.Door;
import com.lpoo2021.g75.view.GUI.GUI;

public class DoorViewer implements ElementViewer<Door> {
    @Override
    public void draw(Door door, GUI gui) {
        gui.drawDoor(door.getPosition(), door.getColor());
    }
}

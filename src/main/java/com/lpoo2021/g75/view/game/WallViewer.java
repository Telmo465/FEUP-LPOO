package com.lpoo2021.g75.view.game;

import com.lpoo2021.g75.model.game.elements.fixedElements.Wall;
import com.lpoo2021.g75.view.GUI.GUI;

public class WallViewer implements ElementViewer<Wall> {
    @Override
    public void draw(Wall wall, GUI gui){
        gui.drawWall(wall.getPosition());
    }
}

package com.lpoo2021.g75.view.game;

import com.lpoo2021.g75.model.game.elements.dynamicElements.Pacman;
import com.lpoo2021.g75.view.GUI.GUI;

public class PacmanViewer implements ElementViewer<Pacman> {
    @Override
    public void draw(Pacman pacman, GUI gui) {
        gui.drawPacman(pacman.getPosition());
    }
}

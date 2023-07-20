package com.lpoo2021.g75.view.game;

import com.lpoo2021.g75.model.game.Position;
import com.lpoo2021.g75.model.game.map.Map;
import com.lpoo2021.g75.model.game.elements.Element;
import com.lpoo2021.g75.view.GUI.GUI;
import com.lpoo2021.g75.view.Viewer;

import java.util.List;

public class GameViewer extends Viewer<Map> {
    public GameViewer(Map map) {
        super(map);
    }

    @Override
    public void drawElements(GUI gui) {
        drawElements(gui, getModel().getWalls(), new WallViewer());
        drawElements(gui, getModel().getClosedDoors(), new DoorViewer());
        drawElements(gui, getModel().getKeys(), new KeyViewer());
        drawElements(gui, getModel().getNotCollectedCoins(), new CoinViewer());
        drawElements(gui, getModel().getPowerUps(), new PowerUpViewer());
        drawElements(gui, getModel().getGhosts(), new GhostViewer());
        drawElement(gui, getModel().getPacman(), new PacmanViewer());

        gui.drawText(new Position(0, 0), "lives: " + getModel().getPacman().getLives() + "   score: " + getModel().getPacman().getScore(), "#FFD700");
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}

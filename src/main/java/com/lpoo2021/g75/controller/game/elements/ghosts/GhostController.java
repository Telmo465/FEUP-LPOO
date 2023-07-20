package com.lpoo2021.g75.controller.game.elements.ghosts;

import com.lpoo2021.g75.Game;
import com.lpoo2021.g75.controller.game.GameController;
import com.lpoo2021.g75.model.game.map.Map;
import com.lpoo2021.g75.model.game.elements.dynamicElements.ghosts.Ghost;
import com.lpoo2021.g75.view.GUI.GUI;

import java.io.IOException;

public class GhostController extends GameController {
    private long lastMovement;
    private long lastTimePasses;

    public GhostController(Map map) {
        super(map);
        this.lastMovement = 0;
        this.lastTimePasses = 0;
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovement > 500) {
            for (Ghost ghost : getModel().getGhosts())
                ghost.getState().step(getModel());
            this.lastMovement = time;
        }

        if (time - lastTimePasses > 1000) {
            for (Ghost ghost : getModel().getGhosts())
                ghost.getState().timePasses();
            this.lastTimePasses = time;
        }
    }
}

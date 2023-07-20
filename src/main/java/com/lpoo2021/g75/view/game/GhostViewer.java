package com.lpoo2021.g75.view.game;

import com.lpoo2021.g75.controller.game.elements.ghosts.states.ParalyzeGhostState;
import com.lpoo2021.g75.model.game.elements.dynamicElements.ghosts.*;
import com.lpoo2021.g75.view.GUI.GUI;

public class GhostViewer implements ElementViewer<Ghost> {
    @Override
    public void draw(Ghost ghost, GUI gui) {
        boolean paralyze = false;

        if (ghost.getState() instanceof ParalyzeGhostState)
            paralyze = true;

        if (ghost instanceof KillerGhost) gui.drawKillerGhost(ghost.getPosition(), paralyze);
        else if (ghost instanceof ReduceScoreGhost) gui.drawReduceScoreGhost(ghost.getPosition(), paralyze);
        else if (ghost instanceof ResetCoinsGhost) gui.drawResetCoinsGhost(ghost.getPosition(), paralyze);
        else if (ghost instanceof EliminatePowerUpsGhost) gui.drawEliminatePwUGhost(ghost.getPosition(), paralyze);
    }
}

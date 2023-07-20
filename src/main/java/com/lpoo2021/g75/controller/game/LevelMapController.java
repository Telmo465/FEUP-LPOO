package com.lpoo2021.g75.controller.game;

import com.lpoo2021.g75.Game;
import com.lpoo2021.g75.controller.game.elements.PacmanController;
import com.lpoo2021.g75.controller.game.elements.ghosts.GhostController;
import com.lpoo2021.g75.model.game.map.Map;
import com.lpoo2021.g75.model.menu.*;
import com.lpoo2021.g75.gamestates.*;
import com.lpoo2021.g75.view.GUI.GUI;

import java.io.IOException;

public class LevelMapController extends GameController {
    private final PacmanController pacmanController;
    private final GhostController ghostController;

    public LevelMapController(Map map) {
        super(map);

        this.pacmanController = new PacmanController(map);
        this.ghostController = new GhostController(map);
    }

    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT)
            game.setState(new PauseLevelMenuState(new PauseLevelMenu(getModel(), getModel().getNumber())));
        else if (!getModel().hasNotCollectedCoins())
            game.setState(new WinLevelMenuState(new WinLevelMenu(getModel().getNumber(), getModel().getPacman().getScore(), getModel().getPacman().getLives())));
        else if (!getModel().getPacman().hasLives())
            game.setState(new LoseLevelMenuState(new LoseLevelMenu(getModel().getNumber(), getModel().getPacman().getScore())));
        else {
            pacmanController.step(game, action, time);
            ghostController.step(game, action, time);
        }
    }
}

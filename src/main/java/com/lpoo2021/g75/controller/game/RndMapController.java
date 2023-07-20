package com.lpoo2021.g75.controller.game;

import com.lpoo2021.g75.Game;
import com.lpoo2021.g75.controller.game.elements.PacmanController;
import com.lpoo2021.g75.controller.game.elements.ghosts.GhostController;
import com.lpoo2021.g75.model.game.map.Map;
import com.lpoo2021.g75.model.menu.LoseRndMenu;
import com.lpoo2021.g75.model.menu.PauseRndMenu;
import com.lpoo2021.g75.model.menu.WinRndMenu;
import com.lpoo2021.g75.gamestates.LoseRndMenuState;
import com.lpoo2021.g75.gamestates.PauseRndMenuState;
import com.lpoo2021.g75.gamestates.WinRndMenuState;
import com.lpoo2021.g75.view.GUI.GUI;

import java.io.IOException;

public class RndMapController extends GameController {
    private final PacmanController pacmanController;
    private final GhostController ghostController;

    public RndMapController(Map map) {
        super(map);

        this.pacmanController = new PacmanController(map);
        this.ghostController = new GhostController(map);
    }

    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT)
            game.setState(new PauseRndMenuState(new PauseRndMenu(getModel())));
        else if (!getModel().hasNotCollectedCoins())
            game.setState(new WinRndMenuState(new WinRndMenu(getModel().getPacman().getScore(), getModel().getPacman().getLives())));
        else if (!getModel().getPacman().hasLives())
            game.setState(new LoseRndMenuState(new LoseRndMenu(getModel().getPacman().getScore())));
        else {
            pacmanController.step(game, action, time);
            ghostController.step(game, action, time);
        }
    }
}

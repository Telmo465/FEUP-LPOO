package com.lpoo2021.g75.controller.menu;

import com.lpoo2021.g75.Game;
import com.lpoo2021.g75.controller.Controller;
import com.lpoo2021.g75.gamestates.RndGameState;
import com.lpoo2021.g75.model.game.map.RandomMapBuilder;
import com.lpoo2021.g75.model.menu.MainMenu;
import com.lpoo2021.g75.model.menu.PauseRndMenu;
import com.lpoo2021.g75.gamestates.MainMenuState;
import com.lpoo2021.g75.view.GUI.GUI;

import java.io.IOException;

public class PauseRndMenuController extends Controller<PauseRndMenu> {
    public PauseRndMenuController(PauseRndMenu menu) {
        super(menu);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedResume()) game.setState(new RndGameState(getModel().getMap()));
                if (getModel().isSelectedRestart()) game.setState(new RndGameState(new RandomMapBuilder().createMap()));
                if (getModel().isSelectedBack()) game.setState(new MainMenuState(new MainMenu()));
                break;
        }
    }
}

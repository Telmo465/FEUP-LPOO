package com.lpoo2021.g75.controller.menu;

import com.lpoo2021.g75.Game;
import com.lpoo2021.g75.controller.Controller;
import com.lpoo2021.g75.model.game.map.FileMapBuilder;
import com.lpoo2021.g75.model.game.map.RandomMapBuilder;
import com.lpoo2021.g75.model.menu.MainMenu;
import com.lpoo2021.g75.gamestates.LevelGameState;
import com.lpoo2021.g75.gamestates.RndGameState;
import com.lpoo2021.g75.view.GUI.GUI;

import java.io.IOException;

public class MainMenuController extends Controller<MainMenu> {
    public MainMenuController(MainMenu menu) {
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
                if (getModel().isSelectedStartRandom()) game.setState(new RndGameState(new RandomMapBuilder().createMap()));
                if (getModel().isSelectedStartSequential()) game.setState(new LevelGameState(new FileMapBuilder(getModel().getStartLevel()).createMap()));
                if (getModel().isSelectedExit()) game.setState(null);
                break;
        }
    }
}

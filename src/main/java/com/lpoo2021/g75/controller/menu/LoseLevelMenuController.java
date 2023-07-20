package com.lpoo2021.g75.controller.menu;

import com.lpoo2021.g75.Game;
import com.lpoo2021.g75.controller.Controller;
import com.lpoo2021.g75.gamestates.LevelGameState;
import com.lpoo2021.g75.model.game.map.FileMapBuilder;
import com.lpoo2021.g75.model.menu.LoseLevelMenu;
import com.lpoo2021.g75.model.menu.MainMenu;
import com.lpoo2021.g75.gamestates.MainMenuState;
import com.lpoo2021.g75.view.GUI.GUI;

import java.io.IOException;

public class LoseLevelMenuController extends Controller<LoseLevelMenu> {
    public LoseLevelMenuController(LoseLevelMenu menu) {
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
                if (getModel().isSelectedTryAgain()) game.setState(new LevelGameState(new FileMapBuilder(1).createMap()));
                if (getModel().isSelectedBack()) game.setState(new MainMenuState(new MainMenu()));
                if (getModel().isSelectedExit()) game.setState(null);
                break;
        }
    }
}

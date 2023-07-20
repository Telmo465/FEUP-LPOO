package com.lpoo2021.g75.controller.menu;

import com.lpoo2021.g75.Game;
import com.lpoo2021.g75.controller.Controller;
import com.lpoo2021.g75.gamestates.LevelGameState;
import com.lpoo2021.g75.model.game.map.FileMapBuilder;
import com.lpoo2021.g75.model.menu.MainMenu;
import com.lpoo2021.g75.model.menu.WinLevelMenu;
import com.lpoo2021.g75.gamestates.MainMenuState;
import com.lpoo2021.g75.view.GUI.GUI;

import java.io.IOException;

public class WinLevelMenuController extends Controller<WinLevelMenu> {
    public WinLevelMenuController(WinLevelMenu menu) {
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
                if (getModel().isSelectedContinue()) {
                    if (getModel().isLastLevel()) game.setState(new LevelGameState(new FileMapBuilder(1).createMap()));
                    else game.setState(new LevelGameState(new FileMapBuilder(getModel().getLevel() + 1).createMap()));
                }
                if (getModel().isSelectedBack()) {
                    if (getModel().isLastLevel()) game.setState(new MainMenuState(new MainMenu()));
                    else game.setState(new MainMenuState(new MainMenu(getModel().getLevel() + 1)));
                }
                if (getModel().isSelectedExit()) game.setState(null);
                break;
        }
    }
}

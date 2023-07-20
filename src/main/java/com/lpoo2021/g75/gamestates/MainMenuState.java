package com.lpoo2021.g75.gamestates;

import com.lpoo2021.g75.controller.Controller;
import com.lpoo2021.g75.controller.menu.MainMenuController;
import com.lpoo2021.g75.model.menu.MainMenu;
import com.lpoo2021.g75.view.Viewer;
import com.lpoo2021.g75.view.menu.MainMenuViewer;

public class MainMenuState extends State<MainMenu> {
    public MainMenuState(MainMenu model) {
        super(model);
    }

    @Override
    protected Viewer<MainMenu> getViewer() {
        return new MainMenuViewer(getModel());
    }

    @Override
    protected Controller<MainMenu> getController() {
        return new MainMenuController(getModel());
    }
}

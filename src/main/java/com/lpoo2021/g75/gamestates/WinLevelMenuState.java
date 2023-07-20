package com.lpoo2021.g75.gamestates;

import com.lpoo2021.g75.controller.Controller;
import com.lpoo2021.g75.controller.menu.WinLevelMenuController;
import com.lpoo2021.g75.model.menu.WinLevelMenu;
import com.lpoo2021.g75.view.Viewer;
import com.lpoo2021.g75.view.menu.WinLevelMenuViewer;

public class WinLevelMenuState extends State<WinLevelMenu> {
    public WinLevelMenuState(WinLevelMenu model) {
            super(model);
    }

    @Override
    protected Viewer<WinLevelMenu> getViewer() {
        return new WinLevelMenuViewer(getModel());
    }

    @Override
    protected Controller<WinLevelMenu> getController() {
        return new WinLevelMenuController(getModel());
    }
}

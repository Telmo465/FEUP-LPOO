package com.lpoo2021.g75.gamestates;

import com.lpoo2021.g75.controller.Controller;
import com.lpoo2021.g75.controller.menu.PauseLevelMenuController;
import com.lpoo2021.g75.model.menu.PauseLevelMenu;
import com.lpoo2021.g75.view.Viewer;
import com.lpoo2021.g75.view.menu.PauseLevelMenuViewer;

public class PauseLevelMenuState extends State<PauseLevelMenu> {
    public PauseLevelMenuState(PauseLevelMenu model) {
        super(model);
    }

    @Override
    protected Viewer<PauseLevelMenu> getViewer() {
        return new PauseLevelMenuViewer(getModel());
    }

    @Override
    protected Controller<PauseLevelMenu> getController() {
        return new PauseLevelMenuController(getModel());
    }
}

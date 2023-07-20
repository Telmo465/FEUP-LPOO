package com.lpoo2021.g75.gamestates;

import com.lpoo2021.g75.controller.Controller;
import com.lpoo2021.g75.controller.menu.PauseRndMenuController;
import com.lpoo2021.g75.model.menu.PauseRndMenu;
import com.lpoo2021.g75.view.Viewer;
import com.lpoo2021.g75.view.menu.PauseRndMenuViewer;

public class PauseRndMenuState extends State<PauseRndMenu> {
    public PauseRndMenuState(PauseRndMenu model) {
        super(model);
    }

    @Override
    protected Viewer<PauseRndMenu> getViewer() {
        return new PauseRndMenuViewer(getModel());
    }

    @Override
    protected Controller<PauseRndMenu> getController() {
        return new PauseRndMenuController(getModel());
    }
}

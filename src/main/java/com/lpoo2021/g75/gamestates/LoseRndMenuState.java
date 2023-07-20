package com.lpoo2021.g75.gamestates;

import com.lpoo2021.g75.controller.Controller;
import com.lpoo2021.g75.controller.menu.LoseRndMenuController;
import com.lpoo2021.g75.model.menu.LoseRndMenu;
import com.lpoo2021.g75.view.Viewer;
import com.lpoo2021.g75.view.menu.LoseRndMenuViewer;

public class LoseRndMenuState extends State<LoseRndMenu> {
    public LoseRndMenuState(LoseRndMenu model) {
        super(model);
    }

    @Override
    protected Viewer<LoseRndMenu> getViewer() {
        return new LoseRndMenuViewer(getModel());
    }

    @Override
    protected Controller<LoseRndMenu> getController() {
        return new LoseRndMenuController(getModel());
    }
}

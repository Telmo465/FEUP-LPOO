package com.lpoo2021.g75.gamestates;

import com.lpoo2021.g75.controller.Controller;
import com.lpoo2021.g75.controller.menu.LoseLevelMenuController;
import com.lpoo2021.g75.model.menu.LoseLevelMenu;
import com.lpoo2021.g75.view.Viewer;
import com.lpoo2021.g75.view.menu.LoseLevelMenuViewer;

public class LoseLevelMenuState extends State<LoseLevelMenu> {
    public LoseLevelMenuState(LoseLevelMenu model) {
        super(model);
    }

    @Override
    protected Viewer<LoseLevelMenu> getViewer() {
        return new LoseLevelMenuViewer(getModel());
    }

    @Override
    protected Controller<LoseLevelMenu> getController() {
        return new LoseLevelMenuController(getModel());
    }
}

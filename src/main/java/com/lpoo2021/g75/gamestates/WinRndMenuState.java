package com.lpoo2021.g75.gamestates;

import com.lpoo2021.g75.controller.Controller;
import com.lpoo2021.g75.controller.menu.WinRndMenuController;
import com.lpoo2021.g75.model.menu.WinRndMenu;
import com.lpoo2021.g75.view.Viewer;
import com.lpoo2021.g75.view.menu.WinRndMenuViewer;

public class WinRndMenuState extends State<WinRndMenu> {
    public WinRndMenuState(WinRndMenu model) {
        super(model);
    }

    @Override
    protected Viewer<WinRndMenu> getViewer() {
        return new WinRndMenuViewer(getModel());
    }

    @Override
    protected Controller<WinRndMenu> getController() {
        return new WinRndMenuController(getModel());
    }
}

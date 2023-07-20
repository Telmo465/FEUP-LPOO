package com.lpoo2021.g75.gamestates;

import com.lpoo2021.g75.controller.Controller;
import com.lpoo2021.g75.controller.game.LevelMapController;
import com.lpoo2021.g75.model.game.map.Map;
import com.lpoo2021.g75.view.Viewer;
import com.lpoo2021.g75.view.game.GameViewer;

public class LevelGameState extends State<Map> {
    public LevelGameState(Map map) {
        super(map);
    }

    @Override
    protected Viewer<Map> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Map> getController() {
        return new LevelMapController(getModel());
    }
}

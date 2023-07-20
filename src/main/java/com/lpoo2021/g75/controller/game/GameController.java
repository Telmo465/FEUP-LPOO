package com.lpoo2021.g75.controller.game;

import com.lpoo2021.g75.controller.Controller;
import com.lpoo2021.g75.model.game.map.Map;

public abstract class GameController extends Controller<Map> {

    public GameController(Map map) {
        super(map);
    }
}

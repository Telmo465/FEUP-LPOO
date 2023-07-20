package com.lpoo2021.g75.model.menu;

import com.lpoo2021.g75.model.game.map.Map;

import java.util.Arrays;

public class PauseRndMenu extends Menu {
    private final Map map;

    public PauseRndMenu(Map map) {
        super();

        this.map = map;
        this.setEntries(Arrays.asList("resume", "restart", "back"));
    }

    public Map getMap() {
        return this.map;
    }

    public boolean isSelectedResume() {
        return isSelected(0);
    }

    public boolean isSelectedRestart() {
        return isSelected(1);
    }

    public boolean isSelectedBack() {
        return isSelected(2);
    }
}

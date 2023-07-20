package com.lpoo2021.g75.model.menu;

import com.lpoo2021.g75.model.game.map.Map;

import java.util.Arrays;

public class PauseLevelMenu extends Menu {
    private final Map map;
    private final int level;

    public PauseLevelMenu(Map map, int level) {
        super();

        this.map = map;
        this.level = level;
        this.setEntries(Arrays.asList("resume", "restart", "back"));
    }

    public Map getMap() {
        return this.map;
    }

    public int getLevel() {
        return this.level;
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

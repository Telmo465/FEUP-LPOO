package com.lpoo2021.g75.model.menu;

import java.util.Arrays;

public class LoseRndMenu extends Menu {
    public final int score;

    public LoseRndMenu(int score) {
        super();

        this.score = score;
        this.setEntries(Arrays.asList("try again", "back", "exit"));
    }

    public int getScore() {
        return this.score;
    }

    public boolean isSelectedTryAgain() {
        return isSelected(0);
    }

    public boolean isSelectedBack() {
        return isSelected(1);
    }

    public boolean isSelectedExit() {
        return isSelected(2);
    }
}

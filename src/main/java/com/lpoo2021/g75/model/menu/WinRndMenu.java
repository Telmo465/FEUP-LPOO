package com.lpoo2021.g75.model.menu;

import java.util.Arrays;

public class WinRndMenu extends Menu {
    private final int score;
    private final int lives;

    public WinRndMenu(int score, int lives) {
        super();

        this.score = score;
        this.lives = lives;
        this.setEntries(Arrays.asList("try again", "back", "exit"));
    }

    public int getScore() {
        return this.score;
    }

    public int getLives() {
        return this.lives;
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

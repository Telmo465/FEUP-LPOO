package com.lpoo2021.g75.model.menu;

import java.io.*;
import java.net.URL;
import java.util.Arrays;

public class LoseLevelMenu extends Menu {
    private final int level;
    private final int score;

    public LoseLevelMenu(int level, int score) throws IOException {
        super();

        this.level = level;
        this.score = score;
        this.setEntries(Arrays.asList("try again", "back", "exit"));

        this.writeStartLevel();
    }

    private void writeStartLevel() throws IOException {
        URL resource = getClass().getClassLoader().getResource("levels/startLevel.txt");
        assert resource != null;

        BufferedWriter bw = new BufferedWriter(new FileWriter(resource.getFile()));
        bw.write("1");
        bw.close();
    }

    public int getLevel() {
        return this.level;
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

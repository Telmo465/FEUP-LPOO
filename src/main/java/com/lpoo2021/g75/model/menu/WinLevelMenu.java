package com.lpoo2021.g75.model.menu;

import java.io.*;
import java.net.URL;
import java.util.Arrays;

public class WinLevelMenu extends Menu {
    private final int totalLevels;
    private final int level;
    private final int score;
    private final int lives;

    public WinLevelMenu(int level, int score, int lives) throws IOException {
        super();

        this.totalLevels = this.readTotalLevels();

        this.level = level;
        this.score = score;
        this.lives = lives;
        this.setEntries(Arrays.asList("continue", "back", "exit"));

        this.writeStartLevel();
    }

    private int readTotalLevels() throws IOException {
        URL resource = getClass().getClassLoader().getResource("levels/totalLevels.txt");
        assert resource != null;

        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));
        return Integer.parseInt(br.readLine());
    }

    private void writeStartLevel() throws IOException {
        URL resource = getClass().getClassLoader().getResource("levels/startLevel.txt");
        assert resource != null;

        BufferedWriter bw = new BufferedWriter(new FileWriter(resource.getFile()));

        if (!isLastLevel()) bw.write(String.valueOf(this.level + 1));
        else bw.write("1");
        bw.close();
    }

    public int getLevel() {
        return this.level;
    }

    public int getScore() {
        return this.score;
    }

    public int getLives() {
        return this.lives;
    }

    public boolean isLastLevel() {
        return this.totalLevels <= this.level;
    }

    public boolean isSelectedContinue() {
        return isSelected(0);
    }

    public boolean isSelectedBack() {
        return isSelected(1);
    }

    public boolean isSelectedExit() {
        return isSelected(2);
    }
}

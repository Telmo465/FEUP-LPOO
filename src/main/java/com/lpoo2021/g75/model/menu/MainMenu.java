package com.lpoo2021.g75.model.menu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

public class MainMenu extends Menu {
    private final int startLevel;

    public MainMenu() throws IOException {
        super();
        this.startLevel = this.readStartLevel();
        this.setEntries();
    }

    public MainMenu(int startLevel) {
        super();
        this.startLevel = startLevel;
        this.setEntries();
    }

    private int readStartLevel() throws IOException {
        URL resource = getClass().getClassLoader().getResource("levels/startLevel.txt");
        assert resource != null;

        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));
        return Integer.parseInt(br.readLine());
    }

    private void setEntries() {
        this.setEntries(Arrays.asList("start random game", "start sequential game", "exit"));
    }

    public int getStartLevel() {
        return startLevel;
    }

    public boolean isSelectedStartRandom() {
        return isSelected(0);
    }

    public boolean isSelectedStartSequential() {
        return isSelected(1);
    }

    public boolean isSelectedExit() {
        return isSelected(2);
    }
}

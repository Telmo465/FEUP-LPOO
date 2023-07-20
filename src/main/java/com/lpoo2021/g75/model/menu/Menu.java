package com.lpoo2021.g75.model.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Menu {
    private List<String> entries = new ArrayList<>();
    private int currentEntry = 0;

    public Menu() { }

    public void setEntries(List<String> entries) {
        this.entries = entries;
    }

    public int getNumberEntries() {
        return this.entries.size();
    }

    public String getEntry(int i) {
        return this.entries.get(i);
    }

    public void nextEntry() {
        currentEntry++;
        if (currentEntry > this.entries.size() - 1)
            currentEntry = 0;
    }

    public void previousEntry() {
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = this.entries.size() - 1;
    }

    public boolean isSelected(int i) {
        return currentEntry == i;
    }
}

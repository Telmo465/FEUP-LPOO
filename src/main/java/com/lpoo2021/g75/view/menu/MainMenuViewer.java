package com.lpoo2021.g75.view.menu;

import com.lpoo2021.g75.model.game.Position;
import com.lpoo2021.g75.model.menu.MainMenu;
import com.lpoo2021.g75.view.GUI.GUI;
import com.lpoo2021.g75.view.Viewer;

public class MainMenuViewer extends Viewer<MainMenu> {
    public MainMenuViewer(MainMenu menu) {
        super(menu);
    }


    @Override
    public void drawElements(GUI gui) {
        gui.drawTitle(new Position(17, 5));
        gui.drawGameSymbols(new Position(16, 6));

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(20 - (getModel().getEntry(i).length()/2), 11 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
    }
}

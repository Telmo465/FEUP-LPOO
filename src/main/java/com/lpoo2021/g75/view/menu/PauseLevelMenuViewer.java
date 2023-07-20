package com.lpoo2021.g75.view.menu;

import com.lpoo2021.g75.model.game.Position;
import com.lpoo2021.g75.model.menu.PauseLevelMenu;
import com.lpoo2021.g75.view.GUI.GUI;
import com.lpoo2021.g75.view.Viewer;

public class PauseLevelMenuViewer extends Viewer<PauseLevelMenu> {
    public PauseLevelMenuViewer(PauseLevelMenu menu) {
        super(menu);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawTitle(new Position(17, 3));
        gui.drawGameSymbols(new Position(16, 4));
        gui.drawText(new Position(14, 8), "pause level " + getModel().getLevel(), "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position( 20 - (getModel().getEntry(i).length()/2), 12 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
    }
}

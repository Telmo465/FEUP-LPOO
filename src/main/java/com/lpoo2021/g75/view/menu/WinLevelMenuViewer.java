package com.lpoo2021.g75.view.menu;

import com.lpoo2021.g75.model.game.Position;
import com.lpoo2021.g75.model.menu.WinLevelMenu;
import com.lpoo2021.g75.view.GUI.GUI;
import com.lpoo2021.g75.view.Viewer;

public class WinLevelMenuViewer extends Viewer<WinLevelMenu> {
    public WinLevelMenuViewer(WinLevelMenu menu) {
        super(menu);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawTitle(new Position(17, 3));
        gui.drawGameSymbols(new Position(16, 4));

        if (getModel().isLastLevel()){
            gui.drawText(new Position(16, 9), "you   win", "#FFFFFF");
            gui.drawCherry(new Position(20, 8));

        } else {
            gui.drawPacman(new Position(11,8));
            gui.drawText(new Position(12, 9), "level " + getModel().getLevel() + " complete", "#FFFFFF");
            gui.drawPacman(new Position(28,8));
        }

        gui.drawText(new Position(10,11), "score: " + getModel().getScore() + "  lives: "+ getModel().getLives(), "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position( 20 - getModel().getEntry(i).length()/2, 14 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
    }
}

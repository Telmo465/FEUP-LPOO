package com.lpoo2021.g75.view.GUI;

import com.lpoo2021.g75.model.game.Position;

import java.io.IOException;

public interface GUI {
    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT}

    ACTION getNextAction() throws IOException;

    void drawText(Position position, String text, String textColor);

    void drawPacman(Position position);

    void drawWall(Position position);

    void drawCoin(Position position);

    void drawKillerGhost(Position position, boolean paralyzeState);

    void drawReduceScoreGhost(Position position, boolean paralyzeState);

    void drawResetCoinsGhost(Position position, boolean paralyzeState);

    void drawEliminatePwUGhost(Position position, boolean paralyzeState);

    void drawKey(Position position, String color);

    void drawDoor(Position position, String color);

    void drawCherry(Position position);

    void drawApple(Position position);

    void drawOrange(Position position);

    void drawPear(Position position);

    void drawTitle(Position position);

    void drawGameSymbols(Position position);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;
}

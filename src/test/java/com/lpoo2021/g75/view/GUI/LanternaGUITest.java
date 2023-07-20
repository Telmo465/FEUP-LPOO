package com.lpoo2021.g75.view.GUI;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.lpoo2021.g75.model.game.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LanternaGUITest {
    private Screen screen;
    private LanternaGUI gui;
    private TextGraphics textGraphics;

    @BeforeEach
    void setUp() {
        screen = Mockito.mock(Screen.class);
        textGraphics = Mockito.mock(TextGraphics.class);

        Mockito.when(screen.newTextGraphics()).thenReturn(textGraphics);

        gui = new LanternaGUI(screen);
    }

    @Test
    void drawText() {
        gui.drawText(new Position(1, 1), "Draw Text Test", "#CC0000");

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(204, 0, 0));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(1, 1, "Draw Text Test");
    }

    @Test
    void drawPacman() {
        gui.drawPacman(new Position(10, 10));

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 215, 0));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(10, 11, "P");
    }

    @Test
    void drawWall() {
        gui.drawWall(new Position(10, 10));

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(51,51,255));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(10, 11, "W");
    }

    @Test
    void drawCoin() {
        gui.drawCoin(new Position(10, 10));

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(153,153,0));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(10, 11, "C");
    }

    @Test
    void drawKillerGhost() {
        gui.drawKillerGhost(new Position(10, 10), false);
        gui.drawKillerGhost(new Position(10, 10), true);

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(204,0,0));
        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(204,204,204));
        Mockito.verify(textGraphics, Mockito.times(2)).putString(10, 11, "G");
    }

    @Test
    void drawReduceScoreGhost() {
        gui.drawReduceScoreGhost(new Position(10, 10), false);
        gui.drawReduceScoreGhost(new Position(10, 10), true);

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(179,255,179));
        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(204,204,204));
        Mockito.verify(textGraphics, Mockito.times(2)).putString(10, 11, "S");
    }

    @Test
    void drawResetCoinsGhost() {
        gui.drawResetCoinsGhost(new Position(10, 10), false);
        gui.drawResetCoinsGhost(new Position(10, 10), true);

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255,153,255));
        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(204,204,204));
        Mockito.verify(textGraphics, Mockito.times(2)).putString(10, 11, "R");
    }

    @Test
    void drawEliminatePwUGhost() {
        gui.drawEliminatePwUGhost(new Position(10, 10), false);
        gui.drawEliminatePwUGhost(new Position(10, 10), true);

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255,153,0));
        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(204,204,204));
        Mockito.verify(textGraphics, Mockito.times(2)).putString(10, 11, "L");
    }

    @Test
    void drawKey() {
        gui.drawKey(new Position(10, 10), "#FF00FF");

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255,0,255));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(10, 11, "K");
    }

    @Test
    void drawDoor() {
        gui.drawDoor(new Position(10, 10), "#FF00FF");

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255,0,255));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(10, 11, "D");
    }

    @Test
    void drawCherry() {
        gui.drawCherry(new Position(10, 10));

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(190,25,49));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(10, 11, "H");
    }

    @Test
    void drawApple() {
        gui.drawApple(new Position(10, 10));

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(119,178,85));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(10, 11, "A");
    }

    @Test
    void drawOrange() {
        gui.drawOrange(new Position(10, 10));

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(246,159,5));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(10, 11, "O");
    }

    @Test
    void drawPear() {
        gui.drawPear(new Position(10, 10));

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(38,89,8));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(10, 11, "E");
    }

    @Test
    void drawTitle() {
        gui.drawTitle(new Position(10, 10));

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255,255,255));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(10, 10, "QV MVN");
        Mockito.verify(textGraphics, Mockito.times(1)).putString(12, 10, "P");
    }

    @Test
    void drawGameSymbols() {
        gui.drawGameSymbols(new Position(10, 10));

        Mockito.verify(textGraphics, Mockito.times(6)).setForegroundColor(Mockito.any(TextColor.RGB.class));
        Mockito.verify(textGraphics, Mockito.times(1)).putString(10, 11, "L");
        Mockito.verify(textGraphics, Mockito.times(1)).putString(11, 11, "G");
        Mockito.verify(textGraphics, Mockito.times(1)).putString(12, 11, "S");
        Mockito.verify(textGraphics, Mockito.times(1)).putString(13, 11, "R");
        Mockito.verify(textGraphics, Mockito.times(1)).putString(15, 11, "P");
        Mockito.verify(textGraphics, Mockito.times(1)).putString(17, 11, "C");
    }

    @Test
    void getNextActionNone() throws IOException {
        Mockito.when(screen.pollInput()).thenReturn(null);

        GUI.ACTION action = gui.getNextAction();
        assertEquals(GUI.ACTION.NONE, action);
    }

    @Test
    void getNextActionUp() throws IOException {
        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowUp));

        GUI.ACTION action = gui.getNextAction();
        assertEquals(GUI.ACTION.UP, action);
    }

    @Test
    void getNextActionDown() throws IOException {
        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowDown));

        GUI.ACTION action = gui.getNextAction();
        assertEquals(GUI.ACTION.DOWN, action);
    }

    @Test
    void getNextActionRight() throws IOException {
        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowRight));

        GUI.ACTION action = gui.getNextAction();
        assertEquals(GUI.ACTION.RIGHT, action);
    }

    @Test
    void getNextActionLeft() throws IOException {
        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowLeft));

        GUI.ACTION action = gui.getNextAction();
        assertEquals(GUI.ACTION.LEFT, action);
    }

    @Test
    void getNextActionQuit() throws IOException {
        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.EOF));

        GUI.ACTION action = gui.getNextAction();
        assertEquals(GUI.ACTION.QUIT, action);
    }

    @Test
    void getNextActionQuitWithQ() throws IOException {
        KeyStroke keyStrokeQ = new KeyStroke('q', false, false);
        Mockito.when(screen.pollInput()).thenReturn(keyStrokeQ);

        GUI.ACTION action = gui.getNextAction();
        assertEquals(GUI.ACTION.QUIT, action);
    }

    @Test
    void getNextActionSelect() throws IOException {
        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.Enter));

        GUI.ACTION action = gui.getNextAction();
        assertEquals(GUI.ACTION.SELECT, action);
    }

    @Test
    void getNextActionNoneOther() throws IOException {
        KeyStroke keyStrokeA = new KeyStroke('a', false, false);
        Mockito.when(screen.pollInput()).thenReturn(keyStrokeA);

        GUI.ACTION action = gui.getNextAction();
        assertEquals(GUI.ACTION.NONE, action);
    }
}
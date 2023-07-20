package com.lpoo2021.g75.view.GUI;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.lpoo2021.g75.model.game.Position;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class LanternaGUI implements GUI {
    private final Screen screen;

    public LanternaGUI(Screen screen) {
        this.screen = screen;
    }

    public LanternaGUI(int width, int height) throws IOException, FontFormatException, URISyntaxException {
        AWTTerminalFontConfiguration fontConfig = loadSquareFont();
        Terminal terminal = createTerminal(width, height, fontConfig);
        this.screen = createScreen(terminal);
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfig) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height + 1);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);

        return terminalFactory.createTerminal();
    }

    private AWTTerminalFontConfiguration loadSquareFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("font/pac.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);


        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 25);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
    }

    @Override
    public ACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return ACTION.NONE;

        if (keyStroke.getKeyType() == KeyType.EOF) return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') return ACTION.QUIT;

        if (keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.UP;
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return ACTION.RIGHT;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return ACTION.LEFT;

        if (keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;

        return ACTION.NONE;
    }

    @Override
    public void drawText(Position position, String text, String textColor) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(textColor));
        tg.putString(position.getX(), position.getY(), text);
    }


    private void drawSymbol(int line, int column, char symbol, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(line, column + 1, "" + symbol);
    }

    @Override
    public void drawPacman(Position position) {
        drawSymbol(position.getX(), position.getY(), 'P', "#FFD700");
    }

    @Override
    public void drawWall(Position position) {
        drawSymbol(position.getX(), position.getY(), 'W', "#3333FF");
    }

    @Override
    public void drawCoin(Position position) {
        drawSymbol(position.getX(), position.getY(), 'C', "#999900");
    }

    @Override
    public void drawKillerGhost(Position position, boolean paralyzeState) {
        if (!paralyzeState)
            drawSymbol(position.getX(), position.getY(), 'G', "#CC0000");
        else
            drawSymbol(position.getX(), position.getY(), 'G', "#CCCCCC");
    }

    @Override
    public void drawReduceScoreGhost(Position position, boolean paralyzeState) {
        if (!paralyzeState)
            drawSymbol(position.getX(), position.getY(), 'S', "#B3FFB3");
        else
            drawSymbol(position.getX(), position.getY(), 'S', "#CCCCCC");
    }

    @Override
    public void drawResetCoinsGhost(Position position, boolean paralyzeState) {
        if (!paralyzeState)
            drawSymbol(position.getX(), position.getY(), 'R', "#FF99FF");
        else
            drawSymbol(position.getX(), position.getY(), 'R', "#CCCCCC");
    }

    @Override
    public void drawEliminatePwUGhost(Position position, boolean paralyzeState) {
        if (!paralyzeState)
            drawSymbol(position.getX(), position.getY(), 'L', "#FF9900");
        else
            drawSymbol(position.getX(), position.getY(), 'L', "#CCCCCC");
    }

    @Override
    public void drawKey(Position position, String color) {
        drawSymbol(position.getX(), position.getY(), 'K', color);
    }

    @Override
    public void drawDoor(Position position, String color) {
        drawSymbol(position.getX(), position.getY(), 'D', color);
    }


    @Override
    public void drawTitle(Position position) {
        int x = position.getX(), y = position.getY();

        drawText(position, "QV MVN", "#FFFFFF");
        drawPacman(new Position(x + 2, y - 1 ));
    }

    @Override
    public void drawGameSymbols(Position position) {
        int x = position.getX(), y = position.getY();

        drawEliminatePwUGhost(position, false);
        drawKillerGhost(new Position(x + 1, y), false);
        drawReduceScoreGhost(new Position(x + 2, y), false);
        drawResetCoinsGhost(new Position(x + 3, y), false);
        drawPacman(new Position(x + 5, y));
        drawCoin(new Position(x + 7, y));
    }

    @Override
    public void drawCherry(Position position) {
        drawSymbol(position.getX(), position.getY(), 'H', "#BE1931");
    }

    @Override
    public void drawApple(Position position) {
        drawSymbol(position.getX(), position.getY(), 'A', "#77B255");
    }

    @Override
    public void drawOrange(Position position) {
        drawSymbol(position.getX(), position.getY(), 'O', "#F69F05");
    }

    @Override
    public void drawPear(Position position) {
        drawSymbol(position.getX(), position.getY(), 'E', "#265908");
    }

    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }
}

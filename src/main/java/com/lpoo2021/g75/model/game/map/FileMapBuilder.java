package com.lpoo2021.g75.model.game.map;

import com.lpoo2021.g75.model.game.elements.dynamicElements.Pacman;
import com.lpoo2021.g75.model.game.elements.dynamicElements.ghosts.*;
import com.lpoo2021.g75.model.game.elements.fixedElements.Door;
import com.lpoo2021.g75.model.game.elements.fixedElements.collectable.Coin;
import com.lpoo2021.g75.model.game.elements.fixedElements.Wall;
import com.lpoo2021.g75.model.game.elements.fixedElements.collectable.keys.Key;
import com.lpoo2021.g75.model.game.elements.fixedElements.collectable.powerUps.*;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FileMapBuilder extends MapBuilder {
    private final int level;
    private final List<String> lines;
    private final List<String> levelInfoLines;

    public FileMapBuilder(int level) throws IOException {
        this.level = level;

        lines = readLines(getResourceBufferedReader("levels/level" + level + "/map.lvl"));
        levelInfoLines = readLines(getResourceBufferedReader("levels/level" + level + "/info.txt"));
    }

    private BufferedReader getResourceBufferedReader(String path) throws IOException {
        URL resource = getClass().getClassLoader().getResource(path);
        assert resource != null;


        return new BufferedReader(new FileReader(resource.getFile()));
    }

    private List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();

        for (String line; (line = br.readLine()) != null; ) {
            lines.add(line);
        }
        return lines;
    }

    @Override
    protected int getWidth() {
        int width = 0;
        for (String line : lines)
            width = Math.max(width, line.length());
        return width;
    }

    @Override
    protected int getHeight() {
        return lines.size();
    }

    @Override
    protected int getCoinValue() {
        int defaultCoinValue = 10;

        for (String line : levelInfoLines) {
            if (line.charAt(0) == 'C')
                try {
                    return Integer.parseInt(line.substring(2));
                } catch (Exception e) {
                    return defaultCoinValue;
                }
        }

        return defaultCoinValue;
    }

    @Override
    protected int getMapNumber() {
        return this.level;
    }

    @Override
    protected List<Ghost> createGhosts() {
        List<Ghost> ghosts = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == 'G') ghosts.add(new KillerGhost(x, y));
                else if (line.charAt(x) == 'S') ghosts.add(new ReduceScoreGhost(x, y));
                else if (line.charAt(x) == 'C') ghosts.add(new ResetCoinsGhost(x, y));
                else if (line.charAt(x) == 'L') ghosts.add(new EliminatePowerUpsGhost(x, y));
            }
        }

        return ghosts;
    }

    @Override
    protected Pacman createPacman() {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'P') return new Pacman(x, y);
        }
        return null;
    }

    @Override
    protected List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '#') walls.add(new Wall(x, y));
        }

        return walls;
    }

    @Override
    protected List<Coin> createCoins() {
        List<Coin> coins = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'o') coins.add(new Coin(x, y));
        }

        return coins;
    }

    private Key constructKey(int x, int y) {
        Key key = new Key(x, y);
        String keyColor = "#FFFFFF";

        for (String line : levelInfoLines) {
            String[] splitLine = line.trim().split("\\s+");
            if (splitLine[0].equals("K")) {
                if (Integer.parseInt(splitLine[1]) == x && Integer.parseInt(splitLine[2]) == y) {
                    keyColor = splitLine[3];
                    key.setColor(keyColor);
                }
            } else if (splitLine[0].equals("D")) {
                if (Integer.parseInt(splitLine[1]) == x && Integer.parseInt(splitLine[2]) == y) {
                    key.addKeyObserver(new Door(Integer.parseInt(splitLine[3]), Integer.parseInt(splitLine[4]), keyColor));
                }
            }
        }

        return key;
    }

    @Override
    protected List<Key> createKeys() {
        List<Key> keys = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'K') keys.add(constructKey(x, y));
        }

        return keys;
    }

    @Override
    protected List<PowerUp> createPowerUps() {
        List<PowerUp> powerUps = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == 'H') powerUps.add(new Cherry(x, y));
                else if (line.charAt(x) == 'A') powerUps.add(new Apple(x, y));
                else if (line.charAt(x) == 'O') powerUps.add(new Orange(x, y));
                else if (line.charAt(x) == 'E') powerUps.add(new Pear(x, y));
            }
        }

        return powerUps;
    }
}

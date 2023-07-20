package com.lpoo2021.g75.model.game.elements.dynamicElements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Orientation {
    UP, DOWN, LEFT, RIGHT;

    public Orientation getOpposite() {
        if (this == Orientation.UP) return Orientation.DOWN;
        else if (this == Orientation.DOWN) return Orientation.UP;
        else if (this == Orientation.LEFT) return Orientation.RIGHT;
        else if (this == Orientation.RIGHT) return Orientation.LEFT;

        return null;
    }

    public static List<Orientation> allOptions() {
        return new ArrayList<>(Arrays.asList(UP, DOWN, LEFT, RIGHT));
    }
}

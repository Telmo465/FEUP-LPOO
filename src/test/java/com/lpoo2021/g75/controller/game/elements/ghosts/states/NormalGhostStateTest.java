package com.lpoo2021.g75.controller.game.elements.ghosts.states;

import com.lpoo2021.g75.controller.game.elements.ghosts.AttackStrategy;
import com.lpoo2021.g75.controller.game.elements.ghosts.GhostState;
import com.lpoo2021.g75.controller.game.elements.ghosts.MovementStrategy;
import com.lpoo2021.g75.model.game.Position;
import com.lpoo2021.g75.model.game.elements.dynamicElements.Pacman;
import com.lpoo2021.g75.model.game.elements.dynamicElements.ghosts.Ghost;
import com.lpoo2021.g75.model.game.elements.fixedElements.Wall;
import com.lpoo2021.g75.model.game.map.Map;
import com.lpoo2021.g75.view.GUI.GUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class NormalGhostStateTest {
    private Map map;
    private Pacman pacman;
    private Ghost ghost;
    private MovementStrategy movementStrategy;
    private AttackStrategy attackStrategy;

    @BeforeEach
    void setUp() {
        map = Mockito.mock(Map.class);
        pacman = Mockito.mock(Pacman.class);
        ghost = Mockito.mock(Ghost.class);
        movementStrategy = Mockito.mock(MovementStrategy.class);
        attackStrategy = Mockito.mock(AttackStrategy.class);

        Mockito.when(ghost.getPosition()).thenReturn(new Position(5, 4));
        Mockito.when(ghost.getMovementStrategy()).thenReturn(movementStrategy);
        Mockito.when(ghost.getAttackStrategy()).thenReturn(attackStrategy);

        Mockito.when(movementStrategy.nextPosition(new Position(5, 4))).thenReturn(new Position(5, 5));
        Mockito.when(map.teleport(new Position(5, 5))).thenReturn(new Position(5, 5));
        Mockito.when(map.getPacman()).thenReturn(pacman);
    }

    @Test
    void stepNotEmpty() {
        Mockito.when(map.isEmpty(new Position(5, 5))).thenReturn(false);

        GhostState state = new NormalGhostState(ghost);
        state.step(map);

        Mockito.verify(ghost, Mockito.times(0)).setPosition(Mockito.any(Position.class));
        Mockito.verify(attackStrategy, Mockito.times(0)).attack(map);
    }

    @Test
    void stepEmptyNoAttack() {
        Mockito.when(map.isEmpty(new Position(5, 5))).thenReturn(true);
        Mockito.when(pacman.getPosition()).thenReturn(new Position(6, 6));

        GhostState state = new NormalGhostState(ghost);
        state.step(map);

        Mockito.verify(ghost, Mockito.times(1)).setPosition(Mockito.any(Position.class));
        Mockito.verify(ghost, Mockito.times(1)).setPosition(new Position(5, 5));
        Mockito.verify(attackStrategy, Mockito.times(0)).attack(map);
    }

    @Test
    void stepEmptyAttack() {
        Mockito.when(map.isEmpty(new Position(5, 5))).thenReturn(true);
        Mockito.when(pacman.getPosition()).thenReturn(new Position(5, 5));

        GhostState state = new NormalGhostState(ghost);
        state.step(map);

        Mockito.verify(ghost, Mockito.times(1)).setPosition(Mockito.any(Position.class));
        Mockito.verify(ghost, Mockito.times(1)).setPosition(new Position(5, 5));
        Mockito.verify(attackStrategy, Mockito.times(1)).attack(map);
    }

    @Test
    void multiplesAttacks() {
        GhostState state = new NormalGhostState(ghost);
        state.attack(map);
        state.attack(map);
        state.attack(map);

        Mockito.verify(attackStrategy, Mockito.times(3)).attack(map);
    }

    @Test
    void paralyze() {
        GhostState state = new NormalGhostState(ghost);
        state.paralyze();

        Mockito.verify(ghost, Mockito.times(1)).setState(Mockito.any(ParalyzeGhostState.class));
    }
}
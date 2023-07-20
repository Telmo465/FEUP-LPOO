package com.lpoo2021.g75.controller.game.elements.ghosts.states;

import com.lpoo2021.g75.controller.game.elements.ghosts.GhostState;
import com.lpoo2021.g75.model.game.elements.dynamicElements.ghosts.Ghost;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ParalyzeGhostStateTest {
    private Ghost ghost;
    private GhostState state;

    @BeforeEach
    void setUp() {
        ghost = Mockito.mock(Ghost.class);
        state = new ParalyzeGhostState(ghost);
    }

    @Test
    void timePasses() {
        for (int i = 0; i < 4; i++)
            state.timePasses();
        Mockito.verify(ghost, Mockito.times(0)).setState(Mockito.any(NormalGhostState.class));

        state.timePasses();
        Mockito.verify(ghost, Mockito.times(1)).setState(Mockito.any(NormalGhostState.class));
    }

    @Test
    void paralyze() {
        state.paralyze();
        Mockito.verify(ghost, Mockito.times(1)).setState(Mockito.any(ParalyzeGhostState.class));
    }
}
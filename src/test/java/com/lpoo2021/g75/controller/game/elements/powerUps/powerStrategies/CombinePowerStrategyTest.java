package com.lpoo2021.g75.controller.game.elements.powerUps.powerStrategies;

import com.lpoo2021.g75.controller.game.elements.ghosts.states.ParalyzeGhostState;
import com.lpoo2021.g75.controller.game.elements.powerUps.PowerStrategy;
import com.lpoo2021.g75.model.game.elements.dynamicElements.Pacman;
import com.lpoo2021.g75.model.game.elements.dynamicElements.ghosts.Ghost;
import com.lpoo2021.g75.model.game.elements.dynamicElements.ghosts.KillerGhost;
import com.lpoo2021.g75.model.game.elements.dynamicElements.ghosts.ResetCoinsGhost;
import com.lpoo2021.g75.model.game.map.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CombinePowerStrategyTest {
    private Map map;
    private Pacman pacman;
    private List<Ghost> ghosts;

    @BeforeEach
    void setUp() {
        map = Mockito.mock(Map.class);
        pacman = Mockito.mock(Pacman.class);
        ghosts = Arrays.asList(new KillerGhost(3, 4), new ResetCoinsGhost(4, 5));

        Mockito.when(map.getPacman()).thenReturn(pacman);
        Mockito.when(map.getGhosts()).thenReturn(ghosts);
    }

    @Test
    void defaultPower() {
        PowerStrategy strategy = new CombinePowerStrategy();
        strategy.power(map);

        Mockito.verify(pacman, Mockito.times(1)).receiveLive();
        Mockito.verify(pacman, Mockito.times(1)).increaseScore(50);
        for (Ghost ghost : ghosts)
            assertEquals(ParalyzeGhostState.class, ghost.getState().getClass());
    }

    @Test
    void customPower() {
        PowerStrategy strategy = new CombinePowerStrategy(Arrays.asList(new AddLivePowerStrategy(), new AddLivePowerStrategy(), new ParalyzeGhostPowerStrategy()));
        strategy.power(map);

        Mockito.verify(pacman, Mockito.times(2)).receiveLive();
        for (Ghost ghost : ghosts)
            assertEquals(ParalyzeGhostState.class, ghost.getState().getClass());
    }
}
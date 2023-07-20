package com.lpoo2021.g75.controller.game.elements.powerUps.powerStrategies;

import com.lpoo2021.g75.controller.game.elements.ghosts.states.ParalyzeGhostState;
import com.lpoo2021.g75.controller.game.elements.powerUps.PowerStrategy;
import com.lpoo2021.g75.model.game.elements.dynamicElements.ghosts.Ghost;
import com.lpoo2021.g75.model.game.elements.dynamicElements.ghosts.KillerGhost;
import com.lpoo2021.g75.model.game.elements.dynamicElements.ghosts.ResetCoinsGhost;
import com.lpoo2021.g75.model.game.map.Map;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParalyzeGhostPowerStrategyTest {
    @Test
    void power() {
        Map map = Mockito.mock(Map.class);

        List<Ghost> ghosts = Arrays.asList(new KillerGhost(3, 4), new ResetCoinsGhost(4, 5));
        Mockito.when(map.getGhosts()).thenReturn(ghosts);

        PowerStrategy strategy = new ParalyzeGhostPowerStrategy();
        strategy.power(map);

        for (Ghost ghost : ghosts)
            assertEquals(ParalyzeGhostState.class, ghost.getState().getClass());
    }
}
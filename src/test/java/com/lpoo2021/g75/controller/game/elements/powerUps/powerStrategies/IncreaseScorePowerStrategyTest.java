package com.lpoo2021.g75.controller.game.elements.powerUps.powerStrategies;

import com.lpoo2021.g75.controller.game.elements.powerUps.PowerStrategy;
import com.lpoo2021.g75.model.game.elements.dynamicElements.Pacman;
import com.lpoo2021.g75.model.game.map.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class IncreaseScorePowerStrategyTest {
    private Map map;
    private Pacman pacman;

    @BeforeEach
    void setUp() {
        map = Mockito.mock(Map.class);
        pacman = Mockito.mock(Pacman.class);
        Mockito.when(map.getPacman()).thenReturn(pacman);
    }

    @Test
    void defaultPower() {
        PowerStrategy strategy = new IncreaseScorePowerStrategy();
        strategy.power(map);

        Mockito.verify(pacman, Mockito.times(1)).increaseScore(50);
    }

    @Test
    void customPower() {
        PowerStrategy strategy = new IncreaseScorePowerStrategy(20);
        strategy.power(map);

        Mockito.verify(pacman, Mockito.times(1)).increaseScore(20);
    }
}
package com.lpoo2021.g75.controller.game.elements.powerUps.powerStrategies;

import com.lpoo2021.g75.controller.game.elements.powerUps.PowerStrategy;
import com.lpoo2021.g75.model.game.elements.dynamicElements.Pacman;
import com.lpoo2021.g75.model.game.map.Map;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AddLivePowerStrategyTest {
    @Test
    void power() {
        Map map = Mockito.mock(Map.class);
        Pacman pacman = Mockito.mock(Pacman.class);
        Mockito.when(map.getPacman()).thenReturn(pacman);

        PowerStrategy strategy = new AddLivePowerStrategy();
        strategy.power(map);

        Mockito.verify(pacman, Mockito.times(1)).receiveLive();
    }
}
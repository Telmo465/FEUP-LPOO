package com.lpoo2021.g75.controller.game.elements.ghosts.attackStrategies;

import com.lpoo2021.g75.controller.game.elements.ghosts.AttackStrategy;
import com.lpoo2021.g75.model.game.map.Map;
import com.lpoo2021.g75.model.game.elements.dynamicElements.Pacman;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class KillAttackStrategyTest {
    @Test
    void attack() {
        Map map = Mockito.mock(Map.class);
        Pacman pacman = Mockito.mock(Pacman.class);
        Mockito.when(map.getPacman()).thenReturn(pacman);

        AttackStrategy strategy = new KillAttackStrategy();
        strategy.attack(map);

        Mockito.verify(pacman, Mockito.times(1)).loseLive();
    }
}
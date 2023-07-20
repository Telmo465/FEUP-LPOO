package com.lpoo2021.g75.controller.game.elements.ghosts.attackStrategies;

import com.lpoo2021.g75.controller.game.elements.ghosts.AttackStrategy;
import com.lpoo2021.g75.model.game.map.Map;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;

class EliminatePwUAttackStrategyTest {
    @Test
    void attack() {
        Map map = Mockito.mock(Map.class);

        AttackStrategy strategy = new EliminatePwUAttackStrategy();
        strategy.attack(map);

        Mockito.verify(map, Mockito.times(1)).setPowerUps(Collections.emptyList());
    }
}
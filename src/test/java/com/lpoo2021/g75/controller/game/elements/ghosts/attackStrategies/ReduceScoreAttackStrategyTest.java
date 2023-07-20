package com.lpoo2021.g75.controller.game.elements.ghosts.attackStrategies;

import com.lpoo2021.g75.controller.game.elements.ghosts.AttackStrategy;
import com.lpoo2021.g75.model.game.map.Map;
import com.lpoo2021.g75.model.game.elements.dynamicElements.Pacman;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ReduceScoreAttackStrategyTest {
    private Map map;
    private Pacman pacman;

    @BeforeEach
    void setUp() {
        map = Mockito.mock(Map.class);
        pacman = Mockito.mock(Pacman.class);
        Mockito.when(map.getPacman()).thenReturn(pacman);
    }

    @Test
    void defaultAttack() {
        AttackStrategy strategy = new ReduceScoreAttackStrategy();
        strategy.attack(map);

        Mockito.verify(pacman, Mockito.times(1)).decreaseScore(30);
    }

    @Test
    void customAttack() {
        AttackStrategy strategy = new ReduceScoreAttackStrategy(20);
        strategy.attack(map);

        Mockito.verify(pacman, Mockito.times(1)).decreaseScore(20);
    }
}
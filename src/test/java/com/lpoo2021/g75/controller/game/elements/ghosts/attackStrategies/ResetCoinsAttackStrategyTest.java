package com.lpoo2021.g75.controller.game.elements.ghosts.attackStrategies;

import com.lpoo2021.g75.controller.game.elements.ghosts.AttackStrategy;
import com.lpoo2021.g75.model.game.elements.fixedElements.collectable.Coin;
import com.lpoo2021.g75.model.game.map.Map;
import com.lpoo2021.g75.model.game.elements.dynamicElements.Pacman;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ResetCoinsAttackStrategyTest {
    private Map map;
    private Pacman pacman;
    private List<Coin> coins;

    @BeforeEach
    void setUp() {
        map = Mockito.mock(Map.class);
        pacman = Mockito.mock(Pacman.class);

        Coin collectedCoin = new Coin(2, 6);
        collectedCoin.collect();
        coins = Arrays.asList(new Coin(2, 3), collectedCoin, new Coin(6, 2));

        Mockito.when(map.getPacman()).thenReturn(pacman);
        Mockito.when(map.getAllCoins()).thenReturn(coins);
    }

    @Test
    void attackResetCoins() {
        Mockito.when(pacman.getScore()).thenReturn(0);

        AttackStrategy strategy = new ResetCoinsAttackStrategy();
        strategy.attack(map);

        Mockito.verify(map, Mockito.times(1)).getAllCoins();
        for (Coin c : coins) assertFalse(c.isCollected());
    }

    @Test
    void attackWithPositiveScore() {
        Mockito.when(pacman.getScore()).thenReturn(30);

        AttackStrategy strategy = new ResetCoinsAttackStrategy();
        strategy.attack(map);

        Mockito.verify(pacman, Mockito.times(1)).resetScore();
    }

    @Test
    void attackWithNegativeScore() {
        Mockito.when(pacman.getScore()).thenReturn(-30);

        AttackStrategy strategy = new ResetCoinsAttackStrategy();
        strategy.attack(map);

        Mockito.verify(pacman, Mockito.times(0)).resetScore();
    }
}
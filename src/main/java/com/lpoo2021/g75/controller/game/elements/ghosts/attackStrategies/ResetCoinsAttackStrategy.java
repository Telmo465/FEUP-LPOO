package com.lpoo2021.g75.controller.game.elements.ghosts.attackStrategies;

import com.lpoo2021.g75.controller.game.elements.ghosts.AttackStrategy;
import com.lpoo2021.g75.model.game.elements.fixedElements.collectable.Coin;
import com.lpoo2021.g75.model.game.map.Map;

public class ResetCoinsAttackStrategy implements AttackStrategy {
    @Override
    public void attack(Map map) {
        for (Coin coin: map.getAllCoins())
            coin.place();

        if (map.getPacman().getScore() > 0)
            map.getPacman().resetScore();
    }
}

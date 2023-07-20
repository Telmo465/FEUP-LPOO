package com.lpoo2021.g75.controller.game.elements;

import com.lpoo2021.g75.Game;
import com.lpoo2021.g75.controller.game.GameController;
import com.lpoo2021.g75.model.game.Position;
import com.lpoo2021.g75.model.game.map.Map;
import com.lpoo2021.g75.view.GUI.GUI;

public class PacmanController extends GameController {

    public PacmanController(Map map) {
        super(map);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.RIGHT) this.moveRight();
        else if (action == GUI.ACTION.LEFT) this.moveLeft();
        else if (action == GUI.ACTION.UP) this.moveUp();
        else if (action == GUI.ACTION.DOWN) this.moveDown();
    }

    public void moveRight() {
        movePacman(getModel().getPacman().getPosition().getRight());
    }

    public void moveLeft() {
        movePacman(getModel().getPacman().getPosition().getLeft());
    }

    public void moveUp() {
        movePacman(getModel().getPacman().getPosition().getUp());
    }

    public void moveDown() {
        movePacman(getModel().getPacman().getPosition().getDown());
    }

    private void movePacman(Position position) {
        position = getModel().teleport(position);

        if (getModel().isEmpty(position)) {
            getModel().getPacman().setPosition(position);

            if (getModel().isGhost(position))
                getModel().getGhost(position).getState().attack(getModel());

            if (getModel().isNotCollectedCoin(position)) {
                getModel().collectCoin(position);
                getModel().getPacman().increaseScore(getModel().getCoinValue());
            }

            if (getModel().isKey(position))
                getModel().collectKey(position);

            if (getModel().isPowerUp(position))
                getModel().collectPowerUp(position).getPowerStrategy().power(getModel());
        }
    }
}

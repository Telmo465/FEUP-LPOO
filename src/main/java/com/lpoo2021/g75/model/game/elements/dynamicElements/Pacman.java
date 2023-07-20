package com.lpoo2021.g75.model.game.elements.dynamicElements;

import com.lpoo2021.g75.model.game.elements.DynamicElement;

public class Pacman extends DynamicElement {
    private int lives;
    private int score;

    public Pacman(int x, int y, int lives){
        super(x, y);
        this.lives = lives;
        this.score = 0;
    }

    public Pacman(int x, int y){
        super(x, y);
        this.lives = 3;
        this.score = 0;
    }

    public int getLives(){
        return lives;
    }

    public int getScore(){
        return score;
    }

    public void loseLive(){
        this.lives -= 1;
    }

    public void receiveLive(){
        this.lives += 1;
    }

    public boolean hasLives() {
        return (this.lives > 0);
    }

    public void increaseScore(int value) {
        this.score += value;
    }

    public void decreaseScore(int value) {
        this.score -= value;
    }

    public void resetScore() {
        this.score = 0;
    }
}

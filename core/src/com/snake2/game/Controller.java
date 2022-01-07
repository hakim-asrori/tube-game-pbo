package com.snake2.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

public class Controller {
    private int score;

    public Direction queryInput() {
        boolean rightPress = Gdx.input.isKeyPressed(Input.Keys.RIGHT);
        boolean leftPress = Gdx.input.isKeyPressed(Input.Keys.LEFT);
        boolean upPress = Gdx.input.isKeyPressed(Input.Keys.UP);
        boolean downPress = Gdx.input.isKeyPressed(Input.Keys.DOWN);

        if (rightPress)
            return Direction.RIGHT;
        if (leftPress)
            return Direction.LEFT;
        if (upPress)
            return Direction.UP;
        if (downPress)
            return Direction.DOWN;
        return Direction.NONE;
    }

    public boolean checkForRestart() {
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            return true;
        }
        return false;
    }

    public void increaseScore() {
        this.score++;
    }

    public void resetScore() {
        this.score = 0;
    }

    public int getScore() {
        return this.score;
    }
}

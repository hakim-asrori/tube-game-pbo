package com.snake2.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Food {
    private int x;
    private int y;
    private boolean alive = false;

    Snake snake;
    Viewport viewport;
    Controller controller;

    public Food(Snake snake, Controller controller) {
        this.snake = snake;
        this.controller = controller;
    }

    public void updatePosition() {
        boolean covered;

        if (!alive) {
            do {
                covered = false;
                x = MathUtils.random(((int) viewport.getWorldWidth() / snake.getSIZE()) - 1) * snake.getSIZE();
                y = MathUtils.random(((int) viewport.getWorldHeight() / snake.getSIZE()) - 1) * snake.getSIZE();

                if (x == snake.getX() || y == snake.getY()) {
                    covered = true;
                }
                alive = true;
            } while (covered);
        }
    }

    public void checkFoodCollision() {
        if (alive && x == snake.getX() && y == snake.getY()) {
            snake.createdBodyPart(snake.getX(), snake.getY());
            controller.increaseScore();
            alive = false;
        }
    }

    public void draw(ShapeRenderer shapeRenderer) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.GREEN);
        shapeRenderer.rect(x, y, snake.getSIZE(), snake.getSIZE());
        shapeRenderer.end();
    }

    public void setViewport(Viewport viewport) {
        this.viewport = viewport;
    }

    public void reset() {
        alive = false;
    }
}

package com.catmb.ffffff;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;

public class Hero {
    private static Hero instance = null;
    protected TextureAtlas atlas;
    protected Array<Sprite> sprites;
    private int rotationIterator, mm;
    private boolean moveTask[];
    protected int x, y;
    protected Hero() {
        atlas = new TextureAtlas("hero.txt");
        sprites = atlas.createSprites();
        rotationIterator = 0;
        mm = 2;
        moveTask = new boolean[4];
    }
    public static Hero getInstance() {
        if(instance == null) {
            instance = new Hero();
        }
        return instance;
    }
    public Sprite getSprite() {
        return sprites.get(rotationIterator);
    }

    //W - 2, S - 1, A - 4, D - 3
    public void rotate(int direction) {
        rotationIterator = direction - 1;
    }
    public void startMove(int direction) {
        moveTask[direction - 1] = true;
    }
    public void stopMove(int direction) {
        moveTask[direction - 1] = false;
    }
    public void move() {
        if(moveTask[0]) {
            y -= mm;
        }
        if(moveTask[1]) {
            y += mm;
        }
        if(moveTask[2]) {
            x += mm;
        }
        if(moveTask[3]) {
            x -= mm;
        }
    }
    public void render(SpriteBatch batch) {
        batch.draw(getSprite(), x, y);
    }
}

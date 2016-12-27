package com.catmb.ffffff;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;

public class Hero {
    private static Hero instance = null;
    protected TextureAtlas atlas;
    protected Array<Sprite> sprites;
    private int rotationIterator, xm, ym, mm, pressedKeysCount;
    protected int x, y;
    protected Hero() {
        atlas = new TextureAtlas("hero.txt");
        sprites = atlas.createSprites();
        rotationIterator = 0;
        xm = 0;
        ym = 0;
        mm = 1;
        pressedKeysCount = 0;
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
        pressedKeysCount++;
        switch (direction) {
            case 1:
                xm = 0;
                ym = -mm;
                break;
            case 2:
                xm = 0;
                ym = mm;
                break;
            case 3:
                xm = mm;
                ym = 0;
                break;
            case 4:
                xm = -mm;
                ym = 0;
                break;
        }
    }
    public void stopMove() {
        pressedKeysCount--;
        if(pressedKeysCount == 0) {
            xm = 0;
            ym = 0;
        }
    }
    public void move() {
        x += xm;
        y += ym;
    }
}

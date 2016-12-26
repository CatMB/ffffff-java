package com.catmb.ffffff;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;

public class Hero {
    private static Hero instance = null;
    protected TextureAtlas atlas;
    protected Array<Sprite> sprites;
    private int rotationIterator;
    protected int x, y;
    protected Hero() {
        atlas = new TextureAtlas("hero.txt");
        sprites = atlas.createSprites();
        rotationIterator = 0;
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
    public void rotate(int direction) {
        rotationIterator = direction - 1;
    }
    public void move(int mx, int my) {
        x += mx;
        y += my;
    }
}

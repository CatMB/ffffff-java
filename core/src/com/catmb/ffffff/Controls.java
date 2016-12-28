package com.catmb.ffffff;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class Controls implements InputProcessor {
    private static Controls instance = null;
    private int movementSpeed;
    protected Controls() {
        movementSpeed = 1;
    }
    public static Controls getInstance() {
        if(instance == null) {
            instance = new Controls();
        }
        return instance;
    }

    private Hero hero = Hero.getInstance();

    public boolean cl = false; //проверка камеры
    public boolean cr = false; //проверка камеры

    @Override
    public boolean keyDown(int keycode) {
        switch(keycode) {
            case Input.Keys.W:
                hero.rotate(2);
                hero.startMove(2);
                break;
            case Input.Keys.S:
                hero.rotate(1);
                hero.startMove(1);
                break;
            case Input.Keys.A:
                hero.rotate(4);
                hero.startMove(4);
                break;
            case Input.Keys.D:
                hero.rotate(3);
                hero.startMove(3);
                break;
            case Input.Keys.E://проверка камеры
                cr = true;
                cl = false;
                break;
            case Input.Keys.Q://проверка камеры
                cl = true;
                cr = false;
                break;
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.W:
                hero.stopMove(2);
                break;
            case Input.Keys.S:
                hero.stopMove(1);
                break;
            case Input.Keys.A:
                hero.stopMove(4);
                break;
            case Input.Keys.D:
                hero.stopMove(3);
                break;
        }
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }



}

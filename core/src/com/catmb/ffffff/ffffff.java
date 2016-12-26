package com.catmb.ffffff;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class ffffff extends ApplicationAdapter implements InputProcessor {
	SpriteBatch batch;
	Controls control;

	OrthographicCamera camera;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		control = Controls.getInstance();
		Gdx.input.setInputProcessor(control);

		camera = new OrthographicCamera(800, 600);
		camera.position.set(new Vector3(400, 300, 0));
	}

	@Override
	public void render () {

	    camera.update();
	    batch.setProjectionMatrix(camera.combined);

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		//batch.draw(img, 0, 0);
		batch.draw(Hero.getInstance().getSprite(), Hero.getInstance().x, Hero.getInstance().y);
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
	}

	@Override
	public boolean keyDown(int keycode) {
		switch(keycode) {
			case Keys.W:
				break;
			case Keys.S:
				break;
			case Keys.A:
				break;
			case Keys.D:
				break;
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
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

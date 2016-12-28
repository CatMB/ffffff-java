package com.catmb.ffffff;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.math.Vector3;

public class ffffff extends ApplicationAdapter{
	SpriteBatch batch;
	Controls control;

	Level level;
	OrthographicCamera camera;



	
	@Override
	public void create () {
		batch = new SpriteBatch();
		control = Controls.getInstance();


		Gdx.input.setInputProcessor(control);

		camera = new OrthographicCamera(400, 300);
		camera.position.set(new Vector3(200, 150, 0));
		camera.update();
		level = new Level();

	}

	@Override
	public void render () {

		update(Gdx.graphics.getDeltaTime());

	    batch.setProjectionMatrix(camera.combined);

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		{
			level.render(camera);
		}
		Hero.getInstance().move();
		batch.draw(Hero.getInstance().getSprite(), Hero.getInstance().x, Hero.getInstance().y);
		batch.end();
	}

	public void update(float dt){
		camera.update();

		if(control.cl) camera.translate(-1, 0);
		if(control.cr) camera.translate(1, 0);
	}

	@Override
	public void dispose () {
		batch.dispose();
		level.dispose();
	}
}

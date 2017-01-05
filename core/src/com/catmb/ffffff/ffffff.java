package com.catmb.ffffff;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector3;

import java.util.ArrayList;

public class ffffff extends ApplicationAdapter{
	SpriteBatch batch;
	Controls control;
	ArrayList<Room> rooms;
	Room room;
	OrthographicCamera camera;
	Hero hero;
	int roomIterator;

	@Override
	public void create () {
		batch = new SpriteBatch();
		control = Controls.getInstance();
		hero = Hero.getInstance();
		roomIterator = 0;
		Gdx.input.setInputProcessor(control);

		camera = new OrthographicCamera(800, 600);
		camera.position.set(new Vector3(400, 150, 0));
		camera.update();
		room = new Room("level/1.tmx");
		rooms = new ArrayList<Room>();
		rooms.add(room);
	}

	@Override
	public void render () {

		update(Gdx.graphics.getDeltaTime());

	    batch.setProjectionMatrix(camera.combined);

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        rooms.get(roomIterator).render(camera);
		batch.begin();
		{
            hero.render(batch);
		}
		batch.end();
	}

	public void update(float dt){
		camera.update();
        hero.move();
		Hero.getInstance().move();
		if(control.cl) camera.translate(-1, 0);
		if(control.cr) camera.translate(1, 0);
	}

	@Override
	public void dispose () {
		batch.dispose();
		room.dispose();
	}
}

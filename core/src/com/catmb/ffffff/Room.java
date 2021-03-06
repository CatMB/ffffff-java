package com.catmb.ffffff;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import java.awt.*;

/**
 * Created by youngsenpai on 12/26/16.
 */
public class Room {

    TiledMap tiledMap;
    TiledMapRenderer tiledMapRenderer;

    public Room(String path) {
        tiledMap = new TmxMapLoader().load(path);
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
    }

    public void render(OrthographicCamera camera){
        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();
    }

    public void dispose(){
        tiledMap.dispose();
    }
}

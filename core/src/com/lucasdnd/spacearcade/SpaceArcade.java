package com.lucasdnd.spacearcade;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
import com.lucasdnd.spacearcade.gameplay.Player;

public class SpaceArcade extends ApplicationAdapter {
	// System objects
	SpriteBatch batch;
	InputHandler input;
	FontUtils font;
	
	// Gamplay objects
	Player player;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new FontUtils();
		input = new InputHandler();
		Gdx.input.setInputProcessor(input);
		
		player = new Player();
	}
	
	public void update() {
		player.update(input);
	}

	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		player.render(batch);
		
		font.drawWhiteFont("PRESS START", 0f, Gdx.graphics.getHeight(), Align.center, Gdx.graphics.getWidth());
	}
}

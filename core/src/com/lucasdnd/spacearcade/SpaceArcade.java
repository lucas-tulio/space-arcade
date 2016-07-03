package com.lucasdnd.spacearcade;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;

public class SpaceArcade extends ApplicationAdapter {
	SpriteBatch batch;
	Texture ship;
	InputHandler input;
	FontUtils font;
	
	float x, y, speed;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new FontUtils();
		ship = Resources.get().player;
		input = new InputHandler();
		Gdx.input.setInputProcessor(input);
		speed = 3f;
	}
	
	public void update() {
		// Movement
		if (input.upPressed) {
			y += speed;
		} else if (input.downPressed) {
			y -= speed;
		}
		
		if (input.rightPressed) {
			x += speed;
		} else if (input.leftPressed) {
			x -= speed;
		}
		
		// Action key
		input.actionDelay--;
		if (input.actionDelay <= 0) {
			input.actionDelay = 0;

			if (input.firePressed) {
				
				// Perform your action here
//				Resources.get().laserSound.play();
				
				input.applyActionDelay();
			}
		}
	}

	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		batch.draw(ship, x, y);
		batch.end();
		
		font.drawWhiteFont("PRESS START", 0f, Gdx.graphics.getHeight(), Align.center, Gdx.graphics.getWidth());
	}
}

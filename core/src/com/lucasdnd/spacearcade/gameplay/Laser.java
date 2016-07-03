package com.lucasdnd.spacearcade.gameplay;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lucasdnd.spacearcade.InputHandler;
import com.lucasdnd.spacearcade.Resources;

public class Laser extends Entity {
	
	private Texture sprite;
	private boolean dead;
	
	public Laser(float x, float y) {
		this.x = x;
		this.y = y;
		speed = 8f;
		sprite = Resources.get().laser;
	}

	@Override
	public void update(InputHandler input) {
		y += speed;
	}

	@Override
	public void render(SpriteBatch batch) {
		batch.draw(sprite, x, y);
	}

	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}
}

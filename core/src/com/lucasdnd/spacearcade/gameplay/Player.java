package com.lucasdnd.spacearcade.gameplay;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lucasdnd.spacearcade.InputHandler;
import com.lucasdnd.spacearcade.Resources;

/**
 * Player class
 * @author lucasdnd
 *
 */
public class Player extends Entity {
	
	private Texture sprite;
	private boolean dead;
	private int score = 0;
	
	public Player() {
		sprite = Resources.get().player;
		x = Gdx.graphics.getWidth() / 2f - (sprite.getWidth() / 2f);
		y = 20f;
		width = sprite.getWidth();
		height = sprite.getHeight();
		speed = 3f;
	}

	@Override
	public void update(InputHandler input) {
		if (dead) {
			return;
		}
		
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
				// Resources.get().laserSound.play();
				
				input.applyActionDelay();
			}
		}
	}

	@Override
	public void render(SpriteBatch batch) {
		if (dead) {
			return;
		}
		batch.begin();
		batch.draw(sprite, x, y);
		batch.end();
	}

	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public void incrementScore() {
		this.score += 10;
	}
}

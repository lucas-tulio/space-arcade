package com.lucasdnd.spacearcade.gameplay;

import java.util.ArrayList;

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
	private ArrayList<Laser> lasers;
	private final int MAX_LASERS = 3;
	private boolean dead;
	private int score = 0;
	private final float MARGIN = 2f;
	private final float BASE_SPEED = 5f;
	private final float MAX_SPEED = 7f;
	
	public Player() {
		sprite = Resources.get().player;
		x = Gdx.graphics.getWidth() / 2f - (sprite.getWidth() / 2f);
		y = 20f;
		width = sprite.getWidth();
		height = sprite.getHeight();
		speed = BASE_SPEED;
		lasers = new ArrayList<Laser>();
	}

	@Override
	public void update(InputHandler input) {
		if (dead) {
			return;
		}
		
		// Increase speed with score
		speed = BASE_SPEED + score * 0.0025f;
		if (speed > MAX_SPEED) {
			speed = MAX_SPEED;
		}
		
		// Movement
		if (input.upPressed && y < Gdx.graphics.getHeight() - height) {
			y += speed;
		} else if (input.downPressed && y > 0) {
			y -= speed;
		}
		
		if (input.rightPressed && x < Gdx.graphics.getWidth() - width - MARGIN) {
			x += speed;
		} else if (input.leftPressed && x > MARGIN) {
			x -= speed;
		}
		
		// Action key
		input.actionDelay--;
		if (input.actionDelay <= 0) {
			input.actionDelay = 0;

			if (input.firePressed) {
				
				// Perform your action here
				if (lasers.size() < MAX_LASERS) {
					Resources.get().laserSound.play();
					lasers.add(new Laser(x + width / 2f - MARGIN, y));
				}
				
				input.applyActionDelay();
			}
		}
		
		// Lasers
		ArrayList<Laser> lasersToRemove = new ArrayList<Laser>();
		for (Laser laser : lasers) {
			laser.update(input);
			if (laser.getY() >= Gdx.graphics.getHeight()) {
				lasersToRemove.add(laser);				
			}
		}
		
		// Remove lasers that left the screen
		for (Laser laser : lasersToRemove) {
			lasers.remove(laser);
		}
	}

	@Override
	public void render(SpriteBatch batch) {
		if (dead) {
			return;
		}
		batch.begin();
		batch.draw(sprite, x, y);
		for (Laser laser : lasers) {
			laser.render(batch);
		}
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
	public ArrayList<Laser> getLasers() {
		return lasers;
	}
}

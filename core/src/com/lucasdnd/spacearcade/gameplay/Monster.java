package com.lucasdnd.spacearcade.gameplay;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lucasdnd.spacearcade.InputHandler;
import com.lucasdnd.spacearcade.Resources;

/**
 * Monster class
 * @author lucasdnd
 *
 */
public class Monster extends Entity {
	
	private Texture[] textures;
	private final int MAX_SPRITE_TIME = 60;
	private int spriteTime, currentTexture;
	private boolean dead;
	
	public Monster(float x, float speed) {
		this.x = x;
		this.speed = speed;
		textures = new Texture[2];
		int randomSprite = new Random().nextInt(3);
		textures[0] = Resources.get().monsters[randomSprite * 2];
		textures[1] = Resources.get().monsters[randomSprite * 2 + 1];
		y = Gdx.graphics.getHeight() + textures[0].getHeight();
	}
	
	/**
	 * Returns the current sprite being rendered in the animation
	 * @return
	 */
	private Texture getCurrentTexture() {
		return textures[currentTexture % 2];
	}

	@Override
	public void update(InputHandler input) {
		if (dead) {
			return;
		}
		
		// Update animation
		spriteTime++;
		if (spriteTime > MAX_SPRITE_TIME) {
			spriteTime = 0;
			currentTexture++;
		}
		
		// Update width and height
		width = getCurrentTexture().getWidth();
		height = getCurrentTexture().getHeight();
		
		// Update movement
		y -= speed;
	}

	@Override
	public void render(SpriteBatch batch) {
		if (dead) {
			return;
		}
		
		batch.begin();
		batch.draw(getCurrentTexture(), x, y);
		batch.end();
	}

	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}
}

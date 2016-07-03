package com.lucasdnd.spacearcade.gameplay;

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
	private int MAX_SPRITE_TIME = 60;
	private int spriteTime, currentTexture;
	
	public Monster(float x, float speed) {
		this.x = x;
		this.speed = speed;
		textures = new Texture[2];
		textures[0] = Resources.get().monsters[0];
		textures[1] = Resources.get().monsters[1];
		y = Gdx.graphics.getHeight() + textures[0].getHeight();
	}

	@Override
	public void update(InputHandler input) {
		// Update animation
		spriteTime++;
		if (spriteTime > MAX_SPRITE_TIME) {
			spriteTime = 0;
			currentTexture++;
		}
		
		// Update movement
		y -= speed;
	}

	@Override
	public void render(SpriteBatch batch) {
		batch.begin();
		batch.draw(textures[currentTexture % 2], x, y);
		batch.end();
	}

}

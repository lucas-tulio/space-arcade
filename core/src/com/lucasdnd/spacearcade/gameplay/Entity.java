package com.lucasdnd.spacearcade.gameplay;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lucasdnd.spacearcade.InputHandler;

/**
 * Basic game object
 * @author lucasdnd
 *
 */
public abstract class Entity {
	protected float x, y, width, height, speed;
	public abstract void update(InputHandler input);
	public abstract void render(SpriteBatch batch);
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	public float getWidth() {
		return width;
	}
	public void setWidth(float width) {
		this.width = width;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public float getSpeed() {
		return speed;
	}
	public void setSpeed(float speed) {
		this.speed = speed;
	}
}

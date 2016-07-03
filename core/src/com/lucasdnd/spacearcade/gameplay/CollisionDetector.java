package com.lucasdnd.spacearcade.gameplay;

import java.util.ArrayList;

/**
 * Detects collisions
 * @author lucasdnd
 *
 */
public class CollisionDetector {
	
	CollisionDetectorListener listener;

	public CollisionDetector(CollisionDetectorListener listener) {
		this.listener = listener;
	}
	
	public void update(Player player, ArrayList<Monster> monsters) {
		for (Monster monster : monsters) {
			// Lasers vs Monsters collision
			for (Laser laser : player.getLasers()) {
				if (rectCollision(laser, monster)) {
					listener.laserHitMonster(laser, monster);
				}
			}
			
			if (player.isDead()) {
				return;
			}
			
			// Player vs Monsters collision
			if (rectCollision(player, monster)) {
				listener.monsterHitPlayer();
			}
		}
	}
	
	/**
	 * Check rectangle collision
	 * @param rect1
	 * @param rect2
	 * @return
	 */
	private boolean rectCollision(Entity rect1, Entity rect2) {
		return rect1.getX() <= rect2.getX() + rect2.getWidth() &&
				rect1.getX() + rect1.getWidth() >= rect2.getX() &&
				rect1.getY() <= rect2.getY() + rect2.getHeight() &&
				rect1.getY() + rect1.getHeight() >= rect2.getY();
	}

	public CollisionDetectorListener getListener() {
		return listener;
	}

	public void setListener(CollisionDetectorListener listener) {
		this.listener = listener;
	}
}

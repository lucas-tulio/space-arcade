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
		// Player vs Monster collision
		for (Monster monster : monsters) {
			if (player.getX() < monster.getX() + monster.getWidth() &&
					player.getX() + player.getWidth() > monster.getX() &&
					player.getY() < monster.getY() + monster.getHeight() &&
					player.getY() + player.getHeight() > monster.getY()) {
				listener.monsterHitPlayer();
			}
		}
	}

	public CollisionDetectorListener getListener() {
		return listener;
	}

	public void setListener(CollisionDetectorListener listener) {
		this.listener = listener;
	}
}

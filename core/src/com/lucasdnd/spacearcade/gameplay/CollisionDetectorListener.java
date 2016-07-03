package com.lucasdnd.spacearcade.gameplay;

/**
 * Notifies other objects about collisions
 * @author lucasdnd
 *
 */
public interface CollisionDetectorListener {
	public void monsterHitPlayer();
	public void laserHitMonster(Laser laser, Monster monster);
}

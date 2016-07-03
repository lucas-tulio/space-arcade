package com.lucasdnd.spacearcade.gameplay;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;

/**
 * Spawns monsters on the screens
 * @author lucasdnd
 * @param <Monster>
 *
 */
public class MonsterSpawner {
	
	private ArrayList<Monster> monsters;
	private float currentMonsterSpeed = 3f;
	private float spawnSpeed = 1;
	private float spawnTime = 0;
	private final float MAX_SPAWN_TIME = 60;
	
	private final int RIGHT_MARGIN = 24;
	
	public MonsterSpawner() {
		monsters = new ArrayList<Monster>();
	}
	
	public void update() {
 		spawnTime += spawnSpeed;
		if (spawnTime > MAX_SPAWN_TIME) {
			spawnTime = 0;
			float randomX = new Random().nextInt(Gdx.graphics.getWidth() - RIGHT_MARGIN);
			monsters.add(new Monster(randomX, currentMonsterSpeed));
		}
	}

	public ArrayList<Monster> getMonsters() {
		return monsters;
	}

	public void setMonsters(ArrayList<Monster> monsters) {
		this.monsters = monsters;
	}

	public float getCurrentMonsterSpeed() {
		return currentMonsterSpeed;
	}

	public void setCurrentMonsterSpeed(float currentMonsterSpeed) {
		this.currentMonsterSpeed = currentMonsterSpeed;
	}

	public float getSpawnSpeed() {
		return spawnSpeed;
	}

	public void setSpawnSpeed(float spawnSpeed) {
		this.spawnSpeed = spawnSpeed;
	}
}

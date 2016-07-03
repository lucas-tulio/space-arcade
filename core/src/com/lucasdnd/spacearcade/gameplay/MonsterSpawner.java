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
	private float monsterSpeed = 3f;
	private float spawnSpeed = 1f;
	private float spawnTime = 0f;
	private final float MAX_SPAWN_TIME = 60f;
	
	private final int RIGHT_MARGIN = 24;
	
	public MonsterSpawner() {
		monsters = new ArrayList<Monster>();
	}
	
	public void update(int score) {
		// Update difficulty according to score
		spawnSpeed = 1f + score / 200f;
		monsterSpeed = 3f + score / 200f;
		
		// Spawn monsters
 		spawnTime += spawnSpeed;
		if (spawnTime > MAX_SPAWN_TIME) {
			spawnTime = 0;
			float randomX = new Random().nextInt(Gdx.graphics.getWidth() - RIGHT_MARGIN);
			monsters.add(new Monster(randomX, monsterSpeed));
		}
	}

	public ArrayList<Monster> getMonsters() {
		return monsters;
	}

	public void setMonsters(ArrayList<Monster> monsters) {
		this.monsters = monsters;
	}
}

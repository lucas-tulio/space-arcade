package com.lucasdnd.spacearcade;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
import com.lucasdnd.spacearcade.gameplay.CollisionDetector;
import com.lucasdnd.spacearcade.gameplay.CollisionDetectorListener;
import com.lucasdnd.spacearcade.gameplay.Entity;
import com.lucasdnd.spacearcade.gameplay.Laser;
import com.lucasdnd.spacearcade.gameplay.Monster;
import com.lucasdnd.spacearcade.gameplay.MonsterSpawner;
import com.lucasdnd.spacearcade.gameplay.Player;

public class SpaceArcade extends ApplicationAdapter implements CollisionDetectorListener {
	// System objects
	SpriteBatch batch;
	InputHandler input;
	FontUtils font;
	
	// Gamplay objects
	Player player;
	MonsterSpawner monsterSpawner;
	CollisionDetector collisionDetector;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new FontUtils();
		input = new InputHandler();
		Gdx.input.setInputProcessor(input);
		
		startGame();
	}
	
	/**
	 * Starts a new game
	 */
	private void startGame() {
		player = new Player();
		monsterSpawner = new MonsterSpawner();
		collisionDetector = new CollisionDetector(this);
	}
	
	@Override
	public void monsterHitPlayer() {
		Resources.get().explosionSound.play();
		player.setDead(true);
	}

	@Override
	public void laserHitMonster(Laser laser, Monster monster) {
		Resources.get().hitSound.play();
		player.incrementScore();
		monster.setDead(true);
		laser.setDead(true);
	}
	
	public void update() {
		// Start
		if (input.isStartJustPressed()) {
			startGame();
		}
		
		player.update(input);
		monsterSpawner.update(player.getScore());
		
		// Remove dead Entities
		ArrayList<Entity> deadEntities = new ArrayList<Entity>();
		for (Monster m : monsterSpawner.getMonsters()) {
			if (m.isDead()) {
				deadEntities.add(m);
			}
		}
		for (Laser l : player.getLasers()) {
			if (l.isDead()) {
				deadEntities.add(l);
			}
		}
		monsterSpawner.getMonsters().removeAll(deadEntities);
		player.getLasers().removeAll(deadEntities);
		
		// Update the remaining ones
		for (Monster m : monsterSpawner.getMonsters()) {
			m.update(input);
		}
		collisionDetector.update(player, monsterSpawner.getMonsters());
		
		input.flush();
	}

	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		// Game objects
		player.render(batch);
		for (Monster m : monsterSpawner.getMonsters()) {
			m.render(batch);
		}
		
		// Text
		font.drawWhiteFont("SCORE: " + player.getScore(), 8f, Gdx.graphics.getHeight() - 8f);
		
		if (player.isDead()) {
			font.drawWhiteFont("PRESS START", 0f, Gdx.graphics.getHeight() / 2f, Align.center, Gdx.graphics.getWidth());
		}
	}
}

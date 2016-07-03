package com.lucasdnd.spacearcade;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

/**
 * Loads and keeps references to resources (fonts, spites, sounds, etc)
 * @author lucasdnd
 *
 */
public class Resources {

	private static Resources instance;
	public static Resources get() {
		if (instance == null) {
			instance = new Resources();
		}
		return instance;
	}
	
	private Resources() {
		pressStart = new BitmapFont(Gdx.files.internal("font/press-start.fnt"));
		
		laserSound = Gdx.audio.newSound(Gdx.files.internal("sfx/laser.wav"));
		hitSound = Gdx.audio.newSound(Gdx.files.internal("sfx/hit.wav"));
		explosionSound = Gdx.audio.newSound(Gdx.files.internal("sfx/explosion.wav"));
		
		player =  new Texture("gfx/player.png");
		laser = new Texture("gfx/laser.png");
		monsters = new Texture[6];
		for (int i = 0; i < monsters.length; i++) {
			monsters[i] = new Texture("gfx/monster-" + (i + 1) + ".png");
		}
	}
	
	// Fonts
	public BitmapFont pressStart;
	
	// Sound effects
	public Sound laserSound, hitSound, explosionSound;
	
	// Sprites
	public Texture player; 
	public Texture[] monsters;
	public Texture laser;
}

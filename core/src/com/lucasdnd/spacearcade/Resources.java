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
//		laserSound = Gdx.audio.newSound(Gdx.files.internal("sfx/laser.ogg"));
		playerShip =  new Texture("badlogic.jpg");
	}
	
	// Fonts
	public BitmapFont pressStart;
	
	// Sound effects
	public Sound laser;
	
	// Sprites
	public Texture playerShip; 
}

package com.lucasdnd.spacearcade;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Use these methods to easily draw text. Supports text alignment and drop shadow.
 * @author lucasdnd
 *
 */
public class FontUtils {
	
	private SpriteBatch fontBatch;
	private float shadowDistance = 1f;
	
	public FontUtils() {
		this.fontBatch = new SpriteBatch();
	}
	
	public int getTextWidth(String text) {
		float charWidth = Resources.get().pressStart.getSpaceWidth();
		float textWidth = charWidth * text.length();
		return (int)textWidth;
	}
	
	public void drawWhiteFont(String text, float x, float y) {
		fontBatch.begin();
		Resources.get().pressStart.draw(fontBatch, text, x, y);
		fontBatch.end();
	}
	
	public void drawWhiteFont(String text, float x, float y, int align, int space) {
		fontBatch.begin();
		Resources.get().pressStart.draw(fontBatch, text, x, y, space, align, false);
		fontBatch.end();
	}
	
	public float getShadowDistance() {
		return shadowDistance;
	}

	public void setShadowDistance(float shadowDistance) {
		this.shadowDistance = shadowDistance;
	}
}

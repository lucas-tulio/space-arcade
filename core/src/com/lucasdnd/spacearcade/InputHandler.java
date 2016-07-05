package com.lucasdnd.spacearcade;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.ControllerListener;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.controllers.PovDirection;
import com.badlogic.gdx.math.Vector3;

public class InputHandler implements InputProcessor, ControllerListener {
	
	public boolean leftMouseDown, leftMouseJustClicked, rightMouseDown, rightMouseJustClicked;
	public boolean upPressed, leftPressed, downPressed, rightPressed;
	public boolean firePressed, shieldPressed;
	public boolean startJustPressed;
	
	// Controls hold down delay. When it reaches 0, the player can perform another action
	public int actionDelay = 0;
	public final int maxActionDelay = 16;
	
	private final float deadzone = 0.1f;
	
	public InputHandler() {
		Controllers.addListener(this);
	}
	
	/**
	 * Release the key states											
	 */
	public void flush() {
		startJustPressed = false;
	}
	
	public void applyActionDelay() {
		actionDelay = maxActionDelay;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		
		if (keycode == Keys.UP) {
			upPressed = true;
		} else if (keycode == Keys.LEFT) {
			leftPressed = true;
		} else if (keycode == Keys.DOWN) {
			downPressed = true;
		} else if (keycode == Keys.RIGHT) {
			rightPressed = true;
		}
		
		if (keycode == Keys.E) {
			firePressed = true;
		} else if (keycode == Keys.W) {
			shieldPressed = true;
		}
		
		if (keycode == Keys.ENTER) {
			startJustPressed = true;
		}
	
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		
		if (keycode == Keys.UP) {
			upPressed = false;
		} else if (keycode == Keys.LEFT) {
			leftPressed = false;
		} else if (keycode == Keys.DOWN) {
			downPressed = false;
		} else if (keycode == Keys.RIGHT) {
			rightPressed = false;
		}
		
		// When releasing the action key, reset the key delay so they can be pressed again immediately
		if (keycode == Keys.E) {
			firePressed = false;
			actionDelay = 0;
		}
		
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if (button == 0) {
			leftMouseDown = true;
			leftMouseJustClicked = true;
		} else if (button == 1) {
			rightMouseDown = true;
			rightMouseJustClicked = true;
		}
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		if (button == 0) {
			leftMouseDown = false;
		} else if (button == 1) {
			rightMouseDown = false;
		}
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}

	@Override
	public void connected(Controller controller) {
		
	}

	@Override
	public void disconnected(Controller controller) {
		
	}

	@Override
	public boolean buttonDown(Controller controller, int buttonCode) {
		
		if (buttonCode == 0) {
			firePressed = true;
		} else if (buttonCode == 1) {
			shieldPressed = true;
		} else if (buttonCode == 9) {
			startJustPressed = true;
		}
		
		return false;
	}

	@Override
	public boolean buttonUp(Controller controller, int buttonCode) {
		
		if (buttonCode == 0) {
			firePressed = false;
			actionDelay = 0;
		}
		
		return false;
	}

	@Override
	public boolean axisMoved(Controller controller, int axisCode, float value) {
		
		if (axisCode == 1) {
		
			// Up / down
			if (value <= -1f + deadzone) {
				upPressed = true;
			} else if (value >= 1f - deadzone) {
				downPressed = true;
			} else {
				upPressed = false;
				downPressed = false;
			}
			
		} else {
			
			// Left / right
			if (value <= -1f + deadzone) {
				leftPressed = true;
			} else if (value >= 1f - deadzone) {
				rightPressed = true;
			} else {
				leftPressed = false;
				rightPressed = false;
			}
		}
		
		return false;
	}

	@Override
	public boolean povMoved(Controller controller, int povCode, PovDirection value) {
		return false;
	}

	@Override
	public boolean xSliderMoved(Controller controller, int sliderCode, boolean value) {
		return false;
	}

	@Override
	public boolean ySliderMoved(Controller controller, int sliderCode, boolean value) {
		return false;
	}

	@Override
	public boolean accelerometerMoved(Controller controller, int accelerometerCode, Vector3 value) {
		return false;
	}

	public boolean isStartJustPressed() {
		return startJustPressed;
	}
}
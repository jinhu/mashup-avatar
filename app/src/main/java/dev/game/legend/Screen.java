package dev.game.legend;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.KeyEvent;
/**
 * Description: Command is a generic class where commands are inherit from. This
 * class contains the attribute and operation the all commands have in common.
 * Input:None Out implements GameCommandput:None
 */
public abstract class Screen {
	public static final int LEFT  = KeyEvent.KEYCODE_DPAD_LEFT;
	public static final int RIGHT = KeyEvent.KEYCODE_DPAD_RIGHT;
	public static final int UP    = KeyEvent.KEYCODE_DPAD_UP;
	public static final int DOWN  = KeyEvent.KEYCODE_DPAD_DOWN;
	public static final int FIRE  = KeyEvent.KEYCODE_ENTER;
	public static final int BACK  = KeyEvent.KEYCODE_BACK;

	protected Sprite selection;
	protected Bitmap image;
	protected Context mContext;
	/** The thread that actually draws the animation */

	protected Screen(Context c) {
		mContext = c;
	}
	public abstract boolean action(int gameAction, KeyEvent msg);
	public abstract void action(int x, int y);
	public abstract void paintScreen(Canvas canvas);
	public abstract int stateMachine();
	public int state = 0;
}
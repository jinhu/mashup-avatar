package dev.game.legend;


import android.content.Context;
import android.graphics.Canvas;
import android.media.MediaPlayer;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
/**
 * Description: Command is a generic class where commands are inherit from. This
 * class contains the attribute and operation the all commands have in common.
 * Input:None Out implements GameCommandput:None
 */
public abstract class GameView extends SurfaceView implements SurfaceHolder.Callback {
	public static final int STATE_SAVE = 8;
	public static final int STATE_LOAD = 7;
	public static final int STATE_PAUSE = 6;
	public static final int STATE_END = 5;
	public static final int STATE_GAME_OVER = 4;
	public static final int STATE_MAP = 3;
	public static final int STATE_PLAY = 2;
	public static final int STATE_TITLE = 1;
	public static final int STATE_GAME_EXIT = -1;

	protected Context mContext;
	private GameThread thread;
	protected MediaPlayer currentSong;
	protected GameView(Context c) {
		super(c);
		SurfaceHolder holder = getHolder();
		holder.addCallback(this);

		// create thread only; it's started in surfaceCreated()
		thread = new GameThread(holder, mContext);
		mContext = c;
		holder.addCallback(this);
		setFocusable(true); // make sure we get key events
	}

	@Override
	public void onDraw(Canvas canvas) {
		paintScreen(canvas);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		int action = event.getAction();

		if (action == MotionEvent.ACTION_DOWN) {
			return true;

		} else if (action == MotionEvent.ACTION_UP) {
			action((int) event.getX(), (int) event.getY());
			return true;
		}

		return false;
	}

	public void keyTyped(KeyEvent arg0) {
	}

	public void keyPressed(KeyEvent ke) {
	}

	public void keyReleased(KeyEvent ke) {
	}

	public abstract boolean action(int gameAction, KeyEvent msg);

	public abstract void action(int x, int y);

	public abstract void paintScreen(Canvas canvas);

	public abstract void stateMachine();

	public int counter = 0;
	public int state = 0;
	public int newState = 0;

	class GameThread extends Thread {
		private SurfaceHolder mSurfaceHolder;
		private boolean paused;

		public GameThread(SurfaceHolder surfaceHolder, Context context) {
			mSurfaceHolder = surfaceHolder;
			mContext = context;
		}

		/**
		 * Starts the game, setting parameters for the current difficulty.
		 */
		public void doStart() {
			synchronized (mSurfaceHolder) {
				// while (true) {
				//
				// }

			}
		}

		/**
		 * Pauses the physics update & animation.
		 */
		public void pause() {
			synchronized (mSurfaceHolder) {

			}
		}

		@Override
		public void run() {
			while (state >= 0) {
				if(!paused){
					stateMachine();
				Canvas c = null;
				SurfaceHolder holder = getHolder();
				counter++;
				try {
					c = holder.lockCanvas(null);
					synchronized (holder) {
						// if(changed)
						doDraw(c);
					}
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					if (c != null) {
						holder.unlockCanvasAndPost(c);
					}
				}
				}
			}
			currentSong.stop();
		}


		/**
		 * Used to signal the thread whether it should be running or not.
		 * Passing true allows the thread to run; passing false will shut it
		 * down if it's already running. Calling start() after this was most
		 * recently called with false will result in an immediate shutdown.
		 * 
		 * @param b
		 *            true to run, false to shut down
		 */
		public void setRunning(boolean b) {
			state = b ? 1 : -1;
		}

		/**
		 * Resumes from a pause.
		 */
		public void unpause() {
			// Move the real time clock up to now
			synchronized (mSurfaceHolder) {
			}

		}

		private void doDraw(Canvas canvas) {
			paintScreen(canvas);
		}

	}

	/**
	 * Standard override to get key-press events.
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent msg) {
		return false;
	}

	/**
	 * Standard override for key-up. We actually care about these, so we can
	 * turn off the engine or stop rotating.
	 */
	@Override
	public boolean onKeyUp(int keyCode, KeyEvent msg) {
		return action(keyCode, msg);
	}

	/**
	 * Standard window-focus override. Notice focus lost so we can pause on
	 * focus lost. e.g. user switches to take a call.
	 */
	@Override
	public void onWindowFocusChanged(boolean hasWindowFocus) {
		if (!hasWindowFocus)
			thread.pause();
	}
	/* Callback invoked when the surface dimensions change. */
	//@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
	
	}

	/*
	 * Callback invoked when the Surface has been created and is ready to be
	 * used.
	 */
	//@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// start the thread here so that we don't busy-wait in run()
		// waiting for the surface to be created
		thread.setRunning(true);
		thread.start();
	}

	/*
	 * Callback invoked when the Surface has been destroyed and must no longer
	 * be touched. WARNING: after this method returns, the Surface/Canvas must
	 * never be touched again!
	 */
	//@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// we have to tell thread to shut down & wait for it to finish, or else
		// it might touch the Surface after we return and explode
		boolean retry = true;
		state=STATE_GAME_EXIT;
		while (retry) {
			try {
				thread.join();
				retry = false;
			} catch (InterruptedException e) {
			}
		}
	}
	public void setState(int s) {
		state =s;
	}


}
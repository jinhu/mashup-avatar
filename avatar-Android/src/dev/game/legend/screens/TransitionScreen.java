/*
 * Created on 9-jan-2004
 * 
 * To change the template for this generated file go to Window - Preferences -
 * Java - Code Generation - Code and Comments
 */
package dev.game.legend.screens;



import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.KeyEvent;
import dev.game.legend.Player;
import dev.game.legend.Screen;
import dev.game.legend.Sprite;
import dev.game.legend.State;

import dev.game.legend.R;
import dev.game.legend.data.Stage;

public class TransitionScreen extends Screen{
	public Player player;
	public 	Bitmap lastStage;
	public 	Bitmap nextStage;
	Paint paint = new Paint();
	long endTime;
	int x=0;
	public TransitionScreen(Context c) {
		super(c);
		paint.setColor(0xFFFFFFFF);
		Resources res = mContext.getResources();      
		selection = new Sprite(BitmapFactory.decodeResource(res,R.drawable.selection));
		image=BitmapFactory.decodeResource(res, R.drawable.screen_transition);
		
	}
	public void init(){
		selection.setPosition(220,380);
		state=State.S_TRANSITION;
		endTime=System.currentTimeMillis()+5000;
	}
	public void setTransition(Stage stage){
		lastStage = stage.image;
		nextStage = stage.getNextStageImage();
		
	}
	@Override
	public boolean action(int action, KeyEvent msg) {
				state=State.S_PLAY;
		return true;
	}

	@Override
	public void action(int x, int y) {
				state=State.S_PLAY;
	}

	@Override
	public void paintScreen(Canvas canvas) {
		canvas.drawBitmap(lastStage, x,0, paint);
		canvas.drawBitmap(nextStage, x+320,0, paint);
		canvas.drawBitmap(image, x+160,0, paint);
		if(player!=null)
			player.paint(canvas);
	}

	@Override
	public int stateMachine() {
		x-=10;
		if(endTime<System.currentTimeMillis()){
			state=State.S_PLAY;
		}

		return state;
	}
}

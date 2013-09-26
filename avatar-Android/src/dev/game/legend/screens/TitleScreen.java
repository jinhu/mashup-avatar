/*
 * Created on 9-jan-2004
 * 
 * To change the template for this generated file go to Window - Preferences -
 * Java - Code Generation - Code and Comments
 */
package dev.game.legend.screens;

import dev.game.legend.Screen;
import dev.game.legend.Sprite;
import dev.game.legend.State;
import dev.game.legend.data.CharInfo;

import dev.game.legend.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.KeyEvent;

public class TitleScreen extends Screen {
	
    private static final int BOTTOM_Y = 300;
	private static final int BOTTOM_X = 100;
	private static final int RIGHT_X = 185;
	private static final int LEFT_X = 10;
	private static final int TOP_Y = 70;
	public TitleScreen(Context c) {
        super(c);
		Resources res = mContext.getResources();      
		selection = new Sprite(BitmapFactory.decodeResource(res,R.drawable.selection));
        image=BitmapFactory.decodeResource(res, R.drawable.screen_title);
    }	
    boolean next=false;
	private int characterId;
	private Paint paint=new Paint();
	public void init() {
		state=State.S_TITLE;
		selection.setPosition(100,170);
		characterId=CharInfo.CHAR_YINOCH;
	}
	
	@Override
	public void action(int x, int y) {
		if (y <160 ) {
			if (x <160){
				this.selection.setPosition(LEFT_X,TOP_Y);
				characterId= CharInfo.CHAR_EDEN;
			}else{
				this.selection.setPosition(RIGHT_X,TOP_Y);
				characterId =CharInfo.CHAR_ISZU;
			}
		}else{
	    	this.selection.setPosition(BOTTOM_X,BOTTOM_Y);
			characterId =CharInfo.CHAR_YINOCH;
		}
		state=State.S_PLAY; 
	}
	@Override
	public boolean action(int key, KeyEvent msg) {
	    switch (key) { 
	    case LEFT:
			this.selection.setPosition(LEFT_X,TOP_Y);
			characterId=CharInfo.CHAR_EDEN;
			break;
	    case RIGHT:
	    	this.selection.setPosition(RIGHT_X,TOP_Y);
	    	characterId=CharInfo.CHAR_ISZU;
	    	break;
		
	    case DOWN:
	    	this.selection.setPosition(BOTTOM_X,BOTTOM_Y);
	    	characterId=CharInfo.CHAR_YINOCH;
	    	break;
	    case FIRE:
			state=State.S_PLAY;
	    	break;
	    default:
	    	return false;
	    }
	    return true;
	    }
	@Override
	public void paintScreen(Canvas canvas) {
		canvas.drawBitmap(image, 0, 0, paint);
		//selection.draw(canvas);
		
	}
	@Override
	public int stateMachine() {
		return state;
	}

	public int getRace() {
		return characterId;
	}



	}

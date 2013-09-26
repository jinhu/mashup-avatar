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
import android.graphics.Paint.Align;
import android.view.KeyEvent;
import dev.game.legend.Player;
import dev.game.legend.Screen;
import dev.game.legend.Sprite;
import dev.game.legend.R;
import dev.game.legend.State;



public class GameOverScreen extends Screen{

	long endTime=System.currentTimeMillis()+20000;
	Paint p =new Paint();
	Sprite count;
	public Player player;
	public GameOverScreen(Context c) {
		super(c);
		Resources res = mContext.getResources();      
        image=BitmapFactory.decodeResource(res, R.drawable.screen_gameover);
        selection = new Sprite(BitmapFactory.decodeResource(res,R.drawable.selection));
        selection.setPosition(220, 380);
		p.setTextSize(60);
		p.setColor(0xFF0000FF);
		p.setShadowLayer(20, 0, 0, 0x88FFFFFF);
		p.setTextAlign(Align.CENTER);
		Bitmap[] f = new Bitmap[10];
		f[0] = BitmapFactory.decodeResource(res, R.drawable.countdown_10);
		f[1] = BitmapFactory.decodeResource(res, R.drawable.countdown_9);
		f[2] = BitmapFactory.decodeResource(res, R.drawable.countdown_8);
		f[3] = BitmapFactory.decodeResource(res, R.drawable.countdown_7);
		f[4] = BitmapFactory.decodeResource(res, R.drawable.countdown_6);
		f[5] = BitmapFactory.decodeResource(res, R.drawable.countdown_5);
		f[6] = BitmapFactory.decodeResource(res, R.drawable.countdown_4);
		f[7] = BitmapFactory.decodeResource(res, R.drawable.countdown_3);
		f[8] = BitmapFactory.decodeResource(res, R.drawable.countdown_2);
		f[9] = BitmapFactory.decodeResource(res, R.drawable.countdown_1);

		count = new Sprite(f, false);
		count.setPosition(0,360);

	}

	public void init(){
		endTime=System.currentTimeMillis();
		state=State.S_GAMEOVER;
	}

	@Override
	public boolean action(int gameAction, KeyEvent msg) {
	    switch (gameAction) { 
	    case LEFT:
	    	selection.setPosition(20,380);
	    	break;
	    case RIGHT:
	    	selection.setPosition(180,380);
	    	break;
	    case FIRE:
	    	if(selection.getX()==20){
				state=State.S_TITLE;
	    	}else{
				state=State.S_PLAY;
	    	}
	    	break;
	    default:
	    	return false;
	    }
		return true;
	}

	@Override
	public void action(int x, int y) {
		if (x < 160){
	    	selection.setPosition(20,380);
			state=State.S_TITLE;
	}
		else{
	    	selection.setPosition(180,380);
			state=State.S_PLAY;
		}
	}

	@Override
	public void paintScreen(Canvas g) {
		g.drawBitmap(image,0,0,p);
		selection.paint(g);
		if(player!=null){
			player.paint(g);
		}
		count.paint(g);
	}
	@Override
	public int stateMachine() {
		long t=System.currentTimeMillis();
		t=(t-endTime) /1000;
		if(t<10){
			count.setFrame((int)t);
		}else{
			state=State.S_TITLE;
		}
		return state;
	}

}
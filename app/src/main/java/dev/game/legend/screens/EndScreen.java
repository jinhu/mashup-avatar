package dev.game.legend.screens;


import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.KeyEvent;
import dev.game.legend.Player;
import dev.game.legend.Screen;
import dev.game.legend.Sprite;
import dev.game.legend.R;
import dev.game.legend.State;

public class EndScreen extends Screen {
	long endTime;		
	public Player player;
	Paint paint = new Paint();

	public EndScreen(Context c) {
		super(c);
		paint.setColor(0xFFFFFFFF);
		Resources res = mContext.getResources();      
		selection = new Sprite(BitmapFactory.decodeResource(res,R.drawable.selection));
		image=BitmapFactory.decodeResource(res, R.drawable.screen_end);
	}
	public void init(){
		selection.setPosition(220,380);
		endTime=System.currentTimeMillis()+10000;
		state=State.S_END;
		
	}
	@Override
	public boolean action(int action, KeyEvent msg) {
			state=State.S_TITLE;
			return true;
	}

	@Override
	public void action(int x, int y) {
		state=State.S_TITLE;
	}

	@Override
	public void paintScreen(Canvas canvas) {
		canvas.drawBitmap(image, 0,0, paint);
		if(player!=null)
			player.paint(canvas);
		selection.draw(canvas);
	}

	@Override
	public int stateMachine() {
		return state;
	}
}

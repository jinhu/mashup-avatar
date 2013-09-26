package dev.game.legend.avatar;

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

import dev.game.legend.R;
import dev.game.legend.data.CharInfo;
import dev.game.legend.State;

public class AvatarScreen extends Screen{
	Paint paint = new Paint();
	Avatar avatar;
	private int frame;
	private int part;
	private Sprite focus;
	private Sprite stage;
	private Sprite zodiacPet;
	private Sprite zodiacArtifact;
	public AvatarScreen(Context c) {
		super(c);
		avatar=new Avatar(c);
		paint.setColor(0xFFFFFFFF);
		Resources res = mContext.getResources();      
		selection = new Sprite(BitmapFactory.decodeResource(res,R.drawable.selection));
		Bitmap[] bitmaps=new Bitmap[9];
		bitmaps[0]= BitmapFactory.decodeResource(res,R.drawable.location_chinastage);
		bitmaps[1]= BitmapFactory.decodeResource(res,R.drawable.location_egyptstage);
		bitmaps[2]= BitmapFactory.decodeResource(res,R.drawable.location_greecestage);
		bitmaps[3]= BitmapFactory.decodeResource(res,R.drawable.location_lake);
		bitmaps[4]= BitmapFactory.decodeResource(res,R.drawable.location_moutain);
		bitmaps[5]= BitmapFactory.decodeResource(res,R.drawable.location_perustage);
		bitmaps[6]= BitmapFactory.decodeResource(res,R.drawable.location_polandstage);
		bitmaps[7]= BitmapFactory.decodeResource(res,R.drawable.location_tibetstage);
		bitmaps[8]= BitmapFactory.decodeResource(res,R.drawable.location_turkeystage);
		stage=new Sprite(bitmaps);
		
		bitmaps=new Bitmap[3];
		bitmaps[0]= BitmapFactory.decodeResource(res,R.drawable.pet_dog);
		bitmaps[1]= BitmapFactory.decodeResource(res,R.drawable.pet_hare);
		bitmaps[2]= BitmapFactory.decodeResource(res,R.drawable.pet_tiger);
		zodiacPet=new Sprite(bitmaps);
		
		bitmaps=new Bitmap[3];
		bitmaps[0]= BitmapFactory.decodeResource(res,R.drawable.artifact_gemini);
		bitmaps[1]= BitmapFactory.decodeResource(res,R.drawable.artifact_libra);
		bitmaps[2]= BitmapFactory.decodeResource(res,R.drawable.artifact_taurus);
		zodiacArtifact=new Sprite(bitmaps);
		
		avatar.info.state = CharInfo.STATE_DRAWING;
		avatar.move(100, 0);
		zodiacArtifact.move(0,320);
		zodiacPet.move(160,320);
		}
	public void init(){
		selection.setPosition(220,380);
		state=State.S_PLAY;
		focus = avatar.head;
	}
	@Override
	public boolean action(int action, KeyEvent msg) {
		switch(action){
		case LEFT:
			frame-=1;
			changeFrame();
			break;
		case RIGHT:
			frame+=1;
			changeFrame();
			break;
		case UP:
			part-=1;
			changePartFocus();
			break;
		case DOWN:
			part+=1;
			changePartFocus();
			break;
		}
		return false;	
	}
	@Override
	public void action(int x, int y) {
				selection.setPosition(20,380);
				state=State.S_TITLE;
	}

	@Override
	public void paintScreen(Canvas canvas) {
		stage.draw(canvas);
		selection.draw(canvas);
		avatar.drawImage(canvas);
		zodiacPet.draw(canvas);
		zodiacArtifact.draw(canvas);
	}

	@Override
	public int stateMachine() {
		return state;
	}
	private void changePartFocus() {
		switch(part%8){
		case 0:
			focus=avatar.head;
			break;
		case 1:
			focus=avatar.face;
			break;
		case 2:
			focus=avatar.body;
			break;
		case 3:
			focus=avatar.element;
			break;
		case 4:
			focus=avatar.wapon;
			break;
		case 5:
			focus=stage;
			break;
		case 6:
			focus=zodiacPet;
			break;
		case 7:
			focus=zodiacArtifact;
			break;
		default:
			focus=avatar.body;
			break;
		}
	}
	private void changeFrame() {
		focus.setFrame(frame);
	}
}

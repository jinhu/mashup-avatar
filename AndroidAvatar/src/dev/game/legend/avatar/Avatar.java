package dev.game.legend.avatar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import dev.game.legend.Player;
import dev.game.legend.R;
import dev.game.legend.Sprite;
import dev.game.legend.data.CharInfo;

public class Avatar extends Player{

	public Avatar(Context c, CharInfo info) {
		super(c, info);
	}

	public Avatar(Context c) {
		super(c, new CharInfo(0));
	}
	@Override
	public void init(CharInfo c) {
		info=c;
		Resources res = context.getResources();
		Bitmap[] bitmaps = new Bitmap[12];
		bitmaps[0] = BitmapFactory.decodeResource(res, R.drawable.basic_head);
		bitmaps[1] = BitmapFactory.decodeResource(res, R.drawable.bat_head);
		bitmaps[2] = BitmapFactory.decodeResource(res, R.drawable.bird_head);
		bitmaps[3] = BitmapFactory.decodeResource(res, R.drawable.fish_head);
		bitmaps[4] = BitmapFactory.decodeResource(res, R.drawable.orc_head);
		bitmaps[5] = BitmapFactory.decodeResource(res, R.drawable.elf_head);
		bitmaps[6] = BitmapFactory.decodeResource(res, R.drawable.horse_head);
		bitmaps[7] = BitmapFactory.decodeResource(res, R.drawable.human_head);
		bitmaps[8] = BitmapFactory.decodeResource(res, R.drawable.lizard_head);
		bitmaps[9] = BitmapFactory.decodeResource(res, R.drawable.yinoch_head);
		bitmaps[10] = BitmapFactory.decodeResource(res, R.drawable.eden_head);
		bitmaps[11] = BitmapFactory.decodeResource(res, R.drawable.iszu_head);
		head = new Sprite(bitmaps, p2);
		
	
		bitmaps = new Bitmap[3];
		bitmaps[0] = BitmapFactory.decodeResource(res,  R.drawable.eden_face2);
		bitmaps[1] = BitmapFactory.decodeResource(res, R.drawable.face2);
		bitmaps[2] = BitmapFactory.decodeResource(res, R.drawable.iszu_face2);
		face = new Sprite(bitmaps, p2);
		
		bitmaps = new Bitmap[9];
		bitmaps[0] = BitmapFactory.decodeResource(res, R.drawable.body);
		bitmaps[1] = BitmapFactory.decodeResource(res, R.drawable.job_archer);
		bitmaps[2] = BitmapFactory.decodeResource(res, R.drawable.job_mage);
		bitmaps[3] = BitmapFactory.decodeResource(res, R.drawable.job_monk);
		bitmaps[4] = BitmapFactory.decodeResource(res, R.drawable.job_ninja);
		bitmaps[5] = BitmapFactory.decodeResource(res, R.drawable.job_wizard);
		bitmaps[6] = BitmapFactory.decodeResource(res, R.drawable.job_swordman);
		bitmaps[7] = BitmapFactory.decodeResource(res, R.drawable.job_soldier);
		bitmaps[8] = BitmapFactory.decodeResource(res, R.drawable.iszu_body);
		body = new Sprite(bitmaps, p2);

		bitmaps = new Bitmap[8];
		bitmaps[0] = BitmapFactory.decodeResource(res, R.drawable.element_air);
		bitmaps[1] = BitmapFactory.decodeResource(res, R.drawable.element_tree);
		bitmaps[2] = BitmapFactory.decodeResource(res, R.drawable.element_fire);
		bitmaps[3] = BitmapFactory.decodeResource(res, R.drawable.element_rock);
		bitmaps[4] = BitmapFactory.decodeResource(res, R.drawable.element_earth);
		bitmaps[5] = BitmapFactory.decodeResource(res, R.drawable.element_ice);
		bitmaps[6] = BitmapFactory.decodeResource(res, R.drawable.element_water);
		bitmaps[7] = BitmapFactory.decodeResource(res, R.drawable.element_thunder);
		element = new Sprite(bitmaps, p2);

		bitmaps = new Bitmap[8];
		bitmaps[0] = BitmapFactory.decodeResource(res, R.drawable.wapon_bow);
		bitmaps[1] = BitmapFactory.decodeResource(res, R.drawable.wapon_staff);
		bitmaps[2] = BitmapFactory.decodeResource(res, R.drawable.wapon_sword);
		bitmaps[3] = BitmapFactory.decodeResource(res, R.drawable.wapon_spear);
		bitmaps[4] = BitmapFactory.decodeResource(res, R.drawable.wapon_schimitar);
		bitmaps[5] = BitmapFactory.decodeResource(res, R.drawable.wapon_kane);
		bitmaps[6] = BitmapFactory.decodeResource(res, R.drawable.wapon_chain);
		bitmaps[7] = BitmapFactory.decodeResource(res, R.drawable.wapon_shield);
		wapon = new Sprite(bitmaps, p2);

		// cache handles to our key sprites & other drawables
		bitmaps = new Bitmap[1];
		bitmaps[0] = BitmapFactory.decodeResource(res,  R.drawable.basic_hand1);
		lFist = new Sprite(bitmaps, p2);
		
		bitmaps = new Bitmap[1];
		bitmaps[0] = BitmapFactory.decodeResource(res, R.drawable.basic_hand6);
		rFist = new Sprite(bitmaps, p2);
		
		bitmaps= new Bitmap[1];
		bitmaps[0] = BitmapFactory.decodeResource(res,  R.drawable.basic_arm1);
		lArm = new Sprite(bitmaps, p2);
		
		bitmaps = new Bitmap[1];
		bitmaps[0] = BitmapFactory.decodeResource(res,  R.drawable.basic_arm5);
		rArm = new Sprite(bitmaps, p2);
		
		legs = new Sprite(BitmapFactory.decodeResource(res,	  R.drawable.basic_legs) , p2);
		feets = new Sprite(BitmapFactory.decodeResource(res,  R.drawable.basic_feets), p2);
		icon = new Sprite(BitmapFactory.decodeResource(res,	  R.drawable.basic_icon) , p2);
		skill = new Sprite(BitmapFactory.decodeResource(res,  R.drawable.job)  , p2);
	}
	
	@Override
	public void initPosition(){
		super.initPosition();
		rFist.setPosition(80, 240);
		rArm.setFrame(1);
		lArm.setFrame(1);
		lFist.setFrame(0);
		rFist.setFrame(2);
	}
	
	@Override
	public 	void drawImage(Canvas c){
		super.drawImage(c);
		//lFist.draw(c);
		rFist.draw(c);
		element.draw(c);
		wapon.draw(c);
		
	}
	@Override
	public void move(int x,int y){
		super.move(x, y);
		element.move(x, y);
		wapon.move(x,y);
		rFist.move(x,y);
		
	}
}

package dev.game.legend;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.*;
import dev.game.legend.data.CharInfo;

public class Player {
	public Sprite head;
	public Sprite face;
	public Sprite body;
	public Sprite lArm;
	public Sprite rArm;
	public Sprite lFist;
	public Sprite rFist;
	public Sprite legs;
	public Sprite feets;
	public Sprite icon;
	public Sprite element;
	public Sprite wapon;
	public Sprite job;
	public Sprite activeArm;
	public Sprite passiveArm;
	public Sprite activeFist;
	protected Sprite skill;
	private int currentPos = 0;
	public CharInfo info;
	protected Context context;
	protected int x = 0;

	protected int y = 0;
	protected boolean p2;

	public Player(Context c, CharInfo info) {
		context = c;
		p2 = isEnemy();
		init(info);
		initPosition();
		
	}

	public void init(CharInfo c) {
		this.info = c;
		this.info.state = CharInfo.STATE_IDLE;
		this.info.command =CharInfo.COMMAND_UNKNOWN;
		Resources res = context.getResources();
		head = new Sprite(BitmapFactory.decodeResource(res,	c.head), p2);
		Bitmap[] fa = new Bitmap[5];
		fa[0] = BitmapFactory.decodeResource(res, c.face0);
		fa[1] = BitmapFactory.decodeResource(res, c.face1);
		fa[2] = BitmapFactory.decodeResource(res, c.face2);
		fa[3] = BitmapFactory.decodeResource(res, c.face3);
		fa[4] = BitmapFactory.decodeResource(res, c.face4);
		face = new Sprite(fa, p2);
		body = new Sprite(BitmapFactory.decodeResource(res,
				c.body), p2);

		// cache handles to our key sprites & other drawables
		Bitmap[] f = new Bitmap[3];
		f[0] = BitmapFactory.decodeResource(res, c.hand1);
		f[1] = BitmapFactory.decodeResource(res, c.hand2);
		f[2] = BitmapFactory.decodeResource(res, c.hand3);
		lFist = new Sprite(f, p2);
		f = new Bitmap[3];
		f[0] = BitmapFactory.decodeResource(res, c.hand4);
		f[1] = BitmapFactory.decodeResource(res, c.hand5);
		f[2] = BitmapFactory.decodeResource(res, c.hand6);
		rFist = new Sprite(f, p2);
		Bitmap[] arm = new Bitmap[3];
		arm[0] = BitmapFactory.decodeResource(res, c.arm1);
		arm[1] = BitmapFactory.decodeResource(res, c.arm2);
		arm[2] = BitmapFactory.decodeResource(res, c.arm3);
		Bitmap[] arm2 = new Bitmap[3];
		arm2[0] = BitmapFactory.decodeResource(res, c.arm4);
		arm2[1] = BitmapFactory.decodeResource(res, c.arm5);
		arm2[2] = BitmapFactory.decodeResource(res, c.arm6);
		lArm = new Sprite(arm, p2);
		rArm = new Sprite(arm2, p2);
		legs = new Sprite(BitmapFactory.decodeResource(res,
				c.legs), p2);
		feets = new Sprite(BitmapFactory.decodeResource(res,
				c.feets), p2);
		icon = new Sprite(BitmapFactory.decodeResource(res,
				c.icon), p2);
		element = new Sprite(BitmapFactory.decodeResource(res,
				c.element), p2);
		skill = new Sprite(BitmapFactory.decodeResource(res,
				c.job), p2);
		wapon = new Sprite(BitmapFactory.decodeResource(res,
				c.wapon), p2);
	}
	protected boolean isEnemy() {
		return false;
	}

	protected void changeMood() {
		switch (this.info.state) {
		case CharInfo.STATE_SHOWING:
			face.setFrame(2);
			lArm.setFrame(1);
			rArm.setFrame(1);
			break;
		case CharInfo.STATE_WINNING:
			face.setFrame(3);
			lArm.setFrame(2);
			rArm.setFrame(2);
			break;
		case CharInfo.STATE_LOSSING:
			face.setFrame(1);
			lArm.setFrame(0);
			rArm.setFrame(0);
			break;
		case CharInfo.STATE_DYING:
			face.setFrame(0);
			lArm.setFrame(2);
			rArm.setFrame(2);
			break;
		case CharInfo.STATE_LEVELING:
			face.setFrame(4);
			lArm.setFrame(2);
			rArm.setFrame(2);
			break;
		case CharInfo.STATE_DRAWING:
			face.setFrame(2);
			lArm.setFrame(1);
			rArm.setFrame(1);
			break;
		case CharInfo.STATE_NONE:
			face.setFrame(2);
			lArm.setFrame(0);
			rArm.setFrame(0);
			break;
		case CharInfo.STATE_IDLE:
		default:
			passiveArm.setFrame(1);
			if(activeArm.getFrame()==1)
				activeArm.setFrame(2);
			else
				activeArm.setFrame(1);
			face.setFrame(2);
			break;
		}
	}

	void changePos() {

		this.currentPos = (this.currentPos + 1 % 8);
		switch (currentPos % 8) {
		case 0:
			x = 0;
			y = 1;
			break;
		case 1:
			x = 1;
			y = 0;
			break;
		case 2:
			x = 1;
			y = 0;
			break;
		case 3:
			x = 1;
			y = -1;
			break;
		case 4:
			x = 0;
			y = 1;
			break;
		case 5:
			x = -1;
			y = 0;
			break;
		case 6:
			x = -1;
			y = 0;
			break;

		case 7:
			x = -1;
			y = -1;
			break;
		}
		head.move(x, y);
		legs.move(x, y);
		body.move(x, -y);
		skill.move(x, -y);
		face.move(x, y);
		lArm.move(x, -y);
		rArm.move(x, -y);
		lFist.move(x, -y);
		rFist.move(x, -y);
	}

	public void drawImage(Canvas g) {
		head.paint(g);
		face.paint(g);
		legs.paint(g);
		feets.paint(g);
		
		rArm.paint(g);
		body.paint(g);
		lArm.paint(g);
		skill.paint(g);
		if (this.info.state == CharInfo.STATE_SHOWING && info.command >= 0) {
			activeFist.paint(g);
			// wapon.paint(g);
			// element.paint(g);
			// icon.paint(g);
		}
	}


	public void initPosition() {
		x=0;
		y=80;
		int y2=240;
		head.setPosition( x   ,y);
		face.setPosition( x+50	  ,y+50);
		body.setPosition( x	  ,y2);
		legs.setPosition( x	  ,y2);
		feets.setPosition(x	  ,y2+120);
		lArm.setPosition( x	  ,y2);
		rArm.setPosition( x+80	  ,y2);
		lFist.setPosition( x	  ,y2);
		rFist.setPosition( x+80	  ,y2);
		icon.setPosition( 2	,2);
		element.setPosition(x+80,y2);
		wapon.setPosition(x,y2);
		skill.setPosition(x,y2);
		activeArm  = lArm;
		activeFist  = lFist;
		passiveArm = rArm;
	}

	public void paint(Canvas g) {
		changePos();
		changeMood();
		drawImage(g);
	}

	public void setCommand(int currentCommand) {
		activeFist.setFrame(currentCommand % 3);
		info.command = currentCommand;
	}

	public void move(int x, int y) {
		head.move(x, y);
		legs.move(x, y);
		body.move(x, y);
		face.move(x, y);
		lArm.move(x, y);
		rArm.move(x, y);
		lFist.move(x, y);
		rFist.move(x, y);
		feets.move(x, y);
	}

}

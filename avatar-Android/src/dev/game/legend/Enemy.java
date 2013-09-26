package dev.game.legend;

import android.content.Context;
import dev.game.legend.data.CharInfo;
import dev.game.legend.data.Position;

public class Enemy extends AiPlayer {

	@Override
	public void initPosition() {
		x = 160;
		y = 80;
		int y2=240;
		head.setPosition(x    , y);
		face.setPosition(x+10 , y+50);  
		body.setPosition(x, y2);
		body.setPosition(320-body.getWidth(), y2);
		legs.setPosition(x , y2);
		feets.setPosition(x   , y2+120);
		lArm.setPosition(x+80    , y2);
		rArm.setPosition(x    , y2);
		lFist.setPosition(320-lFist.getWidth()	  ,	y2);
		rFist.setPosition(x+80-rFist.getWidth()	  ,	y2);
		icon.setPosition(288,2);
		element.setPosition(x - element.getWidth() - Position.ELEMENTX,
				Position.ELEMENTY);
		skill.setPosition(x-263, y);


		wapon.setVisible(false);
		skill.setVisible(false);
		x=0;
		y=0;
		activeArm = rArm;
		passiveArm=lArm;
		activeFist=rFist;
	}

	public Enemy(Context c, CharInfo i) {
		super(c, i);
	}

	@Override
	protected boolean isEnemy() {
		return true;
	}

	public void generateCommand() {
		int currentCommand;
		//prime serie 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97.[1]
		switch (this.info.aiType) {
		case 0:
			currentCommand = getValueOf(13);
			break;
		case 1:
			currentCommand = getValueOf(17);
			break;
		case 2:
			currentCommand = getValueOf(19);
			break;
		case 3:
			currentCommand = getValueOf(23);
			break;
		case 4:
			currentCommand = getValueOf(29);
			break;
		case 5:
			currentCommand = getValueOf(31);
			break;
		case 6:
			currentCommand = getValueOf(37);
			break;
		case 7:
			currentCommand = getValueOf(41);
			break;
		default:
			currentCommand = getValueOf(43);
			break;
		}
		//TODO:  nine is ok
		setCommand(currentCommand%3);
		//setCommand(0);

	}
}

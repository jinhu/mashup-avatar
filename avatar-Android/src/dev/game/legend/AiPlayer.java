package dev.game.legend;

import java.util.Random;

import android.content.Context;

import dev.game.legend.data.CharInfo;


public class AiPlayer extends Player {
	private long endTime;
	public AiPlayer(Context c, CharInfo i){
		super(c,i);
	}
	int seed7 = 1;
	int seed13 = 1;
	int seed17 = 1;
	int seed=100;
	int seedPi=103993;
	public int getValueOf(int prime) {
		int res = (seed/prime) %10;
		seed=(seed%prime)*10;
		return res;
	}

	public int getValueOfPi() {
		int res = (seedPi/33102) %10;
		seedPi=(seedPi%33102)*10;
		return res;
	}

	public int getValueOf13() {
		int res = (seed13/13) %10;
		seed13=(seed13%13)*10;
		return res;
	}

	public int getValueOf17() {
		int res = (seed17/17) %10;
		seed17=(seed17%17)*10;
		return res;
	}

	Random generator = new Random(666);
	private boolean second;

	public int getValueRandom() {
		return generator.nextInt(3);

	}

	public int getValueBasedLast() {
		if (info.state == CharInfo.STATE_WINNING) {
			return info.command*2;
		} else if (info.state == CharInfo.STATE_LOSSING) {
			info.command=3*( (info.command+1)%3);
			
		} else {
			
			info.command=(info.command + 2)%3;
		}
		return info.command;
	}


public int getValueBasedLast2() {
		if(second){
			second=false;
			return info.command*3;
		}
		second=true;
		if (info.state == CharInfo.STATE_WINNING) {
			return info.command;
		} else if (info.state == CharInfo.STATE_LOSSING) {
			info.command=(info.command+1)%3;
		} else {
			
			info.command=(info.command + 2)%3;
		}
		return info.command*2;
	}
int winCounter;
int loseCounter;
int drawCounter;
int rockCounter;
int scissorCounter;
int paperCounter;
	public int getValueChange() {
		if (info.state == CharInfo.STATE_WINNING) {
			return info.command;
		} else if (info.state == CharInfo.STATE_LOSSING) {
			info.command=(info.command+1)%3;
		} else {
			
			info.command=(info.command + 2)%3;
		}
		if(loseCounter>5){
			info.command+=1;
		}
		return info.command;
	}

	public int getValueStat() {
		int ec=info.command+3;
		if (info.state == CharInfo.STATE_WINNING) {
			ec=ec-1;
		} else if (info.state == CharInfo.STATE_LOSSING) {
			ec=ec+1;
		}
		
		switch(ec%3){
		case 0:
			rockCounter++;
			break;
		case 1:
			scissorCounter++;
			break;
		case 2:
			paperCounter++;
			break;
		}
		if(rockCounter>scissorCounter &&rockCounter > scissorCounter ){
			return 2;
		}
		else if(scissorCounter>paperCounter){
			return 0;
		}
		return 1;
	}
	public int getValueTime() {
		int x = (int) ((endTime - System.currentTimeMillis()) / 1000);
		info.command=((x%10) +10)%10;
		return info.command;
	}
}
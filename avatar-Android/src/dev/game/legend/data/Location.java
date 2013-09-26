package dev.game.legend.data;

import dev.game.legend.R;


public class Location {
	private static final int EGYPT = 0;

	private static final int POLAND = 1;

	private static final int TURKEY = 2;

	private static final int CHINA = 3;

	private static final int PERU = 4;

	private static final int GREECE = 5;

	private static final int TIBET = 6;

	private static final int NORWAY = 7;

	
	private static final int SKY = 11;

	private static final int EARTH = 19;

	private static final int WATER = 17;

	private static final int FIRE = 13;

	private static final int WIND = 16;

	private static final int THUNDER = 14;

	private static final int LAKE = 12;

	private static final int MOUTAIN = 18;

	private static final int LOC_X = 160;
	private static final int LOC_Y = 160;
	public int stage;
	public int icon;
	public String res;
	public int element;
	public int x;
	public int y;
	
	public Location(int type) {
		icon =  R.drawable.location_chinaicon;
		stage = R.drawable.location_chinastage;
		switch (type) {
		case EGYPT:
			res = "Egypt";
			stage = R.drawable.location_egyptstage;
			x = 300;
			y = 230;
			element=type;
			break;
		case POLAND:
			res = "Poland";
			stage = R.drawable.location_polandstage;
			x = 310;
			y = 120;
			element=type;
			break;
		case TURKEY:
			res = "Turkey";
			stage = R.drawable.location_turkeystage;
			x = 340;
			y = 170;
			element=type;
			break;
		case CHINA:
			res = "China";
			stage = R.drawable.location_chinastage;
			x = 480;
			y = 200;
			element=type;
			break;
		case PERU:
			res = "Peru";
			stage = R.drawable.location_perustage;
			x = 100;
			y = 350;
			element=type;
			break;
		case GREECE:
			res = "Greece";
			stage = R.drawable.location_greecestage;
			x = 290;
			y = 180;
			element=type;
			break;
		case TIBET:
			stage = R.drawable.location_tibetstage;
			res = "Tibet";
			x = 400;
			y = 200;
			element=type;
			break;
		case NORWAY:
			res = "Norway";
			x = 500;
			y = 200;
			element=type;
			break;
		case SKY:
			res = "Heaven";
			x = 2*LOC_X;
			y = 0*LOC_Y;
			element=type;
			break;		
		case EARTH:
			res = "Earth";
			x = 2*LOC_X;
			y = 4*LOC_Y;
			element=type;
			break;
		case WATER:
			res = "Water";
			x = 0*LOC_X;
			y = 2*LOC_Y;
			element=type;
			break;
		case FIRE:
			res = "Fire";
			x = 4*LOC_X;
			y = 2*LOC_Y;
			element=type;
			break;
		case WIND:
			res = "Wind";
			x = 3*LOC_X;
			y = 3*LOC_Y;
			element=type;
			break;
		case THUNDER:
			res = "Thunder";
			x = 1*LOC_X;
			y = 1*LOC_Y;
			element=type;
			break;
		case LAKE:
			stage = R.drawable.location_lake;
			res = "Lake";
			x = 1*LOC_X;
			y = 3*LOC_Y;
			element=type;
			break;
		case MOUTAIN:
			res = "Moutain";
			x = 3*LOC_X;
			y = 1*LOC_Y;
			element=type;
			break;
		default:
		res = "Default";
		x = 0;
		y = 0;
		element=type;
			
		}
		element=type%8;
		x=200;
		y=200;
	}
}

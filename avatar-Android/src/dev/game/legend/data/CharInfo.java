/*
 * Created on 6-jan-2004
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package dev.game.legend.data;

import dev.game.legend.R;

/**
 * @author huj
 * 
 *         To change the template for this generated type comment go to Window -
 *         Preferences - Java - Code Generation - Code and Comments
 */
public class CharInfo {
	public final static int STATE_IDLE = 0;
	public final static int STATE_SHOWING = 1;
	public final static int STATE_WINNING = 2;
	public final static int STATE_LOSSING = 3;
	public final static int STATE_DRAWING = 4;
	public final static int STATE_DYING = 5;
	public final static int STATE_LEVELING = 6;
	public static final int STATE_NONE = 7;

	public static final int COMMAND_UNKNOWN = -1;
	public static final int COMMAND_ROCK = 0;
	public static final int COMMAND_SCISSOR = 1;
	public static final int COMMAND_PAPER = 2;

	public static final int CHAR_BASIC = 11;
	public static final int CHAR_BAT = 12;
	public static final int CHAR_BIRD = 13;
	public static final int CHAR_ELF = 4;
	public static final int CHAR_FISH = 5;
	public static final int CHAR_ORC = 6;
	public static final int CHAR_LIZARD = 7;
	public static final int CHAR_CENTAUR = 8;
	public static final int CHAR_HUMAN = 9;
	public static final int CHAR_GIRL = 10;
	public static final int CHAR_YINOCH = 3;
	public static final int CHAR_EDEN = 2;
	public static final int CHAR_ISZU = 1;
	
	public static final String[] jobs = { "Archer", "Fighter", "Thief", "Monk",
			"Swordsman", "Clerck", "Soldier", "Mage" };
	public int aiType = 0;
	public int experience = 0;
	public int health = 100;
	public String name = "Yinoch";
	public int race = 0;
	public int magic = 0;
	public int score = 0;
	public int complete=0;
	public int liveLost=0;
	public int state;

	public int game;
	public int command;

	public int head;
	public int job;
	public int face0;
	public int face1;
	public int face2;
	public int face3;
	public int face4;
	public int arm1;
	public int arm2;
	public int arm3;
	public int arm4;
	public int arm5;
	public int arm6;

	public int hand1;
	public int hand2;
	public int hand3;
	public int hand4;
	public int hand5;
	public int hand6;

	public int body;
	public int legs;
	public int feets;
	public int rock;
	public int scissor;
	public int paper;
	public int wapon;
	public int element;
	public int icon;

	public CharInfo(int r) {
		race=r%4;
		aiType=race;
		job = R.drawable.job;
		wapon = R.drawable.wapon;
		element = R.drawable.element;
/*
		face0 = R.drawable.basic_face0;  
	    face1 = R.drawable.basic_face1;  
	    face2 = R.drawable.basic_face2;  
	    face3 = R.drawable.basic_face3;  
	    face4 = R.drawable.basic_face4;  
	    arm1 =  R.drawable.basic_arm1;   
	    arm2 =  R.drawable.basic_arm2;   
	    arm3 =  R.drawable.basic_arm3;   
	    arm4 =  R.drawable.basic_arm4;   
	    arm5 =  R.drawable.basic_arm5;   
	    arm6 =  R.drawable.basic_arm6;   
	    hand1 =  R.drawable.basic_hand1;   
	    hand2 =  R.drawable.basic_hand2;   
	    hand3 =  R.drawable.basic_hand3;   
	    hand4 =  R.drawable.basic_hand4;   
	    hand5 =  R.drawable.basic_hand5;   
	    hand6 =  R.drawable.basic_hand6;   
	    body =  R.drawable.basic_body;   
	    legs =  R.drawable.basic_legs;   
	    feets = R.drawable.basic_feets;  
	    icon =  R.drawable.basic_icon;   
		if(race>10){
			rock 	= R.drawable.basic_hand1;
			scissor = R.drawable.basic_hand2;
			paper 	= R.drawable.basic_hand3;
		}else{
			rock 	= R.drawable.basic_hand4;
			scissor = R.drawable.basic_hand5;
			paper 	= R.drawable.basic_hand6;
			
		}

*/
		switch (race) {
/*		case CHAR_BASIC:
			head = R.drawable.basic_head;
		case CHAR_BAT:
			head = R.drawable.elf_head;
			break;
		case CHAR_BIRD:
			head = R.drawable.bird_head;
			break;
		case CHAR_FISH:
			head = R.drawable.fish_head;
			break;
		case CHAR_CENTAUR:
			head = R.drawable.horse_head;
			break;
		case CHAR_ELF:
			head = R.drawable.elf_head;
			break;
		case CHAR_LIZARD:
			head = R.drawable.lizard_head;
			break;
		case CHAR_HUMAN:
			head = R.drawable.human_head;
			break;
		case CHAR_ORC:
			head = R.drawable.orc_head;
			break;
*/		case CHAR_YINOCH:
			head = R.drawable.yinoch_head;
			face0 = R.drawable.yinoch_face0; 
			face1 = R.drawable.yinoch_face1; 
			face2 = R.drawable.yinoch_face2; 
			face3 = R.drawable.yinoch_face3; 
			face4 = R.drawable.yinoch_face4; 
			arm1 =  R.drawable.yinoch_arm1;  
			arm2 =  R.drawable.yinoch_arm2;  
			arm3 =  R.drawable.yinoch_arm3;  
			arm4 =  R.drawable.yinoch_arm4;  
			arm5 =  R.drawable.yinoch_arm5;  
			arm6 =  R.drawable.yinoch_arm6;  
			hand1 =  R.drawable.yinoch_hand1;  
			hand2 =  R.drawable.yinoch_hand2;  
			hand3 =  R.drawable.yinoch_hand3;  
			hand4 =  R.drawable.yinoch_hand4;  
			hand5 =  R.drawable.yinoch_hand5;  
			hand6 =  R.drawable.yinoch_hand6;  
			body =  R.drawable.yinoch_body;  
			legs =  R.drawable.yinoch_legs;  
			feets = R.drawable.yinoch_feets; 
			icon =  R.drawable.yinoch_icon;
			name =  "Yinoch";
			break;
		case CHAR_EDEN:
		default:
			head = R.drawable.eden_head;
			face0 = R.drawable.eden_face0;  
			face1 = R.drawable.eden_face1;  
			face2 = R.drawable.eden_face2;  
			face3 = R.drawable.eden_face3;  
			face4 = R.drawable.eden_face4;  
			arm1 =  R.drawable.eden_arm1;   
			arm2 =  R.drawable.eden_arm2;   
			arm3 =  R.drawable.eden_arm3;   
			arm4 =  R.drawable.eden_arm4;   
			arm5 =  R.drawable.eden_arm5;   
			arm6 =  R.drawable.eden_arm6;
			hand1 =  R.drawable.yinoch_hand1;  
			hand2 =  R.drawable.yinoch_hand2;  
			hand3 =  R.drawable.yinoch_hand3;  
			hand4 =  R.drawable.yinoch_hand4;  
			hand5 =  R.drawable.yinoch_hand5;  
			hand6 =  R.drawable.yinoch_hand6;  

			body =  R.drawable.eden_body;   
			legs =  R.drawable.eden_legs;   
			feets = R.drawable.eden_feets;  
			icon =  R.drawable.eden_icon;   
			name =  "Eden";

			break;
		case CHAR_ISZU:
			head = R.drawable.iszu_head;
			face0 = R.drawable.iszu_face0;
		    face1 = R.drawable.iszu_face1;
		    face2 = R.drawable.iszu_face2;
		    face3 = R.drawable.iszu_face3;
		    face4 = R.drawable.iszu_face4;
		    arm1 =  R.drawable.iszu_arm1; 
		    arm2 =  R.drawable.iszu_arm2; 
		    arm3 =  R.drawable.iszu_arm3; 
		    arm4 =  R.drawable.iszu_arm4; 
		    arm5 =  R.drawable.iszu_arm5; 
		    arm6 =  R.drawable.iszu_arm6; 
			hand1 =  R.drawable.yinoch_hand1;  
			hand2 =  R.drawable.yinoch_hand2;  
			hand3 =  R.drawable.yinoch_hand3;  
			hand4 =  R.drawable.yinoch_hand4;  
			hand5 =  R.drawable.yinoch_hand5;  
			hand6 =  R.drawable.yinoch_hand6;  

		    body =  R.drawable.iszu_body; 
		    legs =  R.drawable.iszu_legs; 
		    feets = R.drawable.iszu_feets;
		    icon =  R.drawable.iszu_icon; 
			name =  "Iszu";

		    break;
		//	head = R.drawable.basic_head;
		//	break;
		}
	}

}

package dev.game.legend.data;

public class Position {
	int h=480;
	int w=320;
	public static final int CHAR_LENGTH = 400;
	public static final int CHAR_WIDTH = 275;

	public static final int LEFTUP6X = 40;
	public static final int LEFTUP6Y = 130;
	public static final int LEFTDOWN6X = LEFTUP6X;
	public static final int LEFTDOWN6Y = 400;
	public static final int RIGHTUP6X = 475;
	public static final int RIGHTUP6Y = LEFTUP6Y;
	public static final int RIGHTDOWN6X = RIGHTUP6X;
	public static final int RIGHTDOWN6Y = LEFTDOWN6Y;
	public static final int UP6X = 250;
	public static final int UP6Y = 0;
	public static final int DOWN6X = UP6X;
	public static final int DOWN6Y = 500;
	public static final int UP2X = UP6X;
	public static final int UP2Y = 150;
	public static final int DOWN2X = UP6X;
	public static final int DOWN2Y = 450;
	public static final int ICON_SIZE = 30;
	public static final int DOWN_ROW = 550;
	static public final int SCREENX 		= 320;                                   
	static public final int SCREENY 		= 480;                                   
	
	static public final int OFFSETX 		= -30;                                     
	static public final int ENEMYX 		= 250;                                     
	static public final int OFFSETY 		= 50;                             
	
	static public final int BARX			=Position.SCREENX/10;                              
	static public final int BARY			=20;                                     
	static public final int BARLENGTH		=Position.SCREENX/3;                              
	static public final int BARH			=SCREENX/20;                                     
	static public final int MAGY			=600;                            
	static public final int CURVE			=2;                                      
	static public final int BODYX 			= 60;         
	static public final int FACEX 			= Position.CHAR_WIDTH*6/20;                
	static public final int ARMX 			= 125;          
	static public final int FISTX 			= Position.ARMX+Position.CHAR_WIDTH*2/20;           
	static public final int BODYY 			= Position.CHAR_LENGTH*10/20;              
	static public final int LEGSY 			= Position.BODYY+Position.CHAR_LENGTH*3/20;   
	static public final int FEETSY 			= Position.LEGSY+Position.CHAR_LENGTH*5/20;   
	static public final int FACEY 			= Position.CHAR_LENGTH*3/20;
	public static final int SPAN = 5;
	public static final int MOVEMENT = 5;
	public static final int NAMEX = 450;
	public static final int SCOREY = 20;
	public static final int NAMEY = SPAN+BARY+BARH+SCOREY;
	public static final int TIMEY = 20;
	public static final int TIMEX = (SCREENX/2)-25;
	
	
	public static final int COMMAND1X = 30;
	public static final int COMMAND2X = 150;
	public static final int COMMAND3X = 280;
	public static final int COMMANDY = 420;
	
	public static final int TEXTX = 200;
	public static final int TEXT1Y = 200;               
	public static final int TEXT2Y = 250;               
	public static final int TEXT3Y = 300;               
	public static final int TEXT4Y = 350;               
	public static final int TEXT5Y = 400;

	public static final int TIME1Y = 60;
	
	public static final int WIDTH = 30;
	public static final int HIGHT = 30;
	public static final int RANKY = 50;
	public static final int RANKNAMEX = 60;
	public static final int RANKTYPEX = 200;
	public static final int RANKSCOREX = 400;
	
	public static final int CENTERX = 70;               
	public static final int CENTERY = 80;
	public static final int ELEMENTX = 0;               
	public static final int ELEMENTY = 600;
	
	public static final int ICONX = SPAN;               
	public static final int ICONY = BARY;
	
	public static final String SCORE = "";
	public static final int LEFT_SIDE = 50;
	public static final int TEXT_HIGHT = 50;
	public static final int RIGHT_SIDE = 400;
	public static final int TEXT2X = 80;
	public static final int DIALOGX = 30;
	public static final int DIALOGHIGHT = Position.SCREENY-60;
	public static final int DIALOGY = 30;
	public static final int DIALOGWEIDTH = Position.SCREENX-60;
	public static final int WAPONY = 0;
	public static final int SKILLY = 0;
	public static final int WAPONX = 0;
	public static final int SKILLX = 0;
	public static final int MAP_UNITX = 650/5;               
	public static final int MAP_UNITY = 650/5;               


}

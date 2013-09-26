//
//  AvatarScreen.m
//  Avatar
//
//  Created by Jin Hu on 2010/08/04.
//  Copyright 2010 __MyCompanyName__. All rights reserved.
//

#import "AvatarScreen.h"
#import "State.h"
#import "CharInfo.h"
#import <QuartzCore/QuartzCore.h>

@implementation AvatarScreen
@synthesize avatar;

- (id)initWithFrame:(CGRect)f {
    if ((self = [super initWithFrame:f])) {
        self.avatar  = [[Avatar alloc]init:[[CharInfo alloc]init:0]];
		focusUp = [[Sprite alloc] initWithImage:[UIImage imageNamed:@"up0.png" ] mirror:false]; 	
		focusDown = [[Sprite alloc] initWithImage:[UIImage imageNamed:@"down0.png" ] mirror:false]; 	
		last = [[Sprite alloc] initWithImage:[UIImage imageNamed:@"left0.png" ] mirror:false]; 	
		next = [[Sprite alloc] initWithImage:[UIImage imageNamed:@"right0.png" ] mirror:false]; 	
		[focusUp setPosition:130 y:0];
		[focusDown setPosition:130 y:420];
		[last setPosition:0 y:210];
		[next setPosition:260 y:210];
		selection = [[Sprite alloc] initWithImage:[UIImage imageNamed:@"selection.png" ] mirror:false]; 	
		selected = CGRectMake(50, 80, 180, 340);
		
		NSMutableArray* bitmaps;
		
		
		bitmaps =[NSMutableArray arrayWithCapacity:20];
		[bitmaps addObject:[UIImage imageNamed:@"stage_bay.jpg"]];
		[bitmaps addObject:[UIImage imageNamed:@"stage_beach.jpg"]];
		[bitmaps addObject:[UIImage imageNamed:@"stage_desert_city.jpg"]];
		[bitmaps addObject:[UIImage imageNamed:@"stage_lake.jpg"]];
		[bitmaps addObject:[UIImage imageNamed:@"stage_mill.jpg"]];
		[bitmaps addObject:[UIImage imageNamed:@"stage_moutain.jpg"]];
		[bitmaps addObject:[UIImage imageNamed:@"stage_valley.jpg"]];
		[bitmaps addObject:[UIImage imageNamed:@"stage_vulcano.jpg"]];

		[bitmaps addObject:[UIImage imageNamed:@"location_chinastage.jpg"]];
		[bitmaps addObject:[UIImage imageNamed:@"location_egyptstage.jpg"]];
		[bitmaps addObject:[UIImage imageNamed:@"location_greecestage.jpg"]];
		[bitmaps addObject:[UIImage imageNamed:@"location_lake.jpg"]];
		[bitmaps addObject:[UIImage imageNamed:@"location_moutain.jpg"]];
		[bitmaps addObject:[UIImage imageNamed:@"location_perustage.jpg"]];
		[bitmaps addObject:[UIImage imageNamed:@"location_polandstage.jpg"]];
		[bitmaps addObject:[UIImage imageNamed:@"location_tibetstage.jpg"]];
		[bitmaps addObject:[UIImage imageNamed:@"location_turkeystage.jpg"]];
		stage=[[Sprite alloc] initWithArray:bitmaps mirror:false]; 
		
		bitmaps =[NSMutableArray arrayWithCapacity:12];
		[bitmaps addObject:[UIImage imageNamed:@"pet_rat.png"]];
		[bitmaps addObject:[UIImage imageNamed:@"pet_ox.png"]];
		[bitmaps addObject:[UIImage imageNamed:@"pet_tiger.png"]];
		[bitmaps addObject:[UIImage imageNamed:@"pet_hare.png"]];
		[bitmaps addObject:[UIImage imageNamed:@"pet_dragon.png"]];
		[bitmaps addObject:[UIImage imageNamed:@"pet_snake.png"]];
		[bitmaps addObject:[UIImage imageNamed:@"pet_horse.png"]];
		[bitmaps addObject:[UIImage imageNamed:@"pet_monkey.png"]];
		[bitmaps addObject:[UIImage imageNamed:@"pet_goat.png"]];
		[bitmaps addObject:[UIImage imageNamed:@"pet_rooster.png"]];
		[bitmaps addObject:[UIImage imageNamed:@"pet_pig.png"]];
		[bitmaps addObject:[UIImage imageNamed:@"pet_dog.png"]];
		
		zodiacPet=[[Sprite alloc] initWithArray:bitmaps mirror:false]; 
		
		bitmaps =[NSMutableArray arrayWithCapacity:12];
		[bitmaps addObject:[UIImage imageNamed:@"artifact_virgo.png"]];
		[bitmaps addObject:[UIImage imageNamed:@"artifact_aries.png"]];
		[bitmaps addObject:[UIImage imageNamed:@"artifact_leo.png"]];
		[bitmaps addObject:[UIImage imageNamed:@"artifact_scorpio.png"]];
		[bitmaps addObject:[UIImage imageNamed:@"artifact_capricorn.png"]];
		[bitmaps addObject:[UIImage imageNamed:@"artifact_aquarius.png"]];
		[bitmaps addObject:[UIImage imageNamed:@"artifact_cancer.png"]];
		[bitmaps addObject:[UIImage imageNamed:@"artifact_pisces.png"]];
		[bitmaps addObject:[UIImage imageNamed:@"artifact_sagittarius.png"]];
		[bitmaps addObject:[UIImage imageNamed:@"artifact_gemini.png"]];
		[bitmaps addObject:[UIImage imageNamed:@"artifact_libra.png"]];
		[bitmaps addObject:[UIImage imageNamed:@"artifact_taurus.png"]];
		zodiacArtifact=[[Sprite alloc] initWithArray:bitmaps mirror:false]; 
		
		//avatar.info.state = G_DRAWING;
		[avatar move: 60 y: 10];
		[zodiacArtifact move:0 y:380];
		[zodiacPet move:190 y:380 ];
		state =S_PLAY;
	}
	return self;
}
- (id)init {
    if (self = [super init]) {
		// Initialization code
	}
	return self;
}


/*
 // Only override drawRect: if you perform custom drawing.
 // An empty implementation adversely affects performance during animation.
 - (void)drawRect:(CGRect)rect {
 // Drawing code
 }
 */

- (void)dealloc {
    [super dealloc];
}
-(void )action:(int) x y:( int) y {
	if(y>380){
		part+=1;
		[self changePartFocus ];
	}else if (y<100) {
		part-=1;
		[self changePartFocus];
	}
	else{
		if(x<100){
			frame-=1;
			[self changeFrame];
		}
		else if(x>220){
			frame+=1;
			[self changeFrame];
		}else{
			state=S_TITLE;
		}
	}
}

-(void) paintScreen {
	CGContextRef context=UIGraphicsGetCurrentContext();
	CGContextSetRGBFillColor(context, 1, 0, 0, 0.5); // darker blue (bottom)
	CGContextSetRGBStrokeColor(context,0,0,0,1); 
	CGContextSetLineWidth(context,4);
	[stage paint];
	CGContextFillRect(context,selected);
	CGContextStrokeRect(context,selected);
	[selection paint];
	[avatar drawImage];
	[zodiacPet paint];
	[zodiacArtifact paint];
	[focusUp paint];
	[focusDown paint];
	[last paint];
	[next paint];
}

-(int) stateMachine {
	return state;
}
-(void) changePartFocus{
	switch(part%13){
		case 0:
			focus=avatar.head;
			selected = CGRectMake(50, 80, 170, 170);
			break;
		case 1:
			focus=avatar.face;
			selected = CGRectMake(100, 130, 120, 120);
			break;
		case 2:
			focus=avatar.body;
			selected = CGRectMake(90, 240, 110, 100);

			break;
		case 3:
			focus=avatar.lArm;
			selected = CGRectMake(50, 240, 70, 100);
			break;
		case 4:
			focus=avatar.rArm;
			selected = CGRectMake(150, 240, 70, 100);

			break;
		case 5:
			focus=avatar.wapon;
			selected = CGRectMake(50, 200, 70, 180);
			break;
		case 6:
			focus=avatar.element;
			selected = CGRectMake(150, 240, 80, 80);

			break;
		case 7:
			focus=avatar.legs;
			selected = CGRectMake(50, 320, 170, 70);

			break;
		case 8:
			focus=avatar.feets;
			selected = CGRectMake(50, 360, 170, 50);
			break;
		case 9:
			focus=zodiacArtifact;
			selected = CGRectMake(0, 380, 100, 80);

			break;
		case 10:
			focus=zodiacPet;
			selected = CGRectMake(200, 380, 150, 100);

			break;
		case 11:
			focus=stage;
			selected = CGRectMake(20, 20, 280, 440);

			break;
		case 12:
		default:
			focus=nil;
			selected = CGRectMake(50, 80, 180, 340);

			break;
	}
}
-(void) changeFrame{
	if (focus==nil) {
		[avatar setAllFrame:frame];
	}
	[focus setCurrentFrame:frame];
}


@end

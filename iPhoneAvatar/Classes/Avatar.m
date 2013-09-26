//
//  Avatar m
//  Avatar
//
//  Created by Jin Hu on 2010/08/04 
//  Copyright 2010 __MyCompanyName__  All rights reserved 
//

#import "Avatar.h"
#import "CharInfo.h"
#import "Sprite.h"
@implementation Avatar
//@synthesize  head, face,body,legs,feets,element,wapon;


-(Sprite*)initPart:(NSString*)part {
	NSMutableArray* bitmaps = [NSMutableArray arrayWithCapacity:12];
	[bitmaps addObject:[UIImage imageNamed:[NSString stringWithFormat: @"bird_%@.png",part]]];
	[bitmaps addObject:[UIImage imageNamed:[NSString stringWithFormat: @"lizard_%@.png",part]]];
	[bitmaps addObject:[UIImage imageNamed:[NSString stringWithFormat: @"orc_%@.png",part]]];
	[bitmaps addObject:[UIImage imageNamed:[NSString stringWithFormat: @"bat_%@.png",part]]];
	[bitmaps addObject:[UIImage imageNamed:[NSString stringWithFormat: @"basic_%@.png",part]]];
	[bitmaps addObject:[UIImage imageNamed:[NSString stringWithFormat: @"elf_%@.png",part]]];
	[bitmaps addObject:[UIImage imageNamed:[NSString stringWithFormat: @"fish_%@.png",part]]];
	[bitmaps addObject:[UIImage imageNamed:[NSString stringWithFormat: @"horse_%@.png",part]]];
	[bitmaps addObject:[UIImage imageNamed:[NSString stringWithFormat: @"human_%@.png",part]]];
	[bitmaps addObject:[UIImage imageNamed:[NSString stringWithFormat: @"iszu_%@.png",part]]];
	[bitmaps addObject:[UIImage imageNamed:[NSString stringWithFormat: @"yinoch_%@.png",part]]];
	[bitmaps addObject:[UIImage imageNamed:[NSString stringWithFormat: @"eden_%@.png",part]]];
	Sprite* s = [[Sprite alloc] initWithArray:bitmaps mirror:p2]; 
	return s;
}

-(id) init:(CharInfo *)c{
	NSMutableArray* bitmaps ;
	head = [self initPart:@"head"];
	face = [self initPart:@"face_normal"];
	body = [self initPart:@"body"];
	lFist = [self initPart:@"hand_l_rock"];
	rFist = [self initPart:@"hand_r_paper"];
	lArm = [self initPart:@"arm_l1"];
	rArm = [self initPart:@"arm_r2"];
	body = [self initPart:@"body"];
	legs = [self initPart:@"legs"];
	feets = [self initPart:@"feets"];
	
	bitmaps = [NSMutableArray arrayWithCapacity:12];
	[bitmaps addObject:[UIImage imageNamed:@"job.png"]];
	[bitmaps addObject:[UIImage imageNamed:@"job_archer.png"]];
	[bitmaps addObject:[UIImage imageNamed:@"job_mage.png"]];
	[bitmaps addObject:[UIImage imageNamed:@"job_monk.png"]];
	[bitmaps addObject:[UIImage imageNamed:@"job_ninja.png"]];
	[bitmaps addObject:[UIImage imageNamed:@"job_wizard.png"]];
	[bitmaps addObject:[UIImage imageNamed:@"job_swordman.png"]];
	[bitmaps addObject:[UIImage imageNamed:@"job_soldier.png"]];
	skill = [[Sprite alloc] initWithArray:bitmaps mirror:p2]; 

	bitmaps = [NSMutableArray arrayWithCapacity:12];
	[bitmaps addObject:[UIImage imageNamed:@"element.png"]];
	[bitmaps addObject:[UIImage imageNamed:@"element_air.png"]];
	[bitmaps addObject:[UIImage imageNamed:@"element_tree.png"]];
	[bitmaps addObject:[UIImage imageNamed:@"element_fire.png"]];
	[bitmaps addObject:[UIImage imageNamed:@"element_rock.png"]];
	[bitmaps addObject:[UIImage imageNamed:@"element_earth.png"]];
	[bitmaps addObject:[UIImage imageNamed:@"element_ice.png"]];
	[bitmaps addObject:[UIImage imageNamed:@"element_water.png"]];
	[bitmaps addObject:[UIImage imageNamed:@"element_thunder.png"]];
	element = [[Sprite alloc] initWithArray:bitmaps mirror:p2]; 
	
	bitmaps =[NSMutableArray arrayWithCapacity:12];
	[bitmaps addObject:[UIImage imageNamed:@"wapon.png"]];
	[bitmaps addObject:[UIImage imageNamed:@"wapon_bow.png"]];
	[bitmaps addObject:[UIImage imageNamed:@"wapon_staff.png"]];
	[bitmaps addObject:[UIImage imageNamed:@"wapon_sword.png"]];
	[bitmaps addObject:[UIImage imageNamed:@"wapon_spear.png"]];
	[bitmaps addObject:[UIImage imageNamed:@"wapon_schimitar.png"]];
	[bitmaps addObject:[UIImage imageNamed:@"wapon_kane.png"]];
	[bitmaps addObject:[UIImage imageNamed:@"wapon_chain.png"]];
	[bitmaps addObject:[UIImage imageNamed:@"wapon_shield.png"]];
	wapon = [[Sprite alloc] initWithArray:bitmaps mirror:p2]; 
	
	
	icon = [[Sprite alloc] initWithImage:[UIImage imageNamed:@"basic_icon.png" ] mirror:p2]; 

	[self initPosition];
	return self;
}


- (void)dealloc {
    [super dealloc];
}

-(void) initPosition{
	[super initPosition];
	[rFist setPosition:80 y:240];
	[rArm setCurrentFrame:1];
	[lArm setCurrentFrame:1];
	[lFist setCurrentFrame:0];
	[rFist setCurrentFrame:2];
}

-(void) drawImage{
	[super drawImage];
	[rFist paint];
	[element paint];
	[wapon paint ];
	[lFist paint];
	
}
-(void) move:(int) x2 y:(int) y2{
	[super move:x2 y:y2];
	[element move:x2 y:y2];
	[wapon move:x2 y:y2];
	[rFist move:x2 y:y2];
	[lFist move:-55 y:30];
}
-(void)setAllFrame:(int)frame{
	frame = frame%12;
	[head setCurrentFrame:frame];
	[face setCurrentFrame:frame];
	[body setCurrentFrame:frame];
	[lArm setCurrentFrame:frame];
	[rArm setCurrentFrame:frame];
	[lFist setCurrentFrame:frame];
	[rFist setCurrentFrame:frame];
	[legs setCurrentFrame:frame];
	[feets setCurrentFrame:frame];
//	[rArm setFrame:frame];
//	[rArm setFrame:frame];
//	[rArm setFrame:frame];
//	[rArm setFrame:frame];
}
@end


//
//  AvatarScreen.h
//  Avatar
//
//  Created by Jin Hu on 2010/08/04.
//  Copyright 2010 __MyCompanyName__. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "Screen.h"
#import "Avatar.h"
#import "Sprite.h"
@interface AvatarScreen : Screen {
	@private 
		Avatar* avatar;
		uint frame;
		uint part;
		Sprite* focus;
		Sprite* stage;
		Sprite* zodiacPet;
		Sprite* zodiacArtifact;
	Sprite* focusUp,*focusDown;
	Sprite*last,*next;
	CGRect selected;
	
	
}
@property (nonatomic,retain) Avatar* avatar;
-(void) changePartFocus;
-(void) changeFrame;
@end

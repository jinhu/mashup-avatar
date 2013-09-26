//
//  AvatarViewController.h
//  Avatar
//
//  Created by Jin Hu on 2010/08/04.
//  Copyright __MyCompanyName__ 2010. All rights reserved.
//
#import <AudioToolbox/AudioServices.h>
#import "GameViewController.h"
#import "GameView.h"
#import "TitleScreen.h"
#import "TransitionScreen.h"
#import "EndScreen.h"
#import "AvatarScreen.h"
#import "GameViewController.h"
#import <iAd/iAd.h>

@interface AvatarViewController : GameViewController<ADBannerViewDelegate> {
    
@private 
	TitleScreen* titleScreen;
	TransitionScreen* transitionScreen;
	AvatarScreen* playScreen; 
	EndScreen* endScreen;
	MediaPlayer* themeSong; 
    MediaPlayer* stageSong; 
	CGRect frame;
	int stageNr;
	ADBannerView *banner;
	BOOL bannerIsVisible;

}
@property(nonatomic, retain) IBOutlet ADBannerView *banner;
@end

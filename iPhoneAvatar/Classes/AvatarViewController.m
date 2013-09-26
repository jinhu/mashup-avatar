//
//  AvatarViewController.m
//  Avatar
//
//  Created by Jin Hu on 2010/08/04.
//  Copyright __MyCompanyName__ 2010. All rights reserved.
//

#import "AvatarViewController.h"
#import "State.h"
@implementation AvatarViewController
// Implement loadView to create a view hierarchy programmatically, without using a nib.
- (void)loadView {
	state = S_TITLE;
	frame = CGRectMake(0, 50, 320, 430);
	self.view =[[UIView alloc] initWithFrame:CGRectMake(0, 0, 320, 480) ] ;
}
// Implement viewDidLoad to do additional setup after loading the view, typically from a nib.
- (void)viewDidLoad {
    [super viewDidLoad];
	bannerIsVisible = YES;
	ADBannerView *adView = [[ADBannerView alloc] initWithFrame:CGRectZero];
	adView.delegate = self;
	adView.currentContentSizeIdentifier = ADBannerContentSizeIdentifierPortrait;
	[self.view addSubview:adView];
}	


/*
 // Override to allow orientations other than the default portrait orientation.
- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation {
    // Return YES for supported orientations
    return (interfaceOrientation == UIInterfaceOrientationPortrait);
}
*/

- (void)didReceiveMemoryWarning {
	// Releases the view if it doesn't have a superview.
    [super didReceiveMemoryWarning];
	
	// Release any cached data, images, etc that aren't in use.
}

- (void)viewDidUnload {
	// Release any retained subviews of the main view.
	// e.g. self.myOutlet = nil;
}


- (void)dealloc {
    [super dealloc];
}
- (void) onTransition {
	if (transitionScreen == nil) {
		transitionScreen = [TransitionScreen alloc];
	}
	if(currentScreen !=transitionScreen){
		[transitionScreen initWithFrame:frame];
		transitionScreen.image=[UIImage imageNamed:@"screen_transition.png"];
		currentScreen = transitionScreen;
		state = S_TRANSITION;
		currentSong= stageSong;
	}
}

- (void) onPlay {
	if (playScreen == nil) {
		playScreen = [AvatarScreen alloc];
	}
	if(currentScreen !=playScreen){
		//		[playScreen init];
		[playScreen initWithFrame:[[UIScreen mainScreen] applicationFrame]];
		currentScreen = playScreen;
		state = S_PLAY;
		currentSong= stageSong;
	}
	
}


- (void) onEnd {
	if (endScreen == nil) {
		endScreen = [EndScreen alloc];
	}
	if(currentScreen !=endScreen){
		[endScreen initWithFrame:frame];
		//endScreen.player= avatarScreen.avatar;
		//[endScreen.player move:80 y:-10];
		
		currentScreen = endScreen;
		currentSong= themeSong;
	}
}
- (void) onTitle{
	if (titleScreen == nil) {
		titleScreen = [TitleScreen alloc];
	}
	if(titleScreen!=currentScreen){
		[titleScreen initWithFrame:frame];
		//memoryStage.currentStage=0;
		currentScreen = titleScreen;
		titleScreen.image = [UIImage imageNamed:@"avatar_title.png"];
		currentSong= themeSong;
	}
}
- (void) stateMachine{
	MediaPlayer* oldSong = currentSong;
	Screen* oldScreen = currentScreen;
	switch (state){
		case S_PLAY: 
			[self onPlay];
			break;
		case S_END: 
			[self onEnd];
			break;
		case S_TRANSITION: 
			[self onTransition];
			break;
		case S_TITLE: 
		default: 
			[self onTitle];				
			break;
	}
	state = [currentScreen stateMachine];
	if(oldSong != currentSong){
		[oldSong pause];
		[currentSong play];
	}
	if (oldScreen!=currentScreen) {
		[oldScreen removeFromSuperview];
		[currentScreen retain];
		[self.view addSubview:currentScreen];
	}
	
}
#pragma mark ADBannerViewDelegate methods

-(void)bannerViewDidLoadAd:(ADBannerView *)banner
{
}

-(void)bannerView:(ADBannerView *)banner didFailToReceiveAdWithError:(NSError *)error
{
	NSString* s = [error localizedDescription];
	NSLog(s);
	
}

-(BOOL)bannerViewActionShouldBegin:(ADBannerView *)banner willLeaveApplication:(BOOL)willLeave
{
    return YES;
}

-(void)bannerViewActionDidFinish:(ADBannerView *)banner
{
}

@end

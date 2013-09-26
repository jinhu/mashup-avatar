//
//  AvatarAppDelegate.h
//  Avatar
//
//  Created by Jin Hu on 2010/08/04.
//  Copyright __MyCompanyName__ 2010. All rights reserved.
//

#import <UIKit/UIKit.h>

@class AvatarViewController;

@interface AvatarAppDelegate : NSObject <UIApplicationDelegate> {
    UIWindow *window;
    AvatarViewController *viewController;

}

@property (nonatomic, retain) IBOutlet UIWindow *window;
@property (nonatomic, retain) IBOutlet AvatarViewController *viewController;

@end


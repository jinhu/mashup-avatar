package dev.game.legend.avatar;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;

import dev.game.legend.GameView;
import dev.game.legend.Screen;
import dev.game.legend.State;
import dev.game.legend.data.CharInfo;
import dev.game.legend.data.Constants;

//
public class AvatarView extends GameView {

	public AvatarView(Context c) {
		super(c);
		// TODO Auto-generated constructor stub
	}
	private Screen currentScreen;
	private AvatarTitleScreen titleScreen;
	private AvatarScreen playScreen;
	
	CharInfo player;
	private int stage;
    MediaPlayer themeSong; 
    MediaPlayer stageSong; 
    Context hook;
	public void init(Activity a) {
		hook = a;
//		themeSong= MediaPlayer.create(mContext, R.raw.title);
//		themeSong.setLooping(true);
//		stageSong= MediaPlayer.create(mContext, R.raw.perustage);
//		stageSong.setLooping(true);
		state=0;
		stage=0;
	}

	private void onPlay() {
		if (playScreen == null) {
			playScreen = new AvatarScreen(hook);
		}
		if(currentScreen !=playScreen){
			stage++;
			playScreen.init();
			currentScreen = playScreen;
			state = STATE_PLAY;
			currentSong= stageSong;
		}
	}

	private void onTitle() {
		if (titleScreen == null) {
			titleScreen = new AvatarTitleScreen(hook);
		}
		if(titleScreen!=currentScreen){
			titleScreen.init();
			stage=0;
			currentScreen = titleScreen;
			currentSong= themeSong;
		}
	}

	@Override
	public boolean action(int gameAction, KeyEvent msg) {
		return currentScreen.action(gameAction, msg);
	}

	@Override
	public void action(int x, int y) {
		currentScreen.action(x, y);

	}

	@Override
	public void paintScreen(Canvas canvas) {
		currentScreen.paintScreen(canvas);
	}

	@Override
		public void stateMachine(){
			if(currentSong!=null)
				currentSong.pause();
			switch (state){
				case State.S_PLAY: 
					onPlay();
					break;
				case State.S_TITLE: 
				default: 
					onTitle();				
					break;
				}
			state=currentScreen.stateMachine();
//			currentSong.start();
	}
    public synchronized void restoreState(Bundle map) {
    	try{
    		  player.name        =map.getString(Constants.NAME       );
              player.aiType      =map.getInt(Constants.AITYPE      );
              player.experience  =map.getInt(Constants.EXPERIENCE );
              player.health      =map.getInt(Constants.HEALTH     );
              player.race        =map.getInt(Constants.RACE       );
              player.magic       =map.getInt(Constants.MAGIC      );
              player.score       =map.getInt(Constants.SCORE      );
              player.complete    =map.getInt(Constants.COMPLETE   );                   
              player.liveLost    =map.getInt(Constants.LIVELOST  	);    
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }

    public Bundle saveState(Bundle map) {
            if (map != null) {
            	map.putString(Constants.NAME,   player.name                         );
            	map.putInt(Constants.AITYPE,    Integer.valueOf(player.aiType    )  );
            	map.putInt(Constants.EXPERIENCE,Integer.valueOf(player.experience)  );
            	map.putInt(Constants.HEALTH,    Integer.valueOf(player.health		 )  );
            	map.putInt(Constants.RACE,      Integer.valueOf(player.race			 )  );
            	map.putInt(Constants.MAGIC,     Integer.valueOf(player.magic		 )  );
            	map.putInt(Constants.SCORE,     Integer.valueOf(player.score		 )  );
            	map.putInt(Constants.COMPLETE,  Integer.valueOf(player.complete	 )  );                   
            	map.putInt(Constants.LIVELOST,  Integer.valueOf(player.liveLost	 )  );                   
            }
        return map;
    }





}

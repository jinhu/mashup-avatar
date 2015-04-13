package dev.game.legend.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Stage {

	public Bitmap image;

	Bitmap[] resultImage;

	public Location location;
	public CharInfo enemy;
	Context mContext;
	int stageNr;
	public Stage(Context c, int i) {
		stageNr = i;
		mContext=c;
		init(i);
	}
	private void init(int i) {
		enemy = new CharInfo(i);
		location = new Location(i);
		image=BitmapFactory.decodeResource(mContext.getResources(),location.stage);
	}

	public Bitmap getImage() {
		return null;//Helper.createImageIcon("/resources/locations/"+location.res+ "Stage.png");
	}

	public Bitmap getNextStageImage() {
		Location loc= new Location(stageNr+=1);
		Bitmap next=BitmapFactory.decodeResource(mContext.getResources(),loc.stage);

		return next;
	}

}

package dev.game.legend;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;


public class Sprite{
	private int x;
	private int y;
	private Bitmap[] images;
	private int frame;

	public Sprite(Bitmap img,boolean m) {
		images=new Bitmap[1];
        if(m){
            Matrix aMatrix = new Matrix();
            aMatrix.preScale(-1.0f, 1.0f);
            images[0]= Bitmap.createBitmap(img, 0, 0, img.getWidth(),img.getHeight(), aMatrix, false);
            }else{
            images[0] = img;
            }
	}
	public Sprite(Bitmap[] img,boolean m) {
            Matrix aMatrix = new Matrix();
            aMatrix.preScale(-1.0f, 1.0f);
            images =new Bitmap[img.length];
            for(int i=0;i<img.length;i++){
                if(m){
                	images[i]= Bitmap.createBitmap(img[i], 0, 0, img[i].getWidth(),img[i].getHeight(), aMatrix, false);
            }else{
            	images[i] = img[i];
            }
        }
	}
	public Sprite(Bitmap img) {
		this(img, false);
	}
	public Sprite(Bitmap[] img) {
		this(img, false);
	}
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}

	public Bitmap getImage() {
		// TODO Auto-generated method stub
		return images[frame];
	}

	public int getFrame() {
		return frame;
	}
	public void setFrame(int i) {
		i= i%images.length;
		if(i<0){
			i+=images.length;
		}
		frame=i;
	}

	public void setVisible(boolean b) {
	}

	public void move(int x2, int y2) {
		x+=x2;
		y+=y2;
		
	}

	public void paint(Canvas canvas) {
        canvas.drawBitmap(images[frame], x,y, null);
	}
	public void draw(Canvas canvas) {
		paint(canvas);
	}
	public void setPosition(int x2, int y2) {
		x=x2;
		y=y2;
		
	}
	public int getWidth() {
		return images[0].getWidth();
	}

}

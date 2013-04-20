package yk.Screen.Pack;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class BitmapObject {
	
	private int cnt;
	private float position_X;
	private float position_Y;
	
	public BitmapObject() {
		position_X = 0;
		position_Y = 0;
		cnt = 0;
	}
	public BitmapObject(float posX, float posY) {
		position_X = posX;
		position_Y = posY;
		cnt = 0;
	}
	
	public void drow(Canvas canvas) {
		Paint paint = new Paint();
		paint.setColor(Color.BLACK);
		canvas.drawText("" + cnt, position_X, position_Y, paint);
	}

}

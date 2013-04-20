package yk.Screen.Pack;

import java.util.ArrayList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
/**
 * Bitmap画像アニメーションする為のクラス
 * @author Yk
 *
 */
public class BitmapObject {
	/** LOG */
	private final static String CLASS = "BitmapObject";
	/** PAINT */
	private Paint paint;
	/** BITMAPLIST */
	private ArrayList<Bitmap> bitMapList;
	/** LoopFlg */
	private boolean loop = false;
	/** カウント */
	private int cnt;
	/** X座標 */
	private float position_X;
	/** Y座標 */
	private float position_Y;
	
	/**
	 * Contractor
	 */
	public BitmapObject() {
		Log.d(CLASS, "BitmapObject()");
		
		position_X = 0;
		position_Y = 0;
		cnt = 0;
	}
	/**
	 * Contractor
	 * @param posX X初期位置
	 * @param posY Y初期位置
	 */
	public BitmapObject(float posX, float posY) {
		Log.d(CLASS, "BitmapObject(X,Y)");
		
		position_X = posX;
		position_Y = posY;
		cnt = 0;
	}
	/**
	 * Contractor
	 * @param bitmap BITMAP画像
	 */
	public BitmapObject(Bitmap bitmap) {
		Log.d(CLASS, "BitmapObject(bitmap)");
		
		bitMapList = new ArrayList<Bitmap>();
		bitMapList.add(bitmap);
		position_X = 0;
		position_Y = 0;
		cnt = 0;
	}
	
	/**
	 * 描画処理
	 * @param canvas
	 */
	public void draw(Canvas canvas) {
		
		paint = new Paint();
		canvas.drawBitmap(bitMapList.get(cnt), position_X, position_Y, paint);
		
		if(bitMapList.size() >= cnt){
			
			if(loop == true){
				cnt = 0;
			}
			
		}else{
			cnt++;
		}
		
	}

}

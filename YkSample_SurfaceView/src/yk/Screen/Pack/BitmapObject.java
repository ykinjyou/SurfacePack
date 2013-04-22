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
	private boolean loop = true;
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
	 * Contractor
	 * @param bitmap BITMAP画像
	 * @param posX X初期位置
	 * @param posY Y初期位置
	 */
	public BitmapObject(Bitmap bitmap, float posX, float posY) {
		Log.d(CLASS, "BitmapObject(bitmap,X,Y)");
		
		bitMapList = new ArrayList<Bitmap>();
		bitMapList.add(bitmap);
		position_X = posX;
		position_Y = posY;
		cnt = 0;
	}
	/**
	 * Contractor
	 * @param bitmap BITMAP画像配列
	 */
	public BitmapObject(Bitmap[] bitmap) {
		Log.d(CLASS, "BitmapObject(bitmap[])");
		
		bitMapList = new ArrayList<Bitmap>();
		for(int i=0;bitmap.length>i;i++){
			bitMapList.add(bitmap[i]);
		}
		
		position_X = 0;
		position_Y = 0;
		cnt = 0;
	}
	/**
	 * Contractor
	 * @param bitmap BITMAP画像配列
	 * @param posX X初期位置
	 * @param posY Y初期位置
	 */
	public BitmapObject(Bitmap[] bitmap, float posX, float posY) {
		Log.d(CLASS, "BitmapObject(bitmap[],X,Y)");
		
		bitMapList = new ArrayList<Bitmap>();
		for(int i=0;bitmap.length>i;i++){
			bitMapList.add(bitmap[i]);
		}
		
		position_X = posX;
		position_Y = posY;
		cnt = 0;
	}
	/**
	 * Contractor
	 * @param bitmap 画像リスト
	 */
	public BitmapObject(ArrayList<Bitmap> bitmap) {
		Log.d(CLASS, "BitmapObject(ArrayList<Bitmap>)");
		
		bitMapList = new ArrayList<Bitmap>();
		bitMapList.addAll(bitmap);
		
		position_X = 0;
		position_Y = 0;
		cnt = 0;
	}
	/**
	 * Contractor
	 * @param bitmap 画像リスト
	 * @param posX X初期位置
	 * @param posY Y初期位置
	 */
	public BitmapObject(ArrayList<Bitmap> bitmap, float posX, float posY) {
		Log.d(CLASS, "BitmapObject(ArrayList<Bitmap>,X,Y)");
		
		bitMapList = new ArrayList<Bitmap>();
		bitMapList.addAll(bitmap);
		
		position_X = posX;
		position_Y = posY;
		cnt = 0;
	}
	
	/**
	 * 描画処理
	 * @param canvas
	 */
	public void draw(Canvas canvas) {
		
		paint = new Paint();
		canvas.drawBitmap(bitMapList.get(cnt), position_X, position_Y, paint);
		
		/*
		 * List範囲内ならcnt追加
		 * List範囲を超えた場合loopフラグがONなら0を再セット
		 */
		if((bitMapList.size() - 1) > cnt){
			cnt++;
		}else{
			if(loop == true){
				cnt = 0;
			}
		}
		
	}

}

package yk.Sample;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
/**
 * サークルクラス
 * @author yk
 */
public class Circle {
	/** 位置X */
	private float posX;
	/** 位置Y */
	private float posY;
	/** 加速値X */
	private float accX;
	/** 加速値Y */
	private float accY;
	/** 重力値 */
	private float gravity;
	/** サークル半径 */
	private float radius;
	
	/**
	 * 初期値設定
	 */
	public Circle() {
		posX = 100;
		posY = 100;
		accX = 5;
		accY = 5;
		gravity = 1;
		radius = 50;
	}
	
	/**
	 * 描画処理
	 * @param canvas
	 */
	public void drawRun(Canvas canvas) {
		// バウンドor自由落下
		bound_Cal();
		// 色指定
		Paint paint = new Paint();
		paint.setColor(Color.BLUE);
		// サークル
		canvas.drawCircle(posX, posY, radius, paint);
	}
	
	/***
	 * 物理計算
	 * TODO 物理計算不完全
	 */
	private void bound_Cal() {
		
		if(posY > 300) {
			if(accY >= 1) {
				accY = -15;
			}
		}
		
		posY += accY;
		
		accY += gravity;
		
	}

}

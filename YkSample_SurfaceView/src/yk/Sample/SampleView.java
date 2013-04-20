package yk.Sample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.PaintDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import yk.Screen.Pack.SurfaceScreen;
/**
 * サーフェスビュー用クラス
 * @author yk
 *
 */
public class SampleView extends SurfaceScreen {
	/** サークル */
	private Circle circle;

	/**
	 * Contractor
	 * @param context
	 */
	public SampleView(Context context) {
		super(context);
		// サークル生成
		circle = new Circle();
	}
	/**
	 * Contractor
	 * @param context
	 * @param interval 更新間隔
	 */
	public SampleView(Context context, long interval) {
		super(context);
		// 更新間隔再設定
		INTERVAL_TIME = interval;
		// サークル生成
		circle = new Circle();
	}
	
	@Override
	public void drawRun(Canvas canvas) {
		// 背景色
		canvas.drawColor(Color.WHITE);
		// 色指定
		Paint paint = new Paint();
		paint.setColor(Color.BLACK);
		// テキスト
		canvas.drawText("表示O.K", 10, 10, paint);
		// サークル描画
		circle.drawRun(canvas);
	}
	
	@Override
	public void touchEventDown(float x, float y) {
		Bundle bundle = new Bundle();
		bundle.putFloat("X", x);
		bundle.putFloat("Y", y);
		onSend(bundle);
	}

}

package yk.Screen.Pack;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
/**
 * SurfaceView継承OrignalListener付
 * @author yk
 *
 */
public class SurfaceScreen extends SurfaceView implements SurfaceHolder.Callback, Runnable{
	/** LOG **/
	private final static String CLASS = "SurfaceScreen";
	/** ORIGNAL_LISTENER */
	private SurfaceOriginalListener originalListener = null;
	/** ORIGNAL_DRAW_LISTENER */
	private SurfaceOriginalDrawListener originalDrawListener = null;
	/** INTERVALTIME */
	protected static long INTERVAL_TIME;
	/** HANDLERMESSAGE */
	private final static int HANDlER_MESSAGE = 1000;
	
	/** Thread **/
//	private Thread thread;
	
	/** LoopFlg **/
	private boolean loop;
	
	/** Handler */
	private final Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			if(msg.what == HANDlER_MESSAGE) {
				onDrawCanvas(getHolder());
				msg = obtainMessage(HANDlER_MESSAGE);
				long nextTime = SystemClock.uptimeMillis() + INTERVAL_TIME;
				if(loop == true) {
					sendMessageAtTime(msg, nextTime);
				}
			}
		}
	};
	
	/**
	 * Contractor
	 * @param context
	 */
	public SurfaceScreen(Context context) {
		super(context);
		Log.d(CLASS, "contractor");
		// CallBack
		getHolder().addCallback(this);
		
		// 画面更新のタイミング通常は1秒に約10コマ
		INTERVAL_TIME = 100;
	}
	/**
	 * Contractor
	 * @param context
	 * @param interval 画像更新感覚
	 */
	public SurfaceScreen(Context context, int interval){
		super(context);
		Log.d(CLASS, "contractor interval_time=" + interval);
		
		// CallBack
		getHolder().addCallback(this);
		
		// 画面更新のタイミング、引数で決定
		INTERVAL_TIME = interval;
	}

	/**
	 * 描画変更時に呼ばれる
	 */
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		Log.d(CLASS, "surfaceCanged");
	}

	/**
	 * 描画初回時に呼ばれる
	 */
	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		Log.d(CLASS, "surfaceCreated");
		
		// ループフラグ.オン
		loop = true;
		
		// ハンドラ―スタート
		Message message = handler.obtainMessage(HANDlER_MESSAGE);
		handler.sendMessage(message);
		
		/*---------------------------------
		// スレッドスタート.ループスタート
		thread = new Thread(this);
		thread.start();
		----------------------------------*/
		
	}

	/**
	 * 描画破棄時に呼び出される
	 */
	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		Log.d(CLASS, "surfaceDestroyed");
		
		// ループフラグ.オフ
		loop = false;
	}
	
	/**
	 * ループ処理
	 */
	@Override
	public void run() {
		while(loop) {
			onDrawCanvas(getHolder());
		}
	}
	
	/**
	 * 描画実行
	 * @param holder
	 */
	private void onDrawCanvas(SurfaceHolder holder) {
		//Log.d(CLASS, "onDrawCanvas");
		// 終了時にエラーが起きるので例外処理で回避
		try {
			// ロックかける
			Canvas canvas = holder.lockCanvas();
			// ロックしたCanvas渡しちゃう
			if(this.originalDrawListener != null){
				// リスナーがついているとき
				originalDrawListener.onDrawSurface(canvas);
			}else{
				// リスナーがついていないとき
				drawRun(canvas);
			}
			// ロック解除
			holder.unlockCanvasAndPost(canvas);
		} catch (Exception e) {
			Log.d("error", "e:" + e);
		}
	}
	
	/**
	 * タッチ処理
	 */
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// タッチ開始か終了時かで振り分け
		switch (event.getAction()) {
		
		// タッチ開始
		case MotionEvent.ACTION_DOWN:
			Log.d(CLASS, "touchEventDown");
			touchEventDown(event.getX(), event.getY());
			break;
			
		// タッチ終了
		case MotionEvent.ACTION_UP:
			Log.d(CLASS, "touchEventUp");
			touchEventUp(event.getX(), event.getY());
			break;
			
		}
		return true;
	}
	
	/**
	 * オリジナルのリスナー
	 * @param bundle
	 */
	public void onSend(Bundle bundle) {
		if(this.originalListener != null){
			Log.d(CLASS, "SendCue");
			originalListener.SendCue(this, bundle);
		}
	}
	/**
	 * オリジナルのリスナーセット用のメソッド
	 * @param originalListener
	 */
	public void setOnSendCue(SurfaceOriginalListener originalListener) {
		Log.d(CLASS, "setOnSendCue");
		this.originalListener = originalListener;
	}
	/**
	 * オリジナルのリスナー解除用のメソッド
	 */
	public void removeSendCue() {
		Log.d(CLASS, "removeSendCue");
		this.originalListener = null;
	}
	
	/**
	 * 描画用リスナーのセット用メソッド
	 * @param originalDrawListener
	 */
	public void setOnDrawing(SurfaceOriginalDrawListener originalDrawListener) {
		Log.d(CLASS, "setOnDrawing");
		this.originalDrawListener = originalDrawListener;
	}
	/**
	 * 描画用リスナーの解除用メソッド
	 */
	public void removeDrawing() {
		Log.d(CLASS, "removeDrawing");
		this.originalDrawListener = null;
	}
	
	/**
	 * Override
	 * @param canvas
	 */
	public void drawRun(Canvas canvas) {
		/*
		 * 継承時ここに描画処理をOverrideで処理をかく
		 */
	}
	
	/**
	 * タッチイベント押下時
	 * @param x
	 * @param y
	 */
	public void touchEventDown(float x, float y) {
		Log.d(CLASS, "X = " + x + "   Y = " + y);
	}
	
	/**
	 * タッチイベント離上時
	 * @param x
	 * @param y
	 */
	public void touchEventUp(float x, float y) {
		Log.d(CLASS, "X = " + x + "   Y = " + y);
	}

}

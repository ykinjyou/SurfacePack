package yk.Screen.Pack;

import java.util.EventListener;

import android.graphics.Canvas;
/**
 * 描画処理を外部で扱うためのインタフェイス
 * @author Yk
 *
 */
public interface SurfaceOriginalDrawListener extends EventListener {
	/**
	 * ここでCanvasを使った描画処理を書く
	 * @param canvas
	 */
	public void onDrawSurface(Canvas canvas);

}

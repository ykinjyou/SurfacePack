package yk.Screen.Pack;

import java.util.EventListener;

import android.os.Bundle;
import android.view.View;
/**
 * 処理中に外部に合図を送るためのインタファイス
 * @author yk
 *
 */
public interface SurfaceOriginalListener extends EventListener {
	/**
	 * ここを書き換える
	 * @param view
	 * @param bundle
	 */
	public void SendCue(View view, Bundle bundle);

}

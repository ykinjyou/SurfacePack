package yk.Sample;

import yk.Screen.Pack.SurfaceOriginalDrawListener;
import yk.Screen.Pack.SurfaceScreen;
import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		SurfaceScreen sf = new SurfaceScreen(this, 500);
		sf.setOnDrawing(new SurfaceOriginalDrawListener() {
			@Override
			public void onDrawSurface(Canvas canvas) {
				// 描画処理
				canvas.drawColor(Color.BLUE);
				Paint paint = new Paint();
				paint.setColor(Color.BLACK);
				canvas.drawText("TEST", 30, 30, paint);
			}
		});
		
		setContentView(sf);
	}

}

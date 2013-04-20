package yk.Sample;

import yk.Screen.Pack.BitmapObject;
import yk.Screen.Pack.SurfaceOriginalDrawListener;
import yk.Screen.Pack.SurfaceScreen;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Resources res = getResources();
		Bitmap bm = BitmapFactory.decodeResource(res, R.drawable.ic_launcher);
		
		final BitmapObject bo = new BitmapObject(bm);
		SurfaceScreen sf = new SurfaceScreen(this, 500);
		sf.setOnDrawing(new SurfaceOriginalDrawListener() {
			@Override
			public void onDrawSurface(Canvas canvas) {
				// 描画処理
				canvas.drawColor(Color.BLUE);
				
				bo.draw(canvas);
			}
		});
		
		setContentView(sf);
	}

}

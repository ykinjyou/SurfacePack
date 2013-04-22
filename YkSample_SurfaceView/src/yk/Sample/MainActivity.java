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
		Bitmap bm1 = BitmapFactory.decodeResource(res, R.drawable.mon_001);
		Bitmap bm2 = BitmapFactory.decodeResource(res, R.drawable.mon_002);
		Bitmap bm3 = BitmapFactory.decodeResource(res, R.drawable.mon_003);
		Bitmap bm4 = BitmapFactory.decodeResource(res, R.drawable.mon_004);
		Bitmap bm5 = BitmapFactory.decodeResource(res, R.drawable.mon_005);
		
		final BitmapObject bo = new BitmapObject(new Bitmap[]{bm1,bm2,bm3,bm4,bm5});
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

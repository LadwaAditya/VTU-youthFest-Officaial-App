package edu.bietdvg.davana.vtufest;

import com.actionbarsherlock.app.SherlockActivity;

import edu.bietdvg.davana.vtufest.R;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.content.Intent;

public class WelcomeScreen extends SherlockActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_welcome_screen);

		Thread WelcomeScreen = new Thread() {
			public void run() {
				try {
					sleep(2500);

				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					Intent main = new Intent("android.app.action.START");
					startActivity(main);
				}
			}
		};
		WelcomeScreen.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

}

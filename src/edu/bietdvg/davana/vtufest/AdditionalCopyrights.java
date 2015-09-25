package edu.bietdvg.davana.vtufest;

import com.actionbarsherlock.app.SherlockActivity;

import edu.bietdvg.davana.vtufest.R;
import android.os.Bundle;
import android.webkit.WebView;

public class AdditionalCopyrights extends SherlockActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_additional_copyrights);
		// WebView
		WebView web = (WebView) findViewById(R.id.activity_copyrights_webview);
		web.loadUrl("file:///android_asset/index.html");
		// GetActionBarUpButton
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onOptionsItemSelected(
			com.actionbarsherlock.view.MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			finish();
			// NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}

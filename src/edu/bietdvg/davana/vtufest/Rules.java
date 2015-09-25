package edu.bietdvg.davana.vtufest;

import com.actionbarsherlock.app.SherlockActivity;

import edu.bietdvg.davana.vtufest.R;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class Rules extends SherlockActivity {
	WebView web;
	WebSettings webSettings;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rules);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		web = (WebView) findViewById(R.id.web_view_general_rules);

		WebSettings();
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		web.loadUrl("file:///android_asset/rules.html");
	}

	public void WebSettings() {
		webSettings = web.getSettings();
		webSettings.setBuiltInZoomControls(true);
		webSettings.setJavaScriptEnabled(true);
		webSettings.setUseWideViewPort(true);
		webSettings.setLoadWithOverviewMode(true);

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

package edu.bietdvg.davana.vtufest;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.actionbarsherlock.app.SherlockActivity;

import edu.bietdvg.davana.vtufest.R;

public class EventRules extends SherlockActivity {
	WebView web;
	WebSettings webSettings;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_event_rules);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		Intent intent = getIntent();
		int id = intent.getIntExtra("ID", 0);
		String message = "file:///android_asset/" + id + ".html";
		WebView web = (WebView) findViewById(R.id.web_view_event_rules);

		web.loadUrl(message);

	}

	@Override
	public boolean onOptionsItemSelected(
			com.actionbarsherlock.view.MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}

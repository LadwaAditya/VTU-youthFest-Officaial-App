package edu.bietdvg.davana.vtufest;

import com.actionbarsherlock.app.SherlockActivity;

import edu.bietdvg.davana.vtufest.R;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class Contact extends SherlockActivity {

	WebView web;
	WebSettings webSettings;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact);
		String message = "file:///android_asset/Contacts.html";

		WebView web = (WebView) findViewById(R.id.web_view_contacts);
		webSettings = web.getSettings();
		webSettings.setLoadWithOverviewMode(true);
		web.loadUrl(message);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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

package edu.bietdvg.davana.vtufest;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;

import edu.bietdvg.davana.vtufest.R;

public class TeamManagerLogin extends SherlockActivity {

	WebView web;
	WebSettings webSettings;
	AlertDialogManager am = new AlertDialogManager();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_team_manager_login);
		CheckInternet ci = new CheckInternet(getApplicationContext());
		boolean Online = ci.isConnected();
		if (Online) {
			// WebView
			web = (WebView) findViewById(R.id.web_view_team_manager_login);
			WebSettings();
			web.setWebViewClient(new MyWebViewClient());
			web.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
			web.loadUrl("http://www.davana.bietdvg.edu/register/login.html");
			// GetActionBarUpButton
			getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		} else {

			am.ShowAlertBox(TeamManagerLogin.this, "Cant Connect to Internet",
					"Please Turn On Wifi or Data connection", "OK");
			Toast.makeText(getApplication(), "No Internet", Toast.LENGTH_SHORT)
					.show();
		}
	}

	public void WebSettings() {
		webSettings = web.getSettings();
		webSettings.setJavaScriptEnabled(true);
		webSettings.setBuiltInZoomControls(true);
		webSettings.setLoadWithOverviewMode(true);
		webSettings.setUseWideViewPort(true);

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

	private class MyWebViewClient extends WebViewClient {

		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			if (url.endsWith(".pdf")) {
				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
				return true;
			}
			return false;
		}

		@Override
		public void onPageStarted(WebView view, String url, Bitmap favicon) {
			// TODO Auto-generated method stub
			super.onPageStarted(view, url, favicon);
			setProgressBarIndeterminateVisibility(true);

		}

		@Override
		public void onPageFinished(WebView view, String url) {
			// TODO Auto-generated method stub
			super.onPageFinished(view, url);
			setProgressBarIndeterminateVisibility(false);
		}
	}
}
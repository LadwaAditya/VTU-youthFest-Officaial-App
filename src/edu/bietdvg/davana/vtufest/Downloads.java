package edu.bietdvg.davana.vtufest;

import android.app.ProgressDialog;
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

public class Downloads extends SherlockActivity {

	ProgressDialog progressDialog;
	WebView web;
	WebSettings webSettings;
	AlertDialogManager am = new AlertDialogManager();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(com.actionbarsherlock.view.Window.FEATURE_INDETERMINATE_PROGRESS);
		setContentView(R.layout.activity_downloads);
		CheckInternet ci = new CheckInternet(getApplicationContext());
		boolean Online = ci.isConnected();
		if (Online) {
			// WebView
			web = (WebView) findViewById(R.id.web_view_download);

			WebSettings();

			web.setWebViewClient(new MyWebViewClient());
			getSupportActionBar().setDisplayHomeAsUpEnabled(true);

			web.loadUrl("http://www.davana.bietdvg.edu/downloads.html");
			// GetActionBarUpButton

		} else {

			am.ShowAlertBox(Downloads.this, "Cant Connect to Internet",
					"Please Turn On Wifi or Data connection", "I Got It");
			Toast.makeText(getApplication(), "No Internet", Toast.LENGTH_SHORT)
					.show();
		}
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

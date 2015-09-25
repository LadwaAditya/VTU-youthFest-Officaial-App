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
import com.actionbarsherlock.view.Menu;

import edu.bietdvg.davana.vtufest.R;

public class ViewClass extends SherlockActivity {

	ProgressDialog progressDialog;
	WebView web;
	WebSettings webSettings;
	AlertDialogManager am = new AlertDialogManager();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(com.actionbarsherlock.view.Window.FEATURE_INDETERMINATE_PROGRESS);
		setContentView(R.layout.activity_view_class);
		// CheckInternet Class create an object
		// isConnected is a method defined in CheckInternet Class
		CheckInternet ci = new CheckInternet(getApplicationContext());
		boolean Online = ci.isConnected();
		if (Online) {
			// WebView
			web = (WebView) findViewById(R.id.web_view);
			WebSettings();
			web.setWebViewClient(new MyWebViewClient());
			web.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
			web.loadUrl("http://www.davana.bietdvg.edu/register/dean.html");
			// GetActionBarUpButton
			getSupportActionBar().setDisplayHomeAsUpEnabled(true);
			am.ShowAlertBox(
					ViewClass.this,
					"Registration Help",
					"Step-1	For Team Registration, Team Manager (Team Manager) need to be registered first.Click on the link provided below for the same.\n\n"
							+ "Step 2	Provide the details of Team Manager and click Register.\n\n"
							+ "Step 3	A Verification Code (VID) will be sent to Team Manager’s email id provided in the details section.\n\n"
							+ "Step 4	Login to your email account for VID then complete the Team Manager Registration Process by Entering "
							+ "it on to Verification Window.\n\n"
							+ "Step 5	Once you click the Verify option, you will receive a Confirmation mail With the Further"
							+ " Steps to register your team.\n\n"
							+ "Step 6	You can continue the Team Registration Process immediately or"
							+ " you can do it later by selecting Team Manager Login from Registraion Tab.\n\n"
							+ "NOTE 1	Provide the proper Email ID, so that we can further Communicate with you.\n\n"
							+ "NOTE 2	Only Team Manager can Register their team members and details need to be verified before submission.\n\n"
							+ "SUPPORT	For any Queries and Clarifications contact Registration Team under Registration Tab.\n\n",
					"I Got It");

		} else {

			am.ShowAlertBox(ViewClass.this, "Cant Connect to Internet",
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
	public boolean onCreateOptionsMenu(Menu menu) {
		getSupportMenuInflater().inflate(R.menu.view_class, menu);
		return super.onCreateOptionsMenu(menu);
	}

	// Menu_CallBack
	@Override
	public boolean onOptionsItemSelected(
			com.actionbarsherlock.view.MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			finish();
			// NavUtils.navigateUpFromSameTask(this);
			break;
		case R.id.action_team_manager_login: {
			Intent in = new Intent(getApplicationContext(),
					edu.bietdvg.davana.vtufest.TeamManagerLogin.class);
			startActivity(in);
		}

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

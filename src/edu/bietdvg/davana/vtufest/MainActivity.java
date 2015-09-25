package edu.bietdvg.davana.vtufest;

import java.util.ArrayList;

import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import edu.bietdvg.davana.vtufest.R;

public class MainActivity extends SherlockActivity {

	private SlidingMenu menu;
	private String[] navMenuTitles;
	private TypedArray navMenuIcons;
	private ArrayList<NavDrawerItems> navDrawerItems;
	private NavDrawerListAdapter adapter;
	private View v, r;
	private ListView SliderList;
	WebView web;
	WebSettings webSettings;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TextView tv = (TextView) findViewById(R.id.tvHome);
		tv.setText("\"A wise man once said that, spirit and competitions liberate the mind\".Let’s kick start 2014 with the much awaited VTU annual youth Festival! VTU fest known for being the largest intercollegiate cultural festivals held in the state of Karnataka has set its foot in the city of Harmony- Davangere.BIET welcomes you to come and enter the arena of the warriors and lead your battles, earn your credits and make your institution stand tall and proud and be crowned with the championship.Shake a leg, break a leg, key the hidden talents and let yourself delve into 4 days of fun and excitement.\n\n\n               CopyRights ©  UniCS");
		Toast.makeText(getApplicationContext(),
				"Slide Left Or Right To Access Menus", Toast.LENGTH_LONG)
				.show();
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setTitle("VTU Fest");

		// SlidingMenuListAddapter

		v = getLayoutInflater().inflate(R.layout.activity_slider, null);
		r = getLayoutInflater().inflate(R.layout.activity_slider_right, null);
		SliderList = (ListView) v.findViewById(R.id.slider_list);

		navMenuTitles = getResources().getStringArray(R.array.sliderlist);
		navMenuIcons = getResources().obtainTypedArray(R.array.icons);

		navDrawerItems = new ArrayList<NavDrawerItems>();

		navDrawerItems.add(new NavDrawerItems(navMenuTitles[0], navMenuIcons
				.getResourceId(0, -1)));
		navDrawerItems.add(new NavDrawerItems(navMenuTitles[1], navMenuIcons
				.getResourceId(1, -1)));
		navDrawerItems.add(new NavDrawerItems(navMenuTitles[2], navMenuIcons
				.getResourceId(2, -1)));
		navDrawerItems.add(new NavDrawerItems(navMenuTitles[3], navMenuIcons
				.getResourceId(3, -1)));
		navDrawerItems.add(new NavDrawerItems(navMenuTitles[4], navMenuIcons
				.getResourceId(4, -1)));
		navDrawerItems.add(new NavDrawerItems(navMenuTitles[5], navMenuIcons
				.getResourceId(5, -1)));
		navDrawerItems.add(new NavDrawerItems(navMenuTitles[6], navMenuIcons
				.getResourceId(6, -1)));
		navDrawerItems.add(new NavDrawerItems(navMenuTitles[7], navMenuIcons
				.getResourceId(7, -1)));
		navDrawerItems.add(new NavDrawerItems(navMenuTitles[8], navMenuIcons
				.getResourceId(8, -1)));

		navMenuIcons.recycle();

		adapter = new NavDrawerListAdapter(getApplicationContext(),
				navDrawerItems);
		SliderList.setAdapter(adapter);

		SliderList
				.setOnItemClickListener(new AdapterView.OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						switch (position) {
						case 0: {
							menu.showContent();
							break;
						}
						case 1: {
							Intent in = new Intent(getApplication(),
									edu.bietdvg.davana.vtufest.Events.class);
							startActivity(in);

							break;

						}
						case 2: {
							Intent in = new Intent(getApplication(),
									edu.bietdvg.davana.vtufest.ViewClass.class);
							startActivity(in);
							break;

						}
						case 3: {
							Intent in = new Intent(getApplication(),
									edu.bietdvg.davana.vtufest.Rules.class);
							startActivity(in);
							break;
						}
						case 4: {
							Intent in = new Intent(getApplication(),
									edu.bietdvg.davana.vtufest.Downloads.class);
							startActivity(in);
							break;
						}

						case 5: {
							Intent in = new Intent(getApplicationContext(),
									edu.bietdvg.davana.vtufest.Contact.class);
							startActivity(in);
							break;
						}
						case 6: {
							Intent in = new Intent(getApplicationContext(),
									edu.bietdvg.davana.vtufest.About.class);
							startActivity(in);
							break;
						}
						case 7: {
							Intent in = new Intent()
									.setAction(Intent.ACTION_SEND);
							in.putExtra(
									Intent.EXTRA_TEXT,
									"Hey Check out the Official Android App for VTU Fest 2014   https://play.google.com/store/apps/details?id=edu.bietdvg.davana.vtufest");
							in.setType("text/plain");
							startActivity(in);
							menu.showContent();
							break;
						}
						case 8: {
							StartEmailIntent();
							menu.showContent();
							break;
						}

						}

					}
				});

		menu = new SlidingMenu(this);
		menu.setMode(SlidingMenu.LEFT_RIGHT);
		menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		menu.setShadowWidthRes(R.dimen.shadow_width);
		menu.setShadowDrawable(R.drawable.drawer_shadow);
		menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		menu.setFadeDegree(0.5f);
		menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
		menu.setMenu(v);
		menu.setSecondaryMenu(r);

		CheckInternet ci = new CheckInternet(getApplicationContext());
		boolean Online = ci.isConnected();

		if (Online) {
			new LoadEvents(r).execute();
		} else {
			setNoInternet();
		}

		Button bt = (Button) r.findViewById(R.id.refresh_button);

		bt.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				CheckInternet ci = new CheckInternet(getApplicationContext());
				boolean Online = ci.isConnected();
				if (Online) {
					new LoadEvents(r).execute();
				} else {

					setNoInternet();

				}

			}

		});

	}

	private void setNoInternet() {
		TextView tv_music = (TextView) findViewById(R.id.tv_music);
		TextView tv_dance = (TextView) findViewById(R.id.tv_dance);
		TextView tv_literary = (TextView) findViewById(R.id.tv_literary);
		TextView tv_theater = (TextView) findViewById(R.id.tv_theater);
		TextView tv_fineArts = (TextView) findViewById(R.id.tv_fineArts);
		TextView tv_announcement = (TextView) findViewById(R.id.notifications);
		tv_announcement.setText(R.string.no_internet_connection);
		tv_announcement.setTextColor(getResources().getColor(R.color.red));
		tv_music.setText(R.string.no_internet_connection);
		tv_music.setTextColor(getResources().getColor(R.color.red));
		tv_dance.setText(R.string.no_internet_connection);
		tv_dance.setTextColor(getResources().getColor(R.color.red));
		tv_literary.setText(R.string.no_internet_connection);
		tv_literary.setTextColor(getResources().getColor(R.color.red));
		tv_theater.setText(R.string.no_internet_connection);
		tv_theater.setTextColor(getResources().getColor(R.color.red));
		tv_fineArts.setText(R.string.no_internet_connection);
		tv_fineArts.setTextColor(getResources().getColor(R.color.red));
	}

	// EmailIntentMethod
	private void StartEmailIntent() {
		Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
				"mailto", "davanayouthfest.14@gmail.com", null));
		emailIntent.putExtra(Intent.EXTRA_SUBJECT, "FeedBack");
		startActivity(Intent.createChooser(emailIntent, "FeedBack"));

	}

	// If sliding menu is open press back to close it
	@Override
	public void onBackPressed() {
		if (menu.isMenuShowing()) {
			menu.showContent(true);
			return;
		}

		super.onBackPressed();
	}

	// InflateActionBarMenus
	@Override
	public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {
		getSupportMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	// Menu_CallBack
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home: {
			menu.toggle();
			break;
		}
		case R.id.action_settings: {
			Intent intent_settings = new Intent(this,
					edu.bietdvg.davana.vtufest.Settings.class);
			startActivity(intent_settings);
		}
			break;

		case R.id.action_view: {
			Intent intent_view = new Intent(this,
					edu.bietdvg.davana.vtufest.ViewClass.class);
			startActivity(intent_view);
		}
			break;

		}
		return super.onMenuItemSelected(featureId, item);
	}

}

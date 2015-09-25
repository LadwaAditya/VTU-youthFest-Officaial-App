package edu.bietdvg.davana.vtufest;

import java.util.ArrayList;

import com.actionbarsherlock.app.SherlockActivity;

import edu.bietdvg.davana.vtufest.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Settings extends SherlockActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		// ListView
		ListView SettingsList = (ListView) findViewById(R.id.listView1);
		String[] list_string = new String[] { "About", "Additional Terms" };
		final ArrayList<String> list_array = new ArrayList<String>();

		for (int i = 0; i < list_string.length; i++) {
			list_array.add(list_string[i]);
		}

		final ArrayAdapter<String> ListAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, list_array);
		SettingsList.setAdapter(ListAdapter);

		// ListView ItemClickHandler
		SettingsList
				.setOnItemClickListener(new AdapterView.OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						// TODO Auto-generated method stub
						switch (position) {

						case 0: {
							Intent about = new Intent(Settings.this,
									edu.bietdvg.davana.vtufest.About.class);
							startActivity(about);
							break;
						}

						case 1: {
							Intent settings = new Intent(
									Settings.this,
									edu.bietdvg.davana.vtufest.AdditionalCopyrights.class);
							startActivity(settings);
							break;
						}

						}
					}

				});

		// Toast For Welcoming
		Toast.makeText(getApplicationContext(),
				"This is Official App For Davana", Toast.LENGTH_SHORT).show();
		// GetActionBarUpButton
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

	}

	// InflateActionBarMenus
	@Override
	public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getSupportMenuInflater().inflate(R.menu.settings, menu);
		return true;
	}

	// Menu_CallBack
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

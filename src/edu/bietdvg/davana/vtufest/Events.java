package edu.bietdvg.davana.vtufest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;

import com.actionbarsherlock.app.SherlockActivity;

import edu.bietdvg.davana.vtufest.R;

public class Events extends SherlockActivity {

	WebView web;
	WebSettings webSettings;
	ExpandableListAdapter listAdapter;
	ExpandableListView expListView;
	List<String> listDataHeader;
	HashMap<String, List<String>> listDataChild;
	List<String> music = new ArrayList<String>();
	List<String> dance = new ArrayList<String>();
	List<String> literary = new ArrayList<String>();
	List<String> theater = new ArrayList<String>();
	List<String> fineArts = new ArrayList<String>();

	int id_child;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_events);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		expListView = (ExpandableListView) findViewById(R.id.activity_events_exp_listview);
		prepareListData();
		listAdapter = new ExpandableListAdapter(this, listDataHeader,
				listDataChild);
		expListView.setAdapter(listAdapter);

		expListView.setOnChildClickListener(new OnChildClickListener() {

			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {

				if (listDataChild.get(listDataHeader.get(groupPosition)).get(
						childPosition) == music.get(0))
					id_child = 0;
				else if (listDataChild.get(listDataHeader.get(groupPosition))
						.get(childPosition) == music.get(1))
					id_child = 1;
				else if (listDataChild.get(listDataHeader.get(groupPosition))
						.get(childPosition) == music.get(2))
					id_child = 2;
				else if (listDataChild.get(listDataHeader.get(groupPosition))
						.get(childPosition) == music.get(3))
					id_child = 3;
				else if (listDataChild.get(listDataHeader.get(groupPosition))
						.get(childPosition) == music.get(4))
					id_child = 4;
				else if (listDataChild.get(listDataHeader.get(groupPosition))
						.get(childPosition) == music.get(5))
					id_child = 5;
				else if (listDataChild.get(listDataHeader.get(groupPosition))
						.get(childPosition) == music.get(6))
					id_child = 6;
				else if (listDataChild.get(listDataHeader.get(groupPosition))
						.get(childPosition) == music.get(7))
					id_child = 7;
				else if (listDataChild.get(listDataHeader.get(groupPosition))
						.get(childPosition) == dance.get(0))
					id_child = 10;
				else if (listDataChild.get(listDataHeader.get(groupPosition))
						.get(childPosition) == dance.get(1))
					id_child = 11;
				else if (listDataChild.get(listDataHeader.get(groupPosition))
						.get(childPosition) == literary.get(0))
					id_child = 20;
				else if (listDataChild.get(listDataHeader.get(groupPosition))
						.get(childPosition) == literary.get(1))
					id_child = 21;
				else if (listDataChild.get(listDataHeader.get(groupPosition))
						.get(childPosition) == literary.get(2))
					id_child = 22;
				else if (listDataChild.get(listDataHeader.get(groupPosition))
						.get(childPosition) == theater.get(0))
					id_child = 30;
				else if (listDataChild.get(listDataHeader.get(groupPosition))
						.get(childPosition) == theater.get(1))
					id_child = 31;
				else if (listDataChild.get(listDataHeader.get(groupPosition))
						.get(childPosition) == theater.get(2))
					id_child = 32;
				else if (listDataChild.get(listDataHeader.get(groupPosition))
						.get(childPosition) == theater.get(3))
					id_child = 33;
				else if (listDataChild.get(listDataHeader.get(groupPosition))
						.get(childPosition) == fineArts.get(0))
					id_child = 40;
				else if (listDataChild.get(listDataHeader.get(groupPosition))
						.get(childPosition) == fineArts.get(1))
					id_child = 41;
				else if (listDataChild.get(listDataHeader.get(groupPosition))
						.get(childPosition) == fineArts.get(2))
					id_child = 42;
				else if (listDataChild.get(listDataHeader.get(groupPosition))
						.get(childPosition) == fineArts.get(3))
					id_child = 43;
				else if (listDataChild.get(listDataHeader.get(groupPosition))
						.get(childPosition) == fineArts.get(4))
					id_child = 44;
				else if (listDataChild.get(listDataHeader.get(groupPosition))
						.get(childPosition) == fineArts.get(5))
					id_child = 45;
				else if (listDataChild.get(listDataHeader.get(groupPosition))
						.get(childPosition) == fineArts.get(6))
					id_child = 46;

				Intent in = new Intent(getApplication(),
						edu.bietdvg.davana.vtufest.EventRules.class);
				in.putExtra("ID", id_child);
				startActivity(in);

				return false;
			}
		});

	}

	private void prepareListData() {
		listDataHeader = new ArrayList<String>();
		listDataChild = new HashMap<String, List<String>>();

		// Adding child data
		listDataHeader.add("MUSIC");
		listDataHeader.add("DANCE");
		listDataHeader.add("LITERARY EVENTS");
		listDataHeader.add("THEATER");
		listDataHeader.add("FINE ARTS");

		// Adding child data

		music.add("Classical Vocal Solo (Hindustani / Karnatak)");
		music.add("Classical  Instrumental Solo (Percussion- Tal Vadya)");
		music.add("Classical  Instrumental Solo (Non -Percussion- Swar Vadya)");
		music.add("Light Vocal (Indian)");
		music.add("Western Vocal Solo");
		music.add("Group Songs (Indian)");
		music.add("Group Songs (Western)");
		music.add("Folk Orchestra");

		dance.add("Folk/Trible Dance");
		dance.add("Classical Dance(Indian)");

		literary.add("Quiz");
		literary.add("Elocution");
		literary.add("Debate");

		theater.add("One Act Play");
		theater.add("Skit");
		theater.add("Mime");
		theater.add("Mimicry");

		fineArts.add("On Spot Painting");
		fineArts.add("Collage");
		fineArts.add("Poster Making");
		fineArts.add("Clay Modeling");
		fineArts.add("Cartooning");
		fineArts.add("Rangoli");
		fineArts.add("Spot Photography");

		listDataChild.put(listDataHeader.get(0), music); // Header, Child data
		listDataChild.put(listDataHeader.get(1), dance);
		listDataChild.put(listDataHeader.get(2), literary);
		listDataChild.put(listDataHeader.get(3), theater);
		listDataChild.put(listDataHeader.get(4), fineArts);
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

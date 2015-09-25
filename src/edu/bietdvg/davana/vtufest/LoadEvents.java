package edu.bietdvg.davana.vtufest;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import edu.bietdvg.davana.vtufest.R;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

class LoadEvents extends AsyncTask<String, String, String> {

	int success, cat;
	private static final String URL = "http://davana.bietdvg.edu/live_events/";
	private static final String TAG_SUCCESS = "success";
	private static final String TAG_EVENTS = "events";
	private static final String TAG_EVENT_NAME = "event_name";
	private static final String TAG_EVENT_ID = "event_id";
	private static final String TAG_TIME = "time";
	private static final String TAG_NOTIFY = "notify";

	JSONParser jParser = new JSONParser();
	JSONArray events = null;
	TextView tv_music, tv_dance, tv_literary, tv_theater, tv_fineArts,
			tv_announcement;
	TextView tv_music_t, tv_dance_t, tv_literary_t, tv_theater_t,
			tv_fineArts_t;
	View Right, Main;
	String music, dance, literary, theater, fine;
	String t_music, t_dance, t_literary, t_theater, t_fine;
	String notifications;

	public LoadEvents(View r) {
		Right = r;
	}

	@Override
	protected String doInBackground(String... params) {

		List<NameValuePair> param = new ArrayList<NameValuePair>();
		JSONObject json = jParser.makeHttpRequest(URL, "GET", param);
		Log.d("Events:", json.toString());
		try {
			success = json.getInt(TAG_SUCCESS);
			if (success == 1) {
				notifications = json.getString(TAG_NOTIFY);
				events = json.getJSONArray(TAG_EVENTS);
				for (int i = 0; i < events.length(); i++) {
					JSONObject c = events.getJSONObject(i);
					cat = c.getInt(TAG_EVENT_ID);
					switch (cat) {
					case 0:
						music = c.getString(TAG_EVENT_NAME);
						t_music = c.getString(TAG_TIME);
						break;
					case 1:
						dance = c.getString(TAG_EVENT_NAME);
						t_dance = c.getString(TAG_TIME);
						break;
					case 2:
						literary = c.getString(TAG_EVENT_NAME);
						t_literary = c.getString(TAG_TIME);
						break;
					case 3:
						theater = c.getString(TAG_EVENT_NAME);
						t_theater = c.getString(TAG_TIME);
						break;
					case 4:
						fine = c.getString(TAG_EVENT_NAME);
						t_fine = c.getString(TAG_TIME);
						break;
					}

				}

			}

		} catch (JSONException e) {
			e.printStackTrace();
		}	
		
		return null;
	}

	@SuppressLint("ResourceAsColor")
	@Override
	protected void onPostExecute(String result) {
		tv_music = (TextView) Right.findViewById(R.id.tv_music);
		tv_dance = (TextView) Right.findViewById(R.id.tv_dance);
		tv_literary = (TextView) Right.findViewById(R.id.tv_literary);
		tv_theater = (TextView) Right.findViewById(R.id.tv_theater);
		tv_fineArts = (TextView) Right.findViewById(R.id.tv_fineArts);
		tv_announcement = (TextView) Right.findViewById(R.id.notifications);

		tv_music_t = (TextView) Right.findViewById(R.id.header_music);
		tv_dance_t = (TextView) Right.findViewById(R.id.header_dance);
		tv_literary_t = (TextView) Right.findViewById(R.id.header_literary);
		tv_theater_t = (TextView) Right.findViewById(R.id.header_theater);
		tv_fineArts_t = (TextView) Right.findViewById(R.id.header_fineArts);

		if (success == 1) {
			if (notifications != null) {
				tv_announcement.setText(notifications);
				tv_announcement.setTextColor(Color.parseColor("#ffcd12"));
			} else
				tv_announcement.setText(R.string.no_announcements_yet);

			if (music != null) {
				tv_music.setText(music);
				tv_music.setTextColor(Color.parseColor("#99D890"));
				tv_music_t.setText("Music" + t_music);

			} else
				tv_music.setText(R.string.slider_right_no_events);

			if (dance != null) {
				tv_dance.setText(dance);
				tv_dance.setTextColor(Color.parseColor("#99D890"));
				tv_dance_t.setText("Dance" + t_dance);
			} else
				tv_dance.setText(R.string.slider_right_no_events);

			if (literary != null) {
				tv_literary.setText(literary);
				tv_literary.setTextColor(Color.parseColor("#99D890"));
				tv_literary_t.setText("Literary Events" + t_literary);

			} else
				tv_literary.setText(R.string.slider_right_no_events);

			if (theater != null) {
				tv_theater.setText(theater);
				tv_theater.setTextColor(Color.parseColor("#99D890"));
				tv_theater_t.setText("Theater" + t_theater);
			} else
				tv_theater.setText(R.string.slider_right_no_events);

			if (fine != null) {
				tv_fineArts.setText(fine);
				tv_fineArts.setTextColor(Color.parseColor("#99D890"));
				tv_fineArts_t.setText("Fine Arts" + t_fine);
			} else
				tv_fineArts.setText(R.string.slider_right_no_events);

		}
		super.onPostExecute(result);
	}

	@Override
	protected void onPreExecute() {
		tv_music = (TextView) Right.findViewById(R.id.tv_music);
		tv_dance = (TextView) Right.findViewById(R.id.tv_dance);
		tv_literary = (TextView) Right.findViewById(R.id.tv_literary);
		tv_theater = (TextView) Right.findViewById(R.id.tv_theater);
		tv_fineArts = (TextView) Right.findViewById(R.id.tv_fineArts);
		tv_announcement = (TextView) Right.findViewById(R.id.notifications);
		
		tv_music_t = (TextView) Right.findViewById(R.id.header_music);
		tv_dance_t = (TextView) Right.findViewById(R.id.header_dance);
		tv_literary_t = (TextView) Right.findViewById(R.id.header_literary);
		tv_theater_t = (TextView) Right.findViewById(R.id.header_theater);
		tv_fineArts_t = (TextView) Right.findViewById(R.id.header_fineArts);

		tv_music.setText("Loading...");
		tv_dance.setText("Loading...");
		tv_literary.setText("Loading...");
		tv_theater.setText("Loading...");
		tv_fineArts.setText("Loading...");
		tv_announcement.setText("Loading...");
		
		
		tv_music.setTextColor(Color.parseColor("#F2F4C9"));
		tv_dance.setTextColor(Color.parseColor("#F2F4C9"));
		tv_literary.setTextColor(Color.parseColor("#F2F4C9"));
		tv_theater.setTextColor(Color.parseColor("#F2F4C9"));
		tv_fineArts.setTextColor(Color.parseColor("#F2F4C9"));
		tv_announcement.setTextColor(Color.parseColor("#F2F4C9"));
		
		tv_music_t.setText(R.string.slider_right_music);
		tv_dance_t.setText(R.string.slider_right_dance);
		tv_literary_t.setText(R.string.slider_right_literary);
		tv_theater_t.setText(R.string.slider_right_theater);
		tv_fineArts_t.setText(R.string.slider_right_fine);
		
		
		tv_music_t.setTextColor(Color.parseColor("#D28989"));
		tv_dance_t.setTextColor(Color.parseColor("#D28989"));
		tv_literary_t.setTextColor(Color.parseColor("#D28989"));
		tv_theater_t.setTextColor(Color.parseColor("#D28989"));
		tv_fineArts_t.setTextColor(Color.parseColor("#D28989"));
		
		super.onPreExecute();
	}

}

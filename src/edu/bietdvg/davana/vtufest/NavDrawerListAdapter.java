package edu.bietdvg.davana.vtufest;

import java.util.ArrayList;

import edu.bietdvg.davana.vtufest.R;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NavDrawerListAdapter extends BaseAdapter {

	private Context context;
	private ArrayList<NavDrawerItems> navDrawerItems;

	public NavDrawerListAdapter(Context context,
			ArrayList<NavDrawerItems> navDrawerItems) {
		super();
		this.context = context;
		this.navDrawerItems = navDrawerItems;
	}

	@Override
	public int getCount() {
		return navDrawerItems.size();

	}

	@Override
	public Object getItem(int position) {
		return navDrawerItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			LayoutInflater mInflater = (LayoutInflater) context
					.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
			convertView = mInflater.inflate(R.layout.custom_list, null);
		}
		ImageView imgIcon = (ImageView) convertView
				.findViewById(R.id.list_image_view);
		TextView txtTitle = (TextView) convertView
				.findViewById(R.id.list_text_view);
		imgIcon.setImageResource(navDrawerItems.get(position).getIcon());
		txtTitle.setText(navDrawerItems.get(position).getTitle());
		return convertView;
	}

}

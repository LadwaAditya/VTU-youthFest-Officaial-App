package edu.bietdvg.davana.vtufest;

public class NavDrawerItems {
	private String Title;
	private int icon;

	public NavDrawerItems(String title, int icon) {
		super();
		Title = title;
		this.icon = icon;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public void setIcon(int icon) {
		this.icon = icon;
	}

	public String getTitle() {
		return Title;
	}

	public int getIcon() {
		return icon;
	}

}

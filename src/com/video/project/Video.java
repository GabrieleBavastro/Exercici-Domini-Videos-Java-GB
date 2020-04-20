package com.video.project;

public class Video {
	private static String url;
	private static String title;
	private static String tags;

	public Video(String title, String url, String tags) {
		
		this.setTitle(title);
		this.setUrl("https://futurevideos.com/"+(title));
		this.setTags(tags);
	}

	public static String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		Video.url = url;
	}

	public static String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		Video.title = title;
	}
	public static String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		Video.tags = tags;
	}
	
	@Override
    public String toString() {
        return "Title: "+ Video.getTitle() + "\n URL: " + Video.getUrl() + "\n Tag List: " + Video.getTags();
    }

}
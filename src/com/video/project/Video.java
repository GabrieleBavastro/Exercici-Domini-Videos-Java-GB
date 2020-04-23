package com.video.project;

public class Video {

	private static int ID_COUNTER = 1; 
		
	int Id;
	String Title;
	String URL;
	String tags;
	
	public Video(String title, String uRL, String tags) {
		Id = ID_COUNTER;
		ID_COUNTER++;
		
		this.setTitle(title);
		this.setURL(uRL);
		this.setTags(tags);
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "Video [Id=" + Id + ", Title=" + Title + ", URL=" + URL + ", tags=" + tags + "]";
	}
}
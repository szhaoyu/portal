package com.brick.core;

public enum MoviePathFragment implements PathFragment {
	
	NEW("new"), 
	COMMENTS("comments"), 
	TAGS("tags"), 
	EDIT("edit"),
	MOVIES("movies"), 
	NAVIGATION("navigation"),
	ACTORS("actors");
	
	private String name;

	private MoviePathFragment(String name) {
		this.name = name;
	}


	@Override
	public String getName() {
		return name;
	}
	
}

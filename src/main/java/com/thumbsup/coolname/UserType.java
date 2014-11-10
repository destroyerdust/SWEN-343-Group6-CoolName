package com.thumbsup.coolname;

public enum UserType {
	
	ADMIN(1),
	PASSENGER(2),
	DRIVER(3);
	
	private final Integer id;

	private UserType(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
}

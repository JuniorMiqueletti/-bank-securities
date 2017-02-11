package com.juniormiqueletti.model;

public enum Status {
	PENDING("Pending"), RECEIVED("Received");

	private String decription;

	Status(String description) {
		this.decription = description;
	}

	public String getDecription() {
		return decription;
	}

}

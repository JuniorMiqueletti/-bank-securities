package com.juniormiqueletti.model;

public enum Status {
	PENDING("Pending"), RECEIVED("Received"), CANCELED("Canceled");

	private String description;

	Status(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}

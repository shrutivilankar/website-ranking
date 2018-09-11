package com.assignment.report.websites.resources.models;

import java.util.Arrays;

/**
 * Enumeration to define multiple sort options provided for website data
 * retrieval
 * @value SortOptions.MostVisits,SortOptions.LeastVisits
 * @author shruti
 *
 */
public enum SortOptions {

	// TODO enhance sort option to find most visits
	MostVisits("noOfVisitsDesc"), LeastVisits("noOfVisitsAsc");

	private String value;

	private SortOptions(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static SortOptions fromValue(String value) {
		for (SortOptions category : values()) {
			if (category.name().equalsIgnoreCase(value)) {
				return category;
			}
		}
		throw new IllegalArgumentException(
				"Unknown enum type " + value + ", Allowed values are " + Arrays.toString(values()));
	}
}

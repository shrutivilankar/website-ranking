package com.assignment.report.websites.resources.helpers;

import java.beans.PropertyEditorSupport;

import com.assignment.report.websites.resources.models.SortOptions;

/**
 * Property editor for Sort options
 * @author shruti
 */
public class SortOptionsConverter extends PropertyEditorSupport {

	 public void setAsText(final String text) throws IllegalArgumentException {
	        setValue(SortOptions.fromValue(text));
	    }


}

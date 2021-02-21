package com.project.dao.jdbc;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class DaoResource {
	private static final String BUNDLE_NAME = "com.project.dao.jdbc.database";

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	private DaoResource() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}

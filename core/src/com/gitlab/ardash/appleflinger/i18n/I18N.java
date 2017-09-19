/*******************************************************************************
 * Copyright (C) 2015-2017 Andreas Redmer <andreasredmer@mailchuck.com>
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package com.gitlab.ardash.appleflinger.i18n;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;

public class I18N {
	
	public enum k{
		gameName,startNewGame
	}

//	private static final String BUNDLE_NAME = "com.gitlab.ardash.appleflinger.i18n.af"; //$NON-NLS-1$

//	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);
	
	// the following line need to be in release, otherwise the class wont be found after optimization
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle (getBundleBaseName());

	private I18N() {
	}
	
	private static String getBundleBaseName()
	{
		if (Gdx.app.getType() == ApplicationType.Android)
		switch (Gdx.app.getType()) {
		case Android:
			return "assets/af";
		case Applet:
			return "";
		case Desktop:
			return "com.gitlab.ardash.appleflinger.i18n.af";
		case HeadlessDesktop:
			return "com.gitlab.ardash.appleflinger.i18n.af";
		case WebGL:
			return "";
		case iOS:
			return "";
		}
		throw new RuntimeException("Unknown application type");
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
	
	public static String s(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
	
	public static String g(k key) {
		return RESOURCE_BUNDLE.getString(key.name());
	}
}

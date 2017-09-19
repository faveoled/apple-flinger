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
package com.gitlab.ardash.appleflinger.testing.sanity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import com.gitlab.ardash.appleflinger.global.GameManager;

public class DeploymentSanityUnitTest {

	@Test
	public void oneEqualsOne() {
		assertEquals(1, 1);
	}

	@Test
	public void isDebugDisabled() {
		assertFalse(GameManager.DEBUG);
	}

	@Test
	public void isDebugZoomDisabled() {
		assertFalse(GameManager.DEBUGZOOM);
	}

	@Test
	public void isSandboxDisabled() {
		assertFalse(GameManager.SANDBOX);
	}

	@Test
	public void isAlllevelsDisabled() {
		assertFalse(GameManager.ALLLEVELS);
	}
}

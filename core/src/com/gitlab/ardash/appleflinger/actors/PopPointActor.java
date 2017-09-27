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
package com.gitlab.ardash.appleflinger.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import com.gitlab.ardash.appleflinger.GameWorld;
import com.gitlab.ardash.appleflinger.global.Assets;
import com.gitlab.ardash.appleflinger.helpers.LinearInterpolator;

public class PopPointActor extends Label {

	private final float targetSeconds;
	private float secondsVisible;

	public PopPointActor(String text, float x, float y, Color color) {
		super(text, getLabelStyle(color));

		targetSeconds = 1f;
		secondsVisible = 0f;

		setWidth(50);
		setPosition(x * GameWorld.UNIT_TO_SCREEN, y * GameWorld.UNIT_TO_SCREEN);
		setAlignment(Align.center);
		// final Matrix4 invProjectionView =
		// GameManager.getInstance().currentGameScreen.getGuiStage().getCamera().invProjectionView;
		// Vector3 position = new Vector3();
		// invProjectionView.getTranslation(position);
		// setPosition(position.x+150, position.y+10);
		// setWidth(5);
		// setAlignment(Align.center);
		// setScale(1112.1f);
		
	}
	public PopPointActor(String text, float x, float y) {
		this(text, x, y, Color.WHITE);
	}
	/**
	 * @param color 
	 * @return
	 */
	private static LabelStyle getLabelStyle(Color color) {
		final LabelStyle labelstyle = new LabelStyle();
		labelstyle.font = Assets.FontAsset.FLINGER_A75_B5_WB_POINT_POP.font;
		//labelstyle.fontColor = Color.WHITE;
		if (color != null)
			labelstyle.fontColor = color;
		return labelstyle;
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		secondsVisible += Gdx.graphics.getDeltaTime();
		adjustZoomByTime();
		if (secondsVisible >= targetSeconds)
			remove();
		super.draw(batch, parentAlpha);
	}

	private void adjustZoomByTime() {
		final float minZoom = 0.1f;
		final float maxZoom = 1.0f;
		float newZoom;
		newZoom = LinearInterpolator.ilx(0f, minZoom, 1f, maxZoom,
				secondsVisible);
		if (secondsVisible > (targetSeconds / 2f))
			newZoom = 1f - newZoom;
		if (newZoom>0f)
		{
			this.setFontScale(newZoom);
		}
	}

}

package com.davedev.game;

import com.badlogic.gdx.math.Polygon;

public class TetrisBlock extends Polygon {
	private float[] color;
	
	public TetrisBlock(float[] vertices) {
		super(vertices);
	}
	
	public TetrisBlock(float[] vertices, float red, float green, float blue, float alpha) {
		super(vertices);
		this.color = new float[]{ red, green, blue, alpha };
	}

	public TetrisBlock(float red, float green, float blue, float alpha) {
		super();
		this.color = new float[]{ red, green, blue, alpha };
	}
	
	public void setColor(float red, float green, float blue, float alpha) {
		this.color = new float[]{ red, green, blue, alpha };
	}
	
	public float[] getColor() {
		return this.color;
	}
}

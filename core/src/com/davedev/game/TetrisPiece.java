package com.davedev.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Polygon;

public class TetrisPiece {
	
	TetrisPieceShape shape;
	ArrayList<TetrisBlock> blocks;
	
	//Modifiers for the placement of vertices in relation to the vertices of the root block
	private int[][] xmods;
	private int[][] ymods;
	private int currentMod;
	private int maxMod;
	
	private float[] root; //Vertices for the root block;
	
	private final float BLOCKSIZE = 30.0f;
	
	public TetrisPiece(TetrisPieceShape shape) {
		this.shape = shape;
		this.blocks = new ArrayList<TetrisBlock>(4);
		this.currentMod = 0;
		
		int xmod = 6;
		int ymod = 4;
		
		//For each block, the blocks can be described in relation to the root block. xmods and ymods define 
		// where each block is on the x and y plane in relation to the root block for each rotation. Each
		// array in xmods and ymods defines a new rotation, with xmod[0][0] and ymod[0][0] defining the 
		// position of one block in relation to root in the 0th rotation
		switch(shape) {
		case I:			
			this.shape = TetrisPieceShape.I;
			this.maxMod = 2;
			xmods = new int[][] {
				new int[] { 0, 0, 0},
				new int[] { -3, -2, -1 }
			};
			ymods = new int[][] {
				new int[] { 1, 2, 3},
				new int[] { 0, 0, 0}
			};
			
			this.root = new float[] {
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * ymod),		//Bottom left
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Top left
				BLOCKSIZE * xmod, 		Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Top right
				BLOCKSIZE * xmod, 		Gdx.graphics.getHeight() - (BLOCKSIZE * ymod) 		//Bottom right
			};
			break;
		case J: //TODO Add more rotations
			this.shape = TetrisPieceShape.J;
			this.maxMod = 2;
			xmods = new int[][] {
				new int[] { -1, 0, 0 },
				new int[] { 0, 1, 2 },
				new int[] { 1, 0, 0 },
				new int[] { 0, -1, -2 }
			};
			ymods = new int[][] {
				new int[] { 0, 1, 2 },
				new int[] { 1, 0, 0 },
				new int[] { 0, -1, -2 },
				new int[] { -1, 0, 0 }
			};
			//Bottom block (also root block)
			this.root = new float[] {
				BLOCKSIZE * (xmod - 2), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 0)),//Bottom left
				BLOCKSIZE * (xmod - 2), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Top left
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Top right
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 0)) //Bottom right
			};
			break;
		case L: 
			this.shape = TetrisPieceShape.L;
			this.maxMod = 2;
			xmods = new int[][] {
				new int[] { 0, 0, 1 },
				new int[] { -2, -1, 0 },
				new int[] { -1, 0, 0 },
				new int[] { 0, 1, 2 }
			};
			ymods = new int[][] {
				new int[] { 1, 2, 0 },
				new int[] { 0, 0, 1 },
				new int[] { 0, -1, -2 },
				new int[] { -1, 0, 0 }
			};
			//Bottom block (also root block)
			this.root = new float[] {
				BLOCKSIZE * xmod,		Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 0)),//Bottom left
				BLOCKSIZE * xmod, 		Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Top left
				BLOCKSIZE * (xmod + 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Top right
				BLOCKSIZE * (xmod + 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 0)) //Bottom right
			};
			break;
		case O:
			this.shape = TetrisPieceShape.O;
			this.maxMod = 0;
			xmods = new int[][] {
				new int[] { 0, 1, 1 }
			};
			ymods = new int[][] {
				new int[] { 1, 1, 0 }
			};
			//Bottom block (also root block)
			this.root = new float[] {
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * ymod),		//Bottom left
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Top left
				BLOCKSIZE * xmod, 		Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Top right
				BLOCKSIZE * xmod, 		Gdx.graphics.getHeight() - (BLOCKSIZE * ymod) 		//Bottom right
			};
			break;
		case S:
			this.shape = TetrisPieceShape.S;
			this.maxMod = 1;
			xmods = new int[][] {
				new int[] { 1, 1, 2 },
				new int[] { 0, -1, -1 }
			};
			ymods = new int[][] {
				new int[] { 0, 1, 1 },
				new int[] { 1, 1, 2}
			};
			//Bottom block (also root block)
			this.root = new float[] {
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 0)),//Bottom left
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Top left
				BLOCKSIZE * (xmod - 0),	Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Top right
				BLOCKSIZE * (xmod - 0),	Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 0))	//Bottom right
			};
			break;
		case T:	
			this.shape = TetrisPieceShape.T;
			this.maxMod = 4;
			xmods = new int[][] {
				new int[] { 1, 1, 2 },
				new int[] { 0, -1, 0 },
				new int[] { 1, 1, 2 },
				new int[] { 0, 1, 0}
			};
			ymods = new int[][] {
				new int[] { 0, 1, 0 },
				new int[] { 1, 1, 2 },
				new int[] { 0, -1, 0},
				new int[] { 1, 1, 2 }
			};
			//Bottom block (also root block)
			this.root = new float[] {
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 0)),//Bottom left
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Top left
				BLOCKSIZE * (xmod - 0),	Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Top right
				BLOCKSIZE * (xmod - 0),	Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 0))	//Bottom right
			};
			break;
		case Z: 
			this.shape = TetrisPieceShape.Z;
			this.maxMod = 1;
			xmods = new int[][] {
				new int[] { -1, -1, -2 },
				new int[] { 0, 1, 1}
			};
			ymods = new int[][] {
				new int[] { 0, 1, 1 },
				new int[] { 1, 1, 2}
			};
			//Bottom block (also root block)
			this.root = new float[] {
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 0)),//Bottom left
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Top left
				BLOCKSIZE * (xmod - 0),	Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Top right
				BLOCKSIZE * (xmod - 0),	Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 0))	//Bottom right
			};
			break;
		default:
			this.shape = TetrisPieceShape.I;
			this.maxMod = 1;
			xmods = new int[][] {
				new int[] { 0, 0, 0},
				new int[] { }
			};
			ymods = new int[][] {
				new int[] { 1, 2, 3},
				new int[] { }
			};
			
			this.root = new float[] {
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * ymod),		//Bottom left
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Top left
				BLOCKSIZE * xmod, 		Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Top right
				BLOCKSIZE * xmod, 		Gdx.graphics.getHeight() - (BLOCKSIZE * ymod) 		//Bottom right
			};
			break;
		}
		createShape();
	}
	
	public void turn() {		
		this.currentMod = (this.currentMod + 1) % this.xmods.length;			
		this.root = this.blocks.get(0).getTransformedVertices();
		this.blocks = new ArrayList<>();
		
		createShape();
	}
	
	/**
	 * Create the shape's blocks based off the root and modifiers
	 */
	private void createShape() {
		float[] newBlock;
		
		blocks.add(new TetrisBlock(this.root));
		
		for(int n = 0; n < 3; n++) { //Determines which x/y mod for each block being created
			newBlock = new float[8];
			for(int i = 0; i < 8; i++) { //Goes through each vertex
				if(i % 2 == 0) 
					newBlock[i] = this.root[i] + (BLOCKSIZE * this.xmods[this.currentMod][n]);
				else 
					newBlock[i] = this.root[i] + (BLOCKSIZE * this.ymods[this.currentMod][n]);
			}
			blocks.add(new TetrisBlock(newBlock));
		}
	}
	
	public void translate(float x, float y) {
		this.blocks.stream().forEach(p -> p.translate(x, y));
	}

	public TetrisPieceShape getShape() {
		return shape;
	}

	public void setShape(TetrisPieceShape shape) {
		this.shape = shape;
	}

	public ArrayList<TetrisBlock> getBlocks() {
		return blocks;
	}

	public void setBlocks(ArrayList<TetrisBlock> blocks) {
		this.blocks = blocks;
	}

	public float getBLOCKSIZE() {
		return BLOCKSIZE;
	}

	public float[] getRoot() {
		return root;
	}

	public void setRoot(float[] root) {
		this.root = root;
	}	
}

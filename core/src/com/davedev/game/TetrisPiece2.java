package com.davedev.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Polygon;

public class TetrisPiece2 {
	
	TetrisPieceShape shape;
	ArrayList<TetrisBlock> blocks;
	
	private final float BLOCKSIZE = 30.0f;
	
	public TetrisPiece2(TetrisPieceShape shape) {
		this.shape = shape;
		this.blocks = new ArrayList<TetrisBlock>(4);
		
		int xmod = 6;
		int ymod = 4;
		
		switch(shape) {
		case I:
			//Bottom block (also root block)
			blocks.add(new TetrisBlock(new float[] {
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * ymod),		//Bottom left
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Top left
				BLOCKSIZE * xmod, 		Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Top right
				BLOCKSIZE * xmod, 		Gdx.graphics.getHeight() - (BLOCKSIZE * ymod) 		//Bottom right
			}));
			//Second block
			blocks.add(new TetrisBlock(new float[] {
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Bottom left
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 2)),//Top left
				BLOCKSIZE * xmod, 		Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 2)),//Top right
				BLOCKSIZE * xmod, 		Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)) //Bottom right
			}));
			//Third block
			blocks.add(new TetrisBlock(new float[] {
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 2)),//Bottom left
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 3)),//Top left
				BLOCKSIZE * xmod, 		Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 3)),//Top right
				BLOCKSIZE * xmod, 		Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 2))	//Bottom right
			}));
			//End block
			blocks.add(new TetrisBlock(new float[] {
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 3)),//Bottom left
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 4)),//Top left
				BLOCKSIZE * xmod, 		Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 4)),//Top right
				BLOCKSIZE * xmod, 		Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 3)) //Bottom right
			}));
			break;
		case J:
			//Bottom block (also root block)
			blocks.add(new TetrisBlock(new float[] {
				BLOCKSIZE * (xmod - 2), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 2)),//Bottom left
				BLOCKSIZE * (xmod - 2), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Top left
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Top right
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 2)) //Bottom right
			}));
			//Second block
			blocks.add(new TetrisBlock(new float[] {
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Bottom left
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 2)),//Top left
				BLOCKSIZE * xmod, 		Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 2)),//Top right
				BLOCKSIZE * xmod, 		Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)) //Bottom right
			}));
			//Third block
			blocks.add(new TetrisBlock(new float[] {
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 2)),//Bottom left
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 3)),//Top left
				BLOCKSIZE * xmod, 		Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 3)),//Top right
				BLOCKSIZE * xmod, 		Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 2))	//Bottom right
			}));
			//End block
			blocks.add(new TetrisBlock(new float[] {
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 3)),//Bottom left
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 4)),//Top left
				BLOCKSIZE * xmod, 		Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 4)),//Top right
				BLOCKSIZE * xmod, 		Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 3)) //Bottom right
			}));
			break;
		case L:
			//Bottom block (also root block)
			blocks.add(new TetrisBlock(new float[] {
				BLOCKSIZE * xmod,		Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 2)),//Bottom left
				BLOCKSIZE * xmod, 		Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Top left
				BLOCKSIZE * (xmod + 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Top right
				BLOCKSIZE * (xmod + 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 2)) //Bottom right
			}));
			//Second block
			blocks.add(new TetrisBlock(new float[] {
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Bottom left
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 2)),//Top left
				BLOCKSIZE * xmod, 		Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 2)),//Top right
				BLOCKSIZE * xmod, 		Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)) //Bottom right
			}));
			//Third block
			blocks.add(new TetrisBlock(new float[] {
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 2)),//Bottom left
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 3)),//Top left
				BLOCKSIZE * xmod, 		Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 3)),//Top right
				BLOCKSIZE * xmod, 		Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 2))	//Bottom right
			}));
			//End block
			blocks.add(new TetrisBlock(new float[] {
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 3)),//Bottom left
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 4)),//Top left
				BLOCKSIZE * xmod, 		Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 4)),//Top right
				BLOCKSIZE * xmod, 		Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 3)) //Bottom right
			}));
			break;
		case O:
			//Bottom block (also root block)
			blocks.add(new TetrisBlock(new float[] {
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * ymod),		//Bottom left
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Top left
				BLOCKSIZE * xmod, 		Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Top right
				BLOCKSIZE * xmod, 		Gdx.graphics.getHeight() - (BLOCKSIZE * ymod) 		//Bottom right
			}));
			//Second block
			blocks.add(new TetrisBlock(new float[] {
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Bottom left
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 2)),//Top left
				BLOCKSIZE * xmod, 		Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 2)),//Top right
				BLOCKSIZE * xmod, 		Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)) //Bottom right
			}));
			//Third block
			blocks.add(new TetrisBlock(new float[] {
				BLOCKSIZE * (xmod - 0), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Bottom left
				BLOCKSIZE * (xmod - 0), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 2)),//Top left
				BLOCKSIZE * (xmod + 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 2)),//Top right
				BLOCKSIZE * (xmod + 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1))	//Bottom right
			}));
			//End block
			blocks.add(new TetrisBlock(new float[] {
				BLOCKSIZE * (xmod - 0), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 0)),//Bottom left
				BLOCKSIZE * (xmod - 0), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Top left
				BLOCKSIZE * (xmod + 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Top right
				BLOCKSIZE * (xmod + 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 0)) //Bottom right
			}));
			break;
		case S:
			//Bottom block (also root block)
			blocks.add(new TetrisBlock(new float[] {
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 0)),//Bottom left
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Top left
				BLOCKSIZE * (xmod - 0),	Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Top right
				BLOCKSIZE * (xmod - 0),	Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 0))	//Bottom right
			}));
			//Second block
			blocks.add(new TetrisBlock(new float[] {
				BLOCKSIZE * (xmod - 0), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 0)),//Bottom left
				BLOCKSIZE * (xmod - 0), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Top left
				BLOCKSIZE * (xmod + 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Top right
				BLOCKSIZE * (xmod + 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 0)) //Bottom right
			}));
			//Third block
			blocks.add(new TetrisBlock(new float[] {
				BLOCKSIZE * (xmod - 0), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Bottom left
				BLOCKSIZE * (xmod - 0), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 2)),//Top left
				BLOCKSIZE * (xmod + 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 2)),//Top right
				BLOCKSIZE * (xmod + 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1))	//Bottom right
			}));
			//End block
			blocks.add(new TetrisBlock(new float[] {
				BLOCKSIZE * (xmod + 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Bottom left
				BLOCKSIZE * (xmod + 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 2)),//Top left
				BLOCKSIZE * (xmod + 2), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 2)),//Top right
				BLOCKSIZE * (xmod + 2), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)) //Bottom right
			}));
			break;
		case T:	
			//Bottom block (also root block)
			blocks.add(new TetrisBlock(new float[] {
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 0)),//Bottom left
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Top left
				BLOCKSIZE * (xmod - 0),	Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Top right
				BLOCKSIZE * (xmod - 0),	Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 0))	//Bottom right
			}));
			//Second block
			blocks.add(new TetrisBlock(new float[] {
				BLOCKSIZE * (xmod - 0), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 0)),//Bottom left
				BLOCKSIZE * (xmod - 0), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Top left
				BLOCKSIZE * (xmod + 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Top right
				BLOCKSIZE * (xmod + 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 0)) //Bottom right
			}));
			//Third block
			blocks.add(new TetrisBlock(new float[] {
				BLOCKSIZE * (xmod + 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 0)),//Bottom left
				BLOCKSIZE * (xmod + 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Top left
				BLOCKSIZE * (xmod + 2), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Top right
				BLOCKSIZE * (xmod + 2), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 0))	//Bottom right
			}));
			//End block
			blocks.add(new TetrisBlock(new float[] {
				BLOCKSIZE * (xmod - 0), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Bottom left
				BLOCKSIZE * (xmod - 0), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 2)),//Top left
				BLOCKSIZE * (xmod + 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 2)),//Top right
				BLOCKSIZE * (xmod + 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)) //Bottom right
			}));
			break;
		case Z: //TODO: Make Z Block
			//Bottom block (also root block)
			blocks.add(new TetrisBlock(new float[] {
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 0)),//Bottom left
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Top left
				BLOCKSIZE * (xmod - 0),	Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Top right
				BLOCKSIZE * (xmod - 0),	Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 0))	//Bottom right
			}));
			//Second block
			blocks.add(new TetrisBlock(new float[] {
				BLOCKSIZE * (xmod - 2), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 0)),//Bottom left
				BLOCKSIZE * (xmod - 2), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Top left
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Top right
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 0)) //Bottom right
			}));
			//Third block
			blocks.add(new TetrisBlock(new float[] {
				BLOCKSIZE * (xmod - 2), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Bottom left
				BLOCKSIZE * (xmod - 2), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 2)),//Top left
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 2)),//Top right
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1))	//Bottom right
			}));
			//End block
			blocks.add(new TetrisBlock(new float[] {
				BLOCKSIZE * (xmod - 3), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Bottom left
				BLOCKSIZE * (xmod - 3), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 2)),//Top left
				BLOCKSIZE * (xmod - 2), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 2)),//Top right
				BLOCKSIZE * (xmod - 2), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)) //Bottom right
			}));
			break;
		default:
			//Bottom block (also root block)
			blocks.add(new TetrisBlock(new float[] {
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 0)),//Bottom left
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Top left
				BLOCKSIZE * (xmod - 0),	Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Top right
				BLOCKSIZE * (xmod - 0),	Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 0))	//Bottom right
			}));
			//Second block
			blocks.add(new TetrisBlock(new float[] {
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)),//Bottom left
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 2)),//Top left
				BLOCKSIZE * (xmod - 0), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 2)),//Top right
				BLOCKSIZE * (xmod - 0), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 1)) //Bottom right
			}));
			//Third block
			blocks.add(new TetrisBlock(new float[] {
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 2)),//Bottom left
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 3)),//Top left
				BLOCKSIZE * (xmod - 0), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 3)),//Top right
				BLOCKSIZE * (xmod - 0), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 2))	//Bottom right
			}));
			//End block
			blocks.add(new TetrisBlock(new float[] {
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 3)),//Bottom left
				BLOCKSIZE * (xmod - 1), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 4)),//Top left
				BLOCKSIZE * (xmod - 0), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 4)),//Top right
				BLOCKSIZE * (xmod - 0), Gdx.graphics.getHeight() - (BLOCKSIZE * (ymod - 3)) //Bottom right
			}));
			break;
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
}

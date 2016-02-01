package com.davedev.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;

public class Tetris extends ApplicationAdapter {
	
	private final boolean DEBUG = false;
	private final int BLOCKSIZE = 30;

	private float WIDTH;
	
	private Texture I;
	private Texture J;
	private Texture L;
	private Texture O;
	private Texture S;
	private Texture T;
	private Texture Z;
	
	private TetrisPiece playerPiece;
	
	//private Polygon checker;
	
	private ArrayList<TetrisPiece> lockedPieces; //Collection to store pieces have reached the bottom of landed on another piece
	
	private boolean canMoveDown;
	
	private long gravity; //Amount of time the game waits before moving a piece down
	private long lastDownTime;
	
	private OrthographicCamera camera;
	ShapeRenderer shapeRenderer;
	
	@Override
	public void create() {
		this.lockedPieces = new ArrayList<TetrisPiece>();
		this.lastDownTime = TimeUtils.nanoTime();
		this.gravity = 1000000000;
		this.WIDTH = Gdx.graphics.getWidth();
		
		I = new Texture(Gdx.files.internal("I.png"));
		J = new Texture(Gdx.files.internal("J.png"));
		L = new Texture(Gdx.files.internal("L.png"));
		O = new Texture(Gdx.files.internal("O.png"));
		S = new Texture(Gdx.files.internal("S.png"));
		T = new Texture(Gdx.files.internal("T.png"));
		Z = new Texture(Gdx.files.internal("Z.png"));
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false);
		
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setAutoShapeType(true);
	}
	
	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		
		if(this.playerPiece == null) {
			//this.playerPiece = new TetrisPiece(TetrisPieceShape.I);
			this.playerPiece = new TetrisPiece(TetrisPieceShape.J);
			//this.playerPiece = new TetrisPiece(TetrisPieceShape.L);
			//this.playerPiece = new TetrisPiece(TetrisPieceShape.O);
			//this.playerPiece = new TetrisPiece(TetrisPieceShape.S);
			//this.playerPiece = new TetrisPiece(TetrisPieceShape.T);
			//this.playerPiece = new TetrisPiece(TetrisPieceShape.Z);
		}
		
		canMoveDown = canMoveDown();
		
		//Naturally move the piece down with gravity
		if(canMoveDown && TimeUtils.nanoTime() - lastDownTime > gravity) {
				this.playerPiece.translate(0f, this.playerPiece.getBLOCKSIZE() * -1);
				this.lastDownTime = TimeUtils.nanoTime();
		}
		
		//Take player input
		if(Gdx.input.isKeyJustPressed(Keys.LEFT)) {
			if(canMoveSideways(false)){
				this.playerPiece.translate(this.playerPiece.getBLOCKSIZE() * -1, 0.0f);
			}
		}
		if(Gdx.input.isKeyJustPressed(Keys.RIGHT)) {
			if(canMoveSideways(true)) {
				this.playerPiece.translate(this.playerPiece.getBLOCKSIZE(), 0.0f);
			}
		}
		if(Gdx.input.isKeyJustPressed(Keys.DOWN)) {
			if(canMoveDown) {
				this.playerPiece.translate(0.0f, this.playerPiece.getBLOCKSIZE() * -1);
			}
		}
		if(Gdx.input.isKeyJustPressed(Keys.UP)) {
			this.playerPiece.turn();
		}
		
		//if so, lock it in place and create a new piece on the next round
		if(!canMoveDown) {
			this.lockedPieces.add(this.playerPiece);
			this.playerPiece = null;
		}
		
		//tetrisCheck();
		final int BLOCKSIZE = 30;
		tetrisCheck(new Polygon(new float[] {
			    0, 1,				//Bottom left
			    0, BLOCKSIZE - 1, 	//Top left
			WIDTH, BLOCKSIZE - 1,	//Top right
			WIDTH, 1 				//Bottom right				
		}));
		
		//Render all the pieces
		shapeRenderer.begin();
		if(this.playerPiece != null) {
			for(TetrisBlock block : this.playerPiece.getBlocks()) {
				shapeRenderer.polygon(block.getTransformedVertices());
			}
		}
		for(TetrisPiece piece : this.lockedPieces) {
			for(TetrisBlock block : piece.getBlocks()) {
				shapeRenderer.polygon(block.getTransformedVertices());
			}
		}
		shapeRenderer.end();		
	}
	
	/**
	 * Determine if a piece can be moved left or right
	 * @param right if the movement being checked is to the right
	 * @return 
	 */
	private boolean canMoveSideways(boolean right) {
		for(TetrisBlock block : this.playerPiece.getBlocks()) {
			if(right && block.getTransformedVertices()[6] >= Gdx.graphics.getWidth()) return false;
			else if(!right && block.getTransformedVertices()[0] <= 0) return false;
			for(TetrisPiece piece : this.lockedPieces) {
				for(TetrisBlock lockedBox : piece.getBlocks()) {
					if(right) {
						float[] verts = block.getTransformedVertices();
						Vector2 vert1 = new Vector2(verts[4], verts[5] - 1); //45 67
						Vector2 vert2 = new Vector2(verts[6] + 1, verts[7] + 1);
						if(Intersector.intersectSegmentPolygon(vert1, vert2, lockedBox)) return false;
					} else {
						float[] verts = block.getTransformedVertices();
						Vector2 vert1 = new Vector2(verts[0], verts[1] - 1); //01 23
						Vector2 vert2 = new Vector2(verts[2] - 1, verts[3] + 1);
						if(Intersector.intersectSegmentPolygon(vert1, vert2, lockedBox)) return false;
					}
				}
			}
		}
		return true;
	}

	/**
	 * Checks if the player piece can move downwards
	 * @return True if the piece can move down, false otherwise
	 */
	private boolean canMoveDown() {
		for(TetrisBlock block : this.playerPiece.getBlocks()) {
			if(block.getTransformedVertices()[1] <= 0f) return false;
			for(TetrisPiece piece : this.lockedPieces) {
				for(TetrisBlock tBlock : piece.getBlocks()) {
					float[] verts = block.getTransformedVertices();
					Vector2 vert1 = new Vector2(verts[0] + 1, verts[1]);
					Vector2 vert2 = new Vector2(verts[6] - 1, verts[7] - 1);
					if(Intersector.intersectSegmentPolygon(vert1, vert2, tBlock)) return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * Recursively checks for any completed lines, removes them, and moves all the pieces above it down
	 * @param checker A polygon that is checked for overlap with all the locked pieces on the board. Pieces
	 * 	that are found overlapping it are removed.
	 */
	private void tetrisCheck(Polygon checker) {
		int overlapCount = 0;
		ArrayList<TetrisBlock> blockBuffer = new ArrayList<>();
		if(checker.getTransformedVertices()[1] >= Gdx.graphics.getHeight()) return;
		for(TetrisPiece piece : this.lockedPieces) {
			for(TetrisBlock block : piece.getBlocks()) {
				if(Intersector.overlapConvexPolygons(block, checker)) {
					overlapCount++;
					blockBuffer.add(block);
				}
			}
		}
		if(overlapCount >= 10) {
			for(TetrisPiece piece : this.lockedPieces) {
				piece.blocks.removeAll(blockBuffer);
			}
		}
		float[] verts = checker.getTransformedVertices();
		verts[1] = Gdx.graphics.getHeight();
		verts[5] = Gdx.graphics.getHeight();
		Polygon mover = new Polygon(checker.getTransformedVertices());
		
		if(overlapCount >= 10) {
			for(TetrisPiece piece : this.lockedPieces) {
				for(TetrisBlock block : piece.getBlocks()) {
					if(Intersector.overlapConvexPolygons(mover, block)) {
						block.translate(0, piece.getBLOCKSIZE() * -1);
					}
				}
			}
		}	
		checker.translate(0, BLOCKSIZE);
		tetrisCheck(checker);
	}
}

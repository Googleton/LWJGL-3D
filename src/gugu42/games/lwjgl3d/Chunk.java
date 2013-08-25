package gugu42.games.lwjgl3d;

import java.nio.FloatBuffer;
import java.util.Random;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;

import gugu42.games.lwjgl3d.Block.BlockType;

public class Chunk {

	private int VBOColorHandle;
	private int VBOVertexHandle;
	static final int cubesize = 2;

	private int startX, startY, startZ;
	private Random r;

	static final int size = 16;
	private Block[][][] blocks;

	public void render() {
		GL11.glPushMatrix();
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, VBOVertexHandle);
		GL11.glVertexPointer(3, GL11.GL_FLOAT, 0, 0L);
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, VBOColorHandle);
		GL11.glColorPointer(3, GL11.GL_FLOAT, 0, 0L);
		GL11.glDrawArrays(GL11.GL_QUADS, 0, size * size * size * 24);

		GL11.glPopMatrix();
	}

	public void update() {

	}

	public void rebuildMesh(float startX, float startY, float startZ) {

		VBOColorHandle = GL15.glGenBuffers();
		VBOVertexHandle = GL15.glGenBuffers();

		FloatBuffer VertexPositionData = BufferUtils.createFloatBuffer((size
				* size * size) * 6 * 12);
		FloatBuffer VertexColorData = BufferUtils.createFloatBuffer((size
				* size * size) * 6 * 12);
		for (float x = 0; x < size; x += 1) {
			for (float y = 0; y < size; y += 1) {
				for (float z = 0; z < size; z += 1) {

					VertexPositionData.put(createCube((float) startX + x
							* cubesize, (float) startY + y * cubesize,
							(float) startZ + z * cubesize));
					VertexColorData
							.put(createCubeVertexCol(getCubeColor(blocks[(int) x][(int) y][(int) z])));

				}
			}

		}

		VertexColorData.flip();
		VertexPositionData.flip();
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, VBOVertexHandle);
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, VertexPositionData,
				GL15.GL_STATIC_DRAW);
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, VBOColorHandle);
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, VertexColorData,
				GL15.GL_STATIC_DRAW);
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);

	}

	/**
	 * Create a cube
	 * 
	 * @param x
	 *            position X
	 * @param y
	 *            position Y
	 * @param z
	 *            position Z
	 * @return block position
	 */
	public static float[] createCube(float x, float y, float z) {
		int offset = cubesize / 2;
		return new float[] {

		x + offset, y + offset, z, x - offset, y + offset, z, x - offset,
				y + offset, z - cubesize, x + offset, y + offset, z - cubesize,

				x + offset, y - offset, z - cubesize, x - offset, y - offset,
				z - cubesize, x - offset, y - offset, z, x + offset,
				y - offset, z,

				x + offset, y + offset, z - cubesize, x - offset, y + offset,
				z - cubesize, x - offset, y - offset, z - cubesize, x + offset,
				y - offset, z - cubesize,

				x + offset, y - offset, z, x - offset, y - offset, z,
				x - offset, y + offset, z, x + offset, y + offset, z,

				x - offset, y + offset, z - cubesize, x - offset, y + offset,
				z, x - offset, y - offset, z, x - offset, y - offset,
				z - cubesize,

				x + offset, y + offset, z, x + offset, y + offset,
				z - cubesize, x + offset, y - offset, z - cubesize, x + offset,
				y - offset, z };

	}

	private float[] getCubeColor(Block block) {
		switch (block.getID()) {
		case 1:
			return new float[] { 0, 1, 0 };
		case 2:
			return new float[] { 0.33f, 0.33f, 0.33f };
		case 3:
			return new float[] { 1, 0.5f, 0f };
		}
		return new float[] { 1, 1, 1 };
	}

	private float[] createCubeVertexCol(float[] cubeColorArray) {
		float[] cubeColors = new float[cubeColorArray.length * 4 * 6];
		for (int i = 0; i < cubeColors.length; i++) {
			cubeColors[i] = cubeColorArray[i % cubeColorArray.length];
		}
		return cubeColors;
	}

	public Chunk(int startX1, int startY1, int startZ1) {
		r = new Random();
		blocks = new Block[size][size][size];
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				for (int z = 0; z < size; z++) {
					if (r.nextFloat() > 0.7f) {
						blocks[x][y][z] = new Block(BlockType.grass);
					} else if (r.nextFloat() > 0.4f) {
						blocks[x][y][z] = new Block(BlockType.dirt);
					} else if (r.nextFloat() > 0.2f) {
						blocks[x][y][z] = new Block(BlockType.stone);
					} else {
						blocks[x][y][z] = new Block(BlockType.void_block);
					}
				}
			}
		}
		VBOColorHandle = GL15.glGenBuffers();
		VBOVertexHandle = GL15.glGenBuffers();
		startX = startX1;
		startY = startY1;
		startZ = startZ1;
		rebuildMesh(startX, startY, startZ);
	}

}

package gugu42.games.lwjgl3d;

public class Block {

	private boolean isActive;
	private BlockType type;

	public enum BlockType {
		void_block(0), grass(1), stone(2), dirt(3);
		private int blockID;

		BlockType(int i) {
			blockID = i;
		}

		public int getID() {
			return blockID;
		}
	}

	public Block(BlockType btype) {
		type = btype;
	}

	public boolean IsActive() {
		return isActive;
	}

	public void SetActive(boolean active) {
		isActive = active;
	}

	public int getID() {
		return type.getID();
	}

}

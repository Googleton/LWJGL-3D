package gugu42.games.lwjgl3d.render;

import org.lwjgl.opengl.GL11;

public class RenderCube implements IRender {

	@Override
	public void render() {
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glColor3f(0.0f, 1.0f, 0.0f);
		GL11.glVertex3f(1.0f, 1.0f, -1.0f);
		GL11.glVertex3f(-1.0f, 1.0f, -1.0f);
		GL11.glVertex3f(-1.0f, 1.0f, 1.0f);
		GL11.glVertex3f(1.0f, 1.0f, 1.0f);
		GL11.glColor3f(1.0f, 0.5f, 0.0f);
		GL11.glVertex3f(1.0f, -1.0f, 1.0f);
		GL11.glVertex3f(-1.0f, -1.0f, 1.0f);
		GL11.glVertex3f(-1.0f, -1.0f, -1.0f);
		GL11.glVertex3f(1.0f, -1.0f, -1.0f);
		GL11.glColor3f(1.0f, 0.0f, 0.0f);
		GL11.glVertex3f(1.0f, 1.0f, 1.0f);
		GL11.glVertex3f(-1.0f, 1.0f, 1.0f);
		GL11.glVertex3f(-1.0f, -1.0f, 1.0f);
		GL11.glVertex3f(1.0f, -1.0f, 1.0f);
		GL11.glColor3f(1.0f, 1.0f, 0.0f);
		GL11.glVertex3f(1.0f, -1.0f, -1.0f);
		GL11.glVertex3f(-1.0f, -1.0f, -1.0f);
		GL11.glVertex3f(-1.0f, 1.0f, -1.0f);
		GL11.glVertex3f(1.0f, 1.0f, -1.0f);
		GL11.glColor3f(0.0f, 0.0f, 1.0f);
		GL11.glVertex3f(-1.0f, 1.0f, 1.0f);
		GL11.glVertex3f(-1.0f, 1.0f, -1.0f);
		GL11.glVertex3f(-1.0f, -1.0f, -1.0f);
		GL11.glVertex3f(-1.0f, -1.0f, 1.0f);
		GL11.glColor3f(1.0f, 0.0f, 1.0f);
		GL11.glVertex3f(1.0f, 1.0f, -1.0f);
		GL11.glVertex3f(1.0f, 1.0f, 1.0f);
		GL11.glVertex3f(1.0f, -1.0f, 1.0f);
		GL11.glVertex3f(1.0f, -1.0f, -1.0f);
		GL11.glEnd();
	}
	
	public void render(int x, int y, int z) {
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTranslatef(x, y, z);
		GL11.glColor3f(0.0f, 1.0f, 0.0f);
		GL11.glVertex3f(1.0f, 1.0f, -1.0f);
		GL11.glVertex3f(-1.0f, 1.0f, -1.0f);
		GL11.glVertex3f(-1.0f, 1.0f, 1.0f);
		GL11.glVertex3f(1.0f, 1.0f, 1.0f);
		GL11.glColor3f(1.0f, 0.5f, 0.0f);
		GL11.glVertex3f(1.0f, -1.0f, 1.0f);
		GL11.glVertex3f(-1.0f, -1.0f, 1.0f);
		GL11.glVertex3f(-1.0f, -1.0f, -1.0f);
		GL11.glVertex3f(1.0f, -1.0f, -1.0f);
		GL11.glColor3f(1.0f, 0.0f, 0.0f);
		GL11.glVertex3f(1.0f, 1.0f, 1.0f);
		GL11.glVertex3f(-1.0f, 1.0f, 1.0f);
		GL11.glVertex3f(-1.0f, -1.0f, 1.0f);
		GL11.glVertex3f(1.0f, -1.0f, 1.0f);
		GL11.glColor3f(1.0f, 1.0f, 0.0f);
		GL11.glVertex3f(1.0f, -1.0f, -1.0f);
		GL11.glVertex3f(-1.0f, -1.0f, -1.0f);
		GL11.glVertex3f(-1.0f, 1.0f, -1.0f);
		GL11.glVertex3f(1.0f, 1.0f, -1.0f);
		GL11.glColor3f(0.0f, 0.0f, 1.0f);
		GL11.glVertex3f(-1.0f, 1.0f, 1.0f);
		GL11.glVertex3f(-1.0f, 1.0f, -1.0f);
		GL11.glVertex3f(-1.0f, -1.0f, -1.0f);
		GL11.glVertex3f(-1.0f, -1.0f, 1.0f);
		GL11.glColor3f(1.0f, 0.0f, 1.0f);
		GL11.glVertex3f(1.0f, 1.0f, -1.0f);
		GL11.glVertex3f(1.0f, 1.0f, 1.0f);
		GL11.glVertex3f(1.0f, -1.0f, 1.0f);
		GL11.glVertex3f(1.0f, -1.0f, -1.0f);
		GL11.glEnd();
	}

	public void render(float x, float y, float z, float sizeX, float sizeY, float sizeZ) {
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glColor3f(1.0f, 1.0f, 0.0f);
		GL11.glVertex3f(sizeX, sizeY, -sizeZ);
		GL11.glVertex3f(-sizeX, sizeY, -sizeZ);
		GL11.glVertex3f(-sizeX, sizeY, sizeZ);
		GL11.glVertex3f(sizeX, sizeY, sizeZ);
		GL11.glColor3f(1.0f, 0.5f, 0.0f);
		GL11.glVertex3f(sizeX, -sizeY, sizeZ);
		GL11.glVertex3f(-sizeX, -sizeY, sizeZ);
		GL11.glVertex3f(-sizeX, -sizeY, -sizeZ);
		GL11.glVertex3f(sizeX, -sizeY, -sizeZ);
		GL11.glColor3f(0.0f, 0.0f, 0.0f);
		GL11.glVertex3f(sizeX, sizeY, sizeZ);
		GL11.glVertex3f(-sizeX, sizeY, sizeZ);
		GL11.glVertex3f(-sizeX, -sizeY, sizeZ);
		GL11.glVertex3f(sizeX, -sizeY, sizeZ);
		GL11.glColor3f(0.0f, 1.0f, 0.0f);
		GL11.glVertex3f(sizeX, -sizeY, -sizeZ);
		GL11.glVertex3f(-sizeX, -sizeY, -sizeZ);
		GL11.glVertex3f(-sizeX, sizeY, -sizeZ);
		GL11.glVertex3f(sizeX, sizeY, -sizeZ);
		GL11.glColor3f(0.0f, 0.0f, 1.0f);
		GL11.glVertex3f(-sizeX, sizeY, sizeZ);
		GL11.glVertex3f(-sizeX, sizeY, -sizeZ);
		GL11.glVertex3f(-sizeX, -sizeY, -sizeZ);
		GL11.glVertex3f(-sizeX, -sizeY, sizeZ);
		GL11.glColor3f(1.0f, 0.0f, 1.0f);
		GL11.glVertex3f(sizeX, sizeY, -sizeZ);
		GL11.glVertex3f(sizeX, sizeY, sizeZ);
		GL11.glVertex3f(sizeX, -sizeY, sizeZ);
		GL11.glVertex3f(sizeX, -sizeY, -sizeZ);
		GL11.glTranslatef(x, y, z);
		GL11.glEnd();
	}
	
}

package gugu42.games.lwjgl3d;

import java.nio.FloatBuffer;

import gugu42.games.lwjgl3d.render.RenderCube;

import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.util.glu.GLU;

public class Main {

	private int VBOVertexHandle;
	private int VBOColorHandle;
	
	public static GameState currentState = GameState.menu;
	
	private Chunk chunky;
	private float PX, PY, PZ;
	Camera camera = new Camera(0, 0, 0);
	
	public void start() {
		try {

			Display.setDisplayMode(new DisplayMode(1280, 768));

			Display.create();
			initGL();
			run();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}

		while (!Display.isCloseRequested()) {

			Display.update();
		}
		Display.destroy();
	}
	
	private void initGL() {
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glShadeModel(GL11.GL_SMOOTH);
		GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		GL11.glClearDepth(1.0);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glDepthFunc(GL11.GL_LEQUAL);
		GL11.glEnableClientState(GL11.GL_VERTEX_ARRAY);

		GL11.glEnableClientState(GL11.GL_COLOR_ARRAY);

		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();

		GLU.gluPerspective(45.0f, (float) Display.getWidth()
				/ (float) Display.getHeight(), 0.1f, 300.0f);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);

		GL11.glHint(GL11.GL_PERSPECTIVE_CORRECTION_HINT, GL11.GL_NICEST);
	}

	private void run() {
		chunky = new Chunk(0, 0, 0);
		float RotateYaw = 1;
		
		 
	    float dx        = 0.0f;
	    float dy        = 0.0f;
	    float dt        = 0.0f; //length of frame
	    float lastTime  = 0.0f; // when the last frame was
	    float time      = 0.0f;
	 
	    float mouseSensitivity = 0.05f;
	    float movementSpeed = 10.0f; //move 10 units per second
	 
	    //hide the mouse
	    Mouse.setGrabbed(true);
		
		while (!Display.isCloseRequested() && !Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
			try {
		//		input();
				GL11.glClear(GL11.GL_COLOR_BUFFER_BIT
						| GL11.GL_DEPTH_BUFFER_BIT);
				GL11.glLoadIdentity();

				time = Sys.getTime();
		        dt = (time - lastTime)/1000.0f;
		        lastTime = time;
		        dx = Mouse.getDX();
		        dy = Mouse.getDY();
		        camera.yaw(dx * mouseSensitivity);
		        camera.pitch(dy * mouseSensitivity);
		        
		        if (Keyboard.isKeyDown(Keyboard.KEY_Z))
		        {
		            camera.walkForward(movementSpeed*dt);
		        }
		        if (Keyboard.isKeyDown(Keyboard.KEY_S))
		        {
		            camera.walkBackwards(movementSpeed*dt);
		        }
		        if (Keyboard.isKeyDown(Keyboard.KEY_Q))
		        {
		            camera.strafeLeft(movementSpeed*dt);
		        }
		        if (Keyboard.isKeyDown(Keyboard.KEY_D))
		        {
		            camera.strafeRight(movementSpeed*dt);
		        }
		        if (Keyboard.isKeyDown(Keyboard.KEY_A) || Keyboard.isKeyDown(Keyboard.KEY_SPACE))
		        {
		            camera.flyUp(movementSpeed*dt);
		        }
		        if (Keyboard.isKeyDown(Keyboard.KEY_E) || Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
		        {
		            camera.flyDown(movementSpeed*dt);
		        }
		        
		        GL11.glLoadIdentity();
		        camera.lookThrough();
				if (RotateYaw % 60 == 0)
					chunky.rebuildMesh(0, 0, 0);
				chunky.render();
				// Render();
				Display.update();
				Display.sync(60);
			} catch (Exception e) {

			}
		}
		Display.destroy();

	}
	
	private void input() {
		if (Keyboard.isKeyDown(Keyboard.KEY_Z)) {
			PY--;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
			PY++;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_Q)) {
			PX++;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
			PX--;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_E)) {
			PZ--;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
			PZ++;
		}

	}

	public static void main(String[] argv) {
		Main game = new Main();
		game.start();
	}

	public enum GameState {
		menu(0), solo(1), multi(2), mapedit(3);
		private int stateID;

		GameState(int i) {
			stateID = i;
		}

		public int GetID() {
			return stateID;
		}
	}
}

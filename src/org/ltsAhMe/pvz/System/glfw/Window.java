package org.ltsAhMe.pvz.System.glfw;
import org.ltsAhMe.pvz.PlantVsZombie;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import java.awt.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glMatrixMode;

public class Window {
    public long id;

    public  static float offset;
    public static float DrawFox = 3;
   public static int windowWidth = 800; // 假设窗口宽度为800
   public static int windowHeight = 600;
    public Window() {




        System.err.println("glfw init "+glfwInit());
        glfwWindowHint(GLFW_RESIZABLE,GLFW_FALSE);
        id = glfwCreateWindow(windowWidth,windowHeight, PlantVsZombie.Title+" "+PlantVsZombie.version,0,0);
        glfwMakeContextCurrent(id);



        long monitor = glfwGetPrimaryMonitor();
        GLFWVidMode vidMode = org.lwjgl.glfw.GLFW.glfwGetVideoMode(monitor);

        int screenWidth = vidMode.width();
        int screenHeight = vidMode.height();

        GLFW.glfwSetWindowPos(id, (screenWidth - windowWidth) / 2, (screenHeight - windowHeight) / 2);

        GL.createCapabilities();
        float aspectRatio = (float) windowWidth / (float) windowHeight;
        offset = DrawFox * aspectRatio;
        glMatrixMode(GL_PROJECTION);
        glOrtho(-offset, offset, -DrawFox, DrawFox, DrawFox, -DrawFox);
        glMatrixMode(GL_MODELVIEW);
    }
    public boolean isExit(){
        return glfwWindowShouldClose(id);
    }
}

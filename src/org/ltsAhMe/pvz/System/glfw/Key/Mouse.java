package org.ltsAhMe.pvz.System.glfw.Key;

import org.joml.Vector2d;
import org.joml.Vector2f;
import org.ltsAhMe.pvz.PlantVsZombie;
import org.lwjgl.glfw.GLFWCursorEnterCallback;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;
import org.lwjgl.system.MemoryUtil;

import java.awt.*;
import java.nio.DoubleBuffer;

import static org.lwjgl.glfw.GLFW.*;

public class Mouse {
   static int x=0;
   static int y=0;
    public static boolean clickP = false;
  public static boolean isClick =false;
   static GLFWCursorPosCallback cursorPosCallback = new GLFWCursorPosCallback() {
        @Override
        public void invoke(long window, double xpos, double ypos) {
            x = (int) xpos;
            y = (int) ypos;
        }
    };

    static GLFWMouseButtonCallback mouseButtonCallback = new GLFWMouseButtonCallback() {
        @Override
        public void invoke(long window, int button, int action, int mods) {
            if (button == GLFW_MOUSE_BUTTON_1 && action == GLFW_PRESS){
                isClick =  true;
            }else
                isClick = false;
            }
        };


    public static Point getPos(){
        return new Point(x,y);
    }
    public static boolean useP(){
        if (!clickP && isClick){
            clickP=true;
            return true;
        }else if (!isClick){
            clickP = false;
        }
        return false;
    }
    public static void init(){
        glfwSetCursorPosCallback(PlantVsZombie.window.id,cursorPosCallback);
        glfwSetMouseButtonCallback(PlantVsZombie.window.id,mouseButtonCallback);
    }

}

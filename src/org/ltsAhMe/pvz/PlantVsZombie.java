package org.ltsAhMe.pvz;



import static org.lwjgl.glfw.GLFW.*;

import org.ltsAhMe.pvz.Rander.Room.RoomMana;

import org.ltsAhMe.pvz.System.Audio.Audio;
import org.ltsAhMe.pvz.System.glfw.Key.Mouse;
import org.ltsAhMe.pvz.System.glfw.Window;
import org.ltsAhMe.pvz.System.timer.Pick;
import org.lwjgl.opengl.GL11;

import javax.swing.*;

public class PlantVsZombie {

    public static String gameResDir = "C:/Users/ltsAhMe/Desktop/zombie/PVZres/";

    public static String Title = "PlantVsZombie";
    public static String version = "?";

    public static Pick fpsPick;
    public static Window window;
    public PlantVsZombie(){
        init();
        gameloop();
    }

    public void init() {
        Audio.init();
        window = new Window();
        Mouse.init();
        fpsPick =  new Pick(100);
        RoomMana.init();
    }
    public void gameloop(){
        while(!window.isExit()){
            glfwPollEvents();
            if (fpsPick.kick()){
                Rander();
            }
            glfwSwapBuffers(window.id);
        }
    }


    public void Rander(){
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
        RoomMana.Rander();
    }

}

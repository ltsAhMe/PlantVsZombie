package org.ltsAhMe.pvz.Rander.BaseFunc.Screan;
import org.ltsAhMe.pvz.Rander.BaseFunc.BaseFunc;
import org.ltsAhMe.pvz.System.glfw.Window;

import static org.lwjgl.opengl.GL11.*;
public class DarkToLight {
    float sb = 1f;

    float quit = 0.01f;
   public boolean Done = false;

    public DarkToLight(float num){
            quit = num;
    }
    public DarkToLight(){

    }
    public void Draw(){
        if (sb - quit <=0f){
            Done=true;
        }else {
            sb-=quit;
        }
        BaseFunc.EnableBlend();
        glBegin(GL_QUADS);
        glColor4f(0f,0f,0f,sb);
        glVertex2f(-Window.offset,Window.DrawFox);
        glVertex2f(Window.offset,Window.DrawFox);
        glVertex2f(Window.offset,-Window.DrawFox);
        glVertex2f(-Window.offset,-Window.DrawFox);
        glEnd();
        glDisable(GL_BLEND);
    }
}

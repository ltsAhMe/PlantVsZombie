package org.ltsAhMe.pvz.Rander.BaseFunc.Screan;

import org.ltsAhMe.pvz.Rander.BaseFunc.BaseFunc;
import org.ltsAhMe.pvz.System.glfw.Window;

import static org.lwjgl.opengl.GL11.*;

public class LightToDark {
    float sb = 0f;

    float quit = 0.01f;
    public boolean Done = false;

    public LightToDark(float num){
        quit = num;
    }
    public LightToDark(){

    }
    public void Draw(){
        if (sb - quit >=1f){
            Done=true;
        }else {
            sb+=quit;
        }
        BaseFunc.EnableBlend();
        glBegin(GL_QUADS);
        glColor4f(0f,0f,0f,sb);
        glTexCoord2f(0,0);
        glVertex2f(-Window.offset,Window.DrawFox);
        glTexCoord2f(1,0);
        glVertex2f(Window.offset,Window.DrawFox);
        glTexCoord2f(1,1);
        glVertex2f(Window.offset,-Window.DrawFox);
        glTexCoord2f(0,1);
        glVertex2f(-Window.offset,-Window.DrawFox);
        glEnd();
        glDisable(GL_BLEND);
    }
}

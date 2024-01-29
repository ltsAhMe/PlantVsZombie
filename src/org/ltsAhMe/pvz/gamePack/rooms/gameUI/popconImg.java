package org.ltsAhMe.pvz.gamePack.rooms.gameUI;

import org.ltsAhMe.pvz.Rander.BaseFunc.Screan.DarkToLight;
import org.ltsAhMe.pvz.Rander.BaseFunc.Screan.LightToDark;
import org.ltsAhMe.pvz.Rander.BaseFunc.Texture;
import org.ltsAhMe.pvz.Rander.Room.BaseRoom;
import org.ltsAhMe.pvz.System.Audio.Music.MusicEnum;
import org.ltsAhMe.pvz.System.glfw.Window;

import static org.lwjgl.opengl.GL11.*;

public class popconImg extends BaseRoom {
    int num=0;
    Texture texture = new Texture("images/PopCap_Logo.jpg");
    DarkToLight darkToLight = new DarkToLight(0.05f);

    LightToDark lightToDark = new LightToDark(0.05f);
    static float drawFox =  1.5f;

    boolean init = false;

    @Override
    public void Rander(){

        if (!init){
            init=true;
            MusicEnum.MainPlantVsZombe.setPos();
            MusicEnum.MainPlantVsZombe.play();
        }
        texture.bind();
        glBegin(GL_QUADS);
        glColor4f(1,1,1,1);
        glTexCoord2f(0,0);
        glVertex2f(-drawFox,drawFox);
        glTexCoord2f(1,0);
        glVertex2f(drawFox,drawFox);
        glTexCoord2f(1,1);
        glVertex2f(drawFox,-drawFox);
        glTexCoord2f(0,1);
        glVertex2f(-drawFox,-drawFox);
        glEnd();
        Texture.unbind();
        if (!darkToLight.Done) {
            darkToLight.Draw();
        }else {

            num++;

            if (!lightToDark.Done && num>200){
                lightToDark.Draw();
            }

        }
        if (lightToDark.Done){
            this.Done=true;
        }
    }
}

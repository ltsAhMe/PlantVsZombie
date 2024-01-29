package org.ltsAhMe.pvz.gamePack.rooms.gameUI;
import static org.lwjgl.opengl.GL11.*;

import org.ltsAhMe.pvz.Rander.BaseFunc.numKey;
import org.joml.Vector2f;
import org.ltsAhMe.pvz.PlantVsZombie;
import org.ltsAhMe.pvz.Rander.BaseFunc.BaseFunc;
import org.ltsAhMe.pvz.Rander.BaseFunc.Texture;
import org.ltsAhMe.pvz.Rander.Room.BaseRoom;
import org.ltsAhMe.pvz.System.Audio.sound.SoundEnum;
import org.ltsAhMe.pvz.System.Renim.reanimReader;
import org.ltsAhMe.pvz.System.glfw.Window;
import org.ltsAhMe.pvz.System.staticDate;

import java.io.File;

public class MainMenu extends BaseRoom {


    numKey key = new numKey(0,100,true,3);
    numKey davekey = new numKey(0,60,true,3);

    @Override
    public void Rander() {
        BaseFunc.EnableBlend();

        staticDate.ren.Rander(key.get(), new Vector2f(0f,0f),0.01f);
        staticDate.dave.Rander(davekey.get(),new Vector2f(2f,0f),0.01f);
    }
}

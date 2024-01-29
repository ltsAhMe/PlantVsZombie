package org.ltsAhMe.pvz.gamePack.rooms.gameUI;
import static org.lwjgl.opengl.GL11.*;

import org.joml.Vector2f;
import org.ltsAhMe.pvz.Rander.BaseFunc.BaseFunc;
import org.ltsAhMe.pvz.Rander.BaseFunc.Text;
import org.ltsAhMe.pvz.Rander.BaseFunc.Texture;
import org.ltsAhMe.pvz.Rander.BasePos.Rect;
import org.ltsAhMe.pvz.Rander.Room.BaseRoom;

import org.ltsAhMe.pvz.System.Audio.sound.SoundEnum;
import org.ltsAhMe.pvz.System.glfw.Key.Mouse;
import org.ltsAhMe.pvz.System.glfw.Window;
import org.ltsAhMe.pvz.System.staticDate;

import java.awt.*;


import static org.lwjgl.opengl.GL11.*;

public class GameLoading extends BaseRoom {
    Texture backRound  = new Texture("images/titlescreen_new.jpg");
    Texture loadBarDirt = new Texture("images/LoadBar_dirt.png");

    Texture loadBarGrass = new Texture("images/LoadBar_grass.png");

    Texture grassBall = new Texture("reanim/SodRollCap.png");

    Texture text = new Texture("images/PvZ_Logo.jpg","images/PvZ_Logo_.png");


    Color color = Color.ORANGE;

    float where = -1.7f;

    float whereY = 0f;
    float howRotate = 0f;
    float howbig = 0.3f;
    boolean init = false;

    public void init(){
        staticDate.init();
    }

    @Override
    public void Rander() {
        if (!init){
            init=true;
            init();
        }
        if (howbig - 0.01f >0f && where +0.007 <1.55f){
            whereY -= 0.00004;
            where += 0.007f;
            howbig -= 0.00006f;
            howRotate-=4;
        }

        Point mouse = Mouse.getPos();

        Rect rect = new Rect(new Point(370,529),new Point(423,577));

        if (rect.contains(mouse) && staticDate.done){
            color=Color.RED;
            if (Mouse.useP()){
                SoundEnum.tap2.play();
                this.Done=true;
            }
        }else {
            color=Color.ORANGE;
        }



        BaseFunc.DrawScrean(backRound);

        BaseFunc.EnableBlend();


        BaseFunc.DrawBlock(loadBarDirt,0f,-2.6f,0.3f);


        BaseFunc.DrawBlock(loadBarGrass,new Vector2f(-(loadBarGrass.offsetX * 0.2f),0.2f-2.3f),new Vector2f(where,0.2f-2.3f),new Vector2f(where,-0.2f-2.3f),new Vector2f(-(loadBarGrass.offsetX * 0.2f),-0.2f-2.3f),new Vector2f(0,0),new Vector2f(1-(Math.abs((1.7f-where)/3.4f)),0),new Vector2f(1-(Math.abs((1.7f-where)/3.4f)),1),new Vector2f(0,1));

        BaseFunc.DrawBlock(text,0,2.4f,0.6f);

        BaseFunc.DrawBlock(new Texture(Text.getStringImg(Text.dFont,"start",color)),0,-2.55f,0.18f);


        glTranslatef(where,-2.18f + whereY,0);
        glRotatef(howRotate,0,0,1);

        BaseFunc.DrawBlock(grassBall,0,0,howbig);


        glDisable(GL_BLEND);
        glLoadIdentity();
    }
}

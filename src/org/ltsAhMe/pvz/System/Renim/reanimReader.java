
package org.ltsAhMe.pvz.System.Renim;
import org.joml.Vector2f;
import org.ltsAhMe.pvz.Rander.BaseFunc.BaseFunc;
import org.ltsAhMe.pvz.Rander.BaseFunc.Texture;


import static org.lwjgl.opengl.GL11.*;

import java.io.File;

public class reanimReader {
   public track[] tracks;

    public reanimReader(File file) {
        staticDate.resdir = file.getPath().substring(0,file.getPath().length()-file.getName().length());
        MiyaXML reanim = new MiyaXML(file);
        tracks = new track[reanim.getOccurrencesCount("<track>")];
        for (int i=0;i<tracks.length;i++){
            tracks[i] = new track(reanim.getTypeContent("track",i));
        }
    }
    public void Rander(int number, Vector2f where,float high){
        glLoadIdentity();
        for (int track=0;track<tracks.length;track++){
            tracks[track].Read(number);
            glLoadIdentity();
            glTranslatef(where.x, where.y, 0);
            glScalef(high,high,1);
            if (tracks[track].img != null && !tracks[track].isHidden){
                track thet = tracks[track];
                glTranslatef((float) (thet.x/1.3), (float) (-thet.y/1.3),0);
                glRotatef( -thet.kx,0,0,1);
                glRotatef( -thet.ky,0,0,1);
                glScalef(thet.sx, thet.sy,1);
                BaseFunc.DrawBlock(new Texture(thet.img),new Vector2f(-(thet.img.getWidth()/2),thet.img.getHeight()/2),new Vector2f(thet.img.getWidth()/2,thet.img.getHeight()/2),new Vector2f(thet.img.getWidth()/2,-(thet.img.getHeight()/2)),new Vector2f(-(thet.img.getWidth()/2),-(thet.img.getHeight()/2)));
            }
            glLoadIdentity();
        }
        glLoadIdentity();
    }
}

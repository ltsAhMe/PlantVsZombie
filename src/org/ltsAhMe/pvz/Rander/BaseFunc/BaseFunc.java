package org.ltsAhMe.pvz.Rander.BaseFunc;

import org.joml.Matrix2d;
import org.joml.Vector2d;
import org.ltsAhMe.pvz.Rander.BasePos.FloatRect;
import org.ltsAhMe.pvz.System.glfw.Window;
import org.lwjgl.BufferUtils;
import org.joml.Vector2f;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.ByteBuffer;

import static org.lwjgl.opengl.GL11.*;

public class BaseFunc {
    public static void EnableBlend(){
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
    }
    public static void DrawBlock(Texture texture,Vector2f f1,Vector2f f2,Vector2f f3,Vector2f f4,Vector2f Tex1,Vector2f Tex2,Vector2f Tex3,Vector2f Tex4){
        texture.bind();
        glBegin(GL_QUADS);
        glColor3f(1f, 1f, 1f);
        glTexCoord2f(Tex1.x, Tex1.y);
        glVertex2f(f1.x, f1.y);
        glTexCoord2f(Tex2.x, Tex2.y);
        glVertex2f(f2.x, f2.y);
        glTexCoord2f(Tex3.x, Tex3.y);
        glVertex2f(f3.x, f3.y);
        glTexCoord2f(Tex4.x, Tex4.y);
        glVertex2f(f4.x, f4.y);
        glEnd();
        Texture.unbind();
    }
    public static void DrawBlock(Texture texture,Vector2f f1,Vector2f f2,Vector2f f3,Vector2f f4){
        DrawBlock(texture,f1,f2,f3,f4,new Vector2f(0,0),new Vector2f(1,0),new Vector2f(1,1),new Vector2f(0,1));
    }
    public static void DrawBlock(Texture texture, FloatRect rect){
        DrawBlock(texture,new Vector2f(rect.x,rect.y),new Vector2f(rect.x+rect.width,rect.y),new Vector2f(rect.x+rect.width,rect.y-rect.height),new Vector2f(rect.x,rect.y-rect.height),new Vector2f(0,0),new Vector2f(1,0),new Vector2f(1,1),new Vector2f(0,1));
    }
    public static void DrawBlock(Texture texture,float xOffset,float yOffset,float hight,Vector2f Tex1,Vector2f Tex2,Vector2f Tex3,Vector2f Tex4){
        texture.bind();
        glBegin(GL_QUADS);
        glColor3f(1f, 1f, 1f);
        glTexCoord2f(Tex1.x, Tex1.y);
        glVertex2f(-(texture.offsetX * hight) - xOffset, hight + yOffset);
        glTexCoord2f(Tex2.x, Tex2.y);
        glVertex2f((texture.offsetX * hight) - xOffset, hight +yOffset);
        glTexCoord2f(Tex3.x, Tex3.y);
        glVertex2f((texture.offsetX * hight) - xOffset, -hight +yOffset);
        glTexCoord2f(Tex4.x, Tex4.y);
        glVertex2f(-(texture.offsetX * hight) - xOffset, -hight +yOffset);
        glEnd();
        Texture.unbind();
    }
    public static void DrawBlock(Texture texture,float xOffset,float yOffset,float hight){
        DrawBlock(texture,xOffset,yOffset,hight,new Vector2f(0,0),new Vector2f(1,0),new Vector2f(1,1),new Vector2f(0,1));
    }
    public static void DrawScrean(Texture texture){
        texture.bind();
        glBegin(GL_QUADS);
        glColor3f(1, 1, 1);
        glTexCoord2f(0, 0);
        glVertex2f(-org.ltsAhMe.pvz.System.glfw.Window.offset, org.ltsAhMe.pvz.System.glfw.Window.DrawFox);
        glTexCoord2f(1, 0);
        glVertex2f(org.ltsAhMe.pvz.System.glfw.Window.offset, org.ltsAhMe.pvz.System.glfw.Window.DrawFox);
        glTexCoord2f(1, 1);
        glVertex2f(org.ltsAhMe.pvz.System.glfw.Window.offset, -org.ltsAhMe.pvz.System.glfw.Window.DrawFox);
        glTexCoord2f(0, 1);
        glVertex2f(-org.ltsAhMe.pvz.System.glfw.Window.offset, -Window.DrawFox);
        glEnd();
        Texture.unbind();
    }


    public static BufferedImage jpgGetPng(BufferedImage image,BufferedImage backImage){
        int[] Backpixels = new int[backImage.getWidth() * backImage.getHeight()];
        int[] pixels = new int[image.getWidth() * image.getHeight()];

        backImage.getRGB(0, 0, backImage.getWidth(), backImage.getHeight(), Backpixels, 0, backImage.getWidth());//获取图片像素
        image.getRGB(0,0,image.getWidth(),image.getHeight(),pixels,0,image.getWidth());

        BufferedImage done = new BufferedImage(image.getWidth(),image.getHeight(),BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics2D = (Graphics2D) done.getGraphics();

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int Backpixel = Backpixels[y * backImage.getWidth() + x];
                int alpha = ((Backpixel >> 16) & 0xFF);
                int pixel = pixels[y * image.getWidth() + x];
                int red = (pixel >> 16) & 0xFF;
                int green = (pixel >> 8) & 0xFF;
                int blue = pixel & 0xFF;

                graphics2D.setColor(new Color(red,green,blue,alpha));
                graphics2D.drawLine(x,y,x,y);
            }
        }
        graphics2D.dispose();
        return done;
    }

}

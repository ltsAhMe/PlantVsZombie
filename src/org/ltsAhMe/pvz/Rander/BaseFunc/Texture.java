package org.ltsAhMe.pvz.Rander.BaseFunc;

import org.ltsAhMe.pvz.PlantVsZombie;
import org.lwjgl.BufferUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

import static org.lwjgl.opengl.GL11.*;

public class Texture {
    private int id;

    public float offsetX;
    public float offsetY;
    public Texture(String name){
        glEnable(GL_TEXTURE_2D);
        try {
            TakeTexture(ImageIO.read(new File(PlantVsZombie.gameResDir+name)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Texture(String name,String BackImage){
        glEnable(GL_TEXTURE_2D);
        try {
            TakeTexture(BaseFunc.jpgGetPng(ImageIO.read(new File(PlantVsZombie.gameResDir+name)),ImageIO.read(new File(PlantVsZombie.gameResDir+BackImage))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Texture(BufferedImage image) {
        TakeTexture(image);
    }

    public void TakeTexture(BufferedImage image){

        offsetX = image.getWidth() / image.getHeight();
        offsetY = image.getHeight() / image.getWidth();

        int[] pixels = new int[image.getWidth() * image.getHeight()];//创建像素列表



        image.getRGB(0, 0, image.getWidth(), image.getHeight(), pixels, 0, image.getWidth());//获取图片像素

        ByteBuffer buffer = BufferUtils.createByteBuffer(image.getWidth() * image.getHeight() * 4);//创建字节缓冲区，*4是包含alpha *3不包含


        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int pixel = pixels[y * image.getWidth() + x];


                int alpha = (pixel >> 24) & 0xFF;
                int red = (pixel >> 16) & 0xFF;
                int green = (pixel >> 8) & 0xFF;
                int blue = pixel & 0xFF;

                buffer.put((byte) red);//像素点的Red
                buffer.put((byte) green);//像素点的Green
                buffer.put((byte) blue);//像素点的Blue
                buffer.put((byte) alpha);//像素点的Alpha
            }
        }

        buffer.flip(); //一定要翻转



        id = glGenTextures();

        glBindTexture(GL_TEXTURE_2D, id);

        //设置缩放过滤
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);

        //发送数据到OpenGL
        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, image.getWidth(), image.getHeight(), 0, GL_RGBA, GL_UNSIGNED_BYTE, buffer);
    }

    public void bind(){
        glBindTexture(GL_TEXTURE_2D,id);
    }
    public static void unbind(){
        glBindTexture(GL_TEXTURE_2D,0);
    }

}

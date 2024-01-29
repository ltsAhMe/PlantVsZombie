package org.ltsAhMe.pvz.Rander.BasePos;

import java.awt.*;

public class FloatRect {
   public float x;
   public float y;
   public float width;
   public float height;

    public FloatRect(FloatPoint point1, FloatPoint point2){
        this(point1.x, point1.y, point2.x-point1.x, point2.y-point1.y);
    }
    public FloatRect(float x,float y,float width,float height){
        this.x = x;
        this.y=y;
        this.width = width;
        this.height = height;
    }
    public boolean conTect(FloatPoint point){
        if (x<=point.x && point.x<=x+width&&y<= point.y && point.y<=y+height){
            return true;
        }
        return false;
    }

}

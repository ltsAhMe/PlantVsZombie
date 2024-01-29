package org.ltsAhMe.pvz.Rander.BasePos;

import java.awt.*;

public class Rect extends Rectangle {
    public Rect(Point point1,Point point2){
        super(point1.x, point1.y, point2.x- point1.x,point2.y- point1.y);
    }
}

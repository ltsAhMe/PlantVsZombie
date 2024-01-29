package org.ltsAhMe.pvz.System.timer;

public class Pick {

    long lastTime;
    double shoudTime;
    public Pick(int fps){
        shoudTime = 1000000000/fps;
        lastTime=System.nanoTime();
    }
    public boolean kick(){
        long nowTime = System.nanoTime();

        if (nowTime-lastTime>=shoudTime){
            lastTime=nowTime;
            return true;
        }
        return false;
    }

}

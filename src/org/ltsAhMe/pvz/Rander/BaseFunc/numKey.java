package org.ltsAhMe.pvz.Rander.BaseFunc;

public class numKey {
 int start=0;
 int end=0;
 int speed=0;
 int tempSpeed=0;
 int temp=0;
    boolean isloop = false;
    public numKey(int start,int end,int speed){

        this.speed = speed;
        this.start = start;
        this.end = end;
    }
    public numKey(int end,boolean isloop,int speed){
        this.speed = speed;
        this.end = end;
        this.isloop = isloop;
    }
    public numKey(int start,int end,boolean isloop,int speed){
        this.speed = speed;
        this.isloop = isloop;
        this.start = start;
        this.end = end;
    }
    public int get(){
        int done = temp;
        if (tempSpeed==speed){
            if (temp+1<end){
                temp++;
            }else if (isloop){
                temp=0;
            }
            tempSpeed =0;
        }else {
            tempSpeed++;
        }
        return done;
    }
    public void reserve(){
        temp=start;
    }
}

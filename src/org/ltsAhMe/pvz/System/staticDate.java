package org.ltsAhMe.pvz.System;

import org.ltsAhMe.pvz.System.Renim.reanimReader;

import java.io.File;

public class staticDate {
   public static boolean done =false;
    public static reanimReader ren;
    public  static reanimReader dave;

   public static void init(){
       Thread thread = new Thread(){
           @Override
           public void run() {
               super.run();
               ren = new reanimReader(new File("C:\\Users\\ltsAhMe\\Desktop\\PvZ_Toolkit_v1.20.3\\extract_1706608964\\reanim\\Cabbagepult.reanim"));
               dave = new reanimReader(new File("C:\\Users\\ltsAhMe\\Desktop\\PvZ_Toolkit_v1.20.3\\extract_1706608964\\reanim\\Blover.reanim"));
               System.out.print("done");
               done = true;
           }
       };
       thread.start();
   }


}

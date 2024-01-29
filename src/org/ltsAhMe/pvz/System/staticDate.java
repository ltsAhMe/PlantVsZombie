package org.ltsAhMe.pvz.System;

import org.ltsAhMe.pvz.System.Renim.reanimReader;

import java.io.File;

public class staticDate {
   public static boolean done =false;
    public static reanimReader ren = new reanimReader(new File("C:\\Users\\ltsAhMe\\Desktop\\zombie\\PVZres\\reanim\\CobCannon.reanim"));
    public  static reanimReader dave = new reanimReader(new File("C:\\Users\\ltsAhMe\\Desktop\\zombie\\PVZres\\reanim\\Blover.reanim"));

   public static void init(){
       Thread thread = new Thread(){
           @Override
           public void run() {
               super.run();
               ren = new reanimReader(new File("C:\\Users\\ltsAhMe\\Desktop\\zombie\\PVZres\\reanim\\CobCannon.reanim"));
               dave = new reanimReader(new File("C:\\Users\\ltsAhMe\\Desktop\\zombie\\PVZres\\reanim\\Blover.reanim"));
               System.out.print("done");
               done = true;
           }
       };
       thread.start();
   }


}

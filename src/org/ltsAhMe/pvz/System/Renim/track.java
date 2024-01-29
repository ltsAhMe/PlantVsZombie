package org.ltsAhMe.pvz.System.Renim;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class track {




    float x = 0;
    float y = 0;
    float sx = 1;
    float sy = 1;

    float kx = 0;
    float ky = 0;
    public BufferedImage img;
    String name = "";
    String allCommend;
   public boolean isHidden = false;

    public track(String commend) {
        allCommend = commend;
        this.name = new MiyaXML(commend).getTypeContent("name",0);
        Read(0);
    }
        public void Read ( int num){



            MiyaXML miyaXML = new MiyaXML(new MiyaXML(allCommend).getTypeContent("t", num));
            if (!miyaXML.getTypeContent("i", 1).equals("")) {
                String imgTemp = miyaXML.getTypeContent("i", 0);
                String tempFile = staticDate.resdir + imgTemp.toLowerCase().substring(13, imgTemp.length()) + ".png";
                try {
                    img = ImageIO.read(new File(tempFile));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (!miyaXML.getTypeContent("f", 1).equals("")) {
                int temp = Integer.parseInt(miyaXML.getTypeContent("f", 1));
                if (temp == -1){
                    isHidden = true;
                }else {
                    isHidden=false;
                }
            }
            if (!miyaXML.getTypeContent("x", 1).equals("")) {
                x = Float.parseFloat(miyaXML.getTypeContent("x", 1));
            }
            if (!miyaXML.getTypeContent("x", 1).equals("")) {
                x = Float.parseFloat(miyaXML.getTypeContent("x", 1));
            }
            if (!miyaXML.getTypeContent("y", 1).equals("")) {
                y = Float.parseFloat(miyaXML.getTypeContent("y", 1));
            }
            if (!miyaXML.getTypeContent("sx", 1).equals("")) {
                sx = Float.parseFloat(miyaXML.getTypeContent("sx", 1));
            }
            if (!miyaXML.getTypeContent("sy", 1).equals("")) {
                sy = Float.parseFloat(miyaXML.getTypeContent("sy", 1));
            }
            if (!miyaXML.getTypeContent("ky", 1).equals("")) {
                ky = Float.parseFloat(miyaXML.getTypeContent("ky", 1));
            }
            if (!miyaXML.getTypeContent("kx", 1).equals("")) {
                kx = Float.parseFloat(miyaXML.getTypeContent("kx", 1));
            }


        }
        public void init(){
            x=0;
            y=0;
            sy=1;
            sx = 1;
            kx=0;
            ky=0;
            img = null;
        }
    }


package org.ltsAhMe.pvz.Rander.BaseFunc;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Text {
    public static Font dFont = new Font("Alert",Font.PLAIN,30);
    private static Graphics2D graphics2D= (Graphics2D) new BufferedImage(1,1,BufferedImage.TYPE_INT_RGB).getGraphics();
    public static BufferedImage getStringImg(Font font, String string, Color color) {
        FontMetrics fontMetrics = getFontMetrics(font);
        int stringWidth = fontMetrics.stringWidth(string);
        int stringHeight = fontMetrics.getHeight();

        BufferedImage done = new BufferedImage(stringWidth, stringHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = (Graphics2D) done.getGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(color);
        g.setFont(font);
        int x = 0;
        int y = fontMetrics.getAscent();

        g.drawString(string, x, y);
        g.dispose();

        return done;
    }



   private static FontMetrics getFontMetrics(Font font){
        return graphics2D.getFontMetrics(font);
    }
}

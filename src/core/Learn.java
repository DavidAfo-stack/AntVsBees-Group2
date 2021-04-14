package core;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Learn {
    public static void main(String[] args) {
           /* ImageIcon icon = new ImageIcon("img/ant_fire.gif");
            JLabel label = new JLabel(icon);
            label.setText("This is a jlabel");
            JOptionPane.showMessageDialog(null, label);*/
        String html = "<html><body>" +
                "image:" + Learn.getImage() + "<br>"+
                "</body></html>";

        JOptionPane.showMessageDialog(null, html);
    }

    public static ImageIcon getImage(){
          ImageIcon img = new ImageIcon("img/ant_fire.gif");
          return img;
    }
}

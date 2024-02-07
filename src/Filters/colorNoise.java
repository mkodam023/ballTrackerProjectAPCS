package Filters;

import Interfaces.PixelFilter;
import core.DImage;

import javax.swing.*;


public class colorNoise implements PixelFilter {
    private double n;
    public colorNoise(){
        String r = JOptionPane.showInputDialog(null, "enter a noise percentage");
        n = Double.parseDouble(r);
    }
    @Override
    public DImage processImage(DImage img) {
        n = 0.5;
        short[][] red = img.getRedChannel();
        short[][] green = img.getGreenChannel();
        short[][] blue = img.getBlueChannel();



        for (int r = 0; r < red.length; r++) {
            for (int c = 0; c < red[r].length; c++) {
                if (Math.random()<n){
                    red[r][c] = (short)(Math.random()*256);
                    green[r][c] = (short)(Math.random()*256);
                    blue[r][c] = (short)(Math.random()*256);
                }
            }
        }

        img.setColorChannels(red, green, blue);
        return img;
    }
}

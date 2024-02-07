package Filters;

import Interfaces.PixelFilter;
import core.DImage;

public class colorFilter implements PixelFilter {
    private int targetR, targetG, targetB, dist;
    public colorFilter(){
        targetR = 125;
        targetG = 20;
        targetB = 200;
        dist = 20;
    }
    @Override
    public DImage processImage(DImage img) {
        short[][] red = img.getRedChannel();
        short[][] green = img.getGreenChannel();
        short[][] blue = img.getBlueChannel();
        System.out.println(img.getHeight() + " " + img.getWidth());

        for (int row = 0; row < img.getWidth()-1; row++) {
            for (int col = 0; col < img.getHeight()-1; col++) {
                System.out.println(row + " " + col);
                if (Math.sqrt((Math.pow(red[row][col] - targetR,2)) + (Math.pow(green[row][col] - targetB,2)) + (Math.pow(blue[row][col] - targetB,2)))>dist){
                    red[row][col] = 0;
                    green[row][col] = 0;
                    blue[row][col] = 0;
                }
            }
        }
        img.setColorChannels(red, green, blue);
        return img;
    }
}

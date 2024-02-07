package Filters;

import Interfaces.PixelFilter;
import core.DImage;

public class ballTrack implements PixelFilter {
    @Override
    public DImage processImage(DImage img) {
        short[][] red = img.getRedChannel();
        short[][] green = img.getGreenChannel();
        short[][] blue = img.getBlueChannel();
        int ballX = 0;
        int ballY = 0;
        int ballZ = 0;
        short ballR = 0;
        short ballG = 0;
        short ballB = 255;





        img.setColorChannels(red, green, blue);
        return img;
    }
}

package Filters;

import Interfaces.PixelFilter;
import core.DImage;

public class Downsample implements PixelFilter {
    @Override
    public DImage processImage(DImage img) {
        short[][] oldgrid = img.getBWPixelGrid();
        short[][] grid = new short[oldgrid.length/2][oldgrid[0].length/2];
        for (int x = 0; x < oldgrid.length-1; x+=2) {
            for (int y = 0; y < oldgrid[0].length-1; y+=2) {
                short newPixel = (short) ((oldgrid[x][y]+ oldgrid[x+1][y] + oldgrid[x][y+1] + oldgrid[x+1][y+1])/4);
                grid[x/2][y/2] = newPixel;
            }
        }

        img.setPixels(grid);
        return img;

    }
}

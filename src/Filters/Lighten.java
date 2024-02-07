package Filters;

import Interfaces.PixelFilter;
import core.DImage;

public class Lighten implements PixelFilter {
    @Override
    public DImage processImage(DImage img) {
        short[][] grid = img.getBWPixelGrid();
        int lightenValue = 45;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j]>=255-lightenValue){
                    grid[i][j]=255;
                }else {
                    short pixel = grid[i][j];
                    short newPix = (short) (255-(pixel/2)+lightenValue);
                }
            }
        }
        img.setPixels(grid);
        return img;
    }
}

package Filters;

import Interfaces.PixelFilter;
import core.DImage;

public class Objborder implements PixelFilter {
    @Override
    public DImage processImage(DImage img) {
        short[][]grid = img.getBWPixelGrid();
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {

            }
        }
        img.setPixels(grid);
        return img;
    }
}

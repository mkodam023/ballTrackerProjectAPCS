package Filters;

import Interfaces.PixelFilter;
import core.DImage;

public class Border implements PixelFilter {
    @Override
    public DImage processImage(DImage img) {
        short[][] grid = img.getBWPixelGrid();
        int borderThick = 50;
        int borderShade = 65;
        for (int y = 0; y < borderThick; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                grid[y][x] = (short) borderShade;
            }
            for (int y1 = grid.length - borderThick; y1 < grid.length; y1++) {
                for (int x1 = 0; x1 < grid[0].length; x1++) {
                    grid[y1][x1] = (short) borderShade;


                }

            }
            for (int y2 = 0; y2 < grid.length; y2++) {
                for (int x2 = 0; x2 < borderThick; x2++) {
                    grid[y2][x2] = (short) borderShade;
                }
            }

            for (int y3 = 0; y3 < grid.length; y3++) {
                for (int x3 = grid[0].length-borderThick; x3 < grid[0].length; x3++) {
                    grid[y3][x3] = (short) borderShade;
                }
            }
        }
        img.setPixels(grid);
        return img;
    }
}

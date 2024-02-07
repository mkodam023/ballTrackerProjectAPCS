package Filters;

import Interfaces.PixelFilter;
import core.DImage;

import javax.swing.*;

public class Polychrome implements PixelFilter {
    @Override
    public DImage processImage(DImage img) {
        short[][]grid = img.getBWPixelGrid();
        String response = JOptionPane.showInputDialog("select amount of sections");

        int numsections =Integer.parseInt(response);
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                short pixval = grid[r][c];
                pixval = (short)(pixval/(255/numsections)*(255/numsections)+(255/numsections)/2);
                grid[r][c] = pixval;
            }
        }
        img.setPixels(grid);
        return img;
    }
}

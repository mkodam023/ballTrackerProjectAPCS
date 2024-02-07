package Filters;

import Interfaces.PixelFilter;
import core.DImage;

public class Convolution implements PixelFilter {
    private double[][] boxBlurKernel = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
    private double[][] PrewittEdgeKernel = {{-1, -1, -1}, {-1, 8, -1}, {-1, -1, -1}};
    private double[][] Sharpen = {{0, -1, 0}, {-1, 5, -1}, {0, -1, 0}};
    private double[][] Emboss = {{-2, -1, 0}, {-1, 1, 1}, {0, 1, 2}};
    private double[][] GaussianBlur = {{0, 0, 0, 5, 0, 0, 0}, {0, 5, 18, 32, 18, 5, 0}, {0, 18, 64, 100, 64, 18, 0}, {5, 32, 100, 100, 100, 32, 5}, {0, 0, 0, 5, 0, 0, 0}, {0, 5, 18, 32, 18, 5, 0}, {0, 18, 64, 100, 64, 18, 0}};
    private double[][] Gx = {{-1, 0, 1}, {-2, 0, 2}, {-1, 0, 1}};
    private double[][] Gy = {{1, 2, 1}, {0, 0, 0}, {-1, -2, -1}};
    /*  you can define others here */

    public Convolution() {
    }

    @Override
    public DImage processImage(DImage img) {
        short[][] red = img.getRedChannel();
        short[][] green = img.getGreenChannel();
        short[][] blue = img.getBlueChannel();


//        red = doSobel(red, Gx, Gy);
//        green = doSobel(green, Gx, Gy);
//        blue = doSobel(blue, Gx, Gy);
        red = doConvolutions(red, Emboss);
        green = doConvolutions(green, Emboss);
        blue = doConvolutions(blue, Emboss);


       /* perform convolution with one of the kernels defined above
               on each color channel separately
        */

        img.setColorChannels(red, green, blue);
        return img;
    }

    private short[][] doSobel(short[][] grid, double[][] Gx, double[][] Gy) {
        int threshold = 127;
        short newGrid[][] = new short[grid.length][grid[0].length];
        short gridX[][];
        short gridY[][];
        gridX = doConvolutions(grid, Gx);
        gridY = doConvolutions(grid, Gy);

        for (int i = 0; i < newGrid.length; i++) {
            for (int j = 0; j < newGrid[0].length; j++) {
                short x = gridX[i][j];
                short y = gridY[i][j];
                short newVal = (short) Math.sqrt(x * x + y * y);
                if (newVal > threshold) {
                    newVal = 255;
                } else {
                    newVal = 0;
                }
                newGrid[i][j] = newVal;
            }
        }
        return newGrid;
    }

    private short[][] doConvolutions(short[][] grid, double[][] kernel) {
        short[][] newGrid = new short[grid.length][grid[0].length];
        for (int row = kernel.length / 2; row < grid.length - kernel.length / 2; row++) {
            for (int col = kernel[0].length / 2; col < grid[0].length - kernel[0].length / 2; col++) {
                int newVal = computeOutput(grid, kernel, row, col);
                newGrid[row][col] = (short) newVal;
            }
        }
        return newGrid;
    }

    private int computeOutput(short[][] grid, double[][] boxBlurKernel, int startR, int startC) {
        int output = 0;
        int kernelValue = 0;
        for (int row = 0; row < boxBlurKernel.length; row++) {
            for (int col = 0; col < boxBlurKernel[0].length; col++) {
                int weight = (int) boxBlurKernel[row][col];
                kernelValue += weight;
                int pixelVal = grid[row + startR - ((boxBlurKernel.length) / 2)][col + startC - ((boxBlurKernel[0].length) / 2)];
                output += weight * pixelVal;
            }
        }
        if (kernelValue != 0) {
            output /= kernelValue;
        }
        if (output > 255) output = 255;
        if (output < 0) output = 0;
        return output;
    }
}
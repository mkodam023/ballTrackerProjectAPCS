package Filters;

public class Point {
    //short redVal, greenVal, blueVal;
    int x, y, z;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public Point(short redVal, short greenVal, short blueVal) {
        this.x = redVal;
        this.y = greenVal;
        this.z = blueVal;
    }
}

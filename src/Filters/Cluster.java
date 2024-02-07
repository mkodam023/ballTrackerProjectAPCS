package Filters;

import java.util.ArrayList;

public class Cluster {
    private short cr, cg, cb;
    private Point ClusterCenter;
    private ArrayList<Point> clusterPoint = new ArrayList<>();

    public Cluster(short cr, short cg, short cb){
        this.cr = cr;
        this.cg = cg;
        this.cb =cb;

    }




    public short getCr() {
        return cr;
    }

    public void setCr(short cr) {
        this.cr = cr;
    }

    public short getCg() {
        return cg;
    }

    public void setCg(short cg) {
        this.cg = cg;
    }

    public short getCb() {
        return cb;
    }

    public void setCb(short cb) {
        this.cb = cb;
    }




//    public List<Object> getPoints() {
//        return
//    }
}


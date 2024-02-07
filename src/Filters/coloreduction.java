//package Filters;
//
//import Interfaces.PixelFilter;
//import core.DImage;
//
//import java.util.ArrayList;
//
//public class coloreduction implements PixelFilter {
//
//
//    @Override
//    public DImage processImage(DImage img) {
//        short[][] red = img.getRedChannel();
//        short[][] green = img.getGreenChannel();
//        short[][] blue = img.getBlueChannel();
//        int k = 4;
//
//        ArrayList<Point> points = makePList(red, green, blue);
//        ArrayList<Cluster> clusters = initializeClusters(k);
//        for (int i = 0; i < 10; i++) {
//            clearCluster(clusters);
//            assignPoint(clusters, points);
//            reCalculate(clusters, points);
//
//        }
//        img.setColorChannels(red, green, blue);
//        return img;
//    }
//
//    private ArrayList<Point> makePList(short[][] red, short[][] green, short[][] blue) {
//        ArrayList<Point> pList = new ArrayList<>();
//        for (int i = 0; i < red.length; i++) {
//            for (int j = 0; j < red[0].length; j++) {
//                pList.add(new Point(red[i][j], green[i][j], blue[i][j]));
//            }
//
//        }
//        return pList;
//    }
//
//    private ArrayList<Cluster> initializeClusters(int k) {
//        ArrayList<Cluster> clusters = new ArrayList();
//        for (int i = 0; i < k; i++) {
//            clusters.add(new Cluster((short) (Math.random() * 256), (short) (Math.random() * 256), (short) (Math.random() * 256)));
//        }
//        return clusters;
//    }
//
//    private void clearCluster(ArrayList<Cluster> clusters) {
//        for (Cluster cluster : clusters) {
//            cluster.setPoints(new ArrayList<>());
//        }
//    }
//
//    private Cluster findClosestCluster(ArrayList<Cluster> clusters, Point point) {
//        double minDistance = Double.MAX_VALUE;
//        Cluster closestCluster = null;
//
//        for (Cluster cluster : clusters) {
//            double distance = Math.sqrt(Math.pow(point.getX() - cluster.getCr(), 2) + Math.pow(point.getY() - cluster.getCg(), 2) + Math.pow(point.getZ() - cluster.getCb(), 2));
//            if (distance < minDistance) {
//                minDistance = distance;
//                closestCluster = cluster;
//            }
//        }
//
//        return closestCluster;
//    }
//
//    private void reCalculate(ArrayList<Cluster> clusters, ArrayList<Point> points) {
//        for (Cluster cluster : clusters) {
//            double xSum = 0;
//            double ySum = 0;
//            double zSum = 0;
//            for (Point point : points) {
//                xSum += point.getX();
//                ySum += point.getY();
//                zSum += point.getZ();
//            }
//            cluster.setCr((short) (xSum / points.size()));
//            cluster.setCg((short) (ySum / points.size()));
//            cluster.setCb((short) (zSum / points.size()));
//        }
//    }
//
//}
//
//
//
//
//

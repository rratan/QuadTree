package com.rratan.quadTree.RectangularRegions;

import com.rratan.quadTree.GeoPoints.GeoPoints;
import com.rratan.quadTree.GeoPoints.Point;

import java.util.ArrayList;
import java.util.List;

public class RectangularRegion implements Region {
    private double xl;
    private double xh;

    public double getXl() {
        return xl;
    }

    public double getXh() {
        return xh;
    }

    public double getYl() {
        return yl;
    }

    public double getYh() {
        return yh;
    }

    private double yl;
    private double yh;
    private  List<Point> points;

    public RectangularRegion(double xl ,  double xh, double yl, double yh) {
        this.xl = xl;
        this.xh = xh;
        this.yl = yl;
        this.yh = yh;
        this.points = new ArrayList<>();
    }

    @Override
    public boolean containsPoint(Point p) {
        if(p.getLatitude() > xh || p.getLatitude() <xl || p.getLongitude() > yl || p.getLatitude() <yh){
            return false;
        }
        return true;
    }

    @Override
    public List<Point> findPoint(Point p, double radius) {
        List<Point> ans = new ArrayList<>();
        for(Point pr : points){
            if( ((GeoPoints)p).geteuclediandistance(pr) <=radius){
                ans.add(pr);
            }
        }
        return  ans;
    }

    public int getPointCount(){
        return points.size();
    }

    public boolean addPoint(Point p){
        return points.add(p);
    }


}

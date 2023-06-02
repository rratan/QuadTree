package com.rratan.quadTree;

import com.rratan.quadTree.RectangularRegions.RectangularRegion;
import com.rratan.quadTree.RectangularRegions.Region;
import com.rratan.quadTree.GeoPoints.Point;

import java.util.ArrayList;
import java.util.List;

public class QuadTree {
    private List<QuadTree> childQuadrant;
    private Region r;
    private static int THRESHOLD_POINTS = 10;

    public QuadTree(Region r){
        this.r = r;

    }

    public boolean addPoint(Point p){
        QuadTree nodeToSearch = findQuadrant(p);
        if(((RectangularRegion)nodeToSearch.getRegion()).getPointCount() >= QuadTree.THRESHOLD_POINTS){
               divideInto4Quadrant();
        }
        for(QuadTree child : childQuadrant){
            if(child.getRegion().containsPoint(p)){
                return ((RectangularRegion)child.getRegion()).addPoint(p);
            }
        }
        return false;
    }


    public void divideInto4Quadrant(){
        RectangularRegion region = (RectangularRegion)this.r;
        double midX = (region.getXh() - region.getXl()) / 2.0;
        double midY = (region.getYh() - region.getYl()) / 2.0;
        childQuadrant.add(new QuadTree(new RectangularRegion(region.getXl(), midX , region.getYl(),midY)));
        childQuadrant.add(new QuadTree(new RectangularRegion(midX+1 ,region.getXh(), region.getYl(),midY)));
        childQuadrant.add(new QuadTree(new RectangularRegion(region.getXl(), midX , midY+1, region.getYh())));
        childQuadrant.add(new QuadTree(new RectangularRegion(midX+1 ,region.getXh(), midY+1, region.getYh())));
    }

    public Region getRegion(){
        return this.r;
    }


    public QuadTree findQuadrant(Point p) {
        QuadTree node;
        if(childQuadrant == null && r.containsPoint(p)){
            return this;
        }
        for(QuadTree child :  this.childQuadrant){
            node = child.findQuadrant(p);
            if(node != null){
                return node;
            }
        }
        return null;
    }

    public List<Point> search(Point p , List<Point> ans){
        if(ans == null){
            ans = new ArrayList<>();
        }
        ans.addAll(( (RectangularRegion)r).findPoint(p,10.0));
        for(QuadTree child: childQuadrant){
            child.search(p,ans);
        }
        return ans;
    }



}

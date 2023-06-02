package com.rratan.quadTree.RectangularRegions;


import com.rratan.quadTree.GeoPoints.Point;

import java.util.List;

public interface Region {

    boolean containsPoint(Point p);
    List<Point> findPoint(Point p , double radius);

}

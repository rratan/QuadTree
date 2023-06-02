package com.rratan.quadTree.GeoPoints;

public interface Point {

    double getLatitude();
    double getLongitude();

    double geteuclediandistance(Point source);

    double getManHattenDistance(Point source);

}

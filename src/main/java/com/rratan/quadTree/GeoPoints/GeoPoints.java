package com.rratan.quadTree.GeoPoints;

public class GeoPoints implements Point {

    private double lat;
    private double lon;

    public GeoPoints(double lat, double lon){
        this.lat = lat;
        this.lon = lon;
    }

    @Override
    public double getLatitude() {
        return lat;
    }

    @Override
    public double getLongitude() {
        return lon;
    }

    @Override
    public double getManHattenDistance(Point source) {
        return Math.sqrt(Math.pow(source.getLatitude()-lat,2) + Math.pow(source.getLongitude()-lat,2));
    }

    @Override
    public double geteuclediandistance(Point source) {
        return Math.abs(source.getLatitude()-lat) + Math.abs(source.getLongitude()-lon);
    }
}

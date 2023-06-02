package com.rratan.quadTree;

public class ProximityService {
    /*
    1. Design a proximity service i.e give a point and radius find all the relevant points inside it.
    2. User can filter the output based on distance and type.
    3. How will we represent the flat 2-d map??
    4. User can register new place to the service.
    5. Metadata about place.

    Non-Functional
        1. highly available service.

    Region - which marks the boundary of an area.
            overlap(Region s)
            containsPoint(Point p)
     Points - are independent co-ordinate in the flat map.

     QuadTree - Each Node will represent a region.
                When we add a point it will be added to approriate region.
                If Region threshold exceeds the quadTree will sub-divide into four child quad-Drants. Corresponding 4 region will be computed based on regions.
                When we split the regions into 4 we will not re-distribute the points child Nodes. Rather child Node will contains points going forward.

           ADD:-
                1. Check if node is leaf node.
                 If yes: Check the four Node and recursive go to appropirate node.
                 Before adding Check if limit is exceeded. If yes divide the region and create 4 quadrants and assign the point to one quadTree
           SEARCH:-
                 1. Find all the points in given region point.
                2. Check if given node is leaf node or not.
                    Yes - check if region conatins points and recusively search in that region.


     */


}

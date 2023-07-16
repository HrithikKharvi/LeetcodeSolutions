package com.example;

class Point{
    double x;
    double y;
    Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void setLocation(double x, double y){
        this.x = x;
        this.y = y;
    }
}

class Line{
     Point start;
     Point end;
     double slop;
     double yIntercept;

     public Line(Point start, Point end){
         this.start = start;
         this.end = end;
         double deltaX = (end.x - start.x);
         double deltaY = (end.y - start.y);

         this.slop = deltaY / deltaX;
         this.yIntercept = end.y - this.slop * end.x;
     }
}


public class Main {

    public static void main(String[] args) {

        Point start1 = new Point(1,2);
        Point end1 = new Point(3,2);
        Point start2 = new Point(2,2);
        Point end2 = new Point(4,2);

        Point intersection = calculateIntersection(start1, end1, start2, end2);
        if(intersection == null)return;
        System.out.println(intersection.x);
        System.out.println(intersection.y);
    }

    public static Point calculateIntersection(Point start1, Point end1, Point start2, Point end2){
        if(start1.x > end1.x)swap(start1, end1);
        if(start2.x > end2.x)swap(start2, end2);

        if(start1.x > start2.x){
            swap(start1, start2);
            swap(end1, end2);
        }

        //Create the line using the points

        Line line1 = new Line(start1, end1);
        Line line2 = new Line(start2, end2);

        //check if both line has same slop, if they are equal there could be chance of parallel lines

        if(line1.slop == line2.slop){
            if(line1.yIntercept == line2.yIntercept && isBetween(start1, start2, end1)){
                return start2;
            }
            return null;
        }

        //Okay, now they don't have same slops
        //calculate the intersection Point using the formula;

        double x = (line2.yIntercept - line1.yIntercept) / (line1.slop - line2.slop);
        double y = x * line1.slop + line1.yIntercept;
        Point intersection = new Point(x, y);

        //check whether the intersection point lies between both line1 and line2

        if(isBetween(start1, intersection, end1) && isBetween(start2, intersection, end2)){
            return intersection;
        }

        return null;

    }


    public static boolean isBetween(double start, double intersection, double end){
        if(start > end){
            return end <= intersection && start >= intersection;
        }else{
            return start <= intersection && end >= intersection;
        }
    }

    public static boolean isBetween(Point start, Point intersection, Point end){
        return (isBetween(start.x, intersection.x, end.x) && isBetween(start.y, intersection.y, end.y));
    }

    public static void swap(Point p1, Point p2){
        double x = p1.x;
        double y = p1.y;
        p1.setLocation(p2.x, p2.y);
        p2.setLocation(x, y);
    }

}

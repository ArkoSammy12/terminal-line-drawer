public record Line(Point p1, Point p2) {

    public double getEuclideanLength(){

        return Math.sqrt(Math.pow(p2.x() - p1.x(), 2) + Math.pow(p2.y() - p1.y(), 2));

    }

    public int getDeltaX(){
        return Math.abs(p2.x() - p1.x());
    }

    public int getDeltaY(){
        return Math.abs(p2.y() - p1.y());
    }

}

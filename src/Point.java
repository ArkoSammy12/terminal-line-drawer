public record Point(int x, int y) {

    public double getEuclideanDistanceTo(Point other){

        return Math.sqrt(Math.pow(other.x - this.x, 2) + Math.pow(other.y - this.y, 2));

    }

    public static Point fromCoordinate(int x, int y){
        return new Point(x, y);
    }

    @Override
    public String toString(){

        return "x: " + x + ", y: " + y;

    }
    
}

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

public class LineDrawer {

    private List<Line> lines = new ArrayList<>();

    public void submitLine(Line line){

        if(!lines.contains(line)){
            lines.add(line);
        }

    }

    public void submitAllLines(Collection<Line> inputLines){

        for(Line l : inputLines){

            if(!lines.contains(l)){
                
                lines.add(l);

            }

        }

    }

    public List<Point> generatePointsForLines(){

        List<Point> points = new ArrayList<>();

        // Bresenham's Line Algorithm
        Function<Line, List<Point>> pointGenerator = (line) -> {
            
            // List to store the points on the line
            List<Point> linePoints = new ArrayList<>();

            // Differences in x and y coordinates
            int dx = line.getDeltaX();
            int dy = line.getDeltaY();

            // Starting coordinates
            int x1 = line.p1().x();
            int x2 = line.p2().x();
            int y1 = line.p1().y();
            int y2 = line.p2().y();

            // Determine the step direction for x and y
            int sx = x1 < x2 ? 1 : -1;
            int sy = y1 < y2 ? 1 : -1;

            // Initial error term (difference between actual and expected pixel placement)
            int err = dx - dy;
            int e2;

            // Iterate over the line using Bresenham's Algorithm
            while (x1 != x2 || y1 != y2) {

                // Add the current point to the list
                linePoints.add(Point.fromCoordinate(x1, y1));

                e2 = 2 * err;  // e2 is used to check against thresholds to decide whether to update x or y

                // Update x coordinate based on the error
                if (e2 > -dy) {
                    err -= dy;
                    x1 += sx;
                }

                // Update y coordinate based on the error
                if (e2 < dx) {
                    err += dx;
                    y1 += sy;
                }
            }

            // Return the list of points on the line
            return linePoints;
        };


        for(Line l : this.lines){

            List<Point> pointsForLine = pointGenerator.apply(l);
            points.addAll(pointsForLine);

        }

        return points;

    }

    public void clear(){
        this.lines.clear();
    }
    
}

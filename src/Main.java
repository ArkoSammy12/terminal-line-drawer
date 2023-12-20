import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Main {

    public static void main(String[] args) throws InterruptedException{

        Screen.clearConsole();

        LineDrawer drawer = new LineDrawer();
        List<Line> lineBuffer = new ArrayList<>();

        lineBuffer.add(new Line(Point.fromCoordinate(0, 0), Point.fromCoordinate(29, 29)));
        lineBuffer.add(new Line(Point.fromCoordinate(0, 29), Point.fromCoordinate(29, 0)));

        drawer.submitAllLines(lineBuffer);
        List<Point> points = drawer.generatePointsForLines();
        Screen screen = Screen.getInstance();

        screen.submitAllPoints(points);
        screen.refreshDisplay();
        screen.display();

        Scanner s = new Scanner(System.in);

        while(true){

            System.out.println("Enter a comma separated list of lines with the formatting: x1 y1 x2 y2. Enter q to exit:");
            String input = s.nextLine();

            if(input.equals("q")){
                break;
            }

            Screen.clearConsole();
            lineBuffer.clear();

            String[] lineStrings = input.split(",");

            for(String line : lineStrings){

                Scanner lineScanner = new Scanner(line);

                if(lineScanner.hasNext()){

                    int x1 = lineScanner.nextInt();
                    int y1 = lineScanner.nextInt();
                    //int z1 = lineScanner.nextInt();
                    int x2 = lineScanner.nextInt();
                    int y2 = lineScanner.nextInt();
                    //int z2 = lineScanner.nextInt();

                    //int x1Proj = Math.round((Screen.FOCAL_LENGTH * x1) / (Screen.FOCAL_LENGTH + z1));
                    //int y1Proj = Math.round((Screen.FOCAL_LENGTH * y1) / (Screen.FOCAL_LENGTH + z1));

                    //int x2Proj = Math.round((Screen.FOCAL_LENGTH * x2) / (Screen.FOCAL_LENGTH + z2));
                    //int y2Proj = Math.round((Screen.FOCAL_LENGTH * y2) / (Screen.FOCAL_LENGTH + z2));

                    //lineBuffer.add(new Line(Point.fromCoordinate(x1Proj, y1Proj), Point.fromCoordinate(x2Proj, y2Proj)));
                    lineBuffer.add(new Line(Point.fromCoordinate(x1, y1), Point.fromCoordinate(x2, y2)));


                }

                lineScanner.close();

            }

            drawer.clear();
            drawer.submitAllLines(lineBuffer);
            List<Point> pointList = drawer.generatePointsForLines();
            screen.clearPoints();
            screen.submitAllPoints(pointList);
            screen.refreshDisplay();
            screen.display();

        }

        s.close();

    }

}
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Screen {

    private static Screen instance = null;

    public static final int MAX_X = 140;
    public static final int MAX_Y = 30;
    public static final int FOCAL_LENGTH = 6;
    public static final int FRAME_DELAY = 10;

    private final char[][] matrix = new char[MAX_Y][MAX_X];
    private List<Point> pointList = new ArrayList<>();

    public static Screen getInstance(){

        if (instance == null){
            instance = new Screen();
        }

        return instance;

    }

    private Screen(){

        for (int i = 0; i < MAX_X; i++) {
            for (int j = 0; j < MAX_Y; j++) {
                matrix[j][i] = ' ';
            }
        }

    }

    public void clearPoints(){ 
        this.pointList.clear();
    }

    public void submitPoint(Point p){

        if(!pointList.contains(p)){
            pointList.add(p);
        }

    }

    public void submitAllPoints(Collection<Point> points){

        for(Point p : points){

            if(!pointList.contains(p)){

                pointList.add(p);

            }

        }

    }

    public void refreshDisplay() {

        for (int i = 0; i < MAX_X; i++) {
            for (int j = 0; j < MAX_Y; j++) {
                matrix[j][i] = ' ';
            }
        }

        for(Point p : this.pointList){

            matrix[p.y()][p.x()] = '#';

        }

    }

    public void display() throws InterruptedException {

        for(int i = MAX_Y - 1; i >= 0; i--){

            for(int j = 0; j < MAX_X; j++){

                char c = matrix[i][j];

                System.out.print(c);

            }
            
            System.out.println();

        }

        //Thread.sleep(FRAME_DELAY);
        //clearConsole();

    }

    public static void clearConsole(){

        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

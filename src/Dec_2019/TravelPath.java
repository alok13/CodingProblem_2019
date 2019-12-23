package Dec_2019;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TravelPath {

    public static void main(String[] args) {
        int[][] arr = new int[10][10];
        boolean[][] visited = new boolean[10][10];
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = 0;
                visited[i][j] = false;
            }

        int starting_x = 0;
        int starting_y = 0;
        visited[starting_x][starting_y] = true;
        boolean result = returnPath(arr, visited, starting_x, starting_y, "");
        System.out.println(result);
    }

    private static boolean returnPath(int[][] arr, boolean[][] visited, int x, int y, String tour) {
        List<Path> pathList = new ArrayList<>();
        pathList.add(new Path(3, 0));
        pathList.add(new Path(0, 3));
        pathList.add(new Path(-3, 0));
        pathList.add(new Path(0, -3));
        pathList.add(new Path(2, 2));
        pathList.add(new Path(2, -2));
        pathList.add(new Path(-2, 2));
        pathList.add(new Path(-2, -2));


        String finalResult = tour + " -> " + new Path(x, y).toString();
        if (isTripCompleted(visited)) {
            System.out.println(finalResult);
            return true;
        }

        for (int i = 0; i < pathList.size(); i++) {
            Path path = pathList.get(i);
            int new_x = path.x + x;
            int new_y = path.y + y;
            if (isMovementValid(visited, new_x, new_y)) {
                visited[new_x][new_y] = true;
                System.out.println("Travelling from " + x + "," + y + " to " + (x + path.x) + "," + (y + path.y));
                if (returnPath(arr, visited, new_x, new_y, finalResult))
                    return true;
                else {
                    System.out.println("Cant visit "+ new_x+","+new_y);
                    visited[new_x][new_y] = false;
                }

            }
        }

        return false;
    }

    private static boolean isMovementValid(boolean[][] visited, int new_x, int new_y) {
        if (new_x >= 0 && new_x < visited.length && new_y >= 0 && new_y < visited[0].length && !visited[new_x][new_y])
            return true;
        return false;
    }

    private static boolean isTripCompleted(boolean[][] visited) {
        for (int i = 0; i < visited.length; i++)
            for (int j = 0; j < visited[0].length; j++)
                if (visited[i][j]==false){
                    return false;

                }

        return true;
    }
}


class Path {
    int x;
    int y;

    public Path(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Path{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

package Dec_2019;// Java program to for Kinight's tour problem using
// Warnsdorff's algorithm

import java.util.concurrent.ThreadLocalRandom;

class GFG {
    public static final int N = 10;

    // Move pattern on basis of the change of
    // x coordinates and y coordinates respectively
    public static final int moves_X[] = {3, 2, 0, -2, -3, -2, 0, 2, 0, 0};
    ;
    public static final int moves_Y[] = {0, -2, -3, -2, 0, 2, 3, 2, 0, 0};

    // function restricts the knight to remain within
    // the 8x8 chessboard
    boolean limits(int x, int y) {
        return ((x >= 0 && y >= 0) &&
                (x < N && y < N));
    }

    /* Checks whether a square is valid and
    empty or not */
    boolean isempty(int a[], int x, int y) {
        return (limits(x, y)) && (a[y * N + x] < 0);
    }

    /* Returns the number of empty squares
    adjacent to (x, y) */
    int getDegree(int a[], int x, int y) {
        int count = 0;
        for (int i = 0; i < N; ++i)
            if (isempty(a, (x + moves_X[i]),
                    (y + moves_Y[i])))
                count++;

        return count;
    }

    // Picks next point using Warnsdorff's heuristic.
    // Returns false if it is not possible to pick
    // next point.
    Cell nextMove(int array[], Cell cell) {
        int min_deg_index = -1, degree;

        int min_deg = (N + 1), new_x, new_y;

        // Try all N adjacent of (x, y) starting from a random adjacent. Find the adjacent with minimum degree.
        int start = ThreadLocalRandom.current().nextInt(1000) % N;
        //System.out.println("start "+start);
        for (int count = 0; count < N; count++) {
            int i = (start + count) % N;
            System.out.println("i "+ i);
            new_x = cell.x + moves_X[i];
            new_y = cell.y + moves_Y[i];
            if ((isempty(array, new_x, new_y)) && (degree = getDegree(array, new_x, new_y)) < min_deg) {
                min_deg_index = i;
                min_deg = degree;
            }
        }

        // IF we could not find a next cell
        if (min_deg_index == -1)
            return null;

        // Store coordinates of next point
        new_x = cell.x + moves_X[min_deg_index];
        new_y = cell.y + moves_Y[min_deg_index];

        // Mark next move
        array[new_y * N + new_x] = array[(cell.y) * N +
                (cell.x)] + 1;

        // Update next point
        cell.x = new_x;
        cell.y = new_y;

        return cell;
    }

    /* displays the chessboard with all the
    legal knight's moves */
    void print(int a[]) {
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j)
                System.out.printf("%d\t", a[j * N + i]);
            System.out.printf("\n");
        }
    }

    /* checks its neighbouring sqaures */
	/* If the knight ends on a square that is one
	knight's move from the beginning square,
	then tour is closed */
    boolean neighbour(int x, int y, int xx, int yy) {
        for (int i = 0; i < N; ++i)
            if (((x + moves_X[i]) == xx) &&
                    ((y + moves_Y[i]) == yy))
                return true;

        return false;
    }

    /* Generates the legal moves using warnsdorff's
    heuristics. Returns false if not possible */
    boolean findClosedTour() {
        // Filling up the chessboard matrix with -1's
        int a[] = new int[N * N];
        for (int i = 0; i < N * N; ++i)
            a[i] = -1;

        // initial position
        int sx = 3;
        int sy = 2;

        // Current points are same as initial points
        Cell cell = new Cell(sx, sy);

        a[cell.y * N + cell.x] = 1; // Mark first move.

        // Keep picking next points using Warnsdorff's heuristic
        Cell ret = null;
        for (int i = 0; i < N * N - 1; ++i) {
            ret = nextMove(a, cell);
            if (ret == null)
                return false;
        }

        // Check if tour is closed (Can end
        // at starting point)
        if (!neighbour(ret.x, ret.y, sx, sy))
            return false;

        print(a);
        return true;
    }

    // Driver Code
    public static void main(String[] args) {
        // While we don't get a solution
        while (!new GFG().findClosedTour()) {

        }
    }
}

class Cell {
    int x;
    int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

// This code is contributed by SaeedZarinfam

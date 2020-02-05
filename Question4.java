import java.util.Arrays;

public class Question4 {

    public static void showMazePath(boolean[][] arr, int row, int col) {

        System.out.println(row + ", " + col);
        arr[row][col] = false;

        if (row == arr.length - 1 && col == arr[0].length - 1) {
            System.out.println("end of maze");

            resetMaze(arr, 0);
            return;
        }
        //go down
        if (row < arr.length - 1 && arr[row + 1][col]) {
            showMazePath(arr, row + 1, col);
        }
        //go right
        if (col < arr[0].length - 1 && arr[row][col + 1]) {
            showMazePath(arr, row, col + 1);
        }
        //go up
        if (row > 0 && arr[row - 1][col]) {
            showMazePath(arr, row - 1, col);
        }
        //go left
        if (col > 0 && arr[row][col - 1]) {
            showMazePath(arr, row, col - 1);
        }
    }

    private static void resetMaze(boolean[][] arr, int row) {

        if (row == arr.length) {
            return;
        }
        Arrays.fill(arr[row], false);
        resetMaze(arr, row + 1);
    }

    public static void main(String[] args) {

        boolean[][] arr = {{true, true, true, true ,true},
                          {true, false, false, false, true},
                         {true, false, true, true ,true},
                         {true, false, true, false, true},
                         {true, true, true, false ,true}};

        showMazePath(arr, 0 , 0);
    }
}

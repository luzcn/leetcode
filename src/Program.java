import leetcode.TheMaze2;

public class Program {

    public static void main(String[] args) {

        TheMaze2 maze = new TheMaze2();

        int[][] board = new int[][]{
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0},};

        int result = maze.shortestDistance(board, new int[]{0, 4}, new int[]{4, 4});

        // for (int[] cs : board) {
        //     // for (int c : cs) {
        //     //     System.out.print(c + " ");
        //     // }
        //
        //     Arrays.stream(cs).mapToObj(i -> i + " ").forEach(System.out::print);
        //     System.out.println();
        // }

        System.out.println(result);


    }
}

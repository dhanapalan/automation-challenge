public class MazeSolver {
    public static void main(String[] args) {
        int[][] maze = {
            {0, 1, 1, 1, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 0},
            {1, 1, 1, 0, 0, 0, 0},
            {1, 0, 0, 0, 1, 1, 0},
            {1, 1, 1, 1, 1, 1, 0}
        };

        System.out.println("Can you reach the end of the maze? " + canReachEnd(maze));
    }

    public static boolean canReachEnd(int[][] maze) {
        if (maze == null || maze.length == 0) {
            return false;
        }
                return dfs(maze, 0, 0);
    }

    private static boolean dfs(int[][] maze, int row, int col) {
        if (row < 0 || row >= maze.length || col < 0 || col >= maze[0].length || maze[row][col] == 1) {
            return false;
        }

        if (row == maze.length - 1 && col == maze[0].length - 1) {
            return true;
        }

        maze[row][col] = 1; // Mark the cell as visited

        // Move in all allowed directions: up, down, left, and right
        boolean canReach = dfs(maze, row - 1, col) || dfs(maze, row + 1, col) ||
                           dfs(maze, row, col - 1) || dfs(maze, row, col + 1);

        maze[row][col] = 0; // Backtrack

        return canReach;
    }
}

import java.util.*;

class Point{
    int x,y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class ZombieMatrix {
    public static void main(String[] args) {
        int[][] test1 = new int[][]{{0, 1, 1, 0, 1},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 0, 1},
                {0, 1, 0, 0, 0}};
        ZombieMatrix zm = new ZombieMatrix();
        System.out.println(zm.infectedByZombie(test1));
    }
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    public int infectedByZombie(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        Queue<Point> queue = new LinkedList<>();
        int humanCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    queue.add(new Point(i, j));
                } else {
                    humanCount++;
                }
            }
        }
        int days = 0;
        while (!queue.isEmpty() && humanCount > 0) {
            days++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point cur = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int new_x = cur.x + dx[k];
                    int new_y = cur.y + dy[k];
                    if (new_x < 0 || new_x >= n || new_y < 0 || new_y >= m) {
                        continue;
                    }
                    if (matrix[new_x][new_y] == 1) {
                        continue;
                    }
                    queue.add(new Point(new_x, new_y));
                    matrix[new_x][new_y] = 1;
                }
            }

        }
        return days - 1;
    }
}

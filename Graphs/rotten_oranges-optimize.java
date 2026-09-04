import java.util.*;

class Solution {
    public int orangesRot(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        Queue<int[]> q = new ArrayDeque<>();

        int fresh = 0;


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (mat[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }

                if (mat[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        int time = 0;

        while (!q.isEmpty() && fresh > 0) {

            int size = q.size();

            
            while (size-- > 0) {

                int[] cur = q.poll();

                int r = cur[0];
                int c = cur[1];

                for (int k = 0; k < 4; k++) {

                    int nr = r + dr[k];
                    int nc = c + dc[k];

                    if (nr >= 0 && nr < n &&
                        nc >= 0 && nc < m &&
                        mat[nr][nc] == 1) {

                        mat[nr][nc] = 2;
                        fresh--;

                        q.offer(new int[]{nr, nc});
                    }
                }
            }

            time++;
        }

        return fresh == 0 ? time : -1;
    }
}

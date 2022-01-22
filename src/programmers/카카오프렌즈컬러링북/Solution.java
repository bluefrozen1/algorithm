package programmers.카카오프렌즈컬러링북;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    // https://programmers.co.kr/learn/courses/30/lessons/1829

    public static void main(String[] args) {
        int[] result = new Solution().solution(6,4, new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}});
        int[] result2 = new Solution().solution(6,4, new int[][]{{1, 1, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}});
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(result2));
    }

    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{0, -1, 0, 1};
    public int[] solution(int m, int n, int[][] picture) {

        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(visited[i][j] == true || picture[i][j] == 0) {
                    continue;
                }
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(i, j, m, n, picture, visited, picture[i][j]));
                numberOfArea++;
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    private int bfs(int x, int y, int m, int n, int[][] picture, boolean[][] visited, int imageValue) {

        int maxSize = 0;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});

        while(!q.isEmpty()) {
            int[] cp = q.poll();
            int cx = cp[0];
            int cy = cp[1];

            for(int i=0; i<dx.length; i++) {

                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && visited[nx][ny] == false && imageValue > 0) {
                    int value = picture[nx][ny];
                    if (value == imageValue) {
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        maxSize++;
                        //System.out.println("q add. x=" + nx + ", y=" + ny + ", value=" + value + ", maxSize=" + maxSize + ", visited=" + visited[nx][ny]);
                    }
                }
            }
        }

        return maxSize;
    }
}

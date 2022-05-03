package baekjoon.DFS와BFS_1260;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    // https://www.acmicpc.net/problem/1260
//test1234
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        final String PATH = "src/baekjoon.DFS와BFS/input.txt";
        System.setIn(new FileInputStream(PATH));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int V = Integer.parseInt(stringTokenizer.nextToken());

        //인접행렬 생성
        arr = new int[N+1][N+1];
        while(M-- > 0) {
            stringTokenizer = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        visited = new boolean[N + 1];
        dfs(V);

        System.out.println();

        visited = new boolean[N + 1];
        bfs(V);
    }
    //깊이우선탐색(재귀)
    public static void dfs(int V) {
        visited[V] = true;
        System.out.print(V + " ");

        if(V == arr.length) {
            return;
        }
        for(int j = 1; j < arr.length; j++) {
            //연결은 되어있는데, 방문하지 않았다면 재귀
            if(arr[V][j] == 1 && visited[j] == false) {
                dfs(j);
            }
        }
    }

    //너비우선탐색(큐)
    public static void bfs(int V) {
        Queue<Integer> que = new LinkedList<Integer>();

        que.add(V);
        visited[V] = true;
        System.out.print(V + " ");

        while(!que.isEmpty()) {
            int temp = que.poll();
            for(int i = 1; i < arr.length; i++) {
                if(arr[temp][i] == 1 && visited[i] == false) {
                    que.add(i);
                    visited[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }
}
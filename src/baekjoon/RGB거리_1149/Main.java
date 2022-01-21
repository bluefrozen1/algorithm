package baekjoon.RGB거리_1149;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        final String PATH = "src/backjun.RGB거리_1149/input.txt";
        System.setIn(new FileInputStream(PATH));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());

        int[][] cost = new int[N][3];
        for(int i=0; i<N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int H = Integer.parseInt(stringTokenizer.nextToken());
            int H2 = Integer.parseInt(stringTokenizer.nextToken());
            int H3 = Integer.parseInt(stringTokenizer.nextToken());

            cost[i][0] = H;
            cost[i][1] = H2;
            cost[i][2] = H3;
        }

        for (int i = 1; i < N; i++) {
            cost[i][0] += Math.min(cost[i - 1][1], cost[i - 1][2]);
            cost[i][1] += Math.min(cost[i - 1][0], cost[i - 1][2]);
            cost[i][2] += Math.min(cost[i - 1][0], cost[i - 1][1]);
        }

        System.out.println(Math.min(cost[N - 1][0], Math.min(cost[N - 1][1], cost[N - 1][2])));
    }
}
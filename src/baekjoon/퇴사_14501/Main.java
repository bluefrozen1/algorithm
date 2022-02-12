package baekjoon.퇴사_14501;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        final String PATH = "src/baekjoon/퇴사_14501/input.txt";
        System.setIn(new FileInputStream(PATH));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());

        int[] dayArr = new int[N+10];
        int[] payArr = new int[N+10];
        int[] dpArr = new int[N+10];
        for(int i=0; i<N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            dayArr[i] = Integer.parseInt(stringTokenizer.nextToken());
            payArr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int result = 0;
        for(int i=0; i<=N; i++) {
            int nextDay = dayArr[i] + i;
            //if(nextDay <= N) {
                dpArr[nextDay] = Math.max(dpArr[nextDay],payArr[i]+dpArr[i]);
            //}
            dpArr[i] = Math.max(dpArr[i], result);
            result = Math.max(result, dpArr[i]);
        }
        System.out.println(result);
    }
}
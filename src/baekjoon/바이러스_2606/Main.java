package baekjoon.바이러스_2606;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean[] visit;
    static ArrayList<Integer>[] arr;
    static int count = 0;
    static int C,L;

    public static void main(String[] args) throws Exception {
        final String PATH = "src/backjun.바이러스/input.txt";
        System.setIn(new FileInputStream(PATH));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer (br.readLine());
        L = Integer.parseInt(st.nextToken());

        visit = new boolean[C+1];

        //인접리스트
        arr = new ArrayList[C+1];
        for (int i = 1; i <= C; i++) {
            visit[i] = false;
            arr[i] = new ArrayList<Integer>();
        }

        for (int i = 1; i <= L; i++) { // 해당 노드에 연결된 애들만 넣어줌
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }
        dfs(1);
        System.out.println(count);

    }

    private static void dfs(Integer start) {
        visit[start] = true;
        for (int i = 0; i < arr[start].size(); i++) {
            int next = arr[start].get(i);
            if (!visit[next]) {  // 연결되어 있는 것들 중에 방문하지 않은 것 선별
                count += 1; // 감염된 수 ++
                dfs(next);
            }
        }
    }
}
package li.number4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class myCode {

    static int N;
    static List<List<Integer>> adj;

    public static void main(String[] args) throws java.lang.Exception {

        // 시간 복잡도 : O(N+E)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        N = Integer.parseInt(input);
        adj = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            adj.add(new LinkedList<>());
        }
        for (int i = 0; i < Integer.parseInt(input); i++) {
            String[] readLineArr = br.readLine().split(" ");
            adj.get(Integer.parseInt(readLineArr[0])).add(Integer.parseInt(readLineArr[1]));
        }

        if (isCyclic()) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    private static boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack) {
        if (recStack[i]) {
            return true;
        }
        if (visited[i]) {
            return false;
        }

        visited[i] = true;
        recStack[i] = true;
        List<Integer> children = adj.get(i);

        for (Integer c : children) {
            if (isCyclicUtil(c, visited, recStack)) {
                return true;
            }
        }
        recStack[i] = false;
        return false;
    }

    private static boolean isCyclic() {
        boolean[] visited = new boolean[N];
        boolean[] recStack = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (isCyclicUtil(i, visited, recStack)) {
                return true;
            }
        }
        return false;
    }
}

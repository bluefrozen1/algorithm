package li.number2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class myCode {
    static int answer = 0;
    static int N, C; // 커맨드 갯수와 큐의 크기

    static String COMMAND_OFFER = "OFFER";
    static String COMMAND_TAKE = "TAKE";
    static String COMMAND_SIZE = "SIZE";

    static Queue<String> q = new ArrayDeque<>();

    public static void main(String[] args) throws java.lang.Exception {

        // 시간복잡도 : O(1)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nc = br.readLine().split(" ");
        N = Integer.parseInt(nc[0]);
        C = Integer.parseInt(nc[1]);
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            String cmd = input[0];

            if (cmd.equals(COMMAND_OFFER)) {
                String txt = input[1];
                if (q.size() < C) {
                    q.add(txt);
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }
            } else if (cmd.equals(COMMAND_TAKE)) {
                System.out.println(q.poll());
            } else if (cmd.equals(COMMAND_SIZE)) {
                System.out.println(q.size());
            } else {
                System.out.println("Unsupported COMMAND");
            }
        }
    }
}

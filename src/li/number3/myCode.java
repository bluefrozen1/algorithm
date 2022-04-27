package li.number3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class myCode {
    static ArrayList<Integer> list = new ArrayList<>();
    static int target;

    public static void main(String[] args) throws Exception {

        // 시간복잡도 : O(n^2)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        for (String s : nums) {
            list.add(Integer.parseInt(s));

        }

        Collections.sort(list);
        target = Integer.parseInt(br.readLine());

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int sum = list.get(i) + list.get(j);
                if (sum == target) {
                    System.out.println(list.get(i) + " " + list.get(j));
                    return;
                }
            }
        }
    }
}
package li.number5;

import java.io.*;
import java.util.*;

class myCode {
    public static void main (String[] args) throws Exception {


        // 시간복잡도 : O(n log n)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer windowSize = Integer.parseInt(br.readLine());

        Queue<NumberVO> queue = new PriorityQueue<>(new Comparator<NumberVO>() {
            @Override
            public int compare(NumberVO o1, NumberVO o2) {
                if(o2.number > o1.number) {
                    return 1;
                } else if(o2.number == o1.number) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });

        int index = 1;
        String readLine = null;
        while((readLine = br.readLine()) != null) {

            Long number = Long.parseLong(readLine);
            NumberVO numberVO = new NumberVO(number, index);

            queue.add(numberVO);

            while(!queue.isEmpty() && index - queue.peek().getIndex() >= windowSize) {
                queue.poll();
            }

            if(index >= windowSize) {
                System.out.println(queue.peek().getNumber());
            }
            index++;
        }
    }

    public static class NumberVO {
        private Long number;
        private Integer index;

        public NumberVO(Long number, Integer index) {
            this.number = number;
            this.index = index;
        }

        public Long getNumber() {
            return number;
        }

        public Integer getIndex() {
            return index;
        }
    }
}

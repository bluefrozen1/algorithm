package programmers.주식가격;

class Solution {

    // https://programmers.co.kr/learn/courses/30/lessons/42584

    public static void main(String[] args) {
        int[] answer = new Solution().solution(new int[]{1, 2, 3, 2, 3});
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }

    }
    public int[] solution(int[] prices) {

        int[] answer = new int[prices.length];
        for(int i=0; i<prices.length; i++) {
            for(int j = i+1; j<prices.length; j++) {
                answer[i]++;
                if(prices[i] > prices[j]) {
                    break;
                }
            }
        }

        return answer;
    }
}

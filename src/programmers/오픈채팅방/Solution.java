package programmers.오픈채팅방;

import java.util.*;


class Solution {

    // https://programmers.co.kr/learn/courses/30/lessons/12899

    public static void main(String[] args) {
        System.out.println("답:" + new Solution().solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"}));
    }

    public final String ENTER = "Enter";
    public final String LEAVE = "Leave";
    public final String CHANGE = "Change";

    public String[] solution(String[] record) {

        Map<String, String> nickNameMap = new HashMap<>();
        for(String recordStr : record) {
            String[] arr = recordStr.split(" ");
            String command = arr[0];
            String id = arr[1];

            if(ENTER.equals(command) || CHANGE.equals(command)) {
                nickNameMap.put(id, arr[2]);
            }
        }

        List<String> list = new ArrayList<>();
        for(String recordStr : record) {
            String[] arr = recordStr.split(" ");
            String command = arr[0];
            String id = arr[1];

            if(ENTER.equals(command)) {
                String text = nickNameMap.get(id) +"님이 들어왔습니다.";
                list.add(text);
            } else if(LEAVE.equals(command)) {
                String text = nickNameMap.get(id) +"님이 나갔습니다.";
                list.add(text);
            }

        }

        String[] answer = list.toArray(new String[list.size()]);

        return answer;
    }
}
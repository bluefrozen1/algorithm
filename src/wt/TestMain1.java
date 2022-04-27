package wt;

import java.util.HashMap;
import java.util.Map;

public class TestMain1 {

    public static void main(String[] args) throws Exception {


//        문자열 내에서 반복되지 않는 문자를 찾기 (대소문자 구분 안함)
//        - 입력 : aakdflsanlfmuewrbjabds
//        - 출력 : eikmnruw
        String input = "aakdflsanlfmuewrbjabds";
        //String input = "eikmnruw";


        StringBuilder result = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for(Character c : input.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        for(Character c : input.toCharArray()) {
            if(map.get(c) != null && map.get(c) < 2) {
                result.append(c);
            }
        }

        System.out.println(result.toString());



    }
}

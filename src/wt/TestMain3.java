package wt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestMain3 {


    public static void main(String[] args) throws Exception {
//        Q. 코딩 테스트
//        1. 코딩 테스트 단어에 나오는 모음의 순서를 바꾸는 함수를 코딩해보세요.
//                ex) hello => holle
//        naver webtoon => novor webtean

        String input = "naver webtoon";
        StringBuilder result = new StringBuilder();

        // 1. 모음 목록 저장
        List<Character> list = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        // 2. input 문자열의 모음을 모아서 저장
        List<Character> tempList = new ArrayList<>();
        for(Character c : input.toCharArray()) {
            if(list.contains(c)) {
                tempList.add(c);
            }
        }

        // 3. input 문자열의 모음이 등장할때 미리 모아뒀던 문자열을 입력하여 신규 문자열 생성
        int index = tempList.size()-1;
        for(Character c : input.toCharArray()) {
            if(list.contains(c)) {
                result.append(tempList.get(index));
                index--;
            } else {
                result.append(c);
            }
        }

        System.out.println(result.toString());
    }
}

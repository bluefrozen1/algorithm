package programmers.파일명정렬;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {

    // https://programmers.co.kr/learn/courses/30/lessons/17686

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"})));
    }

    public static final Pattern pattern = Pattern.compile("(?<prefix>[^0-9]+)(?<number>[0-9]+)");

    public String[] solution(String[] files) {

        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                String[] o1Arr = extractSplitedStr(o1);
                String[] o2Arr = extractSplitedStr(o2);

                int compare = o1Arr[0].compareToIgnoreCase(o2Arr[0]);
                if(compare == 0) {
                    return Integer.parseInt(o1Arr[1]) - Integer.parseInt(o2Arr[1]);
                } else {
                    return compare;
                }
            }
        });
        return files;
    }

    public static String[] extractSplitedStr(String fileName) {
        Matcher matcher = pattern.matcher(fileName);
        String header = "";
        String number = "";
        String postfix1 = "";
        if(matcher.find()) {
            header = matcher.group("prefix").toLowerCase();
            number = matcher.group("number");
            if(number.length() > 5) {
                number.substring(0, 5);
            }
        }
        return new String[]{header, number};
    }
}

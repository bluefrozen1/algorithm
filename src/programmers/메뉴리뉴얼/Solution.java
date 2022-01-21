package programmers.메뉴리뉴얼;

import java.util.*;

class Solution {

    // https://programmers.co.kr/learn/courses/30/lessons/72411

    public static void main(String[] args) {
        System.out.println("답:" + new Solution().solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2,3,4}));
        System.out.println("답:" + new Solution().solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[]{2,3,5}));
        // ["AC", "ACDE", "BCFG", "CDE"]
        // ["ACD", "AD", "ADE", "CD", "XYZ"]
    }

    public String[] solution(String[] orders, int[] course) {

        Map<String, Boolean> map = new HashMap<>();
        for(int i=0; i<orders.length; i++) {
            List<String> list = new ArrayList<>();
            for(int j=0; j<orders[i].length(); j++) {
                list.add(orders[i].substring(j, j+1));
            }
            for(int courseCount : course) {
                test("", map, list, courseCount);
            }
        }


        Map<String, Integer> answer = new HashMap<>();
        for(int courseCount : course) {
            for(int i=0; i<orders.length; i++) {
                String order = orders[i];
                for(String key : map.keySet()) {
                    if(courseCount == key.length()) {
                        boolean flag = true;
                        for(int j=0; j<key.length(); j++) {
                            if(order.indexOf(key.substring(j, j+1)) < 0) {
                                flag = false;
                                break;
                            }
                        }
                        //System.out.println("order="+order + ", key=" + key +" !!!!!!!!!!!!!!!!!!!!");
                        if(flag) {
                            answer.put(key, answer.getOrDefault(key, 0) + 1);
                        }
                    }
                }
            }
        }

        Map<Integer, Integer> newAnswer = new HashMap<>();
        for(Map.Entry<String, Integer> entry : answer.entrySet()) {
            Integer count = newAnswer.get(entry.getKey().length());
            if(count == null) {
                newAnswer.put(entry.getKey().length(), entry.getValue());
            } else {
                if(count < entry.getValue()) {
                    newAnswer.put(entry.getKey().length(), entry.getValue());
                }
            }
        }

        List<String> removeKey = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : answer.entrySet()) {
            boolean match = false;
            for(int courseCount : course) {
                if(entry.getValue() == courseCount) {
                    match = true;
                    break;
                }
            }
            if(!match) {
                removeKey.add(entry.getKey());
            }

            Integer size = newAnswer.get(entry.getKey().length());
            if(size != null && size > entry.getValue()) {
                removeKey.add(entry.getKey());
            }
        }
        for(String key : removeKey) {
            answer.remove(key);
        }

        List<String> keyList = new ArrayList<>(answer.keySet());
        Collections.sort(keyList);
        return keyList.toArray(new String[keyList.size()]);
    }

    public static Map<String, Boolean> test(String c1, Map<String, Boolean> map, List<String> list, int maxCount) {
        if(list.size() < c1.length()) {
            return map;
        }
        for(String c2 : list) {
            if(c1.equals(c2)) {
                continue;
            }
            if(maxCount == c1.length()) {
                map.put(c1, true);
            }
            if(c1.length() > 0) {
                String ya = c1.substring(c1.length()-1);
                if(c1.substring(c1.length()-1).compareTo(c2) > 0) {
                    continue;
                }
                if(c1.substring(c1.length()-1).equals(c2)) {
                    continue;
                }
            }


            String addString = null;
            if(maxCount > c1.length()) {
                addString = addString(c1, c2, maxCount);
                test(addString, map, list, maxCount);
            }
        }
        return map;
    }

    public static String addString(String origin, String addStr, int maxCount) {
        if(origin.length() < maxCount) {
            return origin + addStr;
        }
        return origin;
    }
}
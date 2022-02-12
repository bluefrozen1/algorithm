package leetcode.WordSearch_79;

import java.util.*;

public class Solution {

    // https://leetcode.com/problems/word-search/

    public static void main(String[] args) {
        System.out.println(new Solution().exist(new char[][]{{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}}, "ABCCED"));
        System.out.println(new Solution().exist(new char[][]{{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}}, "SEE"));
        System.out.println(new Solution().exist(new char[][]{{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}}, "ABCB"));
        System.out.println(new Solution().exist(new char[][]{{'A','B','C','E'}, {'S','F','E','S'}, {'A','D','E','E'}}, "ABCESEEEFS"));
        System.out.println(new Solution().exist(new char[][]{{'a'}, {'a'}}, "aaa"));
        System.out.println(new Solution().exist(new char[][]{{'a','a','a','a'},{'a','a','a','a'},{'a','a','a','a'}}, "aaaaaaaaaaaaa"));


    }

    public char[] answer = null;

    public int[] x = {-1, 0, 1, 0};
    public int[] y = {0, -1, 0, 1};

    public boolean exist(char[][] board, String word) {

        answer = new char[word.length()];

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(search(word, board, i, j)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean search(String word, char[][] board, int i, int j) {
        int[][] visited = new int[board.length][board[0].length];
        visited[i][j] = 1;
        answer[0] = word.charAt(0);
        return search2(word, board, word.toCharArray(), 1, i, j, visited);

    }

    public boolean search2(String word, char[][] board, char[] chars, int charPosition, int i, int j, int[][] visited) {

        if(word.equals(new String(answer))) {
            return true;
        }

        for(int k=0; k<x.length; k++) {
            int searchX = i+x[k];
            int searchY = j+y[k];

            if(searchX >= 0 && searchX < board.length && searchY >= 0 && searchY < board[0].length) {
                //System.out.println("x=" + searchX + ", " + searchY + ", c=" + chars[charPosition]);
                if(board[searchX][searchY] == chars[charPosition]) {

                    if(visited[searchX][searchY] == 0) {
                        visited[searchX][searchY] = 1;
                        answer[charPosition] = chars[charPosition];
                        //System.out.println("Search!! c=" + chars[charPosition] + ", answer=" + new String(answer));

                        if(!search2(word, board, chars, charPosition+1, searchX, searchY, visited)) {
                            answer[charPosition] = 0;
                            visited[searchX][searchY] = 0;
                        }
                    }
                }
            }
        }
        if(word.equals(new String(answer))) {
            return true;
        }
        return false;
    }
}
